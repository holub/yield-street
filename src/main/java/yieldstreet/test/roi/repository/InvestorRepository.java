package yieldstreet.test.roi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yieldstreet.test.roi.model.Investor;

public interface InvestorRepository extends JpaRepository<Investor, Integer> {
}
