package posmanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import posmanager.domain.CompanyDetails;
import posmanager.repository.CompanyRepository;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
@RequestMapping(value = "/companys")
public class CompanyController {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("companyDetails", new CompanyDetails());
        model.addAttribute("url", "/register");
        return "/company/form";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegistration(@Valid @ModelAttribute("companyDetails") CompanyDetails companyDetails, BindingResult result, Model model) {

        CompanyDetails company = companyRepository.findByCode(companyDetails.getCode());

        if (companyDetails.getId() == null && company!=null) {
            model.addAttribute("exist", "exist");
            return "/company/form";
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
        return "/company/companyList";
    }

    @RequestMapping(value = "/deleteCompany", method = RequestMethod.GET)
    public String deleteCompany(@RequestParam(name = "id") int id) {
        companyRepository.delete(id);
        return "redirect:/company/companyList";
    }


    @RequestMapping(value = "/editCompany", method = RequestMethod.GET)
    public String editCompany(@RequestParam(name = "id") int id, Model model) {
        CompanyDetails company = companyRepository.findOne(id);
        model.addAttribute("url", "/editCompany");
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
}
