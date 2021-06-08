package br.com.peopleregister.peopleregister.controllers;

import br.com.peopleregister.peopleregister.models.Phone;
import br.com.peopleregister.peopleregister.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/phone")
public class PhoneController {

    @Autowired
    PhoneService phoneService;

    @GetMapping("/details/{id}")
    public Phone searchPhone (@PathVariable("id") Long id) {
        return phoneService.search(id).get();
    }

    @GetMapping("/list")
    public List<Phone> searchAll () {
        return phoneService.searchAll();
    }

    @PostMapping("/register")
    public Phone registerPhone (@RequestBody Phone phone) throws ParseException {

        return phoneService.save(phone);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePhoneById (@PathVariable("id") Long id) {
        phoneService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Phone updatePhone (@PathVariable ("id") Long id, @RequestBody Phone updatedPhone) {
        return phoneService.updatePhone(id, updatedPhone);

    }
}
