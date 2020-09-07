package com.amazonweb.api;

import com.amazonweb.api.form.AuthForm;
import com.amazonweb.model.User;
import com.amazonweb.service.IUserService;
import com.amazonweb.service.impl.TokenAuthenticationService;
import com.amazonweb.utils.MD5;
import com.amazonweb.utils.MessageUtil;
import com.amazonweb.utils.SessionUtil;
import com.amazonweb.utils.ShoppingCart.MessageReponseId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginAPI {

    @Autowired
    private IUserService userService;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@org.jetbrains.annotations.NotNull @RequestBody User user) {
        MessageUtil<User> message = new MessageUtil<>();
        MessageReponseId messageSuccess = new MessageReponseId();
        MD5 md5 = new MD5();
        if (user.getName() == null) {
            message.setMessage("Name must be not null");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (user.getUsername() == null) {
            message.setMessage("Username must be not null");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (user.getPassword() == null) {
            message.setMessage("Password must be not null");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (user.getPhone() == null) {
            message.setMessage("Phone must be not null");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (user.getEmail() == null) {
            message.setMessage("Email must be not null");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            Double time = Math.floor(System.currentTimeMillis() / 1000);
            User newUser = new User();
            newUser.setName(user.getName());
            newUser.setUsername(user.getUsername());
            newUser.setPassword(md5.getMd5(user.getPassword()));
            newUser.setPhone(user.getPhone());
            newUser.setEmail(user.getEmail());
            newUser.setCreated(time.intValue());
            newUser.setRole(1);
            newUser.setStatus(0);
            User user1 = userService.findByUsername(user.getUsername());
            if (user1 == null) {
                Long id = userService.register(newUser);
                if (id == null) {
                    message.setMessage("Register failed!");
                    return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
                } else {
                    messageSuccess.setMessage("Register success!");
                    messageSuccess.setId(id);
                    return new ResponseEntity<>(messageSuccess, HttpStatus.OK);
                }
            } else {
                message.setMessage("Username existed!");
                return new ResponseEntity<>(message, HttpStatus.CONFLICT);
            }
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> login(HttpServletRequest request, @RequestBody User user) {
        MessageUtil<User> message = new MessageUtil<>();
        MessageReponseId messageSuccess = new MessageReponseId();
        MD5 md5 = new MD5();
        if (user.getUsername() == null) {
            message.setMessage("Username must be not null!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (user.getPassword() == null) {
            message.setMessage("Username must be not null!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            User user1 = userService.findByUsernameAndPassword(user.getUsername(), md5.getMd5(user.getPassword()), 0);
            if (user1 == null) {
                message.setMessage("Username or password is wrong!");
                return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
            } else {
                final String token = tokenAuthenticationService.createToken(user1);
                AuthForm authForm = new AuthForm();
                authForm.setUsername(user1.getUsername());
                authForm.setRole(user1.getRole());
                authForm.setToken(token);
                return new ResponseEntity<>(authForm, HttpStatus.OK);
                // role == 0 ? "user" : admin
//                SessionUtil.getInstance().putValue(request, "USERMODEL", user1);
//                if (user1.getRole() == 0) {
//                    messageSuccess.setMessage("Login success!");
//                    messageSuccess.setId(user1.getId().longValue());
//                    return new ResponseEntity<>(messageSuccess, HttpStatus.OK);
//                } else {
//                    messageSuccess.setMessage("Login success!");
//                    messageSuccess.setId(user1.getId().longValue());
//                    return new ResponseEntity<>(messageSuccess, HttpStatus.OK);
//                }
            }
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<Object> logout(HttpServletRequest request) {
//        SessionUtil.getInstance().removeValue(request, "USERMODEL");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
