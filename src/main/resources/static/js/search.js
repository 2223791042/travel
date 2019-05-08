$(document).ready(function(){

	var height = $(window).height();//获取屏幕高度
	var width = $(window).width();//获取屏幕宽度

	if (width>768) {

		$('.header-info ul .search').click(function(){

			$('.search-window').fadeIn();
			$('.search-window .input-area').css('margin-top','-' + $('.search-window .input-area').height()/2 + 'px')

		});

	}else{

		$('.header-info ul li.sousuo').click(function(){

			$('.search-window').fadeIn();
			$('.search-window .input-area').css('margin-top','-' + $('.search-window .input-area').height()/2 + 'px')

		});

	}

	$('.search-window .close').click(function(){

		$('.search-window').fadeOut();

	});

});

