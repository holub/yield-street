package yieldstreet.test.roi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import yieldstreet.test.roi.model.InvestorPerformance;
import yieldstreet.test.roi.model.Investor;
import yieldstreet.test.roi.repository.InvestorPerformanceRepository;
import yieldstreet.test.roi.repository.InvestorRepository;

import javax.annotation.PostConstruct;
import java.sql.Date;

@Configuration
public class DemoData {

    @Autowired
    InvestorRepository investorRepository;

    @Autowired
    InvestorPerformanceRepository investorPerformanceRepository;

    @PostConstruct
    public void initData() {
        Investor will = addInvestor("Willard Smooth");
        Investor sam = addInvestor("Sam Plane");
        Investor bill = addInvestor("William Rock");

        addPerformance(will, "AAA", Date.valueOf("2014-12-30"), 1000, Date.valueOf("2015-01-03"), 1002);
        addPerformance(will, "BBB", Date.valueOf("2014-01-01"), 5000, Date.valueOf("2014-01-02"), 5002);
        addPerformance(will, "AAA", Date.valueOf("2014-01-03"), 3000, Date.valueOf("2014-01-04"), 3002);
        addPerformance(will, "IBM", Date.valueOf("2014-01-17"), 1000, Date.valueOf("2014-02-03"), 1002);
        addPerformance(will, "TOP", Date.valueOf("2014-06-01"), 6000, Date.valueOf("2014-06-04"), 5800);
        addPerformance(will, "SIU", Date.valueOf("2015-02-01"), 4000, Date.valueOf("2015-02-02"), 1002);

        addPerformance(sam, "AAA", Date.valueOf("2015-01-01"), 1000, Date.valueOf("2015-01-03"), 1100);
        addPerformance(sam, "IBM", Date.valueOf("2015-01-01"), 1000, Date.valueOf("2015-01-03"), 1200);
        addPerformance(sam, "TSL", Date.valueOf("2015-04-01"), 1000, Date.valueOf("2015-04-03"), 1300);
        addPerformance(sam, "IPS", Date.valueOf("2015-07-01"), 1000, Date.valueOf("2015-07-03"), 900);

        addPerformance(bill, "AAA", Date.valueOf("2013-01-01"), 1000, Date.valueOf("2013-01-03"), 900);
        addPerformance(bill, "IBM", Date.valueOf("2014-01-01"), 1000, Date.valueOf("2014-01-03"), 800);
        addPerformance(bill, "TSL", Date.valueOf("2015-04-01"), 1000, Date.valueOf("2015-04-03"), 700);
        addPerformance(bill, "IPS", Date.valueOf("2015-07-01"), 1000, Date.valueOf("2015-07-03"), 1100);
    }

    private Investor addInvestor(String name) {
        Investor investor = new Investor(name);
        investorRepository.save(investor);

        return investor;
    }

    private InvestorPerformance addPerformance(Investor investor, String symbol,
                                               Date buyAt, Integer buyPrice,
                                               Date sellAt, Integer sellPrice) {
        InvestorPerformance investorPerformance = new InvestorPerformance(investor, symbol, buyAt, buyPrice, sellAt, sellPrice);
        investorPerformanceRepository.save(investorPerformance);

        return investorPerformance;
    }

}
