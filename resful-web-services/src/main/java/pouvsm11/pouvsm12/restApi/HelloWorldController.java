/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pouvsm11.pouvsm12.restApi;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pouvsm11.pouvsm12.entity.HelloWorldBean;
import pouvsm11.pouvsm12.entity.User;
import pouvsm11.pouvsm12.service.HelloWorldBeanService;
import pouvsm11.pouvsm12.service.UserService;

/**
 *
 * @author coly diouf
 */
@RestController
public class HelloWorldController {
    
     @Autowired
     private HelloWorldBeanService helloWorldBeanService;
     
@GetMapping("/HelloWorldBeans")
public List<HelloWorldBean> allHelloWorldBean() {
return helloWorldBeanService.getAll();
}

@GetMapping("/HelloWorldBeans/{id}")
public Optional<HelloWorldBean> getHelloWorldBean(@PathVariable Integer id) {
return helloWorldBeanService.getById(id);
}

@PostMapping("/HelloWorldBeans")
public HelloWorldBean createHelloWorldBean(@RequestBody HelloWorldBean helloWorldBean){
 return helloWorldBeanService.addHelloWorldBean(helloWorldBean);
}

@PutMapping("/useHelloWorldBeans")
public HelloWorldBean updateHelloWorldBean(@RequestBody HelloWorldBean helloWorldBean){
 return helloWorldBeanService.updateHelloWorldBean(helloWorldBean);
}

@DeleteMapping("/deleteHelloWorldBean/{id}")
public void deleteHelloWorldBean(@PathVariable Integer id ){
 helloWorldBeanService.deleteHelloWorldBean(id);
}
    
}
