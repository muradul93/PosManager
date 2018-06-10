package posmanager.repository;


import posmanager.domain.HrEmployeeInfo;
import posmanager.domain.MyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by abc on 08-Feb-17.
 */
public interface HrEmployeeInfoRepository extends JpaRepository<HrEmployeeInfo, Integer> {

    @Override
    List<HrEmployeeInfo> findAll();

    Page<HrEmployeeInfo> findAll(Pageable pageable);
    Page<HrEmployeeInfo> findAllByOrderByIdDesc(Pageable pageable);


    @Override
    HrEmployeeInfo save(HrEmployeeInfo hrEmployeeInfo);

    @Override
    HrEmployeeInfo findOne(Integer integer);

    @Override
    void delete(Integer integer);

    Page<HrEmployeeInfo> findByEmpNameContainsOrCodeContainsOrContactContainsAllIgnoreCase(String empName,
                                                                                                       String code, String contains,
                                                                                                       Pageable pageReguest);


    List<HrEmployeeInfo> findByMyUserOrderByIdDesc(MyUser myUser);

    int countByCode(String code);

}
