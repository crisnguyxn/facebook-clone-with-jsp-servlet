function updatePost(postId) {
    $.ajax({
        url:'getPost?id='+postId,
        type:'GET'
    }).done(function (data) {
        $('#userInfo').text(data.user.firstName +" " + data.user.surName )
        $('textarea.textarea').val(data.content);
        $('#mode').val(data.mode);
        if(data.fileUrl != null){
            $('#mime').attr("src",data.fileUrl);
            $("#mime").removeClass("image");
        }
    })
    $('div.form-title').text('Update Post');
    $('#postForm').attr("action",'/Facebook_war_exploded/update?id='+postId);
    $("#form").toggle(100);
}
function savePost(postId) {
    console.log(postId);
}
function deletePost(postId) {
    $.ajax({
        url:'delete?id='+postId,
        type:'GET'
    }).done(function () {
        window.location.reload();
    })
}
$(document).ready(function () {
    $(".post-header-right").click(function () {
        $(this).children(".options").toggle(500);
    });
});

function sendCmt() {
    $('#formCmt').submit();
}

$(document).ready(function () {
    $("#closedForm").click(function () {
        $('#reset').click();
        $('#mime').attr("src","");
        $("#mime").addClass("image");
        $("#form").hide(100);
        $('div.form-title').text('Create Post');
    });
});
$(document).ready(function () {
    $("#openForm").click(function () {
        $("#form").show(100);
    });
});