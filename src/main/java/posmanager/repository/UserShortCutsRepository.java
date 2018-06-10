package posmanager.repository;


import posmanager.domain.HrEmployeeInfo;
import posmanager.domain.UserShortCuts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  on 4/27/17.
 */
@Repository
public interface UserShortCutsRepository extends JpaRepository<UserShortCuts,Integer> {

    List<UserShortCuts> findAllByHrEmployeeInfoOrderByIdDesc(HrEmployeeInfo hrEmployeeInfo);

    UserShortCuts findByPathAndHrEmployeeInfo(String path, HrEmployeeInfo hrEmployeeInfo);

    void deleteByHrEmployeeInfo(HrEmployeeInfo hrEmployeeInfo);

    UserShortCuts save(UserShortCuts userShortCuts);

    void deleteByPathAndHrEmployeeInfo(String path, HrEmployeeInfo hrEmployeeInfo);

    void deleteByHrEmployeeInfoNull();
}
