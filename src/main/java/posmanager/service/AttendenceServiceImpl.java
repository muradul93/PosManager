package posmanager.service;

import posmanager.domain.Attendence;
import posmanager.repository.AttendenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by bipulkhan on 7/2/17.
 */
@Service
public class AttendenceServiceImpl implements AttendenceService {

    @Autowired
    AttendenceRepository attendenceRepository;

    @Override
    public Attendence save(Attendence attendence) {
        return attendenceRepository.save(attendence);
    }

    @Override
    public Attendence findOne(Integer integer) {
        return attendenceRepository.findOne(integer);
    }

    @Override
    public List<Attendence> findAll() {
        return attendenceRepository.findAll();
    }

    @Override
    public List<Attendence> findAllByOrderByIdDesc() {
        return attendenceRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Page<Attendence> findAllByOrderByIdDesc(Pageable pageable) {
        return attendenceRepository.findAllByOrderByIdDesc(pageable);
    }

    @Override
    public List<Attendence> findByLocalDateAndUserId(LocalDate localDate, Integer userID) {
        return attendenceRepository.findByLocalDateAndUserId(localDate, userID);
    }

    @Override
    public Page<Attendence> findByUserId(Integer userID, Pageable pageable) {
        return attendenceRepository.findByUserId(userID, pageable);
    }

    @Override
    public void delete(Integer integer) {
        attendenceRepository.delete(integer);
    }

    @Override
    public Page<Attendence> findByLocalDateBeforeOrLocalDateOrUserIdOrderByIdDesc(LocalDate startDate1, LocalDate startDate2, Integer SrId, Pageable pageable) {
        return attendenceRepository.findByLocalDateBeforeOrLocalDateOrUserIdOrderByIdDesc(startDate1, startDate2, SrId, pageable);
    }

    @Override
    public Page<Attendence> findByLocalDateAfterOrLocalDateOrUserIdOrderByIdDesc(LocalDate startDate1, LocalDate startDate2, Integer SrId, Pageable pageable) {
        return attendenceRepository.findByLocalDateAfterOrLocalDateOrUserIdOrderByIdDesc(startDate1, startDate2, SrId, pageable);
    }

    @Override
    public Page<Attendence> findByLocalDateBetweenOrUserIdOrderByIdDesc(LocalDate startDate1, LocalDate startDate2, Integer SrId, Pageable pageable) {
        return attendenceRepository.findByLocalDateBetweenOrUserIdOrderByIdDesc(startDate1, startDate2, SrId, pageable);
    }

    @Override
    public Page<Attendence> findByUserIdOrderByIdDesc(Integer SrId, Pageable pageable) {
        return attendenceRepository.findByUserIdOrderByIdDesc(SrId, pageable);
    }
}
