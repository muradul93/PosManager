package posmanager.formvalidator;

;
import posmanager.domain.MyUser;
import posmanager.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by dream71 on 2/7/17.
 */
@Component
public class MyUserFormValidator implements Validator {

    @Autowired
    MyUserService myUserService;

    private static String editEmail="";

    @Override
    public boolean supports(Class<?> aClass) {
        return MyUser.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MyUser myUser = (MyUser) o;
        if (myUserService.countByEmail(myUser.getEmail()) != 0 && !editEmail.equals(myUser.getEmail())) {
            errors.rejectValue("email","user.user.exist");
        }
        /*if (!myUser.getPasswordHash().equals(myUser.getRePassword())) {
            errors.rejectValue("rePassword","user.password.mismatch");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordHash", "user.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rePassword", "user.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.name.empty");*/
    }

    public static void setEditEmail(String editEmail) {
        MyUserFormValidator.editEmail = editEmail;
    }
}
