package posmanager.service;

import posmanager.domain.EmployeeLogAddressInfo;
import posmanager.domain.MyUser;
import posmanager.repository.EmployeeLogAddressInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shitul on 4/3/17.
 */

@Service
@Transactional
public class EmployeeLogAddressInfoServiceImpl implements EmployeeLogAddressInfoService {

    @Autowired
    EmployeeLogAddressInfoRepository employeeLogAddressInfoRepository;

    @Override
    public EmployeeLogAddressInfo save(EmployeeLogAddressInfo employeeLogAddressInfo) {
        return employeeLogAddressInfoRepository.save(employeeLogAddressInfo);
    }

    @Override
    public List<EmployeeLogAddressInfo> findAll() {
        return employeeLogAddressInfoRepository.findAll();
    }

    @Override
    public Page<EmployeeLogAddressInfo> findAll(Pageable pageable) {
        return employeeLogAddressInfoRepository.findAll(pageable);
    }

    @Override
    public List<EmployeeLogAddressInfo> findAllByOrderByIdDesc() {
        return employeeLogAddressInfoRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Page<EmployeeLogAddressInfo> findAllByOrderByIdDesc(Pageable pageable) {
        return employeeLogAddressInfoRepository.findAllByOrderByIdDesc(pageable);
    }

    @Override
    public EmployeeLogAddressInfo findOne(Integer integer) {
        return employeeLogAddressInfoRepository.findOne(integer);
    }

    @Override
    public EmployeeLogAddressInfo findFirstByMyUserOrderByIdDesc(MyUser myUser) {
        return employeeLogAddressInfoRepository.findFirstByMyUserOrderByIdDesc(myUser);
    }

    @Override
    public void delete(Integer integer) {
        employeeLogAddressInfoRepository.delete(integer);
    }
}
