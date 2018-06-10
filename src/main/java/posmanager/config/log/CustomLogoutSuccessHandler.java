package posmanager.config.log;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;
import posmanager.domain.CustomLog;
import posmanager.repository.CustomLogRepositiry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 19/6/17.
 */
@Component
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    CustomLogRepositiry customLogRepositiry;

    @Override
    public void onLogoutSuccess(HttpServletRequest request,HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        String userAgent = request.getHeader("User-Agent");
        customLogRepositiry.save(new CustomLog(request.getRemoteAddr(), authentication.getName(),"", userAgent,"LOGOUT"));
        super.onLogoutSuccess(request, response, authentication);
    }

}
