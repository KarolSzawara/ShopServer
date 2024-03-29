package pl.polsl.shopserver.Controler;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.shopserver.JsonEntity.LoginDetails;
import pl.polsl.shopserver.JsonEntity.ReturnRegisterResponse;
import pl.polsl.shopserver.JsonEntity.ReturnToken;
import pl.polsl.shopserver.User.RegisterProfile;
import pl.polsl.shopserver.User.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    UserService userService;
    UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/login")
    ResponseEntity<ReturnToken> login(@RequestBody LoginDetails loginDetails){
        return ResponseEntity.ok(userService.loginUser(loginDetails));
    }
    @PostMapping("/registr")
    ResponseEntity<ReturnRegisterResponse> register(@RequestBody() RegisterProfile user){
        return ResponseEntity.ok(userService.registerUser(user));
    }
    @PostMapping("/verfication")
    ResponseEntity<String> verficationEmail(@RequestBody String token){
        return ResponseEntity.ok(userService.confirmEmail(token));
    }
}
