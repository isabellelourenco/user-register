package services;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

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
        userRepository.deleteById(id);
    }

    public User updateUser (Long id, User updatedUser) {

        if (userRepository.existsById(id)) {
            updatedUser.setId(id);
            userRepository.save(updatedUser);

        }

        return updatedUser;
    }
}
