
var InterValObj2; //timer变量，控制时间
var count2 = 60; //间隔函数，1秒执行
var curCount2;//当前剩余秒数
function sendCode1(){
	var mobile2 = $("#mobile2").val();
	var checkCode = $("#checkCodep").val();
	if(null == mobile2 || '' == mobile2){
		alert('请输入手机号');
		return false;
	}
	if(null == checkCode || '' == checkCode || 'undefined' == checkCode || checkCode.length == 0){
		alert('请输入图形验证码上的文字');
		return false;
	}
	$.ajax({
		type : "POST",
		url : "www.user.ewuzhen.com/sendCheckCode.htm",
		//url : "www.ewuzhen.com/sendCheckCode.htm",
		async : false,
		data:	{"loginName":mobile2,"checkCode":checkCode},
		dataType : "json",
		success : function(data) {
			if(data.flag == "success"){
				alert(data.messages[0]);
				curCount2 = count2;
				//设置button效果，开始计时
				$("#sendCodeBtn").removeAttr("onclick");
				$("#sendCodeBtn").val(curCount2 + "秒后可重新发送");
				InterValObj2 = window.setInterval(SetRemainTime2, 1000); //启动计时器，1秒执行一次
			}else{
				alert(data.messages[0]);
			}
		},
		error : function(x1,x2,x3){
			alert('x1:'+x1+'x2:'+x2+' x3:'+x3);
		}
	});
}

//timer处理函数
function SetRemainTime2() {
	if (curCount2 == 0) {                
		window.clearInterval(InterValObj2);//停止计时器
		$("#sendCodeBtn").attr("onclick","sendCode2();");//启用按钮
		$("#sendCodeBtn").val("重新发送验证码");
	}
	else {
		curCount2--;
		$("#sendCodeBtn").val(curCount2 + "秒后可重新发送");
	}
}
function sendCode2(){
	var mobile2 = $("#mobile2").val();
	var checkCode = $("#checkCode").val();
	if(null == mobile2 || '' == mobile2){
		alert('请输入手机号');
		return false;
	}
	if(null == checkCode || '' == checkCode || 'undefined' == checkCode || checkCode.length == 0){
		alert('请输入图形验证码上的文字');
		return false;
	}
	$.ajax({
		type : "POST",
		url : "${base}/sendCheckCode.htm",
		//url : "www.ewuzhen.com/sendCheckCode.htm",
		async : false,
		data:	{"loginName":mobile2,"checkCode":checkCode},
		dataType : "json",
		success : function(data) {
			if(data.flag == "success"){
				alert(data.messages[0]);
			  　	curCount2 = count2;
			　　//设置button效果，开始计时
			     $("#sendCodeBtn").removeAttr("onclick");
			     $("#sendCodeBtn").val(curCount2 + "秒后可重新发送");
			     InterValObj2 = window.setInterval(SetRemainTime2, 1000); //启动计时器，1秒执行一次
			}else{
				alert(data.messages[0]);
			}
		},
		error : function(x1,x2,x3){
			alert('x1:'+x1+'x2:'+x2+' x3:'+x3);
		}
	});
}

//timer处理函数
function SetRemainTime2() {
    if (curCount2 == 0) {                
        window.clearInterval(InterValObj2);//停止计时器
        $("#sendCodeBtn").attr("onclick","sendCode2();");//启用按钮
        $("#sendCodeBtn").val("重新发送验证码");
    }
    else {
        curCount2--;
        $("#sendCodeBtn").val(curCount2 + "秒后可重新发送");
    }
}
