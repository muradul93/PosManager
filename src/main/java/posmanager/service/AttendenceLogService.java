package posmanager.service;

import posmanager.domain.AttendenceLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by bipulkhan on 7/2/17.
 */
public interface AttendenceLogService {

    AttendenceLog save(AttendenceLog attendenceLog);

    AttendenceLog findOne(Integer integer);

    List<AttendenceLog> findAll();

    List<AttendenceLog> findAllByOrderByIdDesc();

    Page<AttendenceLog> findAllByOrderByIdDesc(Pageable pageable);

    void delete(Integer integer);

}
