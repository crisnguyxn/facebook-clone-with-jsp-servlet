<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Facebook - log in or sign up</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>
    <div class="login-page">
        <div class="login-header">
            <div class="login-center">
                <div class="login-title">
                    <h3>facebook</h3>
                    <p>Facebook helps you connect and share with the people in your life.</p>
                </div>
                <form class="login-form" action="<c:url value='/login'/>" method="post" >
                    <div class="error-message">
                        ${error}
                    </div>
                    <div class="login-field">
                        <label>
                            <input type="text" placeholder="Email address or phone number" name="email">
                        </label>
                    </div>
                    <div class="login-field">
                        <label>
                            <input type="password" placeholder="Password" name="password">
                        </label>
                    </div>
                    <div class="login-field">
                        <button type="submit">Submit</button>
                    </div>
                    <div class="login-forgotten-pass">
                        <a href="#">Forgotten password?</a>
                    </div>
                    <br/>
                    <div class="btn-creation">
                        <a href="<c:url value='/register'/>">Create new account</a>
                    </div>
                    <label for="action">
                        <input type="hidden" id="action" name="action">
                    </label>
                </form>
            </div>
        </div>
        <div class="login-footer">
            <div class="login-information">
                <div class="header-info">
                    <p>English (UK)</p>
                </div>
                <div class="central">
                    <a href="#">Sign up</a>
                </div>
                <div class="footer">
                    Meta 2022
                </div>
            </div>
        </div>
    </div>
</body>
<style>
    <%@ include file="./../css/login.css" %>
</style>
<script>
    function register(){
        window.location.value('/register');
    }
</script>
</html>
