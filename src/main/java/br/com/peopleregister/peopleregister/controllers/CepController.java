package br.com.peopleregister.peopleregister.controllers;

import br.com.peopleregister.peopleregister.models.Address;
import br.com.peopleregister.peopleregister.repositories.AddressRepository;
import br.com.peopleregister.peopleregister.services.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping("api/ceps/{cep}")
    public ResponseEntity<Address> getCep(@PathVariable String cep) {

        Address address = cepService.searchAddressForCep(cep);

        return address != null ? ResponseEntity.ok().body(address) : ResponseEntity.notFound().build();
    }

}
