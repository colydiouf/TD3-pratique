/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pouvsm11.pouvsm12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pouvsm11.pouvsm12.entity.HelloWorldBean;

/**
 *
 * @author coly diouf
 */
public interface HelloWordBeanRepository extends JpaRepository<HelloWorldBean, Integer>{
    
}
