package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "user_login")
@NamedQueries({
    @NamedQuery(name = "UserLogin.findAll", query = "SELECT u FROM UserLogin u"),
    @NamedQuery(name = "UserLogin.findById", query = "SELECT u FROM UserLogin u WHERE u.id = :id"),
    @NamedQuery(name = "UserLogin.findByUsername", query = "SELECT u FROM UserLogin u WHERE u.username = :username"),
    @NamedQuery(name = "UserLogin.findByPassword", query = "SELECT u FROM UserLogin u WHERE u.password = :password"),
    @NamedQuery(name = "UserLogin.findByBarangDiMeja", query = "SELECT u FROM UserLogin u WHERE u.barangDiMeja = :barangDiMeja")})
public class UserLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "barang_di_meja")
    private String barangDiMeja;

    public UserLogin() {
    }

    public UserLogin(Integer id) {
        this.id = id;
    }

    public UserLogin(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBarangDiMeja() {
        return barangDiMeja;
    }

    public void setBarangDiMeja(String barangDiMeja) {
        this.barangDiMeja = barangDiMeja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserLogin)) {
            return false;
        }
        UserLogin other = (UserLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.UserLogin[ id=" + id + " ]";
    }
    
}
