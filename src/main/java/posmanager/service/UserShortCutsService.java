package posmanager.service;



import posmanager.domain.UserShortCuts;

import java.util.List;

/**
 * Created by  on 4/27/17.
 */
public interface UserShortCutsService {
    List<UserShortCuts> findByUsernameOrderByIdDesc(String username);

    UserShortCuts findByPathAndUsername(String path, String username);

    void deleteByUsername(String username);

    UserShortCuts save(UserShortCuts userShortCuts);

    void deleteByPathAndUsername(String path, String username);

    void deleteNull();

}
