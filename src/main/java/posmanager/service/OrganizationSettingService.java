package posmanager.service;


import posmanager.domain.OrganizationSetting;

/**
 * Created by root on 13/4/17.
 */
public interface OrganizationSettingService {
    OrganizationSetting save(OrganizationSetting organizationSetting);
    OrganizationSetting findOne(Integer integer);
}
