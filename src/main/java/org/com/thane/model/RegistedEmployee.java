package org.com.thane.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

@Entity
@Table(name = "employee_registration")
public class RegistedEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="employee_id")
    private Integer EID;


    @NotEmpty(message = "Employee name cannot be empty")
    @Column(name="employee_name")
    private String Ename;

    @NotEmpty(message = "Employee email cannot be empty")
    @Email(message = "Please provide a valid email address")
    @Column(name="employee_email")
    private String Eemail;

    @NotEmpty(message = "Employee password cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^[A-Z].*$", message = "Password must start with a capital letter")
    @Column(name="employee_password")
    private String Epassword;

    @NotNull(message = "Mobile number cannot be null")
    @Min(value = 1000000000L, message = "Mobile number must be at least 10 digits long")
    @Max(value = 9999999999L, message = "Mobile number must be at most 10 digits long")
    @Column(name="employee_no")
    private long Emobileno;

    @NotEmpty(message = "Role cannot be empty")
    @Column(name="role_name")
    private String yourField;

//    @Size(min = 1, message = "Employee post cannot be empty if provided")
   @Column(name="employee_post",nullable = true)

    private String Epost;

    @Column(name="employee_post_check",nullable = true)

    private Boolean isposted;

    public RegistedEmployee() {
    }

    public RegistedEmployee(Integer EID, String ename, String eemail, String epassword, long emobileno, String yourField, String epost, Boolean isposted) {
        this.EID = EID;
        Ename = ename;
        Eemail = eemail;
        Epassword = epassword;
        Emobileno = emobileno;
        this.yourField = yourField;
        Epost = epost;
        this.isposted = isposted;
    }

    @Override
    public String toString() {
        return "RegistedEmployee{" +
                "EID=" + EID +
                ", Ename='" + Ename + '\'' +
                ", Eemail='" + Eemail + '\'' +
                ", Epassword='" + Epassword + '\'' +
                ", Emobileno=" + Emobileno +
                ", yourField='" + yourField + '\'' +
                ", Epost='" + Epost + '\'' +
                ", isposted=" + isposted +
                '}';
    }

    public Integer getEID() {
        return EID;
    }

    public void setEID(Integer EID) {
        this.EID = EID;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getEemail() {
        return Eemail;
    }

    public void setEemail(String eemail) {
        Eemail = eemail;
    }

    public String getEpassword() {
        return Epassword;
    }

    public void setEpassword(String epassword) {
        Epassword = epassword;
    }

    public long getEmobileno() {
        return Emobileno;
    }

    public void setEmobileno(long emobileno) {
        Emobileno = emobileno;
    }

    public String getYourField() {
        return yourField;
    }

    public void setYourField(String yourField) {
        this.yourField = yourField;
    }

    public String getEpost() {
        return Epost;
    }

    public void setEpost(String epost) {
        Epost = epost;
    }

    public Boolean getIsposted() {
        return isposted;
    }

    public void setIsposted(Boolean isposted) {
        this.isposted = isposted;
    }
}

