package posmanager.service;


import posmanager.domain.HrEmployeeInfo;
import posmanager.repository.HrEmployeeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by abc on 08-Feb-17.
 */

@Service
@Transactional
public class HrEmployeeInfoServiceImpl implements HrEmployeeInfoService {
    @Autowired
    HrEmployeeInfoRepository hrEmployeeInfoRepository;

    @Override
    public List<HrEmployeeInfo> findAll() {
        return hrEmployeeInfoRepository.findAll();
    }

    @Override
    public Page<HrEmployeeInfo> findAll(Pageable pageable) {
        return hrEmployeeInfoRepository.findAll(pageable);
    }

    @Override
    public HrEmployeeInfo save(HrEmployeeInfo hrEmployeeInfo) {
        return hrEmployeeInfoRepository.save(hrEmployeeInfo);
    }

    @Override
    public HrEmployeeInfo findOne(Integer integer) {
        return hrEmployeeInfoRepository.findOne(integer);
    }



    @Override
    public void delete(Integer integer) {
        hrEmployeeInfoRepository.delete(integer);
    }

    @Override
    public Page<HrEmployeeInfo> search(String empName, String code, String contains, Pageable pageReguest) {
        return hrEmployeeInfoRepository.findByEmpNameContainsOrCodeContainsOrContactContainsAllIgnoreCase(empName, code, contains, pageReguest);
    }


    @Override
    public int countByCode(String code) {
        return hrEmployeeInfoRepository.countByCode(code);
    }

    @Override
    public List<HrEmployeeInfo> findByMyUserOrderByIdDesc() {
        return hrEmployeeInfoRepository.findByMyUserOrderByIdDesc(null);
    }

}
