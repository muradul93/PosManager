package posmanager.repository;


import posmanager.domain.MyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dream71 on 29-Jan-17.
 */
@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

  @Override
  MyUser save(MyUser myUser);


  Page<MyUser> findByEmailContainsOrRoleContainsOrHrEmployeeInfo_EmpNameContains( String email, String role, String emp, Pageable pageable);

  List<MyUser>findAllByRole(String role);
  int countByEmail(String email);

  MyUser findByEmail(String email);

  @Override
  void delete(Integer integer);
}
