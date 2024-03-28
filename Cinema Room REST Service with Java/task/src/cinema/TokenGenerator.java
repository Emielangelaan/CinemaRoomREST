package cinema;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

public class TokenGenerator {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    UUID token;
    Ticket ticket;

    TokenGenerator() {

    }
    TokenGenerator(Seat seat) {
        this.token = seat.isAvailable() ? null : UUID.randomUUID();
        this.ticket = new Ticket(seat);
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
