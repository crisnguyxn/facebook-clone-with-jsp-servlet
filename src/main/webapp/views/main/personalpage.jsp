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
              <div class="uploadImg" id="coverForm">
                  <label for="file"><img src="img/pencil.png" alt=""> <p>Edit Cover Photo</p></label>
                  <input class="custom-file-input" type="file" name="coverFile" id="file" onchange="previewPhoto()">
              </div>
              <div class="alert-save">
                  <div class="alert-right">
                      <button onclick="discard(${userInfo.id})" class="discard">Discard</button>
                      <button onclick="updateUser(${userInfo.id})" class="save">Save Changed</button>
                  </div>
              </div>
          </div>
          <div class="personal-user-info">
              <div class="user-avatar">
                  <div class="main-avt">
                      <img id="avatarImg" src="${userInfo.avtPhoto}" alt="">
                  </div>
                  <div class="avatar">
                      <label for="avatar"><img src="img/cameraaa.png" alt=""></label>
                      <input type="file" name="avtFile" id="avatar"  onchange="previewAvatar()">
                  </div>
              </div>
              <div class="user-name">
                  <h3>${userInfo.firstName} ${userInfo.surName}</h3>
                  <p>13 friends</p>
              </div>
          </div>
      </div>
      <div class="personal-center">
          <div class="center-left">
              <h3>left</h3>
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
    }
</style>
<script>
    <%@ include file="../js/personal.js" %>
</script>
</html>