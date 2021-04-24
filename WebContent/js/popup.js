

function showPopUp(){
    popup.style.display = "block";
}

function closePopUp(){
    popup.style.display = "none";
}

//close when click outside of the box
var popup = document.getElementById("popupBox");

window.onclick = function(event) {
    if (event.target === popup) {
        popup.style.display = "none";
    }
}