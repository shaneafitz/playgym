package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import models.Member;
import models.Assessment;



@Entity
public class Trainer extends Model {
    public String name;
    public String email;
    public String password;
    /*public String title;
    public int assessmentsize;*/

    @OneToMany(cascade = CascadeType.ALL)
    public List<Member> members = new ArrayList<Member>();

   /* @OneToMany(cascade = CascadeType.ALL)
    public List<Memberlist> memberlists = new ArrayList<Memberlist>();*/

    public Trainer(String name, String email, String password) {
        this.name = name;
       // this.lastname = lastname;
        this.email = email;
        this.password = password;
       /* this.title = title; //member.getFirstname()??
        this.assessmentsize = assessmentsize;*/
    }
    /*public Trainer(String title, int assessmentsize){
        this.title = title;
        this.assessmentsize = assessmentsize;
    }*/

    public static Trainer findByEmail(String email) {
        return find("email", email).first();
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }


}