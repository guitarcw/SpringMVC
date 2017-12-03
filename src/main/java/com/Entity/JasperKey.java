package com.Entity;


import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="Jasper_user",uniqueConstraints = @UniqueConstraint(columnNames = "id"))

public class JasperKey {

    @Id
    @Column(name="id")
    private int jasperId=1;

    @Column(name="user_name")
    private String username;
//    @Column(name="user_password")
//    private String password;
    @Column(name = "user_key")
    private String key;
    public JasperKey(){}
    public JasperKey(String username,String key){
        this.username=username;this.key=key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
