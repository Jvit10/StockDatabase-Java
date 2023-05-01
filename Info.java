import javafx.beans.property.SimpleStringProperty;

public class Info{
    private SimpleStringProperty Company;
    private String StockPrice;
    private String Shares;

    private String Invested;
    private String GainLoss;
    private String TotalGainLoss;

    public Info(String Company, String StockPrice, String Shares, String Invested, String GainLoss, String TotalGainLoss) {
        this.Company = new SimpleStringProperty(Company);
        this.StockPrice = StockPrice;
        this.Shares = Shares;
        this.Invested = Invested;
        this.GainLoss = GainLoss;
        this.TotalGainLoss = TotalGainLoss;
    }

    public String getCompany() {return Company.get();}

    public void setCompany(String firstCompany) {this.Company = Company;}

    public String getStockPrice() {return StockPrice;}

    public void setStockPrice(String StockPrice) {this.StockPrice = StockPrice;}

    public String getShares() {return Shares;}

    public void setShares(String Shares) {this.Shares = Shares ;}

    public String getInvested() {return Invested;}

    public void setInvested(String Invested) {this.Invested = Invested ;}

    public String getGainLoss() {return GainLoss;}

    public void setGainLoss(String GainLoss) {this.GainLoss = GainLoss ;}

    public String getTotalGainLoss() {return TotalGainLoss;}

    public void setTotalGainLoss(String TotalGainLoss) {this.TotalGainLoss = TotalGainLoss;}

}


