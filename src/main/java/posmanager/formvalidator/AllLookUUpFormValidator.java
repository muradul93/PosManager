package posmanager.formvalidator;


import posmanager.domain.AllLookUp;
import posmanager.service.AllLookUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by dream71 on 2/7/17.
 */
@Component
public class AllLookUUpFormValidator implements Validator {

    @Autowired
    AllLookUpService allLookUpService;

    private static String editAllLookUpName="";

    @Override
    public boolean supports(Class<?> aClass) {
        return AllLookUp.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AllLookUp allLookUp = (AllLookUp) o;

        if (allLookUpService.countByAllLookUpName(allLookUp.getAllLookUpName()) != 0 && !editAllLookUpName.equals(allLookUp.getAllLookUpName())) {
            errors.rejectValue("allLookUpName","allLookUp.user.exist");

        }
    }

    public static void setEditAllLookUpName(String editAllLookUpName) {
        AllLookUUpFormValidator.editAllLookUpName = editAllLookUpName;
    }

}
