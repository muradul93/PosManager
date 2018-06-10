package posmanager.controller;


import posmanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

/**
 * Created by root on 17/5/17.
 */
@Controller
public class AdminDashboardController {



    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("cusNo", "5");
        model.addAttribute("salesNo", "5");
        model.addAttribute("invNo", "5");
        model.addAttribute("itemNo", "5");
        model.addAttribute("vanNo", "5");
        return "admin/admin";
    }

}
