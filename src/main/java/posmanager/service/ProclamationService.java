package posmanager.service;


import posmanager.domain.Proclamation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by root on 4/6/17.
 */
public interface ProclamationService {
    List<Proclamation> findByAliveOrderByIdDesc(boolean active);
    Page<Proclamation> findByAliveOrderByIdDesc(boolean active, Pageable pageable);
    Page<Proclamation> findByNameContainsAndAliveOrderByIdDesc(String name, boolean active, Pageable pageable);
    Proclamation findOne(Integer integer);
    Proclamation save(Proclamation proclamation);
    void deleteAll();
}
