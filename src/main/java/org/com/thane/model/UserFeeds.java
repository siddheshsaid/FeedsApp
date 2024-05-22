package org.com.thane.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
@Entity
@Table(name = "employee_feeds")
public class UserFeeds {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="userfeeds_id")
    private Integer userFeedsId;

    @Column(name="employee_id")
    private Integer EID;
    @Column(name="employee_name")
    private String Ename;
    @Column(name="employee_post",nullable = true)

    private String Epost;

    @Column(name="employee_post_date",nullable = true)

    private LocalDate postDate;

    @Column(name="approved_feeds",nullable = true)

    private String isApproved;
//@Column(name="approved_feeds", nullable = false, columnDefinition = "boolean default false")
//private Boolean isApproved = false;


    @PrePersist
    protected void onCreate() {
        if (isApproved == null) {
            isApproved = "false";
        }
    }
    public UserFeeds(Integer userFeedsId, Integer EID, String ename, String epost, LocalDate postDate, String isApproved) {
        this.userFeedsId = userFeedsId;
        this.EID = EID;
        Ename = ename;
        Epost = epost;
        this.postDate = postDate;
        this.isApproved = isApproved;
    }

    @Override
    public String toString() {
        return "UserFeeds{" +
                "userFeedsId=" + userFeedsId +
                ", EID=" + EID +
                ", Ename='" + Ename + '\'' +
                ", Epost='" + Epost + '\'' +
                ", postDate=" + postDate +
                ", isApproved=" + isApproved +
                '}';
    }

    public UserFeeds() {
    }

    public Integer getUserFeedsId() {
        return userFeedsId;
    }

    public void setUserFeedsId(Integer userFeedsId) {
        this.userFeedsId = userFeedsId;
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

    public String getEpost() {
        return Epost;
    }

    public void setEpost(String epost) {
        Epost = epost;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getApproved() {
        return isApproved;
    }

    public void setApproved(String approved) {
        isApproved = approved;
    }
}
