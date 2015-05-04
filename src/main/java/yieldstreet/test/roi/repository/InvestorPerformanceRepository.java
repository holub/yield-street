package yieldstreet.test.roi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yieldstreet.test.roi.controller.PerformanceItem;
import yieldstreet.test.roi.model.InvestorPerformance;

import java.util.List;

public interface InvestorPerformanceRepository extends JpaRepository<InvestorPerformance, Integer> {

    List<Integer> investorActiveYears(Integer investorId);
    List<PerformanceItem> investorPerformanceLog(Integer investorId, Integer year);
}
