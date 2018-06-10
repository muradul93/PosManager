package posmanager.service;


import posmanager.domain.Proclamation;
import posmanager.repository.ProclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by root on 4/6/17.
 */
@Service
@Transactional
public class ProclamationServiceImpl implements ProclamationService {

    @Autowired
    ProclamationRepository proclamationRepository;

    @Override
    public List<Proclamation> findByAliveOrderByIdDesc(boolean active) {
        return proclamationRepository.findByAliveOrderByIdDesc(active);
    }

    @Override
    public Page<Proclamation> findByAliveOrderByIdDesc(boolean active, Pageable pageable) {
        return proclamationRepository.findByAliveOrderByIdDesc(active, pageable);
    }

    @Override
    public Page<Proclamation> findByNameContainsAndAliveOrderByIdDesc(String name, boolean active, Pageable pageable) {
        return proclamationRepository.findByNameContainsAndAliveOrderByIdDesc(name, active, pageable);
    }

    @Override
    public Proclamation findOne(Integer integer) {
        return proclamationRepository.findOne(integer);
    }

    @Override
    public Proclamation save(Proclamation proclamation) {
        return proclamationRepository.save(proclamation);
    }

    @Override
    public void deleteAll() {
        proclamationRepository.deleteAll();
    }
}
