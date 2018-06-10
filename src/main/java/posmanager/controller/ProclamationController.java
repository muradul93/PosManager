package posmanager.controller;

import posmanager.domain.Proclamation;
import posmanager.formdomain.FormProclamation;
import posmanager.service.ProclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by root on 31/5/17.
 */
@Controller
@RequestMapping("/proclamation")
public class ProclamationController {

    @Autowired
    ProclamationService proclamationService;
    
    @RequestMapping(value = "/getHeaderData", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody FormProclamation getProclamation() {
        List<Proclamation> list = proclamationService.findByAliveOrderByIdDesc(true);
        List<Proclamation> top5List = list.stream().limit(5).collect(Collectors.toList());
        return new FormProclamation(top5List, list.size());
    }

    @RequestMapping(value = "/allProclamation")
    public String allProclamation(Model model,Pageable pageable) {
        model.addAttribute("allProclamation", proclamationService.findByAliveOrderByIdDesc(true, pageable));
        return "proclamation/show";
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam("ser") String arg, Model model, Pageable pageable) {
        model.addAttribute("allProclamation", proclamationService.findByNameContainsAndAliveOrderByIdDesc(arg, true, pageable));
        return "proclamation/show";
    }

    @RequestMapping(value = "/seen/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        Proclamation one = proclamationService.findOne(id);
        one.setAlive(false);
        proclamationService.save(one);
        return "forward:/"+one.getLink();
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read(RedirectAttributes redirectAttributes) {
        proclamationService.deleteAll();
        redirectAttributes.addFlashAttribute("delete", " All Notice Deleted Successfully.");
        return "redirect:/proclamation/allProclamation";
    }
}


