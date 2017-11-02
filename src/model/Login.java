package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Mahmoud Ragab on 10/10/2016.
 */
@Entity
@Table(name = "login")
public class Login {
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "pass")
    private String password;
    @Column(name = "priv")
    private String priv;

    public String getPriv() {
        return priv;
    }

    public void setPriv(String priv) {
        this.priv = priv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
