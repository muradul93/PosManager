package posmanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import posmanager.domain.CompanyDetails;
import posmanager.repository.CompanyRepository;
import posmanager.utility.Maneger;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
@RequestMapping(value = "/company")
public class CompanysController {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("companyDetails", new CompanyDetails());
        model.addAttribute("url", "/register");
        return "/company/add";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegistration(@Valid @ModelAttribute("companyDetails") CompanyDetails companyDetails, BindingResult result, Model model) {

        CompanyDetails company = companyRepository.findByCode(companyDetails.getCode());

        if (companyDetails.getId() == null && company!=null) {
            model.addAttribute("exist", "exist");
            return "/company/add";
        } else {
            try {
                companyDetails.setExpireDate(LocalDate.parse(companyDetails.getExpireDate_str(), formatter));
                companyRepository.save(companyDetails);
            } catch (DateTimeParseException n) {
                companyDetails.setExpireDate(null);
            }
            return "redirect:/company/companyList";
        }
    }

    @RequestMapping(value = "/companyList")
    public String companyList(Model model) {
        List<CompanyDetails> companyList = companyRepository.findAll();
        model.addAttribute("companyList", companyList);
        return "/company/list";
    }

    @RequestMapping(value = "/deleteCompany/{id}", method = RequestMethod.GET)
    public String deleteCompany(@PathVariable Integer id) {
        companyRepository.delete(id);
        return "redirect:/company/companyList";
    }


    @RequestMapping(value = "/editCompany/{id}", method = RequestMethod.GET)
    public String editCompany(@PathVariable Integer id, Model model) {
        CompanyDetails company = companyRepository.findOne(id);
        company.setExpireDate_str(company.getExpireDate() == null ? "" : company.getExpireDate() .format(Maneger.formatter));
       // model.addAttribute("url", "/editCompany");
        model.addAttribute("companyDetails", company);
        return "/company/add";
    }

    @RequestMapping(value = "/editCompany", method = RequestMethod.POST)
    public String editCompany(@Valid @ModelAttribute("companyDetails") CompanyDetails companyDetails, Model model) {

        CompanyDetails company = companyRepository.findByCode(companyDetails.getCode());

        CompanyDetails temp = companyRepository.findOne(companyDetails.getId());
        if (!temp.getCode().equals(companyDetails.getCode()) && company !=null) {
            model.addAttribute("exist", "exist");
            return "/company/add";
        }

        else {
            try {
                temp.setExpireDate(LocalDate.parse(companyDetails.getExpireDate_str(), formatter));
                temp.setCompanyName(companyDetails.getCompanyName());
                temp.setBranchName(companyDetails.getBranchName());
                temp.setCode(companyDetails.getCode());
                temp.setValid(companyDetails.isValid());
                companyRepository.save(temp);
            } catch (DateTimeParseException n) {
                temp.setExpireDate(null);
            }
            return "redirect:/company/companyList";
        }
    }


    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable Integer id, Model model) {
        CompanyDetails  companyDetails=companyRepository.findOne(id);
        model.addAttribute("companyDetails", companyDetails);
        return "/company/details";
    }



}
