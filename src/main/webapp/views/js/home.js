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
function previewFile() {
    const preview = document.getElementById('mime');
    const selectedFile = document.getElementById('file').files[0];
    const reader = new FileReader();
    console.log(selectedFile);
    if(selectedFile === undefined){
        $('#mime').addClass("image").attr("src","");
    }
    if (selectedFile) {
        $('#mime').removeClass("image");
        reader.readAsDataURL(selectedFile);
    }
    reader.addEventListener("load", (e) => {
        preview.src = e.target.result;
    }, false);
}
function getImg(imgFile){
    const preview = document.getElementById('postImg');
    const reader = new FileReader();
    if (imgFile) {
        reader.readAsDataURL(imgFile);
    }
    reader.addEventListener("load", (e) => {
        preview.src = e.target.result;
    }, false);
}
function getTimeFromNow(createdTime) {
    const time = Date.now() - createdTime;
    let secondsElapsed = Math.floor(time / 1000);
    if (secondsElapsed >= 60 && secondsElapsed < 3600) {
        return Math.floor(secondsElapsed / 60) > 1 ? Math.floor(secondsElapsed / 60).toString() + " mins" : Math.floor(secondsElapsed / 60).toString() + " min";
    }
    if (secondsElapsed >= 3600 && secondsElapsed < 86400) {
        return Math.floor(secondsElapsed / 3600) > 1 ? Math.floor(secondsElapsed / 3600).toString() + " hours" : Math.floor(secondsElapsed / 3600).toString() + " hour";
    }
    if (secondsElapsed > 0 && secondsElapsed < 60) {
        return secondsElapsed > 1 ? secondsElapsed.toString() + " seconds" : secondsElapsed.toString() + " second";
    }
    if (secondsElapsed === 0) {
        return "Just now";
    }
}