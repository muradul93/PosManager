package posmanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posmanager.domain.CompanyDetails;

@Repository
public interface CompanyRepository  extends JpaRepository<CompanyDetails, Integer>{
   // public boolean existsByCode(String code);
     CompanyDetails findByCode(String code);
}
