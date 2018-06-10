package posmanager.config.log;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import posmanager.domain.CustomLog;
import posmanager.repository.CustomLogRepositiry;

/**
 * Created by root on 19/6/17.
 */
@Component
 class CustomBadCredential implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Autowired
    CustomLogRepositiry customLogRepositiry;


    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        WebAuthenticationDetails auth = (WebAuthenticationDetails)event.getAuthentication().getDetails();
        String userName = event.getAuthentication().getPrincipal().toString();
        String credentials = event.getAuthentication().getCredentials().toString();

        customLogRepositiry.save(new CustomLog(auth.getRemoteAddress(), userName,credentials, "","MALICIOUS USER"));
    }
}
