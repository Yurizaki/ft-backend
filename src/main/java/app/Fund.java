package app;


import java.util.ArrayList;

public class Fund {
    
    public String name;
    public String ticker;

    public ArrayList<Holding> holdings;

    public Fund(String name, String ticker, ArrayList<Holding> holdings) {
        super();
        this.name = name;
        this.ticker = ticker;
        this.holdings = holdings;
    }

}
