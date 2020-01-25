/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pouvsm11.pouvsm12.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pouvsm11.pouvsm12.entity.HelloWorldBean;
import pouvsm11.pouvsm12.entity.User;
import pouvsm11.pouvsm12.repository.HelloWordBeanRepository;
import pouvsm11.pouvsm12.repository.UserRepository;


/**
 *
 * @author coly diouf
 */
@Service
public class HelloWorldBeanService {
    @Autowired
     private  HelloWordBeanRepository helloWordBeanRepository;
    
    public List<HelloWorldBean> getAll(){
        return helloWordBeanRepository.findAll();
    }
     public Optional<HelloWorldBean> getById(Integer id ){
        return helloWordBeanRepository.findById(id);
    }
      public HelloWorldBean addHelloWorldBean( HelloWorldBean helloWorldBean){
        return helloWordBeanRepository.save(helloWorldBean);
    }
     public void deleteHelloWorldBean( Integer id){
         helloWordBeanRepository.deleteById(id);
    }  
      public HelloWorldBean updateHelloWorldBean(HelloWorldBean helloWorldBean){
      Optional<HelloWorldBean>  u = helloWordBeanRepository.findById(helloWorldBean.getId());
       HelloWorldBean Us= u !=null&&u.isPresent()? u.get():null;
       if (Us==null){
           System.out.print("le user que voler mettre ajour n existe pas ");
       }
       Us.setMessage(helloWorldBean.getMessage());
      
       return helloWordBeanRepository.save(Us);
      }
  
}
   
