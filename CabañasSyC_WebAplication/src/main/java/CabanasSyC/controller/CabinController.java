package CabanasSyC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import CabanasSyC.domain.Cabin;
import CabanasSyC.service.CabinService;


@Controller
@RequestMapping("/cabins")
public class CabinController {
    @Autowired
    private CabinService cabinService;

    @GetMapping("/cabinsList")
    public String listCabins(Model model) {
        var cabins = cabinService.getAllCabins();
        
        model.addAttribute("cabins", cabins);
        return "/cabins/cabinsList";
    }

    @GetMapping("/new")
    public String newCabin(Cabin cabin) {
        return "/cabins/edit";
    }

    @GetMapping("/edit/{id}")
    public String editCabin(Long id, Model model) {
        var cabin = cabinService.getCabinById(id);
        model.addAttribute("cabin", cabin);
        return "/cabins/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteCabin(Long id) {
        cabinService.deleteCabana(id);
        return "redirect:/cabins/list";
    }

    @PostMapping("/save")
    public String saveCabin(Cabin cabin) {
        cabinService.saveOrUpdate(cabin);
        return "redirect:/cabins/list";
    }
}
