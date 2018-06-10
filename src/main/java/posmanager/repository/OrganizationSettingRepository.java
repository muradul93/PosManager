package posmanager.repository;


import posmanager.domain.OrganizationSetting;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by root on 13/4/17.
 */
public interface OrganizationSettingRepository extends JpaRepository<OrganizationSetting, Integer> {
    OrganizationSetting save(OrganizationSetting organizationSetting);
    OrganizationSetting findOne(Integer integer);
}
