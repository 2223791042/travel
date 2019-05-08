$(document).ready(function(){

	var width = $(window).width();

	var height = $(window).height();



	//手机和平板尺寸下

	if (width<770) {



		//手机端滑动菜单

		$('nav').css({'left':width+'px','width':width-50+'px'});

		$('nav > div').css('min-height',height+'px');

		var i = 0;

		$('.phone-btn').click(function(){



			$('nav > div').css({'width':width-50+'px','left':width-50+'px'});

			$('header').css('position','absolute');

			if (i==0) {



				$('body').animate({'right':width-50+'px'},500);

				$("body").on("touchmove",function(event){
				event.preventDefault;
				}, false);

				$('#phone-mask').show();

				var _sw = $(document).scrollTop();

				$('#phone-mask div').css('top',_sw + 12 + 'px');

				$('nav').css('top',_sw +'px');

				$('nav').height(height);

				$('body').css({'overflow-y':'hidden'});

				$('nav').css({'overflow-y':'hidden'});

				$('#phone-mask').css('overflow-y','hidden');

				i=1;

			}else{

				$('body').animate({'right':'0px'});

				$('#phone-mask').hide();

				$('body').css('overflow-y','auto');

				$('body').css('overflow-x','hidden');

				$('html').css('overflow-x','hidden');

				$('nav').css('overflow-y','auto');

				$('header').css('position','fixed');

				$('nav > ul').show();

				$("body").off("touchmove");

				i=0;

			}

		});



		$('nav > ul > li > a').click(function(){

			$('nav > div').find('ul').remove();

			$('nav > div').append($(this).siblings('ul').clone());

			$('nav > div > div > span').text($(this).text());

			$('nav > ul').hide();

			$('nav > div').animate({'left':'0'});

			$('nav > div').height(height);

		});



		$('nav > div > div img').click(function(){

			$('nav > div').animate({'left':width-50+'px'});

			$('nav > ul').show();

		});



		$('#phone-mask').click(function(){

			$('body').animate({'right':'0px'},500);

			$('header').animate({'right':'0px'},500);

			$('#phone-mask').hide();

			$('body').css('overflow-y','auto');

			$('nav > ul').show();

			$('header').css('position','fixed');

			$("body").off("touchmove");

			i=0;

		});



		//手机端底部下拉菜单

		var _deg = 180;

		$('.footer .foot-nav > ul > li').click(function(){

			$(this).siblings().find('ul').slideUp();

			$(this).siblings().find('img').css('transform','rotate(0deg)');

			$(this).find('ul').slideToggle();

			$(this).find('img').css('transform','rotate(' + _deg + 'deg)');

			_deg += 180;

		});

	}

});