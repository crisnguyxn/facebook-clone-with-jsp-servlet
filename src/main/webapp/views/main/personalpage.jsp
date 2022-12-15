<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Facebook | Personal Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<%@ include file="../header.jsp" %>
<body>
  <div class="personal-page">
      <div class="post-form" id="form">
          <div class="post-form-header">
              <div class="form-title">
                  Create post
              </div>
              <button id="closedForm">X</button>
          </div>
          <div class="post-form-main">
              <form id="postForm" action="<c:url value='/post'/>" method="post" enctype="multipart/form-data">
                  <div class="post-header-field">
                      <img src="${userInfo.avtPhoto}" alt="">
                      <div class="post-userinfo">
                          <p id="userInfo">${userInfo.firstName} ${userInfo.surName}</p>
                          <label for="mode">
                              <select id="mode" name="mode">
                                  <div class="field-item">
                                      <option value="0" selected>Only me</option>
                                  </div>
                                  <div class="field-item">
                                      <img src="img/world.png" alt="">
                                      <option value="1">Public</option>
                                  </div>
                                  <div class="field-item">
                                      <img src="img/friends.png" alt="">
                                      <option value="2"> Friends</option>
                                  </div>
                              </select>
                          </label>
                      </div>
                  </div>
                  <div class="post-header-content">
                      <label for="content">
                                        <textarea class="textarea"
                                                  placeholder="What's on your mind, ${userInfo.firstName}?"
                                                  name="content" id="content" cols="62" rows="10" style="
                                            font-size: 20px;
                                            width: 480px;
                                            height: 80px;
                                            border: none;
                                            outline: none;
                                            font-family: 'Poppins', sans-serif;
                                            ">
                                        </textarea>
                      </label>
                      <div class="existedImg">
                          <img class="image" id="mime" src="" alt="" height="480" width="480">
                      </div>
                      <label for="file">
                          <input type="file" name="file" id="file" onchange="previewFile()">
                      </label>
                  </div>
                  <div class="more-info">
                      <div class="more-info-title">
                          Add to your post
                      </div>
                      <div class="more-info-func">
                          <img src="img/images.png" alt="">
                          <img src="img/mention.png" alt="">
                          <img src="img/smile.png" alt="">
                          <img src="img/location.png" alt="">
                          <img src="img/flag.png" alt="">
                          <img src="img/morex2x.png" alt="">
                      </div>
                  </div>
                  <div class="post-submit-btn">
                      <button type="submit">Post</button>
                  </div>
                  <input style="display: none" type="reset" id="reset" name="reset" />
                  <input type="hidden" id="userId" value="${userInfo.id}" name="userId">
              </form>
          </div>
      </div>
      <div class="personal-header">
          <div class="personal-cover-photo">
              <img id="coverPhoto" src="${userInfo.coverPhoto}" alt="">
              <c:if test="${userInfo.id == loggedUser.id}">
                  <div class="uploadImg">
                      <label for="file"><img src="img/pencil.png" alt=""> <p>Edit Cover Photo</p></label>
                      <input class="custom-file-input" type="file" name="coverFile" id="fileCover" onchange="previewPhoto()">
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
              <div class="information">
                  <div class="information-header">
                      <h3>Introduction</h3>
                  </div>
              </div>
              <div class="picture-list">
                  <div class="picture-list-header">
                      <div class="list-header-left">
                          <h3>Photo</h3>
                      </div>
                      <button onclick="getFriend(${loggedUser.id})">See All Photos</button>
                  </div>
              </div>
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
              <div class="post-creation">
                  <div class="post-creation-header">
                      <img src="${userInfo.avtPhoto}" alt="">
                      <button id="openForm">What's on your mind, ${userInfo.firstName}?</button>
                  </div>
                  <div class="post-attr">
                      <div class="icon">
                          <img src="img/video-cam.png" alt="">
                          <p>Live video</p>
                      </div>
                      <div class="icon">
                          <img src="img/images.png" alt="">
                          <p>Photo/video</p>
                      </div>
                      <div class="icon">
                          <img src="img/smile.png" alt="">
                          <p>Feeling/activity ${models.size()}</p>
                      </div>
                  </div>
              </div>
              <c:if test="${models.size() == 0}">
                  <div class="alert-message">
                      <h3>${message}</h3>
                  </div>
              </c:if>
              <c:if test="${models.size() > 0}">
                  <c:forEach var="item" items="${models}">
                      <div class="post">
                          <div class="post-header">
                              <div class="post-header-left">
                                  <div class="post-user-avatar">
                                      <a href="<c:url value='/profile?id=${item.user.id}'/>"><img src="${item.user.avtPhoto}" alt=""></a>
                                  </div>
                                  <div class="user-info">
                                          ${item.user.firstName} ${item.user.surName}
                                      <div class="time-info">
                                              ${item.modifiedDate != null ? item.modifiedDate : item.createdDate}
                                          ● <c:choose>
                                          <c:when test="${item.mode==0}">
                                              <img src="img/padlock.png" alt="">
                                          </c:when>
                                          <c:when test="${item.mode==1}">
                                              <img src="img/worldsmall.png" alt="">
                                          </c:when>
                                          <c:otherwise>
                                              <img src="img/friends.png" alt="">
                                          </c:otherwise>
                                      </c:choose>
                                      </div>
                                  </div>
                              </div>
                              <div class="post-header-right">
                                  <div class="options" id="options">
                                      <div class="field">
                                          <a><img src="img/delete.png" alt=""></a>
                                          <button onclick="deletePost(${item.id})">Delete</button>
                                      </div>
                                      <div class="field">
                                          <a href=""><img src="img/pencil.png" alt=""></a>
                                          <button onclick="updatePost(${item.id})">Update</button>
                                      </div>
                                      <div class="field">
                                          <a href=""><img src="img/save-instagram.png" alt=""></a>
                                          <button onclick="savePost(${item.id})">Save</button>
                                      </div>
                                  </div>
                                  <img id="showOptions" src="img/morex2x.png" alt="">
                              </div>
                          </div>
                          <div class="post-info">
                              <div class="post-title">
                                      ${item.content}
                              </div>
                              <c:if test="${item.fileUrl != null}">
                                  <div class="post-img-video">
                                      <img id="postImg" src="<c:url value='${item.fileUrl}'/>" alt="">
                                  </div>
                              </c:if>
                          </div>
                          <div class="post-footer">
                              <div class="post-footer-left">
                                  <p>0</p>
                              </div>
                              <div class="post-footer-right">
                                  <p>0</p>
                              </div>
                          </div>
                          <div class="post-attr">
                              <div class="icon">
                                  <img src="img/likex.png" alt="">
                                  <button>Like</button>
                              </div>
                              <div class="icon">
                                  <img src="img/comment.png" alt=""/>
                                  <button>Comment</button>
                              </div>
                              <div class="icon">
                                  <img src="img/share.png" alt="">
                                  <button>Share</button>
                              </div>
                          </div>
                          <div class="comment" id="commentField">
                              <div class="comment-field">
                                  <div class="comment-user">
                                      <img src="${userInfo.avtPhoto}" alt="">
                                  </div>
                                  <form action="<c:url value='/postCmt'/>" method="post" class="comment-input">
                                      <label for="contentId">
                                          <input placeholder="Write a public comment" name="message" id="contentId">
                                      </label>
                                      <input type="hidden" value="${userInfo.id}" name="userId">
                                      <input type="hidden" value="${item.id}" name="postId">
                                  </form>
                                  <button onclick="sendCmt()"><img src="img/send-message.png" alt=""></button>
                              </div>
                              <div class="comment-list">
                                  <c:if test="${item.commentList.size() > 0}">
                                      <c:forEach items="${item.commentList}" var="cmt">
                                          <div class="comment-item">
                                              <div class="post-user-avatar">
                                                  <a href="<c:url value='/profile?id=${cmt.user.id}'/>"><img src="${cmt.user.avtPhoto}" alt=""></a>
                                              </div>
                                              <div class="msg-info-user">
                                                      ${cmt.user.firstName} ${cmt.user.surName}
                                                  <div class="msg-info">
                                                          ${cmt.message}
                                                  </div>
                                                  <span>${cmt.createdDate}</span>
                                              </div>
                                          </div>
                                      </c:forEach>
                                  </c:if>
                              </div>
                          </div>
                      </div>
                  </c:forEach>
              </c:if>
          </div>
      </div>
  </div>
</body>
<style>
    <%@ include file="./../css/personalpage.css" %>
    <%@ include file="./../css/home.css" %>
    body{
        margin:0;
        overflow-x: hidden;
    }
</style>
<script>
    <%@ include file="../js/personal.js" %>
    <%@ include file="../js/general.js" %>
</script>
</html>
