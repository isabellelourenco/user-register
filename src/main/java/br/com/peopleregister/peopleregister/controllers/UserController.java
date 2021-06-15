package br.com.peopleregister.peopleregister.controllers;

import br.com.peopleregister.peopleregister.models.User;
import br.com.peopleregister.peopleregister.services.ReportService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.peopleregister.peopleregister.services.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ReportService reportService;

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
        User user = userService.findById(id);
        updatedUser.setAddress(user.getAddress());
        updatedUser.setPhone(user.getPhone());
        return userService.updateUser(id, updatedUser);

    }

    @GetMapping(value = "/get-file/{idUser}")
    public void getFile(@PathVariable("idUser") Long idUser, HttpServletResponse response) throws IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=relatorio_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        reportService.report(response, idUser);


    }
}
