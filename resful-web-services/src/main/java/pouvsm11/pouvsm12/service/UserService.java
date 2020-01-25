/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pouvsm11.pouvsm12.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pouvsm11.pouvsm12.entity.User;
import pouvsm11.pouvsm12.repository.UserRepository;



/**
 *
 * @author coly diouf
 */
@Component
public class UserService {
  /* private static List<User> users = new ArrayList<>();
private static int usersCount = 3;

users.save(new User(1, "Adam", new Date()));
users.add(new User(2, "Eve", new Date()));
users.add(new User(3, "Jack", new Date()));

public List<User> findAll() {
return users;
}
public User save(User user) {
if (user.getId() == null) {
user.setId(++ usersCount);
}users.add(user);
return user;
}
public User findOne(int id) {
for (User user : users) {
if (user.getId() == id) {
return user;
}
}return null;

}*/
    
    
 @Autowired
     private  UserRepository userRepository;
    
    public List<User> getAll(){
        return userRepository.findAll();
    }
     public Optional<User> getById(Integer id ){
        return userRepository.findById(id);
    }
      public User addUser( User user){
        return userRepository.save(user);
    }
     public void deleteUser( Integer id){
         userRepository.deleteById(id);
    }  
      public User updateUser(User user){
      Optional<User>  u = userRepository.findById(user.getId());
       User Us= u !=null&&u.isPresent()? u.get():null;
       if (Us==null){
           System.out.print("le user que voler mettre ajour n existe pas ");
       }
       Us.setName(user.getName());
       Us.setBirthDate(user.getBirthDate());
       return userRepository.save(user);
      }
  
}