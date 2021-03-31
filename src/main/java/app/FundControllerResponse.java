package app;

public class FundControllerResponse {
    
    private Fund fund;

    private String search;

    public FundControllerResponse(Fund fund, String search) {
        this.fund = fund;
        this.search = search;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
