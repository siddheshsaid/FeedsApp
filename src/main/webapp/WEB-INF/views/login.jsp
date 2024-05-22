<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

.login-card {
    max-width: 400px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
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

.btn-btn-primary {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 5px;
    background-color: #007bff;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.3s;
}

.btn-btn-primary:hover {
    background-color: #0056b3;
}

.error-message {
    color: red;
    font-size: 14px;
}


        </style>
    </head>
    <body>
      <script type="text/javascript">
            function Validate(){
            if(document.myForm.loginemail.value==""){
                alert("Enter your email first")
                document.myForm.loginemail.focus()

                return false

            }
            else if(document.myForm.loginpassword.value==""){
                alert("Enter your password first")
                document.myForm.loginpassword.focus()
                return false
               }
            else{
                return true
            }
        }

            </script>

    <div class="login-card">

    <form action="createlogin" method="POST" name="myForm" onsubmit="return(Validate())">
                                <div class="form-group">
                                    <input type="text" id="loginemail" name="loginemail" placeholder="email address*">
                                </div>
                                <div class="form-group">
                                    <input type="password" id="loginpassword" name="loginpassword" placeholder="password*">

                                </div>

                                <button class="btn-btn-primary">Login</button><br><br>

                            </form>
                             <% if (request.getAttribute("errorMessage") != null) { %>
                                            <div class="error-message">
                                                <%= request.getAttribute("errorMessage") %>
                                            </div>
                                        <% } %>
                                           </div>
    </body>
    </html>