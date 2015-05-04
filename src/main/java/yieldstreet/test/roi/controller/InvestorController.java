package yieldstreet.test.roi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yieldstreet.test.roi.model.Investor;
import yieldstreet.test.roi.repository.InvestorPerformanceRepository;
import yieldstreet.test.roi.repository.InvestorRepository;

import java.util.List;

@RestController
@RequestMapping("/investors")
public class InvestorController {

    @Autowired InvestorRepository investorRepository;
    @Autowired
    InvestorPerformanceRepository investorPerformanceRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Investor> all() {
        return investorRepository.findAll();
    }

    @RequestMapping(value = "/{investorId}/activeYears", method = RequestMethod.GET)
    public List<Integer> activeYears(@PathVariable Integer investorId) {
        return investorPerformanceRepository.investorActiveYears(investorId);
    }

    @RequestMapping(value = "/{investorId}/year/{year}/log", method = RequestMethod.GET)
    public List<PerformanceItem> performanceLog(@PathVariable Integer investorId, @PathVariable Integer year) {
        return investorPerformanceRepository.investorPerformanceLog(investorId, year);
    }
}
