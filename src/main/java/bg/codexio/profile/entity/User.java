package bg.codexio.profile.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "profile")
public class User {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private Date bornOn;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBornOn() {
        return bornOn;
    }

    public void setBornOn(Date bornOn) {
        this.bornOn = bornOn;
    }
}
