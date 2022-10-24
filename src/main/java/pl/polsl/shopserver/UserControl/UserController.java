package pl.polsl.shopserver.UserControl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.shopserver.JsonEntity.LoginDetails;
import pl.polsl.shopserver.JsonEntity.ReturnRegisterResponse;
import pl.polsl.shopserver.JsonEntity.ReturnToken;
import pl.polsl.shopserver.dbentity.Photo;
import pl.polsl.shopserver.dbentity.User;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("")
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
    ResponseEntity<ReturnRegisterResponse> register(@RequestBody User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }
}
