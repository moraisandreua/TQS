package tqs.lab2;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class StocksPortefolioTest {
    @Mock
    IStockMarket market;

    @InjectMocks
    StocksPortefolio portefolio;

    @Test
    void getTotalValue() {
        // get the mock
        //IStockMarket market = mock(IStockMarket.class)
        // inject mock
        //StocksPortefolio portefolio = new StocksPortefolio(market);
        // set expectations
        when(market.getPrice("TSLA")).thenReturn(690.0);
        when(market.getPrice("APPL")).thenReturn(123.0);

        // perform test
        portefolio.addStock(new Stock("TSLA", 1));
        portefolio.addStock(new Stock("APPL", 7));
        double result = portefolio.getTotalValue();

        // verify
        assertEquals(1551.0, result);
        verify(market, times(2)).getPrice(anyString());
    }

    @Test
    void getTotalValue2() {
        // get the mock
        //IStockMarket market = mock(IStockMarket.class)
        // inject mock
        //StocksPortefolio portefolio = new StocksPortefolio(market);
        // set expectations
        when(market.getPrice("TSLA")).thenReturn(690.0);
        when(market.getPrice("APPL")).thenReturn(123.0);

        // perform test
        portefolio.addStock(new Stock("TSLA", 1));
        portefolio.addStock(new Stock("APPL", 7));
        double result = portefolio.getTotalValue();

        // verify
        assertThat(result, is(1551.0));
        verify(market, times(2)).getPrice(anyString());
    }

}
