package posmanager.repository;

import posmanager.domain.AttendenceLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bipulkhan on 7/2/17.
 */
@Repository
public interface AttendenceLogRepository extends JpaRepository<AttendenceLog,Integer> {

    AttendenceLog save(AttendenceLog attendenceLog);

    AttendenceLog findOne(Integer integer);

    List<AttendenceLog> findAll();

    List<AttendenceLog> findAllByOrderByIdDesc();

    Page<AttendenceLog> findAllByOrderByIdDesc(Pageable pageable);

    void delete(Integer integer);


}
