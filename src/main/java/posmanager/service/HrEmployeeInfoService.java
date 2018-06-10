package posmanager.service;


import posmanager.domain.HrEmployeeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by abc on 08-Feb-17.
 */
public interface HrEmployeeInfoService {

    List<HrEmployeeInfo> findAll();
    Page<HrEmployeeInfo> findAll(Pageable pageable);
//    Page<HrEmployeeInfo> findAllByOrderByIdDesc(Pageable pageable);
    HrEmployeeInfo save(HrEmployeeInfo hrEmployeeInfo);
    HrEmployeeInfo findOne(Integer integer);
    void delete(Integer integer);

    Page<HrEmployeeInfo> search(String empName, String code, String contains, Pageable pageReguest);

    List<HrEmployeeInfo> findByMyUserOrderByIdDesc();

    int countByCode(String code);

}
