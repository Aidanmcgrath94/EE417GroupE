


//To display sound on the website
//Example : onclick="playSound('post')"
function playSound(type){

    var soundUrl = "";

    switch(type){
        case "post":
            soundUrl = "../sounds/almighty_push.mp3";
            break;
        case "success":
            soundUrl = "../sounds/success.mp3";
            break;
        case "comment":
            soundUrl = "../sounds/chakra.mp3";
            break;
        case "like":
            soundUrl = "../sounds/handsign.mp3";
            break;
        case "login":
            soundUrl = "../sounds/know_pain.mp3";
            break;
        case "logout":
            soundUrl = "../sounds/sharingan.mp3";
            break;
        default:
            console.log('wrong sound type')
            break;
    }

    if(soundUrl !== ""){
        var audio = new Audio(soundUrl) ;
        audio.play();
    }

}


//Make an effect when click
function clickEffect(e){
    var doc = document.createElement("div");
    doc.className = "clickEffect";
    doc.style.top = e.clientY+"px";
    doc.style.left = e.clientX+"px";
    document.body.appendChild(doc);
    doc.addEventListener('animationend',function(){doc.parentElement.removeChild(doc);}.bind(this));
}
document.addEventListener('click',clickEffect);
