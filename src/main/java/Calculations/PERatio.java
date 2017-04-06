package Calculations;

import Model.Stock;

/**
 * Created by Robert on 01/04/2017.
 */
public class PERatio {

    private Stock stock;

    public PERatio(Stock stock) {
        this.stock = stock;
    }

    public double calculatePERatio(double marketPrice){

        if(stock.getLastDiv() == 0.0){
            return -1;
        }
        else if(stock.getLastDiv() < 0.0){
            return -1;
        }else{
            return marketPrice/stock.getLastDiv();
        }
    }
}
