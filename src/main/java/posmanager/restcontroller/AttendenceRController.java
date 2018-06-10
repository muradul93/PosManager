package posmanager.restcontroller;


import posmanager.domain.Attendence;
import posmanager.domain.AttendenceLog;
import posmanager.domain.MyUser;

import posmanager.restdomain.AttendanceResponseMessage;
import posmanager.restdomain.AttendenceRequestObject;
import posmanager.service.AttendenceLogService;
import posmanager.service.AttendenceService;
import posmanager.service.MyUserService;
import posmanager.utility.AttendanceTime;
import posmanager.utility.Maneger;
import posmanager.utility.Path;
import posmanager.utility.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by bipulkhan on 7/2/17.
 */
@RestController
public class AttendenceRController {


    @Autowired
    AttendenceService attendenceService;

    @Autowired
    AttendenceLogService attendenceLogService;


    @Autowired
    MyUserService myUserService;



    @RequestMapping(value = Path.RestPrefix + "/attendence", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public AttendanceResponseMessage attendence(@RequestBody AttendenceRequestObject attendenceRequestObject, Principal principal) {

        AttendanceResponseMessage attendanceResponseMessage = new AttendanceResponseMessage();

        try {
            //User Id Set
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
           // String currentPrincipalName = authentication.getName();


            MyUser myUser = myUserService.findByEmail(principal.getName());

            LocalTime localTime = LocalDateTime.now().toLocalTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");


            String currenttime = localTime.format(formatter);

            LocalTime inTime = LocalTime.parse(AttendanceTime.INTIME.time());
            LocalTime outTime = LocalTime.parse(AttendanceTime.OUTTIME.time());

            /** Attendence Log Store Start **/

            AttendenceLog attendenceLog = new AttendenceLog();

            attendenceLog.setUserId(myUser.getId());
            attendenceLog.setLat(attendenceRequestObject.getLatitude().toString());
            attendenceLog.setLon(attendenceRequestObject.getLongitude().toString());
            attendenceLog.setAttemptDate(LocalDate.now());
            attendenceLog.setAttemptTime(currenttime);
            attendenceLog.setDeviceId(attendenceRequestObject.getDeviceId());
            attendenceLog.setStatus(Status.STATUS_FAIL);
            attendenceLog = attendenceLogService.save(attendenceLog);


//            if (attendenceRequestObject.getUserId() == myUser.getId()) {

          //  Organization organization = organizationService.findOne(attendenceRequestObject.getUserId());


            System.out.println("--------------------------->>");
            List<Attendence> attendences = attendenceService.findByLocalDateAndUserId(LocalDate.now(), myUser.getId());
            System.out.println("---------------------------<<" + attendences.size());

            if (attendences.size() == 0) {
                System.out.println("---------------------------attendence in 1 ::: " + attendenceRequestObject.getUserId());
                Attendence attendence = new Attendence();
                attendence.setUserId(myUser.getId());
                attendence.setWareHouseId(attendenceRequestObject.getUserId());
                attendence.setLocalDate(LocalDate.now());
                attendence.setInTime(currenttime);
                attendence.setInAttendenceLogId(attendenceLog.getId());
                attendence.setLocationStatus(Status.STATUS_EXACT_PLACE);

                if (localTime.isAfter(inTime)) {
                    attendence.setInTimeStatus(Status.STATUS_LATE);
                } else {
                    attendence.setInTimeStatus(Status.STATUS_PERFECT_TIME);
                }
                System.out.println("---------------------------attendence in 2");
                attendenceService.save(attendence);
                System.out.println("---------------------------attendence in 3");
                attendenceLog.setStatus(Status.STATUS_SUCCESS);
                attendenceLogService.save(attendenceLog);
                System.out.println("---------------------------attendence in 4");
            } else {
                System.out.println("---------------------------attendence out 1");
                Attendence attendence = attendences.get(0);
                System.out.println("---------------------------attendence out 2");
                attendence.setOutTime(currenttime);
                System.out.println("---------------------------attendence out 3");
                if (localTime.isBefore(outTime)) {
                    attendence.setOutTimeStatus(Status.STATUS_EARLY_LEAVE);
                } else {
                    attendence.setOutTimeStatus(Status.STATUS_PERFECT_TIME);
                }


                attendence.setOutAtttendenceLogId(attendenceLog.getId());
                attendenceService.save(attendence);

                attendenceLog.setStatus(Status.STATUS_SUCCESS);
                attendenceLogService.save(attendenceLog);
            }

            attendanceResponseMessage.setStaus(Status.SUCCESS);
            attendanceResponseMessage.setMessege(Maneger.DATA_FEACHES_SUCCESSS);
            attendanceResponseMessage.setAttendenceStatus(Status.STATUS_SUCCESS);
            attendanceResponseMessage.setAttendenceMessage(Maneger.DATA_SAVE_SUCCESS);


//            } else {
//                attendanceResponseMessage.setStaus(Status.SUCCESS);
//                attendanceResponseMessage.setMessege(Maneger.DATA_FEACHES_SUCCESSS);
//                attendanceResponseMessage.setAttendenceStatus(Status.STATUS_FAIL);
//                attendanceResponseMessage.setAttendenceMessage(Maneger.DATA_UNOTHORIZED_PUSH);
//            }

            return attendanceResponseMessage;
        } catch (Exception e) {
            attendanceResponseMessage.setStaus(Status.FAILED);
            attendanceResponseMessage.setMessege(Maneger.SERVER_ERROR);
            attendanceResponseMessage.setAttendenceStatus(Status.STATUS_FAIL);
            attendanceResponseMessage.setAttendenceMessage(Maneger.SERVER_ERROR);

            return attendanceResponseMessage;
        }


    }


}
