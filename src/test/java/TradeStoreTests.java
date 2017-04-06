import Model.Trade;
import Model.TradeStore;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * Created by Robert on 03/04/2017.
 */
public class TradeStoreTests {

    TradeStore tradeStore;
    Trade trade1;
    Trade trade2;
    Trade trade3;


    @Before //setup for tests
    public void setup(){

        tradeStore = new TradeStore();

        trade1 = new Trade();
        trade1.setID(20);
        trade1.setPrice(50.00);
        trade1.setQuantity(10);
        trade1.setTimestamp(LocalDateTime.now());
        trade1.setSymbol("POP");
        trade1.setBuyOrSell(true);

        trade2 = new Trade();
        trade2.setID(25);
        trade2.setPrice(100.00);
        trade2.setQuantity(10);
        trade2.setTimestamp(LocalDateTime.now());
        trade2.setSymbol("POP");
        trade2.setBuyOrSell(false);

        trade3 = new Trade();
        trade3.setID(1);
        trade3.setPrice(50.00);
        trade3.setQuantity(20);
        trade3.setTimestamp(LocalDateTime.now().minus(20, ChronoUnit.MINUTES));
        trade3.setSymbol("GIN");
        trade3.setBuyOrSell(true);

        tradeStore.addToTradeStore(trade1);
        tradeStore.addToTradeStore(trade2);
        tradeStore.addToTradeStore(trade3);
    }

    @Test
    public void setTradeTest(){
        //Check all getters
        assertNotNull(tradeStore.getTrade(trade1.getID()).getID());
        assertNotNull(tradeStore.getTrade(trade1.getID()).getPrice());
        assertNotNull(tradeStore.getTrade(trade1.getID()).getQuantity());
        assertNotNull(tradeStore.getTrade(trade1.getID()).getTimestamp());
        assertNotNull(tradeStore.getTrade(trade1.getID()).getSymbol());
        assertNotNull(tradeStore.getTrade(trade1.getID()).getBuyOrSell());
    }

    @Test
    public void getTradeTest() {
        assertNotNull(tradeStore.getTrade(trade1.getID()));
    }

    @Test
    public void getAllTradesTest(){
        assertSame("Trade Store size should be 3", 3, tradeStore.getAllTrades().size());
    }

    @Test
    public void getLastFifteenMinuteTradesTest(){
        //expect a result of 2 based off of the setup of the tests.
        assertNotNull("Error with handling previous trades", tradeStore.getLastFifteenTrades("POP"));
        assertEquals("Error with returning the correct number of trades", 2, tradeStore.getLastFifteenTrades("POP").size());
        assertEquals("Error with returning the correct ID of a trade", 20, tradeStore.getLastFifteenTrades("POP").get(0).getID());
    }

    @Test
    public void getVolumeWeightedPriceTest(){

        assertEquals("Error with calculating the weighted price", 75, tradeStore.getVolumeWeightedPrice(tradeStore.getLastFifteenTrades("POP")), 0.00000000001);
    }

}
