package yieldstreet.test.roi.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NamedQueries({
        @NamedQuery(name="InvestorPerformance.investorActiveYears",
        query = "SELECT DISTINCT YEAR(p.sellDate) FROM InvestorPerformance p WHERE p.investor.id = ?1"),
        @NamedQuery(name="InvestorPerformance.investorPerformanceLog",
        query = "SELECT YEAR(p.sellDate), MONTH(p.sellDate), buy, sell FROM InvestorPerformance p WHERE p.investor.id = ?1 AND YEAR(p.sellDate) = ?2")
})
public class InvestorPerformance {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String symbol; // for simplification

    @Column
    private Integer buy;

    @Column
    private Integer sell;

    @Column
    private Date buyDate;

    @Column
    private Date sellDate;

    @ManyToOne
    private Investor investor;

    public InvestorPerformance() {
    }

    public InvestorPerformance(Investor investor, String symbol, Date buyDate, Integer buy, Date sellDate, Integer sell) {
        this.symbol = symbol;
        this.buy = buy;
        this.sell = sell;
        this.buyDate = buyDate;
        this.sellDate = sellDate;
        this.investor = investor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getBuy() {
        return buy;
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}
