package Calculations;

import Model.Stock;

/**
 * Created by Robert on 01/04/2017.
 */
public class DividendYield{

    private Stock stock;

    public DividendYield(Stock stock) {
        this.stock = stock;
    }

    public double calculateDividendYield(double marketPrice){

        double dividendYield;

        if (stock.getType().equals("Common")) {
            try {
                dividendYield = stock.getLastDiv() / marketPrice;
            } catch (Exception e) {
                dividendYield = -1;
                e.printStackTrace();
            }
        }else{
            try {
                dividendYield =  (stock.getFixedDiv() * stock.getParValue() ) / marketPrice;
            } catch (Exception e) {
                dividendYield = -1;
                e.printStackTrace();
            }
        }



        return dividendYield;
    }





}
