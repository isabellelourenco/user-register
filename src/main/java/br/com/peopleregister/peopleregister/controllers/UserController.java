package br.com.peopleregister.peopleregister.controllers;

import br.com.peopleregister.peopleregister.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.peopleregister.peopleregister.services.UserService;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/details/{id}")
    public User searchUser (@PathVariable("id") Long id) {
        return userService.search(id).get();
    }

    @GetMapping("/list")
    public List<User> searchAll () {
        return userService.searchAll();
    }

    @PostMapping("/register")
    public User registerUser (@RequestBody User user) throws ParseException {

        return userService.save(user);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteUserById (@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser (@PathVariable ("id") Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);

    }
}
