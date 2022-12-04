<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div class="header">
        <div class="header-left">
            <div class="header-logo">
                <a><img src="img/facebook.png" alt=""></a>
            </div>
            <div class="search-field">
                <img src="img/search-interface-symbol.png" alt="">
                <label>
                    <input type="text" placeholder="Search on Facebook">
                </label>
            </div>
        </div>
        <div class="header-center">
            <div class="fields">
                <a href="<c:url value='/homepage'/>"><img src="img/homex.png" alt=""></a>
            </div>
            <div class="fields">
                <a href=""><img src="img/group.png" alt=""></a>
            </div>
            <div class="fields">
                <a><img src="img/videox.png" alt=""></a>
            </div>
            <div class="fields">
                <a><img src="img/shop.png" alt=""></a>
            </div>
            <div class="field-last">
                <a><img src="img/group.png" alt=""></a>
            </div>
            <div class="field-hamburger">
                <a><img src="img/morex.png" alt=""></a>
            </div>
        </div>
        <div class="header-right">
            <div class="field-right">
                <a><img src="img/dots-menu.png" alt=""></a>
            </div>
            <div class="field-right">
                <a><img src="img/messenger.png" alt=""></a>
            </div>
            <div class="field-right">
                <a><img src="img/bellx.png" alt=""></a>
            </div>
            <div class="field-right">
                <a><img src="img/userx.png" alt=""></a>
            </div>
        </div>
    </div>
</body>
<style>
    <%@ include file="css/header.css" %>
</style>
</html>