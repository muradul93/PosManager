package posmanager.service;


import posmanager.domain.MyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Dream71 on 29-Jan-17.
 */
public interface MyUserService {

    MyUser save(MyUser myUser);
    Page<MyUser> findAll(Pageable pageable);
    List<MyUser> findAll();
    int countByEmail(String email);
    MyUser findOne(Integer integer);
    MyUser findByEmail(String email);
    MyUser editAndSave(MyUser editUser);
    List<MyUser>findAllByRoleSR();
    List<MyUser>findAllByRoleKeeper();
    Page<MyUser> search(String arg, Pageable pageable);
    void delete(Integer integer);
}
