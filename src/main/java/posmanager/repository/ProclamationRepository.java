package posmanager.repository;


import posmanager.domain.Proclamation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by root on 31/5/17.
 */
public interface ProclamationRepository extends JpaRepository<Proclamation,Integer>{
    List<Proclamation> findByAliveOrderByIdDesc(boolean active);
    Page<Proclamation> findByAliveOrderByIdDesc(boolean active, Pageable pageable);
    Page<Proclamation> findByNameContainsAndAliveOrderByIdDesc(String name, boolean active, Pageable pageable);
    Proclamation findOne(Integer integer);
    Proclamation save(Proclamation proclamation);
    void deleteAll();
}
