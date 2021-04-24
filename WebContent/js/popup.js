


function showPopUp(){
    popup.style.display = "block";
}

function closePopUp(){
    popup.style.display = "none";
}

//open the popup if previous page was signup
var oldUrl = document.referrer;

if(oldUrl.includes("signup")){
    playSound('success')
    showPopUp();
}else if(oldUrl.includes("login")){
    playSound('login')
}

//close when click outside of the box
var popup = document.getElementById("popupBox");

window.onclick = function(event) {
    if (event.target === popup) {
        popup.style.display = "none";
    }
}