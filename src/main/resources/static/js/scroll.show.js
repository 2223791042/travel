
$(document).ready(function(){

	var _height = $(window).height();
	var _width = $(window).width();

	if (_width>770) {

		$('#page1').css({'opacity':'0'});
		$('#page2').css({'opacity':'0'});
		$('#page3').css({'opacity':'0'});
		$('#page1').animate({'top':'20'});
		$('#page2').animate({'top':'20'});
		$('#page3').animate({'top':'20'});

		function getS(_ele){
			var _scollTop = $(_ele).offset().top;

			return _scollTop;
		}

		function f1(){
			$('#page1').css({'opacity':'1','transition':'all 2s','position':'relative'});
			$('#page1').animate({'top':'0'},500);
			f1 = function(){}
		}
		function f2(){
			$('#page2').css({'opacity':'1','transition':'all 2s','position':'relative'});
			$('#page2').animate({'top':'0'},500);
			f2 = function(){}
		}
		function f3(){
			$('#page3').css({'opacity':'1','transition':'all 2s','position':'relative'});
			$('#page3').animate({'top':'0'},500);
			var path = document.querySelectorAll('path');
			// var path2 = getElementsByClassName('cls-2');
			// var path3 = getElementsByClassName('cls-3');

			for(var i =0;i<path.length;i++){
				var length = path[i].getTotalLength();
				path[i].style.transition = path[i].style.WebkitTransition =
				  'none';
				path[i].style.strokeDasharray = length + ' ' + length;
				path[i].style.strokeDashoffset = length;
				path[i].getBoundingClientRect();
				path[i].style.transition = path[i].style.WebkitTransition =
				  'stroke-dashoffset 2s linear';
				path[i].style.strokeDashoffset = '0';
			}

			// for(var i =0;i<path2.length;i++){
			// 	var length = path2[i].getTotalLength();
			// 	path2[i].style.transition = path2[i].style.WebkitTransition =
			// 	  'none';
			// 	path2[i].style.strokeDasharray = length + ' ' + length;
			// 	path2[i].style.strokeDashoffset = length;
			// 	path2[i].getBoundingClientRect();
			// 	path2[i].style.transition = path2[i].style.WebkitTransition =
			// 	  'stroke-dashoffset 2s linear';
			// 	path2[i].style.strokeDashoffset = '0';
			// }

			// for(var i =0;i<path3.length;i++){
			// 	var length = path3[i].getTotalLength();
			// 	path3[i].style.transition = path3[i].style.WebkitTransition =
			// 	  'none';
			// 	path3[i].style.strokeDasharray = length + ' ' + length;
			// 	path3[i].style.strokeDashoffset = length;
			// 	path3[i].getBoundingClientRect();
			// 	path3[i].style.transition = path3[i].style.WebkitTransition =
			// 	  'stroke-dashoffset 2s linear';
			// 	path3[i].style.strokeDashoffset = '0';
			// }

			f3 = function(){}
		}

		$(window).scroll(function(){
			if ($(window).scrollTop() > getS('#page1')-_height-100) {
				f1();
			}
			if ($(window).scrollTop() > getS('#page2')-_height-100) {
				f2();
			}
			if ($(window).scrollTop() > getS('#page3')-_height-100) {
				f3();
			}	
		});


	}


});
