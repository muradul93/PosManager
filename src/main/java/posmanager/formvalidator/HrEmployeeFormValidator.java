package posmanager.formvalidator;


import posmanager.domain.HrEmployeeInfo;
import posmanager.service.HrEmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by abc on 2/7/17.
 */
@Component
public class HrEmployeeFormValidator implements Validator {

    @Autowired
    HrEmployeeInfoService hrEmployeeInfoService;

    public static  String nId="";

    public static void setnId(String nId) {
        HrEmployeeFormValidator.nId = nId;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return HrEmployeeInfo.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        HrEmployeeInfo hrEmploye= (HrEmployeeInfo) o;
        int i = hrEmployeeInfoService.countByCode(hrEmploye.getCode());
            if (i != 0 && !nId.equals(hrEmploye.getCode())) {
                errors.rejectValue("code","code.exist");
            }
    }
}
