package br.com.peopleregister.peopleregister.controllers;

import br.com.peopleregister.peopleregister.models.Address;
import br.com.peopleregister.peopleregister.models.User;
import br.com.peopleregister.peopleregister.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/details/{id}")
    public Address searchAddress (@PathVariable("id") Long id) {
        return addressService.search(id).get();
    }

    @GetMapping("/list")
    public List<Address> searchAll () {
        return addressService.searchAll();
    }

    @PostMapping("/register")
    public Address registerUser (@RequestBody Address address) throws ParseException {

        return addressService.save(address);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteAddressById (@PathVariable("id") Long id) {
        addressService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Address updateAddress (@PathVariable ("id") Long id, @RequestBody Address updatedAddress) {
        return addressService.updateAddress(id, updatedAddress);

    }
}
