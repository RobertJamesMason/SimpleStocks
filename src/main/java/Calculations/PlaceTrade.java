package Calculations;

import Model.Stock;
import Model.Trade;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Robert on 02/04/2017.
 */
public class PlaceTrade {

    public PlaceTrade() {
    }

    public void makeTrade(List<Stock> list){
        Trade trade = new Trade();

        trade.setSymbol(list.get(0).getSymbol());
        trade.setBuyOrSell(false);
        trade.setID(1);
        trade.setPrice(10);
        trade.setQuantity(50);
        trade.setTimestamp(LocalDateTime.now());

        System.out.println("The time is " + trade.getTimestamp());


    }
}
