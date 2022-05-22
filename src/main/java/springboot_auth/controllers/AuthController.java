package springboot_auth.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot_auth.entities.User;
import springboot_auth.services.UserService;



@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthController {

    private Logger log =  LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        if(userService.findByEmailAndPassword(user.getEmail(), user.getPassword()).equals(null)){
            log.error("login error");
        }
        log.info("login successful");
        return new ResponseEntity<User>(userService.findByEmailAndPassword(user.getEmail(), user.getPassword()), HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        User tempUser=userService.saveUser(user);
        if(tempUser.equals(null)){
            log.error("sign up error");

        }
        log.info("sign up successful");
        return new ResponseEntity<User>(tempUser,HttpStatus.CREATED);
    }

}
