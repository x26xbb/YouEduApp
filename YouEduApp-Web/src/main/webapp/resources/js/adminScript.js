$(function (){
    resizeBody();
    $(window).resize(function() {
        resizeBody();
    });      
});

function resizeBody(){
     var height = $(window).height();
    $('.body-section').css('min-height', height * 0.75);
}
        

