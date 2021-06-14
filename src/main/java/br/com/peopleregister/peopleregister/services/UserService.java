package br.com.peopleregister.peopleregister.services;

import br.com.peopleregister.peopleregister.models.Address;
import br.com.peopleregister.peopleregister.models.Phone;
import br.com.peopleregister.peopleregister.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.peopleregister.peopleregister.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressService addressService;
    @Autowired
    PhoneService phoneService;

    public User save(User user){
        return userRepository.save(user);
    }
    public void delete(User user){
        userRepository.delete(user);
    }
    public Optional<User> search (Long id) {
        return userRepository.findById(id);
    }

    public List<User> searchAll (){
        return userRepository.findAll();
    }

    public void deleteById (Long id) {

        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        phoneService.deleteById(user.getPhone().getId());
        addressService.deleteById(user.getAddress().getId());

    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public User updateUser (Long id, User updatedUser) {

        if (userRepository.existsById(id)) {
            updatedUser.setId(id);
            userRepository.save(updatedUser);

        }

        return updatedUser;
    }
}
