package cinema;

public class Ticket extends  Seat{
    private int row;
    private int column;
    private int price;
    Ticket(Seat seat) {
        super(seat.getRow(), seat.getColumn(), seat.getPrice());
        this.row = super.getRow();
        this.column = super.getColumn();
        this.price = super.getPrice();
    }
}
