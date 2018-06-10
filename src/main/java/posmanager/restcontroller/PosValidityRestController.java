package posmanager.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import posmanager.domain.*;
import posmanager.repository.BranchRepository;
import posmanager.repository.CompanyRepository;
import posmanager.restdomain.*;
import posmanager.utility.Maneger;
import posmanager.utility.Path;
import posmanager.utility.Status;

import javax.servlet.ServletContext;
import java.time.LocalDate;

/**
 * Created by Murad on 10/18/2017.
 */

@RestController
@RequestMapping(value = Path.RestPrefix + "/pos")
public class PosValidityRestController {

    @Autowired
    CompanyRepository companyRepository;


    @Autowired
    ServletContext context;

    @Autowired
    BranchRepository branchRepository;


    @RequestMapping(value = "/checkValidity", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public AllGeneralMessage checkCustomerValidity(@RequestBody RestPosUser user) {
        CompanyDetails company;

        try {

            company = companyRepository.findByCode(user.getCode());
            createBranch(user, company);

        } catch (NullPointerException e) {
            company = null;
        }

        if (company != null) {

            RestCompanyDetails restCompanyDetails = new RestCompanyDetails(
                    company.getCompanyName(),
                    company.getBranchName(),
                    company.getCode(),
                    company.isValid(),
                    strDate(company.getExpireDate())
            );
            System.out.println(strDate(company.getExpireDate()));
            return new AllGeneralMessage(Status.SUCCESS, Maneger.DATA_FEACHES_SUCCESSS, restCompanyDetails);
        } else {
            return new AllGeneralMessage(Status.RESOURCE_NOT_FOUND, Maneger.DATA_VALUE_EMPTY);
        }

    }


    public static String strDate(LocalDate r) {
        if (r != null) {
            String monthStr = null;
            if (r.getMonthValue() < 10) {
                monthStr = "0" + r.getMonthValue();
            }
            String reqDateStr = r.getDayOfMonth() + "." + monthStr + "." + r.getYear();
            return reqDateStr;
        }

        return "";

    }


    public void createBranch(RestPosUser user, CompanyDetails company) {
        Branch getBranchByBranchName;
        if (company != null) {
            try {
                getBranchByBranchName = branchRepository.findByBranchName(user.getBranchName());

            } catch (NullPointerException e) {
                getBranchByBranchName = null;
            }

            if (getBranchByBranchName == null) {
                Branch branch = new Branch();
                branch.setBranchName(user.getBranchName());
                branch.setCompanyDetails(company);
                branchRepository.save(branch);


            }
        }


    }


}
