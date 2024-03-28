package cinema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("available")
public class Seat {
    private int row;
    private int column;
    private int price;
    private boolean isAvailable;

    public Seat() {}
    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.isAvailable = true;
    }


    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Seat setAvailable() {
        isAvailable = !isAvailable;
        return this;
    }
}
