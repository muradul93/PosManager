package posmanager.repository;


import posmanager.domain.EmployeeLogAddressInfo;
import posmanager.domain.MyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shitul on 4/3/17.
 */
@Repository
public interface EmployeeLogAddressInfoRepository extends JpaRepository<EmployeeLogAddressInfo,Integer> {
    EmployeeLogAddressInfo save(EmployeeLogAddressInfo employeeLogAddressInfo);

    List<EmployeeLogAddressInfo> findAll();
    Page<EmployeeLogAddressInfo> findAll(Pageable pageable);

    List<EmployeeLogAddressInfo> findAllByOrderByIdDesc();
    Page<EmployeeLogAddressInfo> findAllByOrderByIdDesc(Pageable pageable);

    EmployeeLogAddressInfo findOne(Integer integer);
    EmployeeLogAddressInfo findFirstByMyUserOrderByIdDesc(MyUser myUser);


    void delete(Integer integer);
}
