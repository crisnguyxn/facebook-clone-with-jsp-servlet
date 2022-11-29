<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./shadow.css" />
    <script src="jquery-3.6.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <title>Facebook Home</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="homepage">
        <div class="homepage-left">
            <div class="utils">
                <div class="field">
                    <a href=""><img src="img/userx.png" alt=""></a>
                    <p>${userInfo.firstName} ${userInfo.surName}</p>
                </div>
                <div class="field">
                    <a href=""><img src="img/groupx.png" alt=""></a>
                    <p>Find friends</p>
                </div>
                <div class="field">
                    <a href=""><img src="img/teamx.png" alt=""></a>
                    <p>Groups</p>
                </div>
                <div class="field">
                    <a href=""><img src="img/marketplace.png" alt=""></a>
                    <p>Marketplace</p>
                </div>
                <div class="field">
                    <a href=""><img src="img/slideshow.png" alt=""></a>
                    <p>Watch</p>
                </div>
                <div class="field">
                    <a href=""><img src="img/historyx.png" alt=""></a>
                    <p>Memories</p>
                </div>
                <div class="field">
                    <a href=""><img src="img/award.png" alt=""></a>
                    <p>Saved</p>
                </div>
                <div class="field">
                    <a href=""><img src="img/arrow-down-sign-to-navigate.png" alt=""></a>
                    <p>Watch more</p>
                </div>
            </div>
            <div class="shortcut">
                <h3>Your shortcuts</h3>
            </div>
        </div>
        <div class="homepage-center">
            <div class="center">
                <div class="container">
                    <div class="post-form" id="form">
                        <div class="post-form-header">
                            <div class="form-title">
                                Create post
                            </div>
                            <button id="closedForm">X</button>
                        </div>
                        <div class="post-form-main">
                            <form action="<c:url value='/post'/>" method="post" enctype="multipart/form-data">
                                <div class="post-header-field">
                                    <img src="img/userx.png" alt="">
                                    <div class="post-userinfo">
                                        <p>${userInfo.firstName} ${userInfo.surName}</p>
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
                                        <textarea class="textarea" placeholder="What's on your mind, ${userInfo.firstName}?" name="content" id="content" cols="62" rows="10" style="
                                            font-size: 20px;
                                            width: 480px;
                                            height: 181px;
                                            border: none;
                                            outline: none;
                                            font-family: 'Poppins', sans-serif;
                                            "></textarea>
                                    </label>
                                </div>
                                <label for="file">
                                    <input type="file" name="file" id="file">
                                </label>
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
                                <input type="hidden" id="userId" value="${userInfo.id}" name="userId">
                            </form>
                        </div>
                    </div>
                </div>
                <div class="post-creation">
                    <div class="post-creation-header">
                        <img src="img/userx.png" alt="">
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
                            <p>Feeling/activity</p>
                        </div>
                    </div>
                </div>
                <c:forEach var = "item" items="${model.resultList}">
                <div class="post">
                        <div class="post-header">
                            <div class="post-header-left">
                                <div class="post-user-avatar">
                                    <a href=""><img src="img/userx.png" alt=""></a>
                                </div>
                                <div class="user-info">
                                    ${item.user.firstName} ${item.user.surName}
                                    <div class="time-info">
                                        ${item.createdDate}
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
                                <img src="img/morex2x.png" alt="">
                            </div>
                        </div>
                        <div class="post-info">
                            <div class="post-title">
                                ${item.content}
                            </div>
                            <c:if test="${item.fileUrl != null}">
                                <div class="post-img-video">
                                    <img src="<c:url value='${item.fileUrl}'/>" alt="">
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
                                <p>Like</p>
                            </div>
                            <div class="icon">
                                <img src="img/comment.png" alt=""/>
                                <p id="comment">Comment</p>
                            </div>
                            <div class="icon">
                                <img src="img/share.png" alt="">
                                <p>Share</p>
                            </div>
                        </div>
                        <div class="comment" id="commentField">
                            <div class="comment-field">
                                <div class="comment-user">
                                    <img src="img/userx.png" alt="">
                                </div>
                                <form action="<c:url value='/postCmt'/>" method="post" class="comment-input">
                                    <label for="content">
                                        <input placeholder="Write a public comment" name="content" id="contentId">
                                    </label>
                                    <input type="hidden" value="${item.userId}" name="userId">
                                    <input type="hidden" value="${item.id}" name="postId">
                                </form>
                            </div>
                            <div>${item.content}</div>
                        </div>
                </div>
                </c:forEach>
            </div>
        </div>
        <div class="homepage-right">
            <div class="friends">
                <div class="friend-header">
                    <div class="title">
                        <h3>Contacts</h3>
                    </div>
                    <div class="icons">
                        <img src="img/video-camerax.png" alt="">
                        <img src="img/loupe.png" alt="">
                        <img src="img/dots.png" alt="">
                    </div>
                </div>
                <div class="field">
                    <a href=""><img src="img/userx.png" alt=""></a>
                    <p>Dyann Nguyen</p>
                </div>
                <div class="field">
                    <a href=""><img src="img/userx.png" alt=""></a>
                    <p>Nguyen Thanh Huynh</p>
                </div>
            </div>
        </div>
    </div>
</body>
<style>
    body{
        margin:0 !important;
    }
    <%@ include file="css/home.css" %>
</style>
<script>
    $(document).ready(function(){
        $("#closedForm").click(function(){
            $("#form").hide(100);
        });
    });
    $(document).ready(function(){
        $("#openForm").click(function(){
            $("#form").show(100);
        });
    });
    $(document).ready(function(){
        $("#comment").click(function(){
            $("#commentField").show(100);
        });
    });
    // $('#file').change( function(e)
    // {
    //     let fileName = e.target.files[0].name;
    //     if(fileName != null){
    //         $("#kaka").click();
    //     }
    // });
</script>
</html>