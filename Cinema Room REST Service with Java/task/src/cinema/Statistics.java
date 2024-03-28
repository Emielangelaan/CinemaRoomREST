package cinema;

import java.util.HashMap;
import java.util.UUID;

public class Statistics {
    int income;
    int available;
    int purchased;

    Statistics(HashMap<UUID, Seat> token) {
        this.income = 0;
        this.available = 81;
        this.purchased = 0;
        for (Seat seat : token.values()) {
            this.income += seat.getPrice();
            this.available--;
            this.purchased++;
        }
    }
    Statistics() {

    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getPurchased() {
        return purchased;
    }

    public void setPurchased(int purchased) {
        this.purchased = purchased;
    }
}
