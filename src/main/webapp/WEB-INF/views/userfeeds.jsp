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
        /* Form container styling */
                form {
                    width: 100%;
                    max-width: 600px;
                    margin: 0 auto;
                    padding: 20px;
                    border: 1px solid #ddd;
                    border-radius: 8px;
                    background-color: #f9f9f9;
                }

                /* Form group styling */
                .form-group {
                    margin-bottom: 15px;
                }

                /* Input field styling */
                input[type="text"] {
                    width: 100%;
                    padding: 10px;
                    border: 1px solid #ccc;
                    border-radius: 4px;
                    font-size: 16px;
                }

                /* Error message styling */
                .error {
                    display: block;
                    margin-top: 5px;
                    color: red;
                    font-size: 14px;
                }

                /* Button styling */
                .button {
                    display: inline-block;
                    padding: 10px 20px;
                    margin: 5px 0;
                    border: none;
                    border-radius: 4px;
                    background-color: #007bff;
                    color: #fff;
                    font-size: 16px;
                    cursor: pointer;
                    transition: background-color 0.3s ease;
                }

                /* Button hover effect */
                .button:hover {
                    background-color: #0056b3;
                }

        </style>

        </head>
        <body>
       <form method="POST" action="createpost">
           <div class="form-group">
               <input type="text" id="Epost" name="Epost" placeholder="ENTER YOUR POST"/>

           </div>

           <button type="submit"  name="button" value="createpost" class="button">Create Post</button>

           <button type="submit"   name="button" value="viewmypost"  class="button" >View My Post</button>
           <button type="submit"  name="button" class="button"  value="viewotherapprovedusers" >View Other User Posts</button>
       </form>



        </body>
        </html>