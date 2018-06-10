package posmanager.controller;

import posmanager.domain.AllLookUp;

import posmanager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping(value="/allLookUp")
public class AllLookUpController {

    @Autowired
    AllLookUpService allLookUpService;



   @RequestMapping(value = "/show",method = RequestMethod.GET)
    public String addMOU(ModelMap modelMap,Model model){
        model.addAttribute("all_look_up",new AllLookUp());
        return "allLookUp/add_all_look_up";
    }

    @RequestMapping(value="/show",method = RequestMethod.POST)
    public String SaveMou(@Valid @ModelAttribute( "all_look_up") AllLookUp allLookUp, BindingResult bindingResult,Model model,final RedirectAttributes redirectAttributes){

        if (allLookUp.getId()!=null)
           // allLookUUpFormValidator.setEditAllLookUpName(allLookUpService.findOne(allLookUp.getId()).getAllLookUpName());

        /*allLookUUpFormValidator.validate(allLookUp,bindingResult);
         if(bindingResult.hasErrors()){
             return "allLookUp/add_all_look_up";
         }*/

        if (allLookUp.getId() == null) {
            allLookUpService.save(allLookUp);
            redirectAttributes.addFlashAttribute("save", allLookUp.getAllLookUpName()+" Look Up Name Added Successfully.");
        } else {
            AllLookUp editRole = allLookUpService.findOne(allLookUp.getId());
            editRole.setAllLookUpName(allLookUp.getAllLookUpName());
            editRole.setAllLookUpCode(allLookUp.getAllLookUpCode());
            editRole.setAllLookUpModule(allLookUp.getAllLookUpModule());
            editRole.setAllLookUpDescription(allLookUp.getAllLookUpDescription());
            allLookUpService.save(editRole);
            redirectAttributes.addFlashAttribute("edit", allLookUp.getAllLookUpName()+" Look Up Name Updated Successfully.");
        }

        model.addAttribute("allLookUp",allLookUpService.findAllByOrderByIdDesc());
        return "redirect:all_look_up";
    }

    @RequestMapping(value = "/editshow", method = RequestMethod.POST)
    public @ResponseBody boolean EditMou(@RequestBody AllLookUp AllLookUpObj) {

        if (showEditValid(AllLookUpObj)) {
            AllLookUp editLookUp = allLookUpService.findOne(AllLookUpObj.getId());
            editLookUp.setAllLookUpName(AllLookUpObj.getAllLookUpName());
            editLookUp.setAllLookUpCode(AllLookUpObj.getAllLookUpCode());
            editLookUp.setAllLookUpModule(AllLookUpObj.getAllLookUpModule());
            editLookUp.setAllLookUpDescription(AllLookUpObj.getAllLookUpDescription());
            allLookUpService.save(editLookUp);
            return true;
        }

        return false;

    }


    @RequestMapping(value = "/all_look_up")
    public String allAllLookUp(Model model,@PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 20) Pageable pageable){
        model.addAttribute("allLookUp", allLookUpService.findAll(pageable));
        return "allLookUp/show_all_look_up";
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam("ser") String arg, Model model, @PageableDefault(size = 20) Pageable pageable) {
        Page<AllLookUp> res = allLookUpService.findByAllLookUpNameContainsOrAllLookUpCodeContainsAllIgnoreCase(arg, arg, pageable);
        model.addAttribute("allLookUp", res);
        return "allLookUp/show_all_look_up";
    }

    @RequestMapping(value = "/delete/{id}")
    public  String deleteObject(@PathVariable Integer id, Model model,RedirectAttributes redirectAttrs){
        String name = allLookUpService.findOne(id).getAllLookUpName();
        allLookUpService.delete(id);
        redirectAttrs.addFlashAttribute("delete", name+" Look Up Name Deleted Successfully.");
        return "redirect:/allLookUp/all_look_up";
    }


    @RequestMapping(value = "/edit/{id}")
    String editAllLookUp(@PathVariable Integer id, Model model,ModelMap modelMap) {
        model.addAttribute("all_look_up", allLookUpService.findOne(id));
        return "allLookUp/add_all_look_up";
    }

    private  boolean showEditValid(AllLookUp allLookUp){

        AllLookUp allLookup =allLookUpService.findOne(allLookUp.getId());

        if (allLookUpService.countByAllLookUpName(allLookUp.getAllLookUpName()) != 0&& !allLookUp.getAllLookUpName().contentEquals(allLookup.getAllLookUpName().toString())) {
            return false;
        }else{
            return  true;
        }
    }

//    @Autowired
//    ProductService productService;
//
//    @Autowired
//    PriceMasterService priceMasterRepository;
//
//    @Autowired
//    PriceDetailsService priceDetailsRepository;

}




