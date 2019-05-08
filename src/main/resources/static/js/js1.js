$(document).ready(function(){



	var height = $(window).height();//获取屏幕高度

	var width = $(window).width();//获取屏幕宽度



	//查看更多效果

	

	for(var i=0;i<$('.views').length;i++){



		$('.views').eq(i).children('span').children('span').css('left','-'+$('.views').eq(i).children('span').children('span').width()+'px');



	}

	// $('.views > span > span').css('left','-'+$('.views > span > span').width()+'px');

	$('.views > span').hover(function(){

		var _move = $(this).width() + 1;

		$(this).find('span').css('left','-' + _move + 'px');

		$(this).find('span').stop().animate({'left':'0'},500);

	},function(){

		var _move = $(this).width() + 1;

		$(this).find('span').stop().animate({'left':_move},500);

		

	});



	$('.viewMore').hover(function(){

		$(this).find('.zhankai').attr('src','/resource/web/images/zhankai-12.png');

	},function(){

		$(this).find('.zhankai').attr('src','/resource/web/images/zhankai.png');

	});




	//乌镇导航条滚动固定

	if (width>768) {



		//header导航

		$('nav ul .dropDown').hover(function(){

			$(this).find('ul').slideDown();

		},function(){

			$(this).find('ul').stop(true).slideUp();

		});



		$('nav > span').width($('nav ul .active > a').width());

		$('nav > ul > .dropDown').hover(function(){

			$('nav > span').show();

			var _ew = $('nav ul .active > a').outerWidth();

			var _index = $(this).index();

			var _ml = parseInt($('nav > ul > li > a').css('margin-right'));

			var _x = _index*(_ew+_ml);

			$('nav > span').stop().animate({'left':_x},500);

		},function(){

			$('nav > span').hide();

		});





	}



	//banner渐变图,主页大图

	

	if (width>768) {

		//PC端

		var _tabli = '<li></li>'

		var _length = $('.bannerFade > div').length;



		$('.bannerFade > div').hide();

		$('.bannerFade > div').eq(0).show();

		for(var i=0;i<_length;i++){

			$('.bannerFade .tab-btn').append(_tabli);

		}

		$('.bannerFade .tab-btn li').eq(0).addClass('active');



		$(window).load(function(){

			$('.bannerFade').height($('.bannerFade > .active').height());

		});

		



		$('.bannerFade .tab-btn li').click(function(){

			$('.bannerFade .tab-btn li').removeClass('active');

			$(this).addClass('active');

			var _index = $(this).index();

			$('.bannerFade > div').removeClass('active');

			$('.bannerFade > div').eq(_index).addClass('active');

			$('.bannerFade > div').fadeOut(1000);

			$('.bannerFade > div').eq(_index).fadeIn(1000);

		});



		function autoFade(){

			var l = $('.bannerFade > div').length;

			var i = $('.bannerFade > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				$('.bannerFade .tab-btn li').removeClass('active');

				$('.bannerFade .tab-btn li').eq(x).addClass('active');

				$('.bannerFade > div').removeClass('active');

				$('.bannerFade > div').eq(x).addClass('active');

				$('.bannerFade > div').fadeOut(1000);

				$('.bannerFade > div').eq(x).fadeIn(1000);

			}else{

				$('.bannerFade .tab-btn li').removeClass('active');

				$('.bannerFade .tab-btn li').eq(0).addClass('active');

				$('.bannerFade > div').removeClass('active');

				$('.bannerFade > div').eq(0).addClass('active');

				$('.bannerFade > div').fadeOut(1000);

				$('.bannerFade > div').eq(0).fadeIn(1000);

			}

		}



		timer =  setInterval(autoFade,5000);



		$('.bannerFade').hover(function(){

			clearInterval(timer);

		},function(){

			timer =  setInterval(autoFade,5000);

		});

	}else{



		//手机端

		var _tabli = '<li></li>'

		var _length_0 = $('.bannerFade > div').length;



		for(var i=0;i<_length_0;i++){

			$('.slidebanner-wrap .tab-btn-wap').append(_tabli);

		}



		$('.slidebanner-wrap .tab-btn-wap li').eq(0).addClass('active');

		$('.bannerFade').height($('.bannerFade > .active').height());



		var imgWidth_0 =  $('.bannerFade').parent().width();

		var imgNum_0 = $('.bannerFade').children('div').length;



		$('.bannerFade').children('div').width(imgWidth_0);

		$('.bannerFade').css('height','auto');

		$('.bannerFade').width(imgNum_0 * imgWidth_0);



		var x_0 = 0;





		$(".bannerFade").on("swiperight",function(){



			if (x_0 == 0) {



				x_0 = (imgNum_0-1)*imgWidth_0;



				$(".bannerFade").animate({'right':x_0+'px'});

				$('.slidebanner-wrap .tab-btn-wap li').removeClass('active');

				$('.slidebanner-wrap .tab-btn-wap li').eq(x_0/imgWidth_0).addClass('active');



			}else{



				x_0 =  x_0 -imgWidth_0;

				$(".bannerFade").animate({'right':x_0+'px'});

				$('.slidebanner-wrap .tab-btn-wap li').removeClass('active');

				$('.slidebanner-wrap .tab-btn-wap li').eq(x_0/imgWidth_0).addClass('active');



			}



		});



		$(".bannerFade").on("swipeleft",function(){



			if (x_0 == (imgNum_0-1)*imgWidth_0) {



				x_0 = 0;

				$(".bannerFade").animate({'right':x_0+'px'});

				$('.slidebanner-wrap .tab-btn-wap li').removeClass('active');

				$('.slidebanner-wrap .tab-btn-wap li').eq(x_0/imgWidth_0).addClass('active');

			}else{



				x_0 += imgWidth_0;

				$(".bannerFade").animate({'right':x_0+'px'});

				$('.slidebanner-wrap .tab-btn-wap li').removeClass('active');

				$('.slidebanner-wrap .tab-btn-wap li').eq(x_0/imgWidth_0).addClass('active');



			}





		});





		$('.slidebanner-wrap .tab-btn-wap li').click(function(){

			$('.slidebanner-wrap .tab-btn-wap li').removeClass('active');

			$(this).addClass('active');

			var _index = $(this).index();

			x = _index*imgWidth_0;

			$('.bannerFade > div').removeClass('active');

			$('.bannerFade > div').eq(_index).addClass('active');



			$(".bannerFade").animate({'right':x+'px'});

		});



		// function autoFade(){

		// 	var l = $('.bannerFade > div').length;

		// 	var i = $('.bannerFade > div.active').index();

		// 	var x = i+1;

		// 	if (x<=l-1) {

		// 		$('.bannerFade > div > h2').css('top','-36px');

		// 		$('.bannerFade .tab-btn li').removeClass('active');

		// 		$('.bannerFade .tab-btn li').eq(x).addClass('active');

		// 		$('.bannerFade > div').removeClass('active');

		// 		$('.bannerFade > div').eq(x).addClass('active');

		// 		$('.bannerFade > div').fadeOut(1000);

		// 		$('.bannerFade > div').eq(x).fadeIn(1000);

		// 		$('.bannerFade > div').eq(x).find('h2').animate({top:'30%'},1000);

		// 	}else{

		// 		$('.bannerFade > div > h2').css('top','-36px');

		// 		$('.bannerFade .tab-btn li').removeClass('active');

		// 		$('.bannerFade .tab-btn li').eq(0).addClass('active');

		// 		$('.bannerFade > div').removeClass('active');

		// 		$('.bannerFade > div').eq(0).addClass('active');

		// 		$('.bannerFade > div').fadeOut(1000);

		// 		$('.bannerFade > div').eq(0).fadeIn(1000);

		// 		$('.bannerFade > div').eq(0).find('h2').animate({top:'30%'},1000);

		// 	}

		// }



		// timer =  setInterval(autoFade,5000);



		// $('.bannerFade').hover(function(){

		// 	clearInterval(timer);

		// },function(){

		// 	timer =  setInterval(autoFade,5000);

		// });

	}







	//中国乌镇小banner渐变图



	if (width>768) {

		var _length2 = $('.bannerFade2 > div').length;

		

		$('.bannerFade2 > div').hide();

		$('.content-text > div').hide();

		$('.content-text > div').eq(0).show();

		$('.content-text').height($('.content-text > div').eq(0).height());

		$('.bannerFade2 > div').eq(0).show();

		$('.bannerFade2 > .phone-tip span').eq(0).addClass('active');

		for(var i=0;i<_length2;i++){

			$('.bannerFade2 .tab-btn').append(_tabli);

		}

		$('.bannerFade2 .tab-btn li').eq(0).addClass('active');

		$(window).load(function(){

			$('.bannerFade2').height($('.bannerFade2 > .active').height());

		});

		

		$('.bannerFade2 .tab-btn li').click(function(){

			$('.bannerFade2 .tab-btn li').removeClass('active');

			$(this).addClass('active');

			var _index = $(this).index();

			$('.content-text').height($('.content-text > div').eq(_index).height());

			$('.content-text > div').fadeOut(1000);

			$('.content-text > div').eq(_index).fadeIn(1000);

			$('.bannerFade2 > .phone-tip span').removeClass('active');

			$('.bannerFade2 > .phone-tip span').eq(_index).addClass('active');

			$('.bannerFade2 > div').removeClass('active');

			$('.bannerFade2 > div').eq(_index).addClass('active');

			$('.bannerFade2 > div').fadeOut(1000);

			$('.bannerFade2 > div').eq(_index).fadeIn(1000);

		});



		$('.bannerFade2 > .tip > div').eq(0).find('span').addClass('active');

		$('.bannerFade2 > .tip > div > p').click(function(){

			$('.bannerFade2 > .tip > div > span').removeClass('active');

			$(this).siblings().addClass('active');

			var _index = $(this).parent().index();

			$('.content-text').height($('.content-text > div').eq(_index).height());

			$('.content-text > div').fadeOut(1000);

			$('.content-text > div').eq(_index).fadeIn(1000);

			$('.bannerFade2 > div').removeClass('active');

			$('.bannerFade2 > div').eq(_index).addClass('active');

			$('.bannerFade2 > div').fadeOut(1000);

			$('.bannerFade2 > div').eq(_index).fadeIn(1000);

		});



		function autoFade2(){

			var l = $('.bannerFade2 > div').length;

			var i = $('.bannerFade2 > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				$('.content-text').height($('.content-text > div').eq(x).height());

				$('.content-text > div').fadeOut(1000);

				$('.content-text > div').eq(x).fadeIn(1000);

				$('.bannerFade2 > .phone-tip span').removeClass('active');

				$('.bannerFade2 > .phone-tip span').eq(x).addClass('active');

				$('.bannerFade2 .tab-btn li').removeClass('active');

				$('.bannerFade2 .tab-btn li').eq(x).addClass('active');

				$('.bannerFade2 > .tip > div').find('span').removeClass('active');

				$('.bannerFade2 > .tip > div').eq(x).find('span').addClass('active');

				$('.bannerFade2 > div').removeClass('active');

				$('.bannerFade2 > div').eq(x).addClass('active');

				$('.bannerFade2 > div').fadeOut(1000);

				$('.bannerFade2 > div').eq(x).fadeIn(1000);

			}else{

				$('.content-text').height($('.content-text > div').eq(0).height());

				$('.content-text > div').fadeOut(1000);

				$('.content-text > div').eq(0).fadeIn(1000);

				$('.bannerFade2 > .phone-tip span').removeClass('active');

				$('.bannerFade2 > .phone-tip span').eq(0).addClass('active');

				$('.bannerFade2 .tab-btn li').removeClass('active');

				$('.bannerFade2 .tab-btn li').eq(0).addClass('active');

				$('.bannerFade2 > .tip > div').find('span').removeClass('active');

				$('.bannerFade2 > .tip > div').eq(0).find('span').addClass('active');

				$('.bannerFade2 > div').removeClass('active');

				$('.bannerFade2 > div').eq(0).addClass('active');

				$('.bannerFade2 > div').fadeOut(1000);

				$('.bannerFade2 > div').eq(0).fadeIn(1000);

			}

		}



		$('.bannerFade2 .arrow-right').click(function(){

			var l = $('.bannerFade2 > div').length;

			var i = $('.bannerFade2 > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				$('.content-text').height($('.content-text > div').eq(x).height());

				$('.content-text > div').fadeOut(1000);

				$('.content-text > div').eq(x).fadeIn(1000);

				$('.bannerFade2 > .phone-tip span').removeClass('active');

				$('.bannerFade2 > .phone-tip span').eq(x).addClass('active');

				$('.bannerFade2 .tab-btn li').removeClass('active');

				$('.bannerFade2 .tab-btn li').eq(x).addClass('active');

				$('.bannerFade2 > .tip > div').find('span').removeClass('active');

				$('.bannerFade2 > .tip > div').eq(x).find('span').addClass('active');

				$('.bannerFade2 > div').removeClass('active');

				$('.bannerFade2 > div').eq(x).addClass('active');

				$('.bannerFade2 > div').fadeOut(1000);

				$('.bannerFade2 > div').eq(x).fadeIn(1000);

			}else{

				$('.content-text').height($('.content-text > div').eq(0).height());

				$('.content-text > div').fadeOut(1000);

				$('.content-text > div').eq(0).fadeIn(1000);

				$('.bannerFade2 > .phone-tip span').removeClass('active');

				$('.bannerFade2 > .phone-tip span').eq(0).addClass('active');

				$('.bannerFade2 .tab-btn li').removeClass('active');

				$('.bannerFade2 .tab-btn li').eq(0).addClass('active');

				$('.bannerFade2 > .tip > div').find('span').removeClass('active');

				$('.bannerFade2 > .tip > div').eq(0).find('span').addClass('active');

				$('.bannerFade2 > div').removeClass('active');

				$('.bannerFade2 > div').eq(0).addClass('active');

				$('.bannerFade2 > div').fadeOut(1000);

				$('.bannerFade2 > div').eq(0).fadeIn(1000);

			}

		});

		$('.bannerFade2 .arrow-left').click(function(){

			var l = $('.bannerFade2 > div').length;

			var i = $('.bannerFade2 > div.active').index();

			var x = i-1;

			if (x>=0) {

				$('.content-text').height($('.content-text > div').eq(x).height());

				$('.content-text > div').fadeOut(1000);

				$('.content-text > div').eq(x).fadeIn(1000);

				$('.bannerFade2 .tab-btn li').removeClass('active');

				$('.bannerFade2 .tab-btn li').eq(x).addClass('active');

				$('.bannerFade2 > .tip > div').find('span').removeClass('active');

				$('.bannerFade2 > .tip > div').eq(x).find('span').addClass('active');

				$('.bannerFade2 > div').removeClass('active');

				$('.bannerFade2 > div').eq(x).addClass('active');

				$('.bannerFade2 > div').fadeOut(1000);

				$('.bannerFade2 > div').eq(x).fadeIn(1000);

			}else{

				$('.content-text').height($('.content-text > div').eq(l-1).height());

				$('.content-text > div').fadeOut(1000);

				$('.content-text > div').eq(l-1).fadeIn(1000);

				$('.bannerFade2 .tab-btn li').removeClass('active');

				$('.bannerFade2 .tab-btn li').eq(l-1).addClass('active');

				$('.bannerFade2 > .tip > div').find('span').removeClass('active');

				$('.bannerFade2 > .tip > div').eq(l-1).find('span').addClass('active');

				$('.bannerFade2 > div').removeClass('active');

				$('.bannerFade2 > div').eq(l-1).addClass('active');

				$('.bannerFade2 > div').fadeOut(1000);

				$('.bannerFade2 > div').eq(l-1).fadeIn(1000);

			}

		});



		timer1 =  setInterval(function(){



			var l = $('.bannerFade2 > div').length;

			var i = $('.bannerFade2 > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				$('.content-text').height($('.content-text > div').eq(x).height());

				$('.content-text > div').fadeOut(1000);

				$('.content-text > div').eq(x).fadeIn(1000);

				$('.bannerFade2 > .phone-tip span').removeClass('active');

				$('.bannerFade2 > .phone-tip span').eq(x).addClass('active');

				$('.bannerFade2 .tab-btn li').removeClass('active');

				$('.bannerFade2 .tab-btn li').eq(x).addClass('active');

				$('.bannerFade2 > .tip > div').find('span').removeClass('active');

				$('.bannerFade2 > .tip > div').eq(x).find('span').addClass('active');

				$('.bannerFade2 > div').removeClass('active');

				$('.bannerFade2 > div').eq(x).addClass('active');

				$('.bannerFade2 > div').fadeOut(1000);

				$('.bannerFade2 > div').eq(x).fadeIn(1000);

			}else{

				$('.content-text').height($('.content-text > div').eq(0).height());

				$('.content-text > div').fadeOut(1000);

				$('.content-text > div').eq(0).fadeIn(1000);

				$('.bannerFade2 > .phone-tip span').removeClass('active');

				$('.bannerFade2 > .phone-tip span').eq(0).addClass('active');

				$('.bannerFade2 .tab-btn li').removeClass('active');

				$('.bannerFade2 .tab-btn li').eq(0).addClass('active');

				$('.bannerFade2 > .tip > div').find('span').removeClass('active');

				$('.bannerFade2 > .tip > div').eq(0).find('span').addClass('active');

				$('.bannerFade2 > div').removeClass('active');

				$('.bannerFade2 > div').eq(0).addClass('active');

				$('.bannerFade2 > div').fadeOut(1000);

				$('.bannerFade2 > div').eq(0).fadeIn(1000);

			}



		},5000);



		$('.bannerFade2').hover(function(){

			clearInterval(timer1);

		},function(){

			timer1 =  setInterval(function(){



				var l = $('.bannerFade2 > div').length;

				var i = $('.bannerFade2 > div.active').index();

				var x = i+1;

				if (x<=l-1) {

					$('.content-text').height($('.content-text > div').eq(x).height());

					$('.content-text > div').fadeOut(1000);

					$('.content-text > div').eq(x).fadeIn(1000);

					$('.bannerFade2 > .phone-tip span').removeClass('active');

					$('.bannerFade2 > .phone-tip span').eq(x).addClass('active');

					$('.bannerFade2 .tab-btn li').removeClass('active');

					$('.bannerFade2 .tab-btn li').eq(x).addClass('active');

					$('.bannerFade2 > .tip > div').find('span').removeClass('active');

					$('.bannerFade2 > .tip > div').eq(x).find('span').addClass('active');

					$('.bannerFade2 > div').removeClass('active');

					$('.bannerFade2 > div').eq(x).addClass('active');

					$('.bannerFade2 > div').fadeOut(1000);

					$('.bannerFade2 > div').eq(x).fadeIn(1000);

				}else{

					$('.content-text').height($('.content-text > div').eq(0).height());

					$('.content-text > div').fadeOut(1000);

					$('.content-text > div').eq(0).fadeIn(1000);

					$('.bannerFade2 > .phone-tip span').removeClass('active');

					$('.bannerFade2 > .phone-tip span').eq(0).addClass('active');

					$('.bannerFade2 .tab-btn li').removeClass('active');

					$('.bannerFade2 .tab-btn li').eq(0).addClass('active');

					$('.bannerFade2 > .tip > div').find('span').removeClass('active');

					$('.bannerFade2 > .tip > div').eq(0).find('span').addClass('active');

					$('.bannerFade2 > div').removeClass('active');

					$('.bannerFade2 > div').eq(0).addClass('active');

					$('.bannerFade2 > div').fadeOut(1000);

					$('.bannerFade2 > div').eq(0).fadeIn(1000);

				}



			},5000);

		});



	}else{



	}







	//客栈banner图

	

	if (width>768) {

		$('.slidebanner-area').eq(1).children().removeClass('innBanner').addClass('innBanner2');

		var _inn = $('.innBanner > div').length;

		

		$('.innBanner > div').hide();

		$('.innBanner > div').eq(0).show();

		for(var i=0;i<_inn;i++){

			$('.innBanner .tab-btn').append(_tabli);

		}

		$('.innBanner .tab-btn li').eq(0).addClass('active');



		$(window).load(function(){

			$('.innBanner').height($('.innBanner > .active').height());

		});

		



		$('.innBanner .tab-btn li').click(function(){

			$('.innBanner .tab-btn li').removeClass('active');

			$(this).addClass('active');

			var _index = $(this).index();

			$('.innBanner > div').removeClass('active');

			$('.innBanner > div').eq(_index).addClass('active');

			$('.innBanner > div').fadeOut(1000);

			$('.innBanner > div').eq(_index).fadeIn(1000);

		});



		$('.innBanner > .tip > div').eq(0).find('span').addClass('active');

		$('.innBanner > .tip > div > p').click(function(){

			$('.innBanner > .tip > div > span').removeClass('active');

			$(this).siblings().addClass('active');

			var _index = $(this).parent().index();

			$('.innBanner > div').removeClass('active');

			$('.innBanner > div').eq(_index).addClass('active');

			$('.innBanner > div').fadeOut(1000);

			$('.innBanner > div').eq(_index).fadeIn(1000);

		});



		function innBanner(){

			var l = $('.innBanner > div').length;

			var i = $('.innBanner > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				$('.innBanner .tab-btn li').removeClass('active');

				$('.innBanner .tab-btn li').eq(x).addClass('active');

				$('.innBanner > div').removeClass('active');

				$('.innBanner > div').eq(x).addClass('active');

				$('.innBanner > div').fadeOut(1000);

				$('.innBanner > div').eq(x).fadeIn(1000);

			}else{

				$('.innBanner .tab-btn li').removeClass('active');

				$('.innBanner .tab-btn li').eq(0).addClass('active');

				$('.innBanner > div').removeClass('active');

				$('.innBanner > div').eq(0).addClass('active');

				$('.innBanner > div').fadeOut(1000);

				$('.innBanner > div').eq(0).fadeIn(1000);

			}

		}



		$('.innBanner .arrow-right').click(function(){

			var l = $('.innBanner > div').length;

			var i = $('.innBanner > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				$('.innBanner .tab-btn li').removeClass('active');

				$('.innBanner .tab-btn li').eq(x).addClass('active');

				$('.innBanner > div').removeClass('active');

				$('.innBanner > div').eq(x).addClass('active');

				$('.innBanner > div').fadeOut(1000);

				$('.innBanner > div').eq(x).fadeIn(1000);

			}else{

				$('.innBanner .tab-btn li').removeClass('active');

				$('.innBanner .tab-btn li').eq(0).addClass('active');

				$('.innBanner > div').removeClass('active');

				$('.innBanner > div').eq(0).addClass('active');

				$('.innBanner > div').fadeOut(1000);

				$('.innBanner > div').eq(0).fadeIn(1000);

			}

		});

		$('.innBanner .arrow-left').click(function(){

			var l = $('.innBanner > div').length;

			var i = $('.innBanner > div.active').index();

			var x = i-1;

			if (x>=0) {

				$('.innBanner .tab-btn li').removeClass('active');

				$('.innBanner .tab-btn li').eq(x).addClass('active');

				$('.innBanner > div').removeClass('active');

				$('.innBanner > div').eq(x).addClass('active');

				$('.innBanner > div').fadeOut(1000);

				$('.innBanner > div').eq(x).fadeIn(1000);

			}else{

				$('.innBanner .tab-btn li').removeClass('active');

				$('.innBanner .tab-btn li').eq(l-1).addClass('active');

				$('.innBanner > div').removeClass('active');

				$('.innBanner > div').eq(l-1).addClass('active');

				$('.innBanner > div').fadeOut(1000);

				$('.innBanner > div').eq(l-1).fadeIn(1000);

			}

		});



		timer2 =  setInterval(function(){



			var l = $('.innBanner > div').length;

			var i = $('.innBanner > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				$('.innBanner .tab-btn li').removeClass('active');

				$('.innBanner .tab-btn li').eq(x).addClass('active');

				$('.innBanner > div').removeClass('active');

				$('.innBanner > div').eq(x).addClass('active');

				$('.innBanner > div').fadeOut(1000);

				$('.innBanner > div').eq(x).fadeIn(1000);

			}else{

				$('.innBanner .tab-btn li').removeClass('active');

				$('.innBanner .tab-btn li').eq(0).addClass('active');

				$('.innBanner > div').removeClass('active');

				$('.innBanner > div').eq(0).addClass('active');

				$('.innBanner > div').fadeOut(1000);

				$('.innBanner > div').eq(0).fadeIn(1000);

			}



		},5000);



		$('.innBanner').hover(function(){

			clearInterval(timer2);

		},function(){

			timer2 =  setInterval(function(){



				var l = $('.innBanner > div').length;

				var i = $('.innBanner > div.active').index();

				var x = i+1;

				if (x<=l-1) {

					$('.innBanner .tab-btn li').removeClass('active');

					$('.innBanner .tab-btn li').eq(x).addClass('active');

					$('.innBanner > div').removeClass('active');

					$('.innBanner > div').eq(x).addClass('active');

					$('.innBanner > div').fadeOut(1000);

					$('.innBanner > div').eq(x).fadeIn(1000);

				}else{

					$('.innBanner .tab-btn li').removeClass('active');

					$('.innBanner .tab-btn li').eq(0).addClass('active');

					$('.innBanner > div').removeClass('active');

					$('.innBanner > div').eq(0).addClass('active');

					$('.innBanner > div').fadeOut(1000);

					$('.innBanner > div').eq(0).fadeIn(1000);

				}



			},5000);

		});





	}else{



		var _inn = $('.innBanner > div').length;



		for(var i=0;i<_inn;i++){

			$('.slidebanner-container .tab-btn-wap').append(_tabli);

		}

		$('.slidebanner-container .tab-btn-wap li').eq(0).addClass('active');

		$('.innBanner').height($('.innBanner > .active').height());





		var imgWidth_1 =  $('.innBanner').parent().width();

		var imgNum_1 = $('.innBanner').children('div').length;

		var x_1 = 0;



		$('.slidebanner-container .tab-btn-wap li').eq(0).addClass('active');



		$('.innBanner').children('div').width(imgWidth_1);

		$('.innBanner').css('height','auto');

		$('.innBanner').width(imgNum_1 * imgWidth_1);



		$(".innBanner").on("swiperight",function(){



			if (x_1 == 0) {



				x_1 = (imgNum_1-1)*imgWidth_1;



				$(".innBanner").animate({'right':x_1+'px'});

				$('.slidebanner-container .tab-btn-wap li').removeClass('active');

				$('.slidebanner-container .tab-btn-wap li').eq(x_1/imgWidth_1).addClass('active');



			}else{



				x_1 =  x_1 -imgWidth_1;

				$(".innBanner").animate({'right':x_1+'px'});

				$('.slidebanner-container .tab-btn-wap li').removeClass('active');

				$('.slidebanner-container .tab-btn-wap li').eq(x_1/imgWidth_1).addClass('active');

			}



		});



		$(".innBanner").on("swipeleft",function(){



			if (x_1 == (imgNum_1-1)*imgWidth_1) {



				x_1 = 0;

				$(".innBanner").animate({'right':x_1+'px'});

				$('.slidebanner-container .tab-btn-wap li').removeClass('active');

				$('.slidebanner-container .tab-btn-wap li').eq(x_1/imgWidth_1).addClass('active');

			}else{



				x_1 += imgWidth_1;

				$(".innBanner").animate({'right':x_1+'px'});

				$('.slidebanner-container .tab-btn-wap li').removeClass('active');

				$('.slidebanner-container .tab-btn-wap li').eq(x_1/imgWidth_1).addClass('active');

			}





		});





		$('.slidebanner-container .tab-btn-wap li').click(function(){

			$('.slidebanner-container .tab-btn-wap li').removeClass('active');

			$(this).addClass('active');

			var _index = $(this).index();

			x_1 = _index*imgWidth_1;



			$('.innBanner > div').removeClass('active');

			$('.innBanner > div').eq(_index).addClass('active');



			$(".innBanner").animate({'right':x_1+'px'});

		});





		function innBanner(){

			var l = $('.innBanner > div').length;

			var i = $('.innBanner > div.active').index();

			if (x_1 == (imgNum_1-1)*imgWidth_1) {

				x_1 = 0;

				$('.slidebanner-container .tab-btn-wap li').removeClass('active');

				$('.slidebanner-container .tab-btn-wap li').eq(x_1/imgWidth_1).addClass('active');

				$('.innBanner > div').removeClass('active');

				$('.innBanner > div').eq(x_1/imgWidth_1).addClass('active');

				$(".innBanner").animate({'right':x_1+'px'});

			}else{

				x_1 += imgWidth_1;

				$('.slidebanner-container .tab-btn-wap li').removeClass('active');

				$('.slidebanner-container .tab-btn-wap li').eq(x_1/imgWidth_1).addClass('active');

				$('.innBanner > div').removeClass('active');

				$('.innBanner > div').eq(x_1/imgWidth_1).addClass('active');

				$(".innBanner").animate({'right':x_1+'px'});

			}

		}



		timerInn =  setInterval(innBanner,5000);



		$('.innBanner').hover(function(){

			clearInterval(timerInn);

		},function(){

			timerInn =  setInterval(innBanner,5000);

		});





	}



	//客栈banner2图

	

	if (width>768) {

		$('.slidebanner-area').eq(1).children().removeClass('innBanner').addClass('innBanner2');

		var _inn2 = $('.innBanner2 > div').length;

		

		$('.innBanner2 > div').hide();

		$('.innBanner2 > div').eq(0).show();

		for(var i=0;i<_inn2;i++){

			$('.innBanner2 .tab-btn').append(_tabli);

		}

		$('.innBanner2 .tab-btn li').eq(0).addClass('active');

		$(window).load(function(){

			$('.innBanner2').height($('.innBanner2 > .active').height());

		});

		

		$('.innBanner2 .tab-btn li').click(function(){

			$('.innBanner2 .tab-btn li').removeClass('active');

			$(this).addClass('active');

			var _index = $(this).index();

			$('.innBanner2 > div').removeClass('active');

			$('.innBanner2 > div').eq(_index).addClass('active');

			$('.innBanner2 > div').fadeOut(1000);

			$('.innBanner2 > div').eq(_index).fadeIn(1000);

		});



		$('.innBanner2 > .tip > div').eq(0).find('span').addClass('active');

		$('.innBanner2 > .tip > div > p').click(function(){

			$('.innBanner2 > .tip > div > span').removeClass('active');

			$(this).siblings().addClass('active');

			var _index = $(this).parent().index();

			$('.innBanner2 > div').removeClass('active');

			$('.innBanner2 > div').eq(_index).addClass('active');

			$('.innBanner2 > div').fadeOut(1000);

			$('.innBanner2 > div').eq(_index).fadeIn(1000);

		});



		function innBanner2(){

			var l = $('.innBanner2 > div').length;

			var i = $('.innBanner2 > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				$('.innBanner2 .tab-btn li').removeClass('active');

				$('.innBanner2 .tab-btn li').eq(x).addClass('active');

				$('.innBanner2 > div').removeClass('active');

				$('.innBanner2 > div').eq(x).addClass('active');

				$('.innBanner2 > div').fadeOut(1000);

				$('.innBanner2 > div').eq(x).fadeIn(1000);

			}else{

				$('.innBanner2 .tab-btn li').removeClass('active');

				$('.innBanner2 .tab-btn li').eq(0).addClass('active');

				$('.innBanner2 > div').removeClass('active');

				$('.innBanner2 > div').eq(0).addClass('active');

				$('.innBanner2 > div').fadeOut(1000);

				$('.innBanner2 > div').eq(0).fadeIn(1000);

			}

		}



		$('.innBanner2 .arrow-right').click(function(){

			var l = $('.innBanner2 > div').length;

			var i = $('.innBanner2 > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				$('.innBanner2 .tab-btn li').removeClass('active');

				$('.innBanner2 .tab-btn li').eq(x).addClass('active');

				$('.innBanner2 > div').removeClass('active');

				$('.innBanner2 > div').eq(x).addClass('active');

				$('.innBanner2 > div').fadeOut(1000);

				$('.innBanner2 > div').eq(x).fadeIn(1000);

			}else{

				$('.innBanner2 .tab-btn li').removeClass('active');

				$('.innBanner2 .tab-btn li').eq(0).addClass('active');

				$('.innBanner2 > div').removeClass('active');

				$('.innBanner2 > div').eq(0).addClass('active');

				$('.innBanner2 > div').fadeOut(1000);

				$('.innBanner2 > div').eq(0).fadeIn(1000);

			}

		});

		$('.innBanner2 .arrow-left').click(function(){

			var l = $('.innBanner2 > div').length;

			var i = $('.innBanner2 > div.active').index();

			var x = i-1;

			if (x>=0) {

				$('.innBanner2 .tab-btn li').removeClass('active');

				$('.innBanner2 .tab-btn li').eq(x).addClass('active');

				$('.innBanner2 > div').removeClass('active');

				$('.innBanner2 > div').eq(x).addClass('active');

				$('.innBanner2 > div').fadeOut(1000);

				$('.innBanner2 > div').eq(x).fadeIn(1000);

			}else{

				$('.innBanner2 .tab-btn li').removeClass('active');

				$('.innBanner2 .tab-btn li').eq(l-1).addClass('active');

				$('.innBanner2 > div').removeClass('active');

				$('.innBanner2 > div').eq(l-1).addClass('active');

				$('.innBanner2 > div').fadeOut(1000);

				$('.innBanner2 > div').eq(l-1).fadeIn(1000);

			}

		});



		timer21 =  setInterval(function(){



			var l = $('.innBanner2 > div').length;

			var i = $('.innBanner2 > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				$('.innBanner2 .tab-btn li').removeClass('active');

				$('.innBanner2 .tab-btn li').eq(x).addClass('active');

				$('.innBanner2 > div').removeClass('active');

				$('.innBanner2 > div').eq(x).addClass('active');

				$('.innBanner2 > div').fadeOut(1000);

				$('.innBanner2 > div').eq(x).fadeIn(1000);

			}else{

				$('.innBanner2 .tab-btn li').removeClass('active');

				$('.innBanner2 .tab-btn li').eq(0).addClass('active');

				$('.innBanner2 > div').removeClass('active');

				$('.innBanner2 > div').eq(0).addClass('active');

				$('.innBanner2 > div').fadeOut(1000);

				$('.innBanner2 > div').eq(0).fadeIn(1000);

			}



		},5000);



		$('.innBanner2').hover(function(){

			clearInterval(timer21);

		},function(){

			timer21 =  setInterval(function(){



			var l = $('.innBanner2 > div').length;

			var i = $('.innBanner2 > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				$('.innBanner2 .tab-btn li').removeClass('active');

				$('.innBanner2 .tab-btn li').eq(x).addClass('active');

				$('.innBanner2 > div').removeClass('active');

				$('.innBanner2 > div').eq(x).addClass('active');

				$('.innBanner2 > div').fadeOut(1000);

				$('.innBanner2 > div').eq(x).fadeIn(1000);

			}else{

				$('.innBanner2 .tab-btn li').removeClass('active');

				$('.innBanner2 .tab-btn li').eq(0).addClass('active');

				$('.innBanner2 > div').removeClass('active');

				$('.innBanner2 > div').eq(0).addClass('active');

				$('.innBanner2 > div').fadeOut(1000);

				$('.innBanner2 > div').eq(0).fadeIn(1000);

			}

				

			},5000);

		});





	}else{



		var _inn2 = $('.slidebanner-container2 .innBanner2 > div').length;



		for(var i=0;i<_inn2;i++){

			$('.slidebanner-container2 .tab-btn-wap').append(_tabli);

		}

		$('.slidebanner-container2 .tab-btn-wap li').eq(0).addClass('active');

		$('.innBanner2').height($('.innBanner2 > .active').height());





		var imgWidth_2 =  $('.innBanner2').parent().width();

		var imgNum_2 = $('.innBanner2').children('div').length;

		var x_2 = 0;



		$('.slidebanner-container2 .tab-btn-wap li').eq(0).addClass('active');



		$('.innBanner2').children('div').width(imgWidth_2);

		$('.innBanner2').css('height','auto');

		$('.innBanner2').width(imgNum_2 * imgWidth_2);



		$(".innBanner2").on("swiperight",function(){



			if (x_2 == 0) {



				x_2 = (imgNum_2-1)*imgWidth_2;



				$(".innBanner2").animate({'right':x_2+'px'});

				$('.slidebanner-container2 .tab-btn-wap li').removeClass('active');

				$('.slidebanner-container2 .tab-btn-wap li').eq(x_2/imgWidth_2).addClass('active');



			}else{



				x_2 =  x_2 -imgWidth_2;

				$(".innBanner2").animate({'right':x_2+'px'});

				$('.slidebanner-container2 .tab-btn-wap li').removeClass('active');

				$('.slidebanner-container2 .tab-btn-wap li').eq(x_2/imgWidth_2).addClass('active');

			}



		});



		$(".innBanner2").on("swipeleft",function(){



			if (x_2 == (imgNum_2-1)*imgWidth_2) {



				x_2 = 0;

				$(".innBanner2").animate({'right':x_2+'px'});

				$('.slidebanner-container2 .tab-btn-wap li').removeClass('active');

				$('.slidebanner-container2 .tab-btn-wap li').eq(x_2/imgWidth_2).addClass('active');

			}else{



				x_2 += imgWidth_2;

				$(".innBanner2").animate({'right':x_2+'px'});

				$('.slidebanner-container2 .tab-btn-wap li').removeClass('active');

				$('.slidebanner-container2 .tab-btn-wap li').eq(x_2/imgWidth_2).addClass('active');

			}





		});





		$('.slidebanner-container2 .tab-btn-wap li').click(function(){

			$('.slidebanner-container2 .tab-btn-wap li').removeClass('active');

			$(this).addClass('active');

			var _index = $(this).index();

			x_2 = _index*imgWidth_2;



			$('.innBanner2 > div').removeClass('active');

			$('.innBanner2 > div').eq(_index).addClass('active');



			$(".innBanner2").animate({'right':x_2+'px'});

		});



		function innBanner2(){

			var l = $('.innBanner2 > div').length;

			var i = $('.innBanner2 > div.active').index();

			if (x_2 == (imgNum_2-1)*imgWidth_2) {

				x_2 = 0;

				$('.slidebanner-container2 .tab-btn-wap li').removeClass('active');

				$('.slidebanner-container2 .tab-btn-wap li').eq(x_2/imgWidth_2).addClass('active');

				$('.innBanner2 > div').removeClass('active');

				$('.innBanner2 > div').eq(x_2/imgWidth_2).addClass('active');

				$(".innBanner2").animate({'right':x_2+'px'});

			}else{

				x_2 += imgWidth_2;

				$('.slidebanner-container2 .tab-btn-wap li').removeClass('active');

				$('.slidebanner-container2 .tab-btn-wap li').eq(x_2/imgWidth_2).addClass('active');

				$('.innBanner2 > div').removeClass('active');

				$('.innBanner2 > div').eq(x_2/imgWidth_2).addClass('active');

				$(".innBanner2").animate({'right':x_2+'px'});

			}

		}



		timerInn2 =  setInterval(innBanner2,5000);



		$('.innBanner2').hover(function(){

			clearInterval(timerInn2);

		},function(){

			timerInn2 =  setInterval(innBanner2,5000);

		});





	}







	//乌镇历史轮播

	if (width>768) {



		var _history_length = $('.historyBanner > div').length;



		var _history_line = $('.history-line').width()/(_history_length - 1);

		for(i=0;i<$('.history-line > span').length;i++){

			$('.history-line > span').eq(i).css('left',_history_line*i + 'px');

		}

		if (width>1600) {

			$('.history-line > span:last').css('left','1370px');

		}else{

			$('.history-line > span:last').css('left','970px');

		}



		$('.historyBanner > div').hide();

		$('.historyBanner > div').eq(0).show();



		$('.history-line > .active-line').animate({'width':parseInt($('.history-line > .active').css('left')) + $('.history-line > .active').width()});

		

		for(var i=0;i<_history_length;i++){

			$('.historyBanner .tab-btn').append(_tabli);

		}

		$('.historyBanner .tab-btn li').eq(0).addClass('active');

		$(window).load(function(){

			$('.historyBanner').height($('.historyBanner > .active').height());

		});

		

		$('.historyBanner .tab-btn li').click(function(){

			$('.historyBanner .tab-btn li').removeClass('active');

			$(this).addClass('active');

			var _index = $(this).index();

			var _linew = parseInt($('.history-line > span').eq(_index).css('left'));

			var _linel = $('.history-line > span').eq(_index).width();

			$('.history-line > span').removeClass('active');

			$('.history-line > span').eq(_index).addClass('active');

			$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

			$('.historyBanner > div').removeClass('active');

			$('.historyBanner > div').eq(_index).addClass('active');

			$('.historyBanner > div').fadeOut(1000);

			$('.historyBanner > div').eq(_index).fadeIn(1000);

		});



		function historyAuto(){

			var l = $('.historyBanner > div').length;

			var i = $('.historyBanner > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				var _linew = parseInt($('.history-line > span').eq(x).css('left'));

				var _linel = $('.history-line > span').eq(x).width();

				$('.history-line > span').removeClass('active');

				$('.history-line > span').eq(x).addClass('active');

				$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

				$('.historyBanner .tab-btn li').removeClass('active');

				$('.historyBanner .tab-btn li').eq(x).addClass('active');

				$('.historyBanner > div').removeClass('active');

				$('.historyBanner > div').eq(x).addClass('active');

				$('.historyBanner > div').fadeOut(1000);

				$('.historyBanner > div').eq(x).fadeIn(1000);

			}else{

				var _linew = parseInt($('.history-line > span').eq(0).css('left'));

				var _linel = $('.history-line > span').eq(0).width();

				$('.history-line > span').removeClass('active');

				$('.history-line > span').eq(0).addClass('active');

				$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

				$('.historyBanner .tab-btn li').removeClass('active');

				$('.historyBanner .tab-btn li').eq(0).addClass('active');

				$('.historyBanner > div').removeClass('active');

				$('.historyBanner > div').eq(0).addClass('active');

				$('.historyBanner > div').fadeOut(1000);

				$('.historyBanner > div').eq(0).fadeIn(1000);

			}

		}



		$('.history-line > span').click(function(){

			$('.history-line > span').removeClass('active');

			$(this).addClass('active');

			var _index = $(this).index();

			var _linew = parseInt($('.history-line > span').eq(_index).css('left'));

			var _linel = $('.history-line > span').eq(_index).width();

			$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

			$('.historyBanner .tab-btn li').removeClass('active');

			$('.historyBanner .tab-btn li').eq(_index).addClass('active');

			$('.historyBanner > div').removeClass('active');

			$('.historyBanner > div').eq(_index).addClass('active');

			$('.historyBanner > div').fadeOut(1000);

			$('.historyBanner > div').eq(_index).fadeIn(1000);

		});



		$('.historyBanner .arrow-right').click(function(){

			var l = $('.historyBanner > div').length;

			var i = $('.historyBanner > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				var _linew = parseInt($('.history-line > span').eq(x).css('left'));

				var _linel = $('.history-line > span').eq(x).width();

				$('.history-line > span').removeClass('active');

				$('.history-line > span').eq(x).addClass('active');

				$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

				$('.historyBanner .tab-btn li').removeClass('active');

				$('.historyBanner .tab-btn li').eq(x).addClass('active');

				$('.historyBanner > div').removeClass('active');

				$('.historyBanner > div').eq(x).addClass('active');

				$('.historyBanner > div').fadeOut(1000);

				$('.historyBanner > div').eq(x).fadeIn(1000);

			}else{

				var _linew = parseInt($('.history-line > span').eq(0).css('left'));

				var _linel = $('.history-line > span').eq(0).width();

				$('.history-line > span').removeClass('active');

				$('.history-line > span').eq(0).addClass('active');

				$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

				$('.historyBanner .tab-btn li').removeClass('active');

				$('.historyBanner .tab-btn li').eq(0).addClass('active');

				$('.historyBanner > div').removeClass('active');

				$('.historyBanner > div').eq(0).addClass('active');

				$('.historyBanner > div').fadeOut(1000);

				$('.historyBanner > div').eq(0).fadeIn(1000);

			}

		});

		$('.historyBanner .arrow-left').click(function(){

			var l = $('.historyBanner > div').length;

			var i = $('.historyBanner > div.active').index();

			var x = i-1;

			if (x>=0) {

				var _linew = parseInt($('.history-line > span').eq(x).css('left'));

				var _linel = $('.history-line > span').eq(x).width();

				$('.history-line > span').removeClass('active');

				$('.history-line > span').eq(x).addClass('active');

				$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

				$('.historyBanner .tab-btn li').removeClass('active');

				$('.historyBanner .tab-btn li').eq(x).addClass('active');

				$('.historyBanner > div').removeClass('active');

				$('.historyBanner > div').eq(x).addClass('active');

				$('.historyBanner > div').fadeOut(1000);

				$('.historyBanner > div').eq(x).fadeIn(1000);

			}else{

				var _linew = parseInt($('.history-line > span').eq(l-1).css('left'));

				var _linel = $('.history-line > span').eq(l-1).width();

				$('.history-line > span').removeClass('active');

				$('.history-line > span').eq(l-1).addClass('active');

				$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

				$('.historyBanner .tab-btn li').removeClass('active');

				$('.historyBanner .tab-btn li').eq(l-1).addClass('active');

				$('.historyBanner > div').removeClass('active');

				$('.historyBanner > div').eq(l-1).addClass('active');

				$('.historyBanner > div').fadeOut(1000);

				$('.historyBanner > div').eq(l-1).fadeIn(1000);

			}

		});



		history_timer =  setInterval(function(){



			var l = $('.historyBanner > div').length;

			var i = $('.historyBanner > div.active').index();

			var x = i+1;

			if (x<=l-1) {

				var _linew = parseInt($('.history-line > span').eq(x).css('left'));

				var _linel = $('.history-line > span').eq(x).width();

				$('.history-line > span').removeClass('active');

				$('.history-line > span').eq(x).addClass('active');

				$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

				$('.historyBanner .tab-btn li').removeClass('active');

				$('.historyBanner .tab-btn li').eq(x).addClass('active');

				$('.historyBanner > div').removeClass('active');

				$('.historyBanner > div').eq(x).addClass('active');

				$('.historyBanner > div').fadeOut(1000);

				$('.historyBanner > div').eq(x).fadeIn(1000);

			}else{

				var _linew = parseInt($('.history-line > span').eq(0).css('left'));

				var _linel = $('.history-line > span').eq(0).width();

				$('.history-line > span').removeClass('active');

				$('.history-line > span').eq(0).addClass('active');

				$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

				$('.historyBanner .tab-btn li').removeClass('active');

				$('.historyBanner .tab-btn li').eq(0).addClass('active');

				$('.historyBanner > div').removeClass('active');

				$('.historyBanner > div').eq(0).addClass('active');

				$('.historyBanner > div').fadeOut(1000);

				$('.historyBanner > div').eq(0).fadeIn(1000);

			}



		},5000);

		

		$('.history-line').hover(function(){

			clearInterval(history_timer);

		},function(){

			history_timer =  setInterval(function(){



				var l = $('.historyBanner > div').length;

				var i = $('.historyBanner > div.active').index();

				var x = i+1;

				if (x<=l-1) {

					var _linew = parseInt($('.history-line > span').eq(x).css('left'));

					var _linel = $('.history-line > span').eq(x).width();

					$('.history-line > span').removeClass('active');

					$('.history-line > span').eq(x).addClass('active');

					$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

					$('.historyBanner .tab-btn li').removeClass('active');

					$('.historyBanner .tab-btn li').eq(x).addClass('active');

					$('.historyBanner > div').removeClass('active');

					$('.historyBanner > div').eq(x).addClass('active');

					$('.historyBanner > div').fadeOut(1000);

					$('.historyBanner > div').eq(x).fadeIn(1000);

				}else{

					var _linew = parseInt($('.history-line > span').eq(0).css('left'));

					var _linel = $('.history-line > span').eq(0).width();

					$('.history-line > span').removeClass('active');

					$('.history-line > span').eq(0).addClass('active');

					$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

					$('.historyBanner .tab-btn li').removeClass('active');

					$('.historyBanner .tab-btn li').eq(0).addClass('active');

					$('.historyBanner > div').removeClass('active');

					$('.historyBanner > div').eq(0).addClass('active');

					$('.historyBanner > div').fadeOut(1000);

					$('.historyBanner > div').eq(0).fadeIn(1000);

				}



			},5000);

		});



		$('.historyBanner').hover(function(){

			clearInterval(history_timer);

		},function(){

			history_timer =  setInterval(function(){



				var l = $('.historyBanner > div').length;

				var i = $('.historyBanner > div.active').index();

				var x = i+1;

				if (x<=l-1) {

					var _linew = parseInt($('.history-line > span').eq(x).css('left'));

					var _linel = $('.history-line > span').eq(x).width();

					$('.history-line > span').removeClass('active');

					$('.history-line > span').eq(x).addClass('active');

					$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

					$('.historyBanner .tab-btn li').removeClass('active');

					$('.historyBanner .tab-btn li').eq(x).addClass('active');

					$('.historyBanner > div').removeClass('active');

					$('.historyBanner > div').eq(x).addClass('active');

					$('.historyBanner > div').fadeOut(1000);

					$('.historyBanner > div').eq(x).fadeIn(1000);

				}else{

					var _linew = parseInt($('.history-line > span').eq(0).css('left'));

					var _linel = $('.history-line > span').eq(0).width();

					$('.history-line > span').removeClass('active');

					$('.history-line > span').eq(0).addClass('active');

					$('.history-line > .active-line').animate({'width':_linew + _linel},1000);

					$('.historyBanner .tab-btn li').removeClass('active');

					$('.historyBanner .tab-btn li').eq(0).addClass('active');

					$('.historyBanner > div').removeClass('active');

					$('.historyBanner > div').eq(0).addClass('active');

					$('.historyBanner > div').fadeOut(1000);

					$('.historyBanner > div').eq(0).fadeIn(1000);

				}



			},5000);

		});



	}else{



	}





});



