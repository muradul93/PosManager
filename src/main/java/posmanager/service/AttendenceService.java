package posmanager.service;


import posmanager.domain.Attendence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by bipulkhan on 7/2/17.
 */
public interface AttendenceService {

    Attendence save(Attendence attendence);

    Attendence findOne(Integer integer);

    List<Attendence> findAll();

    List<Attendence> findAllByOrderByIdDesc();

    Page<Attendence> findAllByOrderByIdDesc(Pageable pageable);

    List<Attendence> findByLocalDateAndUserId(LocalDate localDate, Integer userID);

    Page<Attendence> findByLocalDateBeforeOrLocalDateOrUserIdOrderByIdDesc(
            LocalDate startDate1, LocalDate startDate2, Integer SrId, Pageable pageable);



    Page<Attendence> findByLocalDateAfterOrLocalDateOrUserIdOrderByIdDesc(
            LocalDate startDate1, LocalDate startDate2, Integer SrId, Pageable pageable);


    Page<Attendence> findByLocalDateBetweenOrUserIdOrderByIdDesc(
            LocalDate startDate1, LocalDate startDate2, Integer SrId, Pageable pageable);

    Page<Attendence> findByUserIdOrderByIdDesc(
            Integer SrId, Pageable pageable);


    Page<Attendence> findByUserId(Integer userID, Pageable pageable);


    void  delete(Integer integer);

}
