package posmanager.service;


import posmanager.domain.AttendenceLog;
import posmanager.repository.AttendenceLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bipulkhan on 7/2/17.
 */
@Service
public class AttendenceLogServiceImpl implements AttendenceLogService {

    @Autowired
    AttendenceLogRepository attendenceLogRepository;

    @Override
    public AttendenceLog save(AttendenceLog attendenceLog) {
        return attendenceLogRepository.save(attendenceLog);
    }

    @Override
    public AttendenceLog findOne(Integer integer) {
        return attendenceLogRepository.findOne(integer);
    }

    @Override
    public List<AttendenceLog> findAll() {
        return attendenceLogRepository.findAll();
    }

    @Override
    public List<AttendenceLog> findAllByOrderByIdDesc() {
        return attendenceLogRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Page<AttendenceLog> findAllByOrderByIdDesc(Pageable pageable) {
        return attendenceLogRepository.findAllByOrderByIdDesc(pageable);
    }

    @Override
    public void delete(Integer integer) {
        attendenceLogRepository.delete(integer);
    }
}
