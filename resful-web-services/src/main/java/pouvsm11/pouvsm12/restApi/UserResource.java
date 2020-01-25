/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pouvsm11.pouvsm12.restApi;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pouvsm11.pouvsm12.entity.User;
import pouvsm11.pouvsm12.exceptions.UserNotFoundException;

import pouvsm11.pouvsm12.service.UserService;



/**
 *
 * @author coly diouf
 */
@RestController
public class UserResource {
   @Autowired
private UserService userService;
@GetMapping("/users")
public List<User> retrieveAllUsers() {
return userService.getAll();
}
@GetMapping("/users/{id}")
public Optional<User> retrieveUser(@PathVariable Integer id) {
     Optional<User> user=userService.getById(id);
     if(user==null)  throw new UserNotFoundException("un utilisateur id"+id +"existe pas pour le moment");
   return user;

}
/*@PostMapping("/users")
public User createUser(@RequestBody User user){
 return userService.addUser(user);
}*/
@PostMapping("/users")
public ResponseEntity<Object> createUser(@RequestBody User user) {
User savedUser = userService.addUser(user);
// CREATED
// /user/{id} savedUser.getId()
URI location = ServletUriComponentsBuilder
.fromCurrentRequest()
.path("/{id}")
.buildAndExpand(savedUser.getId()).toUri();
return ResponseEntity.created(location).build();
}

@PutMapping("/users")
public User updateUser(@RequestBody User user){
 return userService.updateUser(user);
}
@DeleteMapping("/deleteusers")
public void deleteUser(@PathVariable Integer id ){
 userService.deleteUser(id);
}
}

