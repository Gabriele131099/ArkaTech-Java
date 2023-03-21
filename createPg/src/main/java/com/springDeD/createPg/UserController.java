package com.springDeD.createPg;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    User user1 = new User("Eraon","e@gmail.com","root");
    User user2 = new User("Gon","g@gmail.com","root");
    User user3 = new User("Kilua","k@gmail.com","root");
    private Map<String,User> dbUser= new HashMap<>(){{
        put(user1.getId(),user1);
        put(user2.getId(),user2);
        put(user3.getId(),user3);
    }};
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users")
    public Collection<User> getPg(){
        return dbUser.values();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users/{id}")
    public User getSinglePg(@PathVariable String id){
        User userTmp = dbUser.get(id);
        if (userTmp==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return userTmp;
    }
    static boolean flagEmail = false;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/usersCheckEmail/{email}")
    public boolean getEmailExist(@PathVariable String email){
    flagEmail = false;
        dbUser.forEach((s, user) -> {
            if(user.getEmail().equals(email)) {
                flagEmail = true;
            }
        });
        return flagEmail;

    }
    static String p = "";
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/usersCheckUsername/{username}")
    public String getUsernameExist(@PathVariable String username){
     this.p = "false";
        dbUser.forEach((s, user) -> {
            if(user.getUsername().equals(username)) {
                 this.p = user.getUsername();
            }
        });
        return p;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/users/{id}")
    public void deleteSinglePg(@PathVariable String id){
        User userTmp = dbUser.remove(id);
        if (userTmp==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/users")
    public void create(@RequestBody String username){
        String email = username.split("/space/")[1];
        String pass = username.split("/space/")[2];
        username = username.split("/space/")[0];
        User userTmp = new User(username,email,pass);
        dbUser.put(userTmp.getId(),userTmp);

    }
}
