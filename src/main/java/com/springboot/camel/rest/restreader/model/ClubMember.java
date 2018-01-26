package com.springboot.camel.rest.restreader.model;



import javax.persistence.*;

@Entity
@Table(name = "healthmember")
public class ClubMember {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;

    @Column(name = "firstname")
    private String firstName;

    private String lastName;
    private String occupation;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
}
