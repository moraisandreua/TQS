package tqs.lab2;

import java.util.ArrayList;
import java.util.List;

public class StocksPortefolio {
    private String name;
    private IStockMarket marketService;
    private List<Stock> carteira = new ArrayList<>();

    private IStockMarket getMarketService(){
        return this.marketService;
    }

    private void setMarketService(IStockMarket ms){
        this.marketService=ms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalValue(){
        Double total = 0.0;
        for(Stock s : carteira){
            total += marketService.getPrice(s.getName()) * s.getQuantity();
        }

        return total;
    }

    public void addStock(Stock s){
        this.carteira.add(s);
    }
}
