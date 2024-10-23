package CabanasSyC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import CabanasSyC.domain.Contact;
import CabanasSyC.service.ContactService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contactsList")
    public String listContacts(Model model) {
        var contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "/contactsList";
    }

    @GetMapping("/new")
    public String newContact() {
        return "/contact/edit";
    }

    @GetMapping("/edit/{id}")
    public String editContact(Long id, Model model) {
        var contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "/contact/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(Long id) {
        contactService.deleteContact(id);
        return "redirect:/contact/list";
    }

    @PostMapping("/save")
    public String saveContact(Contact contact) {
        contactService.saveOrUpdate(contact);
        return "redirect:/contact/contact";
    }
    
}
