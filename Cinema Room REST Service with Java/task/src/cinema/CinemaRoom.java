package cinema;

import java.util.ArrayList;
import java.util.List;

public class CinemaRoom {
    private int rows;
    private int columns;
    private List<Seat> seats;

    CinemaRoom(int numberOfRows, int numberOfColumns) {
        this.rows = numberOfRows;
        this.columns = numberOfColumns;
        this.seats = new ArrayList<>(numberOfRows * numberOfColumns);
        int price = 10;
        for (int row = 1; row <= numberOfRows; row++) {
            price = row > this.rows / 2 && this.rows * this.columns > 60 ? 8 : 10;
            for (int column = 1; column <= numberOfColumns; column++) {
                this.seats.add(new Seat(row, column, price));
            }
        }
    }
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<Seat> getSeats() {
        List<Seat> availableSeats = new ArrayList<>(rows * columns);
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                availableSeats.add(getSeat(seat));
            }
        }
        return availableSeats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Seat getSeat(Seat requestedSeat) {
        for (Seat seat : seats) {
            if (seat.getRow() == requestedSeat.getRow()
                    && seat.getColumn() == requestedSeat.getColumn()
                    && seat.isAvailable()) {
                return seat;
            }
        }
        return null;
    }

    public Seat flipSeat(Seat requestedSeat) {
        Seat output = null;
        for (Seat seat : seats) {
            if (seat.getRow() == requestedSeat.getRow()
                    && seat.getColumn() == requestedSeat.getColumn()) {
                output = seat.setAvailable();
            }
        }
        return output;
    }

    public boolean outOfBounds(Seat seat) {
        return seat.getRow() < 1
                || seat.getColumn() < 1
                || seat.getRow() > this.rows
                || seat.getColumn() > this.columns;
    }
}