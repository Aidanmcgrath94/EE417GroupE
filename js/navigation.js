
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
quoteSentenceList[2] = "";
quoteSentenceList[3] = "";
quoteSentenceList[4] = "";
quoteSentenceList[5] = "";
quoteSentenceList[6] = "";
quoteSentenceList[7] = "";
quoteSentenceList[8] = "";
quoteSentenceList[9] = "";
quoteSentenceList[10] = "";
quoteSentenceList[11] = "";
quoteSentenceList[12] = "";


var quoteCharacterList = [];
quoteCharacterList[0] = "Madara, Naruto";
quoteCharacterList[1] = "Alucard, Hellsing";
quoteCharacterList[2] = "";
quoteCharacterList[3] = "";
quoteCharacterList[4] = "";
quoteCharacterList[5] = "";
quoteCharacterList[6] = "";
quoteCharacterList[7] = "";
quoteCharacterList[8] = "";
quoteCharacterList[9] = "";
quoteCharacterList[10] = "";
quoteCharacterList[11] = "";
quoteCharacterList[12] = "";


// $('#quoteSentence').replaceWith($('#quoteCharacter'));

// <h2 id="quoteSentence">"Weakness Disgusts Me"</h2>


// var rdNb = Math.floor(Math.random() * (max - min + 1)) + min;


function getRandomdNb(maxQuoteNb){
    var rdNb = Math.floor(Math.random() * (maxQuoteNb + 1 - 1 + 1));
    return Math.trunc(rdNb);
}


function switchQuote(){
    var rdNb = getRandomdNb(12);
    $('#quoteSentence').replaceWith('<h2 id="quoteSentence">"' + quoteSentenceList[rdNb] + '"</h2>');
    $('#quoteCharacter').replaceWith('<h3 id="quoteCharacter">- ' + quoteCharacterList[rdNb] + '</h3>');
}


// switchQuote();

$('#switchButton').click(function() {
    switchQuote();
});

$('.closeBtn').click(function() {
    switchQuote();
});











