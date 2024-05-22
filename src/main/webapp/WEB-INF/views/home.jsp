<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
           <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <title>Home</title>
            <style>
          body {
              font-family: Arial, sans-serif;
              background-color: #f4f4f4;
              margin: 0;
              padding: 0;
          }

          .register-card {
              max-width: 400px;
              margin: 50px auto;
              padding: 20px;
              background-color: #fff;
              border-radius: 5px;
              box-shadow: 0 0 10px rgba(0,0,0,0.1);
          }

          .register-heading {
              color: #007bff;
              text-align: center;
          }

          .form-group {
              margin-bottom: 20px;
          }

          .form-group input {
              width: 100%;
              padding: 10px;
              border: 1px solid #ccc;
              border-radius: 5px;
              box-sizing: border-box;
          }

          .button {
              width: 100%;
              padding: 10px;
              border: none;
              border-radius: 5px;
              background-color: #007bff;
              color: #fff;
              cursor: pointer;
              transition: background-color 0.3s;
          }

          .button:hover {
              background-color: #0056b3;
          }

          .error {
              color: red;
              font-size: 14px;
          }
         .link {
                    display: inline-block;
                    padding: 10px 20px;
                    background-color: #007bff;
                    color: #fff;
                    text-decoration: none;
                    border-radius: 5px;
                    transition: background-color 0.3s;
                }

                .link:hover {
                    background-color: #0056b3;
                }

                .link + .link {
                    margin-left: 20px; /* Adjust spacing between links */
                }




                </style>
    </head>

    <body>

       <h3 class="register-heading">Create an Account</h3>

             <div class="form-card register-card">


                      <form:form method="POST" action="createregister" modelAttribute="RegistedEmployee">

                          <div class="form-group">
                              <form:input path="Ename" id="full-name" placeholder="Ename" />
                              <form:errors path="Ename" cssClass="error" />
                          </div>
                          <div class="form-group">
                              <form:input path="Eemail" id="email" placeholder="Email Address" />
                             <form:errors path="Eemail" cssClass="error" />
                          </div>
                           <div class="form-group">
                           <form:input path="Epassword" id="candidatePassword" placeholder="Password"  />
                            <form:errors path="Epassword" cssClass="error" />
                           </div>
                          <div class="form-group">
                              <form:input path="Emobileno" placeholder="Mobile No" />
                                <form:errors path="Emobileno" cssClass="error" />

                          </div>
                           <form:label path="yourField">Select an Option:</form:label>
                              <form:select path="yourField">
                                  <form:option value="Role_Admin">Admin</form:option>
                                  <form:option value="Role_User">User</form:option>

                              </form:select>
                              <form:errors path="yourField" cssClass="error" />


                                         <button class="button">Create Account</button>
                                      <p style="text-align: center;">
                                             <a class="link" href="loginpage">Login page</a>
                                             <a class="link" href="admin-page">Admin page</a>
                                         </p>





                      </form:form>

                     </div>
                 </div>
    </body>
</html>
