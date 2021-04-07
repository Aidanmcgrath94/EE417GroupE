
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

