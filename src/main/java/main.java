import Calculations.DividendYield;
import Calculations.PERatio;
import Calculations.PlaceTrade;
import Model.Stock;
import Model.Trade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 01/04/2017.
 */
public class main {
    public static void main(String[] args) {

        List<Stock> stockList = populateMarket();

        Stock dummy = stockList.get(0);

        for(int i = 0 ; i < stockList.size() ; i++){
            if(stockList.get(i).getSymbol().contains("POP")){
                System.out.println("Found at index - " + i);
            }
        }

        DividendYield dividendYield = new DividendYield(dummy);

        List<Trade> allTrades = new ArrayList<Trade>();

        PERatio peRatio = new PERatio(dummy);

        System.out.println("This is the PE Ratio " + peRatio.calculatePERatio(5.0));

        //PlaceTrade placeTrade = new PlaceTrade();
       // placeTrade.makeTrade();

    }

    private static List populateMarket(){

        List<Stock> stockList = new ArrayList<Stock>();

        Stock tea = new Stock();
        tea.setLastDiv(0);
        tea.setParValue(100);
        tea.setType("Common");
        tea.setSymbol("TEA");
        stockList.add(tea);

        Stock pop = new Stock();
        pop.setLastDiv(8);
        pop.setParValue(100);
        pop.setType("Common");
        pop.setSymbol("POP");
        stockList.add(pop);

        Stock ale = new Stock();
        ale.setLastDiv(23);
        ale.setParValue(60);
        ale.setType("Common");
        ale.setSymbol("ALE");
        stockList.add(ale);

        Stock gin = new Stock();
        gin.setLastDiv(8);
        gin.setFixedDiv(2);
        gin.setParValue(100);
        gin.setType("Preferred");
        gin.setSymbol("GIN");
        stockList.add(gin);

        Stock joe = new Stock();
        joe.setLastDiv(0);
        joe.setParValue(100);
        joe.setType("Common");
        joe.setSymbol("TEA");
        stockList.add(joe);

        return stockList;
    }

}
