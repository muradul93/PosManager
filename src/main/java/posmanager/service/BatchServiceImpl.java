package posmanager.service;

import posmanager.domain.Batch;
import posmanager.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by dream71 on 31/10/17.
 */
@Transactional
@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    BatchRepository batchRepository;

    @Override
    public Batch findOne(Integer integer) {
        return batchRepository.findOne(integer);
    }

    @Override
    public Batch save(Batch batch) {
        return batchRepository.save(batch);
    }


    @Override
    public String batchNo() {

        Batch batch =batchRepository.findFirstByOrderByIdDesc();
        Integer id = 0;
        if (batch != null) {
            id = batch.getId();
            id++;
        }

        return "Batch_" + id.toString();

    }

    @Override
    public int countByBatchNo(String name) {
        return batchRepository.countByBatchNo(name);
    }

    @Override
    public Page<Batch> findAll(Pageable pageable) {
        return batchRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer integer) {
        batchRepository.delete(integer);
    }

    @Override
    public List<Batch> findAllByOrderByIdDesc() {
        return batchRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Batch findByBatchNo(String batchNo) {
        return batchRepository.findByBatchNo(batchNo);
    }

    @Override
    public List<Batch> findAllValidBatches() {
        LocalDate today = LocalDate.now();
        return batchRepository.findAllByExpirationDateAfterOrExpirationDateOrderByIdDesc(today, today);
    }
}
