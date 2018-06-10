package posmanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posmanager.domain.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>{
   // public boolean existsByCode(String code);
    Branch findByBranchName(String branchName);
}
