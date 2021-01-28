package bg.codexio.profile.payload;

import java.util.Date;

public class UserResponse {

    private long id;
    private String firstName;
    private String lastName;
    private Date bornOn;

    public UserResponse(long id) {
        this.id = id;
    }

    public UserResponse(){};

    public long getId() {
        return id;
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

    public void setId(long id) {
        this.id = id;
    }
}
