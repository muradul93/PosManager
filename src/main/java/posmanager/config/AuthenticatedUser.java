package posmanager.config;

import posmanager.domain.MyUser;
import posmanager.utility.RoleFMCG;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by dream71 on 19/9/17.
 */
public class AuthenticatedUser implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;
    private String password;
    private String username;

    public AuthenticatedUser(MyUser user) {
        this.username = user.getEmail();
        this.password = user.getPasswordHash();
        this.authorities = new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(user.getRole())));
    }

    public AuthenticatedUser(String password, String username) {
        this.password = password;
        this.username = username;
        this.authorities = new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(RoleFMCG.ROLE_BLOCKED.name())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}