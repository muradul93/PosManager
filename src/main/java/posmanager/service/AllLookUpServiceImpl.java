package posmanager.service;


import posmanager.domain.AllLookUp;
import posmanager.repository.AllLookUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  on 2/7/17.
 */
@Service
public class AllLookUpServiceImpl implements   AllLookUpService {

    @Autowired
    AllLookUpRepository allLookUpRepository;


    @Override
    public AllLookUp save(AllLookUp allLookUp) {
        return allLookUpRepository.save(allLookUp);
    }

    @Override
    public List<AllLookUp> findAll() {
        return allLookUpRepository.findAll();
    }

    @Override
    public List<AllLookUp> findAllByOrderByIdDesc() {
        return allLookUpRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Page<AllLookUp> findAllByOrderByIdDesc(Pageable pageable) {
        return allLookUpRepository.findAllByOrderByIdDesc(pageable);
    }

    @Override
    public AllLookUp findOne(Integer integer) {
        return allLookUpRepository.findOne(integer);
    }

    @Override
    public void delete(Integer integer) {
            allLookUpRepository.delete(integer);
    }

    @Override
    public int countByAllLookUpName(String allLookUPName) {
        return allLookUpRepository.countByAllLookUpName(allLookUPName);
    }

    @Override
    public Page<AllLookUp> findAll(Pageable pageable) {
        return allLookUpRepository.findAll(pageable);
    }

    @Override
    public Page<AllLookUp> findByAllLookUpNameContainsOrAllLookUpCodeContainsAllIgnoreCase(String allLookUpName, String allLookUpCode, Pageable pageable) {
        return allLookUpRepository.findByAllLookUpNameContainsOrAllLookUpCodeContainsAllIgnoreCase(allLookUpName,
                allLookUpCode,
                pageable);
    }
}
