







//NavBar
function hideIconBar() {
    var iconBar = document.getElementById("iconBar");
    var navigation = document.getElementById("navigation");
    iconBar.setAttribute("style", "display:none;");
    navigation.classList.remove("hide");
}


function showIconBar() {
    var iconBar = document.getElementById("iconBar");
    var navigation = document.getElementById("navigation");
    iconBar.setAttribute("style", "display:block;");
    navigation.classList.add("hide");
}

// $(function(){
//     $("#controller1").click(function(){ //button
//         $("#slideMenu").toggle();   //main div
//     })
//
//     $("#controller2").click(function(){
//         $("#slideMenu").toggle();
//     })
//
// });