package springboot_auth.controllers;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot_auth.entities.User;
import springboot_auth.repositories.UserRepository;
import springboot_auth.services.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
    private Logger log =  LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User user=userRepository.findById(id).get();
        if(user.equals(null)) log.error("user not found");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user){
        User tempUser=userService.saveUser(user);
        if(tempUser.equals(null))  log.error("user is not updated");
        return new ResponseEntity<>(tempUser, HttpStatus.OK);
    }

}
