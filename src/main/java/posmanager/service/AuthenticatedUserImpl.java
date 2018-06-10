package posmanager.service;

import posmanager.config.AuthenticatedUser;
import posmanager.domain.MyUser;
import posmanager.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by dream71 on 19/9/17.
 */
@Service
public class AuthenticatedUserImpl implements UserDetailsService {

    @Autowired
    MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MyUser user = myUserRepository.findByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException("The user " + s + " does not exist");
        }

        if (user.isActive()) {
            return new AuthenticatedUser(user);
        } else {
            return new AuthenticatedUser(user.getPasswordHash(), user.getEmail());
        }


    }
}
