/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pouvsm11.pouvsm12.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author coly diouf
 */
@Entity
public class HelloWorldBean implements Serializable{
    @Id @GeneratedValue
    private Integer id;
    private String message;

    public HelloWorldBean() {
    }

    
    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" + "id=" + id + ", message=" + message + '}';
    }
    
}
