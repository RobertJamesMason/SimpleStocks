package Model;

/**
 * Created by Robert on 01/04/2017.
 */
public class Stock {

    String symbol;
    String type;
    double lastDiv;
    double fixedDiv;
    double parValue;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLastDiv() {
        return lastDiv;
    }

    public void setLastDiv(double lastDiv) {
        this.lastDiv = lastDiv;
    }

    public double getFixedDiv() {
        return fixedDiv;
    }

    public void setFixedDiv(double fixedDiv) {
        this.fixedDiv = fixedDiv;
    }

    public double getParValue() {
        return parValue;
    }

    public void setParValue(double parValue) {
        this.parValue = parValue;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof Stock) {
            Stock s = (Stock) object;
            return this.symbol.equals(s.symbol);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }

}
