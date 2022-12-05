function previewPhoto() {
    const preview = document.getElementById('coverPhoto');
    const selectedFile = document.getElementById('file').files[0];
    const reader = new FileReader();
    console.log(selectedFile);
    if(selectedFile === undefined){
        $('.alert-save').removeClass('display-alert');
        $('#coverPhoto').addClass("image").attr("src","");
    }
    if (selectedFile) {
        $('#coverPhoto').removeClass("image");
        $('.alert-save').addClass('display-alert');
        reader.readAsDataURL(selectedFile);
    }
    reader.addEventListener("load", (e) => {
        preview.src = e.target.result;
    }, false);
}
function discard(userId){
    let coverQueried = document.getElementById('file').files[0];
    let avtQueried = document.getElementById('avatar').files[0];
    $.ajax({
        url:'userInfo?id='+userId,
        type:'GET'
    }).done(function (data) {
        console.log(data);
        if(coverQueried !== undefined){
            if(data.coverPhoto != null){
                $('#coverPhoto').attr("src",data.coverPhoto);
            }else{
                $('#coverPhoto').addClass("image");
            }
            $('.alert-save').removeClass('display-alert');
        }
        if(avtQueried !== undefined){
            if(data.avtQueried != null){
                $('#avatarImg').attr("src",data.avtPhoto);
            }else{
                $('#avatarImg').attr("src","img/biguser.png");
            }
            $('.alert-save').removeClass('display-alert');
        }
    })
}
function updateUser(userId) {
    let avtPhotoQueried = document.getElementById('avatar').files;
    let coverPhotoQueried = document.getElementById('file').files;
    const formData = new FormData();
    formData.append("coverFile",coverPhotoQueried[0]);
    formData.append("avtFile",avtPhotoQueried[0]);
    $.ajax({
        url:'updateUser?id=' + userId,
        type:'POST',
        data:formData,
        processData:false,
        contentType:false,
        enctype: "multipart/form-data",
    }).done(function (data) {
        if(data !== null){
            window.location.href = 'profile?id='+data.id;
        }
    })
}
function previewAvatar() {
    const preview = document.getElementById('avatarImg');
    const selectedFile = document.getElementById('avatar').files[0];
    const reader = new FileReader();
    console.log(selectedFile);
    if(selectedFile === undefined){
        $('#avatarImg').attr("src","");
    }
    if (selectedFile) {
        $('.alert-save').addClass('display-alert');
        console.log(selectedFile);
        reader.readAsDataURL(selectedFile);
    }
    reader.addEventListener("load", (e) => {
        preview.src = e.target.result;
    }, false);
}
function addFriend(userId) {
    let loggedId = $('#loggedId').val();
    $.ajax({
        url:'addfriend',
        data:{
            friendId:userId,
            loggedId:loggedId
        },
        type:'POST'
    }).done(function (data) {
        console.log(data);
    })
}
function getFriend(loggedId) {
    $.ajax({
        url:'getfriends?id='+loggedId,
        type:'GET'
    }).done(function (data) {
        console.log(data);
    })
}
