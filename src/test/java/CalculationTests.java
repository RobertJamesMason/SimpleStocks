import Calculations.DividendYield;
import Calculations.GeometricMean;
import Calculations.PERatio;
import Model.Stock;
import Model.Trade;
import Model.TradeStore;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 *  Created by Robert on 02/04/2017.
 */
public class CalculationTests {

    Stock tea;
    double marketPrice;

    @Before
    public void setup(){
        tea = new Stock();
        tea.setLastDiv(0);
        tea.setParValue(100);
        tea.setType("Common");
        tea.setSymbol("TEA");
        marketPrice = 35.0;

    }

    @Test
    public void dividendYieldCommonTest() {

        DividendYield dividendYieldTest = new DividendYield(tea); // MyClass is tested
        double marketPrice = 35;

        assertNotNull(dividendYieldTest.calculateDividendYield(marketPrice));
        assertEquals(0, dividendYieldTest.calculateDividendYield(marketPrice), 0.00000000001);

    }

    @Test
    public void dividendYieldPreferredTest() {

        Stock gin = new Stock();
        gin.setLastDiv(8);
        gin.setFixedDiv(2);
        gin.setParValue(100);
        gin.setType("Preferred");
        gin.setSymbol("GIN");

        DividendYield dividendYieldTest = new DividendYield(gin); // MyClass is tested

        double expectedValue = (2.0 * 100.0)/ marketPrice;

        assertNotNull(dividendYieldTest.calculateDividendYield(marketPrice));
        assertEquals(expectedValue, dividendYieldTest.calculateDividendYield(marketPrice), 0.00000000001);

    }

    @Test
    public void PERatioTest() {

        Stock tea = new Stock();
        tea.setLastDiv(0);
        tea.setParValue(100);

        PERatio PERTest0LastDiv = new PERatio(tea); //testing for value of 0

        assertEquals(-1, PERTest0LastDiv.calculatePERatio(marketPrice), 0.000001);

        tea.setLastDiv(-1);

        PERatio PERTestNegativeLastDiv = new PERatio(tea); // Testing for a negative value

        assertEquals(-1, PERTestNegativeLastDiv.calculatePERatio(marketPrice), 0.000001);

        tea.setLastDiv(5);

        PERatio PERTestAllowedLastDiv = new PERatio(tea); // Testing for a positive value

        assertEquals(20, PERTestAllowedLastDiv.calculatePERatio(marketPrice), 0.000001);
    }

    @Test
    public void getGeoMetricPriceTest(){

        TradeStore tradeStore = new TradeStore();
        GeometricMean geometricMean = new GeometricMean();

        Trade trade = new Trade();

        trade.setID(20);
        trade.setPrice(50.00);
        trade.setQuantity(10);
        trade.setTimestamp(LocalDateTime.now());

        Trade trade2 = new Trade();

        trade2.setID(25);
        trade2.setPrice(100.00);
        trade2.setQuantity(10);
        trade2.setTimestamp(LocalDateTime.now());

        Trade trade3 = new Trade();

        trade3.setID(1);
        trade3.setPrice(50.00);
        trade3.setQuantity(20);
        trade3.setTimestamp(LocalDateTime.now().minus(20, ChronoUnit.MINUTES));

        tradeStore.addToTradeStore(trade);
        tradeStore.addToTradeStore(trade2);
        tradeStore.addToTradeStore(trade3);

        double result = Math.pow(250000, 1.0 / 3);

        assertEquals("Error with receiving Geometric trade price", result , geometricMean.calculateGeometricMean(tradeStore), 0.00000000001);
    }

    @Test
    public void emptyTradeStoreGeometricMeanTest(){

        TradeStore emptyTradeStore = new TradeStore();
        GeometricMean geometricMean = new GeometricMean();

        assertEquals(-1.0 , geometricMean.calculateGeometricMean(emptyTradeStore), 0.00001);
    }

}
