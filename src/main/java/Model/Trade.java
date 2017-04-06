package Model;

/**
 * Created by Robert on 01/04/2017.
 */

import java.time.LocalDateTime;
import java.util.Date;

@SuppressWarnings("ALL")
public class Trade {

    String symbol;
    LocalDateTime timestamp;
    int ID;
    int quantity;
    Boolean buyOrSell;
    double Price;

    public String getSymbol() { return symbol; }

    public void setSymbol(String symbol) { this.symbol = symbol; }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Boolean getBuyOrSell() {
        return buyOrSell;
    }

    public void setBuyOrSell(Boolean buyOrSell) {
        this.buyOrSell = buyOrSell;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
