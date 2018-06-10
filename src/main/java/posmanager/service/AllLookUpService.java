package posmanager.service;


import posmanager.domain.AllLookUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by  on 2/7/17.
 */
public interface AllLookUpService {

    AllLookUp save(AllLookUp allLookUp);

    List<AllLookUp> findAll();

    List<AllLookUp> findAllByOrderByIdDesc();
    Page<AllLookUp> findAllByOrderByIdDesc(Pageable pageable);

    AllLookUp findOne(Integer integer);


    void delete(Integer integer);

    public int countByAllLookUpName(String allLookUPName);
    Page<AllLookUp> findAll(Pageable pageable);
    Page<AllLookUp> findByAllLookUpNameContainsOrAllLookUpCodeContainsAllIgnoreCase(String allLookUpName,
                                                                                    String allLookUpCode,
                                                                                    Pageable pageable);

}
