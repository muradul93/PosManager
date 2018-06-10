package posmanager.controller;

import posmanager.domain.*;
import posmanager.formvalidator.HrEmployeeFormValidator;
import posmanager.service.*;
import posmanager.utility.Maneger;
import posmanager.utility.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.ServletContext;
import javax.validation.Valid;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


@Controller
@RequestMapping(value = "/hrEmployee")
public class HrEmployeeController {

    @Autowired
    HrEmployeeInfoService hrEmployeeInfoService;

    @Autowired
    HrEmployeeFormValidator validator;

    @Autowired
    MyUserService myUserService;

    @Autowired
    ServletContext context;

    private int imageFlag = 0;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String create(ModelMap modelMap, Model model) {
        model.addAttribute("hrEmployee", new HrEmployeeInfo());
        return "hrEmployee/form";
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute(value = "hrEmployee") HrEmployeeInfo hrEmployee, BindingResult bindingResult, Model model,
                       @RequestParam("file") MultipartFile file, final RedirectAttributes redirectAttributes) throws IOException {

        if (hrEmployee.getId() != null)
            validator.setnId(hrEmployeeInfoService.findOne(hrEmployee.getId()).getCode());


        validator.validate(hrEmployee, bindingResult);
        if (bindingResult.hasErrors()) {
            return "hrEmployee/form";
        }
        String realPathtoUploads = context.getRealPath(Path.IMAGE_HR_LOCATION);

        if (!new File(realPathtoUploads).exists()) {
            System.out.println("Directiry is creating...");
            new File(realPathtoUploads).mkdir();
        }

        HrEmployeeInfo hr = null;

        if (hrEmployee.getId() == null) {

            if (!file.isEmpty()) {
                String s = Maneger.imageBaseName();
                hrEmployee.setImage(s + "" + file.getOriginalFilename());
                FileCopyUtils.copy(file.getBytes(), new File(realPathtoUploads + s + file.getOriginalFilename()));
            } else {
                hrEmployee.setImage(Path.DEFUALT_HR);
            }
            try {
                hrEmployee.setsDate(LocalDate.parse(hrEmployee.getStartDate(), Maneger.formatter));
            } catch (DateTimeParseException n) {
                hrEmployee.setsDate(null);
            }
            try {
                hrEmployee.seteDate(LocalDate.parse(hrEmployee.getEndDate(), Maneger.formatter));
            } catch (DateTimeParseException n) {
                hrEmployee.seteDate(null);
            }
            hrEmployeeInfoService.save(hrEmployee);
            redirectAttributes.addFlashAttribute("save", hrEmployee.getEmpName() + " Employee Added Successfully.");
        } else {
            hr = hrEmployeeInfoService.findOne(hrEmployee.getId());
            hr.setCode(hrEmployee.getCode());
            hr.setEmpName(hrEmployee.getEmpName());
            hr.setContact(hrEmployee.getContact());
            hr.setAltContact(hrEmployee.getAltContact());
            hr.setEmail(hrEmployee.getEmail());
            hr.setNationalId(hrEmployee.getNationalId());
            hr.setDesignation(hrEmployee.getDesignation());
            hr.setPostingArea(hrEmployee.getPostingArea());
            hr.setSalary(hrEmployee.getSalary());
            hr.setPresentAddress(hrEmployee.getPresentAddress());
            hr.setPermanentAddress(hrEmployee.getPermanentAddress());
            try {
                hr.setsDate(LocalDate.parse(hrEmployee.getStartDate(), Maneger.formatter));
            } catch (DateTimeParseException n) {
                hr.setsDate(null);
            }
            try {
                hr.seteDate(LocalDate.parse(hrEmployee.getEndDate(), Maneger.formatter));
            } catch (DateTimeParseException n) {
                hr.seteDate(null);
            }

            if (file.isEmpty()) {
                if (imageFlag == 1)
                    hr.setImage(Path.DEFUALT_HR);
            } else {
                String s = Maneger.imageBaseName();
                hr.setImage(s + "" + file.getOriginalFilename());
                FileCopyUtils.copy(file.getBytes(), new File(realPathtoUploads + s + file.getOriginalFilename()));
            }
            hrEmployeeInfoService.save(hr);
            imageFlag = 0;
            redirectAttributes.addFlashAttribute("edit", hrEmployee.getEmpName() + " Employee Updated Successfully.");
        }

        return "redirect:allType";
    }

    @RequestMapping(value = "/allType")
    public String showAll(Model model,@PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 20) Pageable pageable) {
        model.addAttribute("allType", hrEmployeeInfoService.findAll(pageable));
        return "hrEmployee/list";
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam("ser") String arg, Model model, Pageable pageable) {
        model.addAttribute("allType", hrEmployeeInfoService.search(arg, arg, arg, pageable));
        return "hrEmployee/list";
    }

    @RequestMapping(value = "/delete/{id}")
    String delete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttrs) {

        HrEmployeeInfo hrEmployeeInfo = hrEmployeeInfoService.findOne(id);
        hrEmployeeInfoService.delete(id);

       /* MyUser myUser = hrEmployeeInfo.getMyUser();
        if (myUser != null) {
            myUser.setSendTrash(Status.USER_DELETE);
            myUserService.save(myUser);
        }

        hrEmployeeInfoService.save(hrEmployeeInfo);*/

        redirectAttrs.addFlashAttribute("delete", hrEmployeeInfo.getEmpName() + " Employee Deleted Successfully.");
        return "redirect:/hrEmployee/allType";
    }

    @RequestMapping(value = "/edit/{id}")
    String edit(@PathVariable Integer id, Model model, ModelMap modelMap) {
        HrEmployeeInfo hr = hrEmployeeInfoService.findOne(id);
        hr.setStartDate(hr.getsDate() == null ? "" : hr.getsDate().format(Maneger.formatter));
        hr.setEndDate(hr.geteDate() == null ? "" : hr.geteDate().format(Maneger.formatter));
        model.addAttribute("hrEmployee", hr);
        return "/hrEmployee/form";
    }


    @RequestMapping(value = "/setFlag", method = RequestMethod.POST)
    public @ResponseBody  void setID(@RequestParam("val") Integer val) {
        imageFlag = val;
    }

}
