$(function() {
	$(window).on("load", function() {
		$(this).scrollTop(700);
	})
});

var swiper = new Swiper('.swiper-container', {
	direction : 'vertical',
	slidesPerView : 'auto',
	freeMode : true,
	scrollbar : {
		el : '.swiper-scrollbar',
	},
	mousewheel : true,
});

function nott() {
	var ok = confirm("本当に削除されますか？");
	console.log(ok);
	if (ok == true) {
		return true;
	} else {
		return false;
	}
}