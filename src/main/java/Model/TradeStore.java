package Model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Created by Robert on 03/04/2017.
 */
public class TradeStore {

    List<Trade> tradeList = new ArrayList<Trade>();

    public void addToTradeStore(Trade trade){
        tradeList.add(trade);
    }

    public Trade getTrade(int tradeID){

        for(int i = 0 ; i < tradeList.size() ; i++){
            if(tradeList.get(i).getID() == tradeID ){
                return tradeList.get(i);
            }
        }
        // trade not found
        return null;
    }

    public List<Trade> getAllTrades(){
        return tradeList;
    }

    public List<Trade> getLastFifteenTrades(String stockSymbol){

        List<Trade> lastFifteenTradeList;
        LocalDateTime fifteenMinutesPrevious = LocalDateTime.now().minus(15, ChronoUnit.MINUTES);

        lastFifteenTradeList = tradeList.stream().filter(p -> p.getTimestamp().isAfter(fifteenMinutesPrevious) && p.getSymbol().equals(stockSymbol)).collect(Collectors.toList());
        return lastFifteenTradeList;
    }

    public double getVolumeWeightedPrice(List<Trade> lastFifteenTradeList){

        int totalQuantity = 0;
        double[] priceMulQuantity = new double[lastFifteenTradeList.size()];

        for(int i = 0 ; i < lastFifteenTradeList.size() ; i++){
            priceMulQuantity[i] = lastFifteenTradeList.get(i).getQuantity() * lastFifteenTradeList.get(i).getPrice();
            totalQuantity += lastFifteenTradeList.get(i).getQuantity();
        }

        double totalPriceMulQuantity = DoubleStream.of(priceMulQuantity).sum();
        double volumeWeightedPrice = totalPriceMulQuantity / totalQuantity;

        return volumeWeightedPrice;
    }

}
