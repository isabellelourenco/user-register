package br.com.peopleregister.peopleregister.services;

import br.com.peopleregister.peopleregister.models.Address;
import br.com.peopleregister.peopleregister.models.User;
import br.com.peopleregister.peopleregister.repositories.AddressRepository;
import br.com.peopleregister.peopleregister.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public Address save(Address address){
        return addressRepository.save(address);
    }
    public void delete(Address address){
        addressRepository.delete(address);
    }
    public Optional<Address> search (Long id) {
        return addressRepository.findById(id);
    }

    public List<Address> searchAll (){
        return addressRepository.findAll();
    }

    public void deleteById (Long id) {
        addressRepository.deleteById(id);
    }

    public Address updateAddress (Long id, Address updatedAddress) {

        if (addressRepository.existsById(id)) {
            updatedAddress.setId(id);
            addressRepository.save(updatedAddress);

        }

        return updatedAddress;
    }
}
