package posmanager.service;


import posmanager.domain.OrganizationSetting;
import posmanager.repository.OrganizationSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by root on 13/4/17.
 */
@Service
@Transactional
public class OrganizationSettingServiceImpl implements OrganizationSettingService {

    @Autowired
    OrganizationSettingRepository organizationSettingRepository;

    @Override
    public OrganizationSetting save(OrganizationSetting organizationSetting) {
        return organizationSettingRepository.save(organizationSetting);
    }

    @Override
    public OrganizationSetting findOne(Integer integer) {
        return organizationSettingRepository.findOne(integer);
    }
}
