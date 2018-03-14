$(function() {
  $('.panel-tabs li:first').addClass('active');
  $('.panel-tabs li').click(function() {
    $('.panel-tabs li').removeClass('active');
    $(this).addClass('active');
  });
});

