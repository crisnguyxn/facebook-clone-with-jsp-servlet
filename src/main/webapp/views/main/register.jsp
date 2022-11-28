<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign up for Facebook | Facebook</title>
</head>
<body>
<div class="register-page">
    <div class="register-header">
        <div class="register-center">
            <div class="register-title">
                <h3>facebook</h3>
            </div>
            <form action="<c:url value='/register'/>" id="formLogin" method="post"  class="register-form">
                <div class="register-msg">
                    <h3>Create a new account</h3>
                    <p>It's quick and easy.</p>
                </div>
                <div class="error-message">
                    ${error}
                </div>
                <div class="register-field-1">
                    <label>
                        <input type="text" placeholder="First name" name="firstName" required>
                    </label>
                    <label>
                        <input type="text" placeholder="Surname" name="surName" required>
                    </label>
                </div>
                <div class="register-field">
                    <label>
                        <input type="text" placeholder="Mobile number or email address " name="email" required>
                    </label>
                </div>
                <div class="register-field">
                    <label>
                        <input type="password" placeholder="New password" name="password" required>
                    </label>
                </div>
                <div class="register-dob">
                    <label>Date of birth</label>
                    <div class="dob-info">
                        <div class="register-dob-field">
                            <label>
                                <input type="number" placeholder="Date" name="date" required>
                            </label>
                        </div>
                        <div class="register-dob-field">
                            <label>
                                <input type="number" placeholder="Month" name="month" required>
                            </label>
                        </div>
                        <div class="register-dob-field">
                            <label>
                                <input type="number" placeholder="Year" name="year" required>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="register-gender">
                    <p>Gender</p>
                    <div class="gender-info">
                        <div class="register-gender-field">
                            <label for="female">Female</label>
                            <input type="radio" id="female" name="gender" value="0">
                        </div>
                        <div class="register-gender-field">
                            <label for="male">Male</label>
                            <input type="radio" id="male" name="gender" value=1>
                        </div>
                        <div class="register-gender-field">
                            <label for="option">Option</label>
                            <input type="radio" id="option" name="gender" value=2>
                        </div>
                    </div>
                </div>
                <div class="register-attr">
                    <p>People who use our service may have uploaded your contact information to Facebook. <a href="#">Learn more.</a></p><br>
                    <p>By clicking Sign Up, you agree to our <a href="#">Terms</a>,<a href="#">Privacy Policy</a> and <a
                            href="#">Cookies Policy</a>. You may receive SMS notifications from us and can opt out at any time.</p>
                </div>
                <div class="btn-creation">
                    <button type="submit">Sign Up</button>
                </div>
                <div class="login-forgotten-pass">
                    <a href="<c:url value='/login'/>">Already have an account?</a>
                </div>
                <label for="action">
                    <input type="hidden" id="action" name="action">
                </label>
            </form>
        </div>
    </div>
    <div class="register-footer">
        <div class="register-information">
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
    <%@ include file="./../css/register.css" %>
</style>
</html>
