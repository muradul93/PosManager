package posmanager.restcontroller;

import posmanager.domain.EmployeeLogAddressInfo;
import posmanager.domain.HrEmployeeInfo;
import posmanager.domain.MyUser;
import posmanager.domain.UserGcmInfo;
import posmanager.restdomain.*;
import posmanager.service.EmployeeLogAddressInfoService;
import posmanager.service.HrEmployeeInfoService;
import posmanager.service.MyUserService;
import posmanager.utility.Maneger;
import posmanager.utility.Path;
import posmanager.utility.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Created by dream71 on 19/10/17.
 */
@RestController
@RequestMapping(value = Path.RestPrefix)
public class LoginRestController {

    @Autowired
    MyUserService myUserService;


    @Autowired
    HrEmployeeInfoService hrEmployeeInfoService;

    @Autowired
    EmployeeLogAddressInfoService employeeLogAddressInfoService;




    @RequestMapping(value = "/userLogin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestLoginMessage userlogin(@RequestBody UserLoginObject userLoginObject) {
        RestLoginMessage message = new RestLoginMessage();
        MyUser myUser = myUserService.findByEmail(userLoginObject.getUsername());
        EmployeeLogAddressInfo employeeLogAddressInfo = new EmployeeLogAddressInfo();
        System.out.println("dealer2");

        employeeLogAddressInfo.setMyUser(myUser);
        employeeLogAddressInfo.setLoginIp(userLoginObject.getLoginIp());
        employeeLogAddressInfo.setLoginAddress(userLoginObject.getLoginAddress());
        employeeLogAddressInfo.setLoginLatitude(userLoginObject.getLoginLatitude());
        employeeLogAddressInfo.setLoginLongitude(userLoginObject.getLoginLongitude());
        System.out.println("dealer  lon  :" + userLoginObject.getLoginLatitude());
        try {
            LocalDate parsedDate = LocalDate.parse(userLoginObject.getLoginDateTime());
            employeeLogAddressInfo.setdLoginDateTime(parsedDate);
        } catch (DateTimeParseException n) {

            employeeLogAddressInfo.setdLoginDateTime(LocalDate.now());
        }
        employeeLogAddressInfo = employeeLogAddressInfoService.save(employeeLogAddressInfo);


        HrEmployeeInfo hrEmployeeInfo = hrEmployeeInfoService.findOne(myUser.getHrEmployeeInfo().getId());

        RestUser restUser = new RestUser(myUser.getId(), myUser.getEmail(), myUser.getRole(), myUser.getHrEmployeeInfo().getId()
                , Path.IMAGE_HR_LOCATION + hrEmployeeInfo.getImage());


        Integer userId = myUser.getId();
        if (myUser == null)
            return new RestLoginMessage(Status.UNOTHORIZED, Maneger.LOGIN_FAILED);


        if (new BCryptPasswordEncoder().matches(userLoginObject.getPassword(), myUser.getPasswordHash()))
            return new RestLoginMessage(Status.SUCCESS, Maneger.LOGIN_SUCCESS, restUser);
        else
            return new RestLoginMessage(Status.UNOTHORIZED, Maneger.LOGIN_FAILED);


    }


//    @RequestMapping(value = "/userlogin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public RestLoginMessage login(@RequestBody RestLogin restLogin) {
//
//        MyUser user = myUserService.findByEmail(restLogin.getUsername());
//
//        HrEmployeeInfo hrEmployeeInfo=hrEmployeeInfoService.findOne(user.getHrEmployeeInfo().getId());
//
//
//        RestUser restUser= new RestUser(user.getId(),user.getEmail(),user.getRole(),user.getHrEmployeeInfo().getId()
//               ,Path.IMAGE_HR_LOCATION +hrEmployeeInfo.getImage());
//
//
//
//
//        Integer userId=user.getId();
//        if (user == null)
//            return new RestLoginMessage(Status.UNOTHORIZED, Maneger.LOGIN_FAILED);
//
//
//        if (new BCryptPasswordEncoder().matches(restLogin.getPassword(),user.getPasswordHash()))
//            return new RestLoginMessage(Status.SUCCESS, Maneger.LOGIN_SUCCESS,restUser);
//         else
//            return new RestLoginMessage(Status.UNOTHORIZED, Maneger.LOGIN_FAILED);
//
//    }


    @RequestMapping(value = "/userLogout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message UserLogout(@RequestBody UserLogoutObject userLogoutObject) {
        Message message = new Message();

        try {
            System.out.println("check........userLogoutObject.getLoginID()  :" + userLogoutObject.getLoginID() + "   as :" + userLogoutObject.getLogoutLatitude());

            MyUser myUser = myUserService.findOne(userLogoutObject.getLoginID());
            EmployeeLogAddressInfo employeeLogAddressInfo = employeeLogAddressInfoService.findFirstByMyUserOrderByIdDesc(myUser);
            if (employeeLogAddressInfo != null) {


                employeeLogAddressInfo.setLogoutAddress(userLogoutObject.getLogoutAddress());
                employeeLogAddressInfo.setLogoutLatitude(userLogoutObject.getLogoutLatitude());
                employeeLogAddressInfo.setLogoutLongitude(userLogoutObject.getLogoutLongitude());
                employeeLogAddressInfo.setLogoutIp(userLogoutObject.getLogoutIp());

                try {
                    LocalDate parsedDate = LocalDate.parse(userLogoutObject.getLogoutDateTime());
                    employeeLogAddressInfo.setdLogoutDate(parsedDate);
                } catch (DateTimeParseException n) {

                    employeeLogAddressInfo.setdLoginDateTime(LocalDate.now());
                }
                //System.out.println("check........3");
                employeeLogAddressInfo = employeeLogAddressInfoService.save(employeeLogAddressInfo);
                System.out.println("check........4");
                message.setStaus(Status.SUCCESS);
                message.setMessege("Logout Successfully");
                return message;


            }
        } catch (Exception e) {
            message.setStaus(Status.FAILED);
            message.setMessege("Server Fail To Save Data");
            return message;
        }
        message.setStaus(Status.FAILED);
        message.setMessege("Server Fail To Save Data");
        return message;
    }


}
