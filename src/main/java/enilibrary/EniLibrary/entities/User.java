package enilibrary.EniLibrary.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;

@Entity
public class User implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;
    private String fname;
    private String lname;
    private String password;
    private String email;
    private String adresse;
    private String username;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "userrole", joinColumns = @JoinColumn(name="iduser"), inverseJoinColumns = @JoinColumn(name="idrole"))
    private Set<Role> listroles = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private List<FeedBack> feedBacks;







    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public User(Long iduser, String fname, String lname, String password, String confirmPassword, String email,
                String adresse, String username, Set<Role> listroles) {
        super();
        this.iduser = iduser;
        this.fname = fname;
        this.lname = lname;
        this.password = password;

        this.email = email;
        this.adresse = adresse;
        this.username = username;
        this.listroles = listroles;

    }


    public User() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Long getIduser() {
        return iduser;
    }


    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }


    public String getFname() {
        return fname;
    }


    public void setFname(String fname) {
        this.fname = fname;
    }


    public String getLname() {
        return lname;
    }


    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getAdresse() {
        return adresse;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public Set<Role> getListroles() {
        return listroles;
    }


    public void setListroles(Set<Role> listroles) {
        this.listroles = listroles;
    }




    @Override
    public String toString() {
        return "User [iduser=" + iduser + ", fname=" + fname + ", lname=" + lname + ", password=" + password
                + ", email=" + email + ", adresse=" + adresse + ", username="
                + username + ", listroles=" + listroles + "]";
    }

    public void addRole(Role role)
    {
        this.listroles.add(role);
    }
    public Set<Role> getRoles() {
        return listroles;
    }
    public void setRoles(Set<Role> roles) {
        this.listroles = roles;
    }}

