package posmanager.repository;


import posmanager.domain.AllLookUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  on 2/7/17.
 */
@Repository
public interface AllLookUpRepository extends JpaRepository<AllLookUp, Integer> {

    AllLookUp save(AllLookUp allLookUp);

    List<AllLookUp> findAll();

    List<AllLookUp> findAllByOrderByIdDesc();
    Page<AllLookUp> findAllByOrderByIdDesc(Pageable pageable);

    AllLookUp findOne(Integer integer);

    @Override
    void delete(Integer integer);

    public int countByAllLookUpName(String allLookUPName);
    Page<AllLookUp> findAll(Pageable pageable);

    Page<AllLookUp> findByAllLookUpNameContainsOrAllLookUpCodeContainsAllIgnoreCase(String allLookUpName,
                                                                                    String allLookUpCode,
                                                                                    Pageable pageable);

}
