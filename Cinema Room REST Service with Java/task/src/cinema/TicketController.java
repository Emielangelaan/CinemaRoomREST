package cinema;


import cinema.exceptions.OutOfBoundsException;
import cinema.exceptions.UnavailableSeatException;
import cinema.exceptions.WrongPasswordException;
import cinema.exceptions.WrongTokenException;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class TicketController {
    CinemaRoom room = new CinemaRoom(9, 9);
    HashMap<UUID, Seat> purchasedTickets = new HashMap<>();

    @GetMapping("/seats")
    public CinemaRoom getSeats() {
        return room;
    }

    @GetMapping("/stats")
    public Statistics managerStatistics(@RequestParam(required = false) String password) {
        if (password != null) {
            if (password.equals("super_secret")) {
                return new Statistics(purchasedTickets);
            }
        }
        throw new WrongPasswordException("The password is wrong!");
    }

    @PostMapping("/purchase")
    public TokenGenerator purchaseTicket(@RequestBody Seat seat) {
        if (room.outOfBounds(seat)) {
            throw new OutOfBoundsException("The number of a row or a column is out of bounds!");
        }
        if(room.getSeat(seat) != null) {
            Seat unavailableSeat = room.flipSeat(seat);
            TokenGenerator token = new TokenGenerator(unavailableSeat);
            purchasedTickets.put(token.getToken(), unavailableSeat);
            return token;
        }
        throw new UnavailableSeatException("The ticket has been already purchased!");
    }
    
    @PostMapping("/return")
    public TokenGenerator returnTicket(@RequestBody TokenGenerator token) {
        if (purchasedTickets.containsKey(token.getToken())) {
            Seat availableSeat = room.flipSeat(purchasedTickets.get(token.getToken()));
            purchasedTickets.remove(token.getToken());
            return new TokenGenerator(availableSeat);
        }
        throw new WrongTokenException("Wrong token!");
    }
}
