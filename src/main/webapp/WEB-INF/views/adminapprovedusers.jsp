<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
           <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <title>Own Post</title>
         <style>
               .card {
                   margin: 20px;
                   padding: 10px;
                   border: 1px solid #ccc;
                   border-radius: 5px;
                    text-align: center;
                   box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
               }

               .card-title {
                   font-size: 1.25rem;
                   font-weight: bold;
                   margin-bottom: 0.5rem;
               }

               .card-subtitle {
                   font-size: 1rem;
                   color: #6c757d;
                   margin-bottom: 0.5rem;
               }

               .card-text {
                   font-size: 0.875rem;
                   color: #495057;
               }

               .card-body {
                   padding: 10px;
               }

               .button-container {
                   text-align: center;
                     display: flex;
                        justify-content: center; /* or space-between */
                        align-items: center;
               }

               .button-container button {

                   padding: 10px 20px;
                   margin: 10px;
                   font-size: 1rem;
                   color: #fff;
                   background-color: #007bff;
                   border: 1px solid #007bff;
                   border-radius: 5px;
                   cursor: pointer;
               }

               .button-container button:hover {
                   background-color: #0056b3;
                   border-color: #0056b3;
               }


            </style>
        </head>
        <body>
   <h1 style="text-align: center;">All Users Aprroved feeds Posts</h1>

   <c:if test="${not empty allAdminApprovedFeeds}">
       <div class="card">
           <c:forEach var="post" items="${allAdminApprovedFeeds}">
               <div class="card-body">

                 <h5 class="card-subtitle mb-2 text-muted" style="font-size: 1.2rem; font-weight: bold;">Post : ${post.epost}</h5>
                    <h5 class="card-title">Created by:${post.ename}</h5>
                   <h6 class="card-text">Date: ${post.postDate}</h6>
 <div class="button-container">
        <form action="editPost" method="GET">
            <button class="styled-button" type="submit">Edit Post</button>
        </form>

        <!-- Button 2 -->
        <form action="deletePost" method="POST">
            <button class="styled-button" type="submit">Delete Post</button>
        </form>
    </div>
               </div>
           </c:forEach>
       </div>
   </c:if>

   <c:if test="${empty allAdminApprovedFeeds}">
       <p>No posts available.</p>
   </c:if>

        </body>
        </html>