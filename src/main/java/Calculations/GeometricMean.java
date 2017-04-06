package Calculations;

import Model.Trade;
import Model.TradeStore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * Created by Robert on 05/04/2017.
 */
public class GeometricMean {

    public double calculateGeometricMean(TradeStore tradeStore){

        double geometricMean;
        List<Trade> listOfTrades;

        listOfTrades = tradeStore.getAllTrades();

        if( listOfTrades.size() > 0) {

            double factorOfAllTrades = listOfTrades.stream()
                    .map(Trade::getPrice)
                    .reduce(1.0, (a, b) -> a * b);

            geometricMean = Math.pow(factorOfAllTrades, 1.0 / listOfTrades.size());
            return geometricMean;
        }else{
            return -1;
        }
    }
}
