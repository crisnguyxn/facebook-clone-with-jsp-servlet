<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Facebook | Personal Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<%@ include file="../header.jsp" %>
<body>
  <div class="personal-page">
      <div class="personal-header">
          <div class="personal-cover-photo">
              <img id="coverPhoto" src="${userInfo.coverPhoto}" alt="">
              <c:if test="${userInfo.id == loggedUser.id}">
                  <div class="uploadImg">
                      <label for="file"><img src="img/pencil.png" alt=""> <p>Edit Cover Photo</p></label>
                      <input class="custom-file-input" type="file" name="coverFile" id="file" onchange="previewPhoto()">
                  </div>
              </c:if>
              <div class="alert-save">
                  <div class="alert-right">
                      <button onclick="discard(${userInfo.id})" class="discard">Discard</button>
                      <button onclick="updateUser(${userInfo.id})" class="save">Save Changed</button>
                  </div>
              </div>
          </div>
          <div class="personal-user-info">
              <div class="personal-info">
                  <div class="user-avatar">
                      <div class="main-avt">
                          <img id="avatarImg" src="${userInfo.avtPhoto}" alt="">
                      </div>
                      <c:if test="${userInfo.id == loggedUser.id}">
                          <div class="avatar">
                              <label for="avatar"><img src="img/cameraaa.png" alt=""></label>
                              <input type="file" name="avtFile" id="avatar"  onchange="previewAvatar()">
                          </div>
                      </c:if>
                  </div>
                  <div class="user-name">
                      <h3>${userInfo.firstName} ${userInfo.surName}</h3>
                      <p>${userInfo.friendList.size()} ${userInfo.friendList.size() > 1 ? "friends" :"friend"}</p>
                  </div>
              </div>
              <c:if test="${userInfo.id != loggedUser.id}">
                  <div class="add-friend">
                      <button onclick="addFriend(${userInfo.id})">Add friend</button>
                      <input type="hidden" name="loggedId" value="${loggedUser.id}" id="loggedId">
                  </div>
              </c:if>
          </div>
      </div>
      <div class="personal-center">
          <div class="center-left">
              <div class="friend-list">
                  <div class="friend-list-header">
                      <div class="list-header-left">
                          <h3>Friends</h3>
                          <c:if test="${userInfo.friendList.size() > 0}">
                              <p>${userInfo.friendList.size()} ${userInfo.friendList.size() > 1 ? "friends" :"friend"}</p>
                          </c:if>
                      </div>
                      <button onclick="getFriend(${loggedUser.id})">See All Friends</button>
                  </div>
                  <div class="lists">
                      <c:if test="${userInfo.friendList.size() > 0}">
                          <c:forEach items="${userInfo.friendList}" var="friend">
                              <div class="friend">
                                  <img src="${friend.user.avtPhoto}" alt="">
                                  <p>${friend.user.firstName} ${friend.user.surName}</p>
                              </div>
                          </c:forEach>
                      </c:if>
                  </div>
              </div>
          </div>
          <div class="center-right">
              <h3>right</h3>
          </div>
      </div>
  </div>
</body>
<style>
    <%@ include file="./../css/personalpage.css" %>
    body{
        margin:0;
        overflow-x: hidden;
    }
</style>
<script>
    <%@ include file="../js/personal.js" %>
</script>
</html>
