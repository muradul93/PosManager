package posmanager.repository;

import posmanager.domain.Batch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by dream71 on 31/10/17.
 */
public interface BatchRepository extends JpaRepository<Batch, Integer> {
    Batch findFirstByOrderByIdDesc();
    public int countByBatchNo(String name);
    Page<Batch> findAll(Pageable pageable);
    void delete(Integer integer);
    List<Batch> findAllByOrderByIdDesc();
    Batch findByBatchNo(String batchNo);

    List<Batch> findAllByExpirationDateAfterOrExpirationDateOrderByIdDesc(LocalDate d1, LocalDate d2);

}
