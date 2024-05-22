package org.com.thane.service;

import org.com.thane.model.RegistedEmployee;
import org.com.thane.model.UserFeeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface RegistedEmployeeDetails {
    public void persist(RegistedEmployee registedEmployee);
    public List<RegistedEmployee> readallReigstedEmployee();
    public Optional<RegistedEmployee> findEmployeeByGmail(String emailId);
    public Optional<RegistedEmployee> persistPost(String post,String loginEmail);

    public Optional<List<UserFeeds>> findPostsByEid(Integer eid);
    public List<UserFeeds> findAdminApprovedPost();
  //  public List<UserFeeds> findAdminApprovedPost();



}
