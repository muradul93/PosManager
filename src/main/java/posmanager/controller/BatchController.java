package posmanager.controller;

import posmanager.domain.Batch;

import posmanager.service.BatchService;
import posmanager.utility.Maneger;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Created by Murad on 10/31/2017.
 */



@Controller
@RequestMapping(value = "/batch")
public class BatchController {


    @Autowired
    BatchService batchService;

//    @Autowired
//    BatchFormValidator validator;



    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Model model) {
        Batch batch=new Batch();
        batch.setBatchNo(batchService.batchNo());
        model.addAttribute("batch", batch);
        return "batch/form";
    }


    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute(value = "batch") Batch batch, BindingResult bindingResult, Model model,
                       final RedirectAttributes redirectAttributes) throws IOException {

        if (batch.getId() != null)
          //  validator.setEditBatchNo(batchService.findOne(batch.getId()).getBatchNo());


        //validator.validate(batch, bindingResult);
        if (bindingResult.hasErrors()) {
            return "batch/form";
        }


        if (batch.getId() == null) {



            try {
                batch.setManufactureDate(LocalDate.parse(batch.getManufactureDateStr(), Maneger.formatter));
            } catch (DateTimeParseException n) {
                batch.setManufactureDate(null);
            }
            try {
                batch.setExpirationDate(LocalDate.parse(batch.getExpirationDateStr(), Maneger.formatter));
            } catch (DateTimeParseException n) {
                batch.setExpirationDate(null);
            }
            batchService.save(batch);
            redirectAttributes.addFlashAttribute("save", batch.getBatchNo() + " Batch Added Successfully.");
        } else {

            Batch batch1=batchService.findOne(batch.getId());
            try {
                batch1.setManufactureDate(LocalDate.parse(batch.getManufactureDateStr(), Maneger.formatter));
            } catch (DateTimeParseException n) {
                batch1.setManufactureDate(null);
            }
            try {
                batch1.setExpirationDate(LocalDate.parse(batch.getExpirationDateStr(), Maneger.formatter));
            } catch (DateTimeParseException n) {
                batch1.setExpirationDate(null);
            }

            batchService.save(batch1);

            redirectAttributes.addFlashAttribute("edit", batch.getBatchNo() + " Batch Updated Successfully.");
        }

        return "redirect:allBatch";
    }

    @RequestMapping(value = "/allBatch")
    public String allVanType(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 20) Pageable pageable) {
        model.addAttribute("allBatch", batchService.findAll(pageable));
        return "batch/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Integer id, Model model, ModelMap modelMap) {
        Batch batch = batchService.findOne(id);
        batch.setExpirationDateStr(batch.getExpirationDate() == null ? "" : batch.getExpirationDate().format(Maneger.formatter));
        batch.setManufactureDateStr(batch.getManufactureDate() == null ? "" : batch.getManufactureDate().format(Maneger.formatter));
        model.addAttribute("batch", batch);
        return "batch/form";
    }



    @RequestMapping(value = "/delete/{id}")
    String delete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttrs) {
        Batch batch = batchService.findOne(id);
        batchService.delete(id);
        redirectAttrs.addFlashAttribute("delete", batch.getBatchNo() + " Batch Deleted Successfully.");
        return "redirect:/batch/allBatch";
    }





}
