package posmanager.service;

import posmanager.domain.Batch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by dream71 on 31/10/17.
 */
public interface BatchService {
    Batch findOne(Integer integer);
    Batch save(Batch batch);
    public String batchNo() ;
    public int countByBatchNo(String name);
    Page<Batch> findAll(Pageable pageable);
    void delete(Integer integer);
    List<Batch> findAllByOrderByIdDesc();
    List<Batch> findAllValidBatches();
    Batch findByBatchNo(String batchNo);
}
