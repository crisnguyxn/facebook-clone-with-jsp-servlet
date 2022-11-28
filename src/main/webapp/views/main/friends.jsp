<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./../header.jsp" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <div class="friend">
        <div class="friend-left">
            <h3>this is left</h3>
        </div>
        <div class="friend-center">
            <h3>${message}</h3>
        </div>
        <div class="friend-right">
            <h3>this is right</h3>
        </div>
    </div>
</body>
<style>
    <%@ include file="./../css/friends.css" %>
</style>
</html>
