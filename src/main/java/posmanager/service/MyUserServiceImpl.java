package posmanager.service;


import posmanager.domain.MyUser;
import posmanager.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static posmanager.utility.RoleFMCG.ROLE_SR;
import static posmanager.utility.RoleFMCG.ROLE_WAREHOUSE;

/**
 * Created by Dream71 on 29-Jan-17.
 */
@Service
@Transactional
public class MyUserServiceImpl implements MyUserService {

    @Autowired
    MyUserRepository myUserRepository;

    @Override
    public MyUser save(MyUser myUser) {
        myUser.setPasswordHash(new BCryptPasswordEncoder().encode(myUser.getPasswordHash()));
        return myUserRepository.save(myUser);
    }

    @Override
    public Page<MyUser> findAll(Pageable pageable) {
        return myUserRepository.findAll(pageable);
    }

    @Override
    public int countByEmail(String email) {
        return myUserRepository.countByEmail(email);
    }

    @Override
    public MyUser findOne(Integer integer) {
        return myUserRepository.findOne(integer);
    }

    @Override
    public MyUser editAndSave(MyUser editUser) {
        return myUserRepository.save(editUser);
    }

    @Override
    public List<MyUser> findAllByRoleSR() {
        return myUserRepository.findAllByRole(ROLE_SR.name());
    }

    @Override
    public List<MyUser> findAllByRoleKeeper() {
        return myUserRepository.findAllByRole(ROLE_WAREHOUSE.name());
    }

    @Override
    public Page<MyUser> search(String arg, Pageable pageable) {
        return myUserRepository.findByEmailContainsOrRoleContainsOrHrEmployeeInfo_EmpNameContains(
                arg,arg,arg,pageable
        );
    }

    @Override
    public void delete(Integer integer) {
        myUserRepository.delete(integer);
    }

    @Override
    public MyUser findByEmail(String email) {
        return myUserRepository.findByEmail(email);
    }

    @Override
    public List<MyUser> findAll() {
        return myUserRepository.findAll();
    }


}
