package posmanager.repository;


import posmanager.domain.CustomLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by root on 19/6/17.
 */
public interface CustomLogRepositiry extends JpaRepository<CustomLog, Integer> {
}
