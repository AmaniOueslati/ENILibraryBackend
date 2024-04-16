package enilibrary.EniLibrary.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import enilibrary.EniLibrary.Enum.Rolename;

import javax.persistence.*;

@Entity
public class Role implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrole;

    @Enumerated(EnumType.STRING)
    private Rolename rolename;

    @ManyToMany(mappedBy = "listroles")
    Set<User> listusers = new HashSet<>();

    public Role() {
        super();
        // TODO Auto-generated constructor stub
    }



    public Set<User> getListusers() {
        return listusers;
    }



    public void setListusers(Set<User> listusers) {
        this.listusers = listusers;
    }



    public Role(Long idrole, Rolename rolename, Set<User> listusers) {
        super();
        this.idrole = idrole;
        this.rolename = rolename;
        this.listusers = listusers;
    }



    public Long getIdrole() {
        return idrole;
    }

    public void setIdrole(Long idrole) {
        this.idrole = idrole;
    }

    public Rolename getRolename() {
        return rolename;
    }

    public void setRolename(Rolename rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "Role [idrole=" + idrole + ", rolename=" + rolename + ", listusers=" + listusers + "]";
    }

    public Rolename getName() {
        return rolename;
    }
    public void setName(Rolename rolename) {
        this.rolename = rolename;
    }


}
