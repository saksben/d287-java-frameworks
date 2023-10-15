package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Controller
public class AddOutsourcedPartController {
    private Set<Part> listParts = new HashSet<>();
    private boolean verify = false;

    @Autowired
    private ApplicationContext context;

    //send user to Outsourced Part form and add part to model
    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(Model theModel){
        Part part=new OutsourcedPart();
        theModel.addAttribute("outsourcedpart",part);
        return "OutsourcedPartForm";
    }

    //submit part added by user and display confirmation
    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") OutsourcedPart part, BindingResult bindingResult, Model theModel){
        theModel.addAttribute("outsourcedpart",part);
        if(bindingResult.hasErrors()){
            return "OutsourcedPartForm";
        }
        else{
        OutsourcedPartService repo=context.getBean(OutsourcedPartServiceImpl.class);
        OutsourcedPart op=repo.findById((int)part.getId());
        if(op!=null)part.setProducts(op.getProducts());

            //if there is already a part with the same name, create a multi-pack version
            for (Part thing : listParts) {
                if (thing.getName().equals(part.getName())) {
                    verify = true;
                } else {
                    verify = false;
                }
            }

            if (verify == true) {
                part.multiPart();
                listParts.add(part);
            } else {
                listParts.add(part);
            }

            repo.save(part);
        return "confirmationaddpart";}
    }



}
