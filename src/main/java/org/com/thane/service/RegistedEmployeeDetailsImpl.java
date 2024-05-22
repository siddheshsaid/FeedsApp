package org.com.thane.service;

import org.com.thane.model.RegistedEmployee;
import org.com.thane.model.UserFeeds;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RegistedEmployeeDetailsImpl implements RegistedEmployeeDetails {
    @Autowired
    HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    @Transactional
    public void persist(RegistedEmployee registedEmployee) {
//        try {
//            hibernateTemplate.save(registedEmployee);
//        } catch (Exception e) {
//            // Duplicate email
//            System.out.print("Email is not valid: ");
//            return false; // Return false to indicate failure
//        }
//        return true; // Return true to indicate success

//    }
        System.out.println("okkkkk"+registedEmployee);
         hibernateTemplate.save(registedEmployee);

    }
    @Override
    @Transactional(readOnly = true)
    public List<RegistedEmployee> readallReigstedEmployee() {
        return hibernateTemplate.loadAll(RegistedEmployee.class);
    }

    @Override
    @Transactional
    public Optional<RegistedEmployee> findEmployeeByGmail(String emailId) {
        System.out.println("Dao" + emailId);
        DetachedCriteria criteria = DetachedCriteria.forClass(RegistedEmployee.class);
        if (emailId != null) {
            criteria.add(Restrictions.eq("Eemail", emailId));
        }
        RegistedEmployee registeredEmployee = (RegistedEmployee) hibernateTemplate.findByCriteria(criteria).stream().findFirst().orElse(null);
        Optional<RegistedEmployee> optionalEmployee = Optional.ofNullable(registeredEmployee);
        System.out.println("OPTIONAL DETAILS OF EMPLOYEE" + optionalEmployee);




        return optionalEmployee;
    }

    @Override
    @Transactional
    public Optional<List<UserFeeds>> findPostsByEid(Integer eid) {
        System.out.println("Inside findpostbyeid" + eid);
        DetachedCriteria criteria = DetachedCriteria.forClass(UserFeeds.class);
        if (eid != null) {
            criteria.add(Restrictions.eq("EID", eid));
        }
        List<UserFeeds> posts = (List<UserFeeds>) hibernateTemplate.findByCriteria(criteria);
        Optional<List<UserFeeds>> allFeeds = Optional.ofNullable(posts.isEmpty() ? null : posts);
        System.out.println("All feeds" + allFeeds);




        return allFeeds;
    }
    @Override
    @Transactional
    public Optional<RegistedEmployee> persistPost(String post,String loginEmail) {
        System.out.println("PersistPost" + loginEmail);
        DetachedCriteria criteria = DetachedCriteria.forClass(RegistedEmployee.class);
        if (loginEmail != null) {
            criteria.add(Restrictions.eq("Eemail", loginEmail));
        }
        RegistedEmployee registeredEmployee = (RegistedEmployee) hibernateTemplate.findByCriteria(criteria).stream().findFirst().orElse(null);
        Optional<RegistedEmployee> optionalEmployee = Optional.ofNullable(registeredEmployee);
        System.out.println("OPTIONAL DETAILS OF EMPLOYEE" + optionalEmployee);


        Integer eid=registeredEmployee.getEID();
        LocalDate now=LocalDate.now();

        registeredEmployee.setEpost(post);
        registeredEmployee.setIsposted(true);


        UserFeeds feeds=new UserFeeds();
       String epost= registeredEmployee.getEpost();
        feeds.setEID(eid);
        feeds.setEpost(registeredEmployee.getEpost());
        feeds.setEname(registeredEmployee.getEname());
        feeds.setPostDate(now);
        List<UserFeeds> existingFeeds = (List<UserFeeds>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(UserFeeds.class)
                .add(Restrictions.eq("Epost",epost)));

// Check if any existing UserFeeds objects have the same epost
        if (existingFeeds.isEmpty()) {
            // No existing UserFeeds objects with the same epost, so save the new UserFeeds object
            hibernateTemplate.save(feeds);
        }

//        UserFeeds allfeeds=new UserFeeds();
        System.out.println("EID" + eid);



      hibernateTemplate.saveOrUpdate(registeredEmployee);





        return optionalEmployee;
    }
    @Override
    public List<UserFeeds> findAdminApprovedPost() {
        List<UserFeeds> allfeeds = hibernateTemplate.loadAll(UserFeeds.class);
        return allfeeds
                .stream()
                .filter(feed -> "true".equals(feed.getApproved()))
                .collect(Collectors.toList());
    }
//@Override
//@Transactional
//public List<UserFeeds> findAdminApprovedPost() {
//    Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(UserFeeds.class);
//    criteria.add(Restrictions.eq("isApproved", true));
//    List<UserFeeds> approvedFeeds = criteria.list();
//    return approvedFeeds;
//}

}
