
var slideMenu = (function() {

    var slideMenu = function(config) {
        config = config || {};
        this.toggleBtn = $(config.toggleBtn);
        this.menu = $(config.menu);
        this.close = $(config.close);

        this.init();
        config = null;
    };


    // public interface
    slideMenu.prototype = {
        constructor: slideMenu,
        init: function() {
            this.eventManager();
        },
        eventManager: function() {
            this.toggleBtn.on('click.openMenu', onButtonClickHandler.bind(this));
            this.close.on('click.closeMenu', onCloseClickHandler.bind(this));
        }
    };


    // private interface
    function onButtonClickHandler(menu, evt) {
        if (!this.menu.hasClass('open')) {
            this.menu.addClass('open');
        };
    }


    function onCloseClickHandler(evt) {
        this.menu.removeClass('open')
    }


    function onDocumentClickHandler(evt) {
        var $target = $(evt.target);

        if (!$target.closest(this.menuForm).length && !$target.closest(this.menuContent).length && this.menu.hasClass('open')) {
            this.menu.removeClass('open')
        }
    }


    return slideMenu;
})();


$(document).ready(function() {
    var mainMenu = new slideMenu({
        menu: '.slideNav',
        toggleBtn: '.menuBtn',
        close: '.closeBtn'
    });
});

// Random Quote in Nav Bar
var quoteSentenceList = [];
quoteSentenceList[0] = "Weakness Disgusts Me";
quoteSentenceList[1] = "Giving up is what kills people";
quoteSentenceList[2] = "This World Shall Know Pain";
quoteSentenceList[3] = "The True Measure Of A Shinobi Is Not How He Lives, But How He Dies";
quoteSentenceList[4] = "Those who cannot acknowledge themselves, will eventually fail";
quoteSentenceList[5] = "That's my Flying Raijin Level 2!!";
quoteSentenceList[6] = "Kaaaaa Meeeee Haaaaa Meeee HAAAAA!!!!!!!!";
quoteSentenceList[7] = "Regain my Honour";
quoteSentenceList[8] = "I'm Gonna Be Hokage and ignore Family Duties";
quoteSentenceList[9] = "I will not allow my comrades to die";
quoteSentenceList[10] = "";
quoteSentenceList[11] = "";
quoteSentenceList[12] = "";


var quoteCharacterList = [];
quoteCharacterList[0] = "Madara, Naruto";
quoteCharacterList[1] = "Alucard, Hellsing";
quoteCharacterList[2] = "Nagato Uzumaki, Naruto";
quoteCharacterList[3] = "Jiraya, Naruto";
quoteCharacterList[4] = "Itachi, Naruto";
quoteCharacterList[5] = "Minato, Naruto";
quoteCharacterList[6] = "Goku, DBZ";
quoteCharacterList[7] = "Zuko, Avatar";
quoteCharacterList[8] = "Naruto, Naruto";
quoteCharacterList[9] = "Kakashi, Naruto";
quoteCharacterList[10] = "";
quoteCharacterList[11] = "";
quoteCharacterList[12] = "";

const actualQuoteNb = 10;

// var rdNb = Math.floor(Math.random() * (max - min + 1)) + min;


function getRandomdNb(maxQuoteNb){
    var rdNb = Math.floor(Math.random() * (maxQuoteNb + 1 - 1 + 1));
    return Math.trunc(rdNb);
}


function switchQuote(){
    var rdNb = getRandomdNb(actualQuoteNb-1);
    $('#quoteSentence').replaceWith('<h2 id="quoteSentence">"' + quoteSentenceList[rdNb] + '"</h2>');
    $('#quoteCharacter').replaceWith('<h3 id="quoteCharacter">- ' + quoteCharacterList[rdNb] + '</h3>');
}


switchQuote();

$('#switchButton').click(function() {
    switchQuote();
});

$('.closeBtn').click(function() {
    switchQuote();
});





