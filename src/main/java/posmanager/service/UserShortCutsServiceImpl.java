package posmanager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import posmanager.domain.UserShortCuts;
import posmanager.repository.UserShortCutsRepository;

import java.util.List;

/**
 * Created by  on 4/27/17.
 */
@Transactional
@Service
public class UserShortCutsServiceImpl implements UserShortCutsService {

    @Autowired
    UserShortCutsRepository userShortCutsRepository;

    @Autowired
    MyUserService myUserService;

    @Override
    public List<UserShortCuts> findByUsernameOrderByIdDesc(String username) {
        return userShortCutsRepository.findAllByHrEmployeeInfoOrderByIdDesc(myUserService.findByEmail(username).getHrEmployeeInfo());
    }

    @Override
    public UserShortCuts findByPathAndUsername(String path, String username) {
        return userShortCutsRepository.findByPathAndHrEmployeeInfo(path, myUserService.findByEmail(username).getHrEmployeeInfo());
    }

    @Override
    public void deleteByUsername(String username) {
        List<UserShortCuts> list = userShortCutsRepository.findAllByHrEmployeeInfoOrderByIdDesc(myUserService.findByEmail(username).getHrEmployeeInfo());
        for (UserShortCuts shortCuts : list) {
            shortCuts.setHrEmployeeInfo(null);
            userShortCutsRepository.save(shortCuts);
        }
//        userShortCutsRepository.deleteByHrEmployeeInfo(myUserService.findByEmail(username).getHrEmployeeInfo());
    }

    @Override
    public UserShortCuts save(UserShortCuts userShortCuts) {
        return userShortCutsRepository.save(userShortCuts);
    }

    @Override
    public void deleteByPathAndUsername(String path, String username) {
        UserShortCuts nl = userShortCutsRepository.findByPathAndHrEmployeeInfo(path, myUserService.findByEmail(username).getHrEmployeeInfo());
        nl.setHrEmployeeInfo(null);
        userShortCutsRepository.save(nl);
//        userShortCutsRepository.deleteByPathAndHrEmployeeInfo(path, myUserService.findByEmail(username).getHrEmployeeInfo());
    }

    @Override
    public void deleteNull() {
        userShortCutsRepository.deleteByHrEmployeeInfoNull();
    }
}
