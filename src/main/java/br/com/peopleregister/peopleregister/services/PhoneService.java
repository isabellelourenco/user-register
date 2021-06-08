package br.com.peopleregister.peopleregister.services;

import br.com.peopleregister.peopleregister.models.Phone;
import br.com.peopleregister.peopleregister.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    public Phone save(Phone phone){
        return phoneRepository.save(phone);
    }
    public void delete(Phone phone){
        phoneRepository.delete(phone);
    }
    public Optional<Phone> search (Long id) {
        return phoneRepository.findById(id);
    }

    public List<Phone> searchAll (){
        return phoneRepository.findAll();
    }

    public void deleteById (Long id) { phoneRepository.deleteById(id); }

    public Phone updatePhone (Long id, Phone updatedPhone) {

        if (phoneRepository.existsById(id)) {
            updatedPhone.setId(id);
            phoneRepository.save(updatedPhone);

        }

        return updatedPhone;
    }
}
