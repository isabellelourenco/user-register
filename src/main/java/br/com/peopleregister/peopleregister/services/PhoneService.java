package br.com.peopleregister.peopleregister.services;

import br.com.peopleregister.peopleregister.models.Phone;
import br.com.peopleregister.peopleregister.models.User;
import br.com.peopleregister.peopleregister.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    UserService userService;

    public Phone save(Phone phone, Long userId){
        Phone newPhone = phoneRepository.save(phone);

        User user = userService.findById(userId);
        user.setPhone(newPhone);
        userService.save(user);

        return newPhone;
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
