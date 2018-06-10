package posmanager.controller;

import posmanager.domain.MyUser;
import posmanager.formvalidator.MyUserFormValidator;
import posmanager.service.*;
import posmanager.utility.RoleFMCG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by dream71 on 2/7/17.
 */
@Controller
@RequestMapping("/user")
public class MyUserController {

    @Autowired
    MyUserFormValidator myUserFormValidator;

    @Autowired
    MyUserService myUserService;

    @Autowired
    HrEmployeeInfoService hrEmployeeInfoService;


    @ModelAttribute
    public void initValues(Model model) {
        model.addAttribute("roleComboBox", RoleFMCG.values());
        model.addAttribute("hrEmployeeCBox", hrEmployeeInfoService.findByMyUserOrderByIdDesc());
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("myUser", new MyUser());
        return "user/form";
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute MyUser myUser,@Valid MyUser myUserValid, BindingResult bindingResult, Model model, @RequestParam(value = "onoffswitch", required = false, defaultValue = "false") boolean onoffswitch,
                           final RedirectAttributes redirectAttributes) {

        if(myUser.getId() != null)
            MyUserFormValidator.setEditEmail(myUserService.findOne(myUser.getId()).getEmail());

        myUserFormValidator.validate(myUser, bindingResult);
        if (bindingResult.hasErrors())
                return "user/form";


        myUser.setActive(onoffswitch);

        if (myUser.getId() == null) {
            myUser.setHrEmployeeInfo(hrEmployeeInfoService.findOne(myUser.getHrId()));
            myUserService.save(myUser);
            redirectAttributes.addFlashAttribute("save", myUser.getEmail() + " User Added Successfully.");
        } else {
            MyUser editUser = myUserService.findOne(myUser.getId());
            editUser.setEmail(myUser.getEmail());
            editUser.setActive(onoffswitch);

            String passwordHash = myUser.getPasswordHash();
            if (passwordHash.isEmpty() || passwordHash.equals("")) {
                myUserService.editAndSave(editUser);
            } else {
                editUser.setPasswordHash(myUser.getPasswordHash());
                myUserService.save(editUser);
            }
            redirectAttributes.addFlashAttribute("edit", myUser.getEmail() + " User Updated Successfully.");
        }
        return "redirect:allUser";
    }

    @RequestMapping(value = "/allUser")
    public String allUser(Model model,@PageableDefault(sort = "id", direction = Sort.Direction.DESC,size = 20) Pageable pageable) {
        model.addAttribute("allUser", myUserService.findAll(pageable));
        return "user/list";
    }


    @RequestMapping(value = "/search")
    public String search(@RequestParam("ser") String arg, Model model,@PageableDefault(sort = "id", direction = Sort.Direction.DESC,size = 20) Pageable pageable) {
        if (arg.isEmpty())
            return "redirect:allUser";
        model.addAttribute("allUser", myUserService.search(arg, pageable));
        return "user/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Integer id, Model model, RedirectAttributes redirectAttrs) {
        MyUser myUser = myUserService.findOne(id);

        myUser.setHrEmployeeInfo(null);
        myUserService.save(myUser);

        myUserService.delete(id);
        redirectAttrs.addFlashAttribute("delete", myUser.getEmail() + " User Deleted Successfully.");
        return "redirect:/user/allUser";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        MyUser one = myUserService.findOne(id);
        one.setPasswordHash(null);
        model.addAttribute("myUser", one);
        return "user/form";
    }

    @RequestMapping(value = "/details")
    public String detailDser(Model model, Principal principal) {
        model.addAttribute("myUser", myUserService.findByEmail(principal.getName()));
        return "user/details";
    }

    @RequestMapping(value = "/allUserAnalysis")
    public String allUserAna(Model model,@PageableDefault(sort = "id", direction = Sort.Direction.DESC,size = 20) Pageable pageable) {
        model.addAttribute("allUser", myUserService.findAll(pageable));
        return "user/analysis";
    }

    @RequestMapping(value = "/searchAnalysis")
    public String search1(@RequestParam("ser") String arg, Model model,@PageableDefault(sort = "id", direction = Sort.Direction.DESC,size = 20) Pageable pageable) {
        model.addAttribute("allUser", myUserService.search(arg, pageable));
        return "user/analysis";
    }

    @RequestMapping(value="/changeStatus", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  int validateUsername(@RequestParam("uid") Integer uid, @RequestParam("flag")boolean flag) {
        MyUser one = myUserService.findOne(uid);
        one.setActive(flag);
        myUserService.editAndSave(one);
        return 1;
    }

}
