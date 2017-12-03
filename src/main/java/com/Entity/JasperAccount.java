package com.Entity;

import javax.persistence.*;

@Entity
@Table(name="Jasper_account",uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class JasperAccount {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name ="user_name")
    private String userName;
    @Column(name="account_id")
    private String accountId;
    public JasperAccount(){
        id=null;
        userName=null;
        accountId=null;
    }


    public JasperAccount(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public JasperAccount(String id, String userName, String accountId) {
        this.id = id;
        this.userName = userName;
        this.accountId = accountId;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
