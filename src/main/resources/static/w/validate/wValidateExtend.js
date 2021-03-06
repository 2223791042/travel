	jQuery.extend(jQuery.validator, {
		messages:{
	        required: "必输字段",
		  	remote: "请修正该字段",
	  		email: "请输入正确格式的电子邮件",
		  	url: "请输入合法的网址",
		  	date: "请输入合法的日期",
		  	dateISO: "请输入合法的日期 (ISO).",
		  	number: "请输入合法的数字",
		  	digits: "只能输入整数",
		  	creditcard: "请输入合法的信用卡号",
		  	equalTo: "请再次输入相同的值",
		  	accept: "请输入拥有合法后缀名的字符串",
		  	maxlength: jQuery.validator.format("请输入一个长度最多是 {0} 的字符串"),
		  	minlength: jQuery.validator.format("请输入一个长度最少是 {0} 的字符串"),
		  	rangelength: jQuery.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
		  	range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
		  	max: jQuery.validator.format("请输入一个最大为 {0} 的值"),
		  	min: jQuery.validator.format("请输入一个最小为 {0} 的值"),
		  	password: jQuery.validator.format("请输入一致的密码"),
		  	ip:"请输入有效的IP地址",
		  	chrnum:"只能输入数字、字母或者它们的组合",
		  	phone:"电话号码格式不对",
		  	mobile:"手机号码格式不对",
		  	zipcode:"邮政编码格式不对",
		  	idcardno:"请正确输入身份证号码",
		  	chcharacter:"请输入汉字",
		  	regstr:"请输入有效的数据",
		  	fck:"数据不能为空!",
		  	maxTo:"输入数据有误!",
		  	minTo:"输入数据有误!"
		}
	});
	
	jQuery.validator.addMethod("ip", function(value, element) {        
	    return this.optional(element) || (/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/.test(value) && (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256));        
	});
	
	// 增加只能是字母和数字的验证
	  jQuery.validator.addMethod("chrnum", function(value, element) {        
	    return this.optional(element) || (/^([a-zA-Z0-9]+)$/.test(value));        
	  });        
	    
	// 自定义验证规则——对电话号码进行验证
	$.validator.addMethod("phone",function(value, element){           
	   // "/\(?0\d{2,3}[)
		// -]?\d{7,8}/"匹配电话号码的格式多种：010-82839278、(010)82839278、01082839278等，但是，这样有一个问题
	   // 如：(01082839278这样的也会匹配。当然可以用分支条件"|"解决，比较麻烦。而且以什么开始或结束也没有匹配。
	   // 为了简单起见，去掉有"()"的形式。匹配区号3位，则本地号8位，区号4位，则本地号7位的号码。
	   var tel = /^0\d{2}[-]?\d{8}$|^0\d{3}[-]?\d{7}$/;        
	   return this.optional(element) || (tel.test(value));        
	   } );       
	  
	// 手机号码验证
	jQuery.validator.addMethod("mobile", function(value, element) {      
	  var length = value.length;      
	  // 长度为11，以13，15，18开头的
	  return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value));      
	});      
	    
	// 邮政编码验证
	jQuery.validator.addMethod("zipcode", function(value, element) {      
	  var tel = /^[0-9]{6}$/;      
	  return this.optional(element) || (tel.test(value));      
	});   
	/**
	 *比较验证最大
	 */
	jQuery.validator.addMethod("maxTo",function(value,element,param){
		
		var flag=false;
		var temp=parseInt($(param).val());
		if(temp==""){
			flag=true;
		}
		else{
		if(parseInt(value) >= temp)
			 flag=true;
		}
	    return flag;
	});
	/**
	 *比较验证最小
	 */
	jQuery.validator.addMethod("minTo",function(value,element,param){
		var flag=false;
		var temp=parseInt($(param).val());
		if(temp==""){
			flag=true;
		}
		else{
		if(parseInt(value)<= temp)
			 flag=true;
		}
	    return flag;
	});
	/* 追加自定义验证方法 */
	// 身份证号码验证
	jQuery.validator.addMethod("idcardno", function(value, element) {
	return this.optional(element) || isIdCardNo(value);
	});

	// 汉字
	jQuery.validator.addMethod("chcharacter", function(value, element) {
	var tel = /^[\u4e00-\u9fa5]+$/;
	return this.optional(element) || (tel.test(value));
	});
	//正则表达式验证
	jQuery.validator.addMethod("regstr",function(value,element,param){
	    return this.optional(element)||(param.test(value));
	});
	/**
	 * fck验证
	 */
	jQuery.validator.addMethod("fck",function(value,element,param){
		var flag=true;
		var oEditor = FCKeditorAPI.GetInstance($(element).attr("name"));   //获取名为content的FCK编辑器实例
		var content = oEditor.GetXHTML(); //获取编辑器内容
		$(element).val(content);
		if(param==true){
		    if(content == ""||content == "<br />"||content == "&nbsp;"){
				oEditor.SetHTML("");
	            oEditor.Focus();
	            flag=false;
	        }
		}
	    return flag;
	});
	
	/**
	 * 身份证号码验证
	 * 
	 */
	function isIdCardNo(num) {

	var factorArr = new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1);
	var parityBit=new Array("1","0","X","9","8","7","6","5","4","3","2");
	var varArray = new Array();
	var intValue;
	var lngProduct = 0;
	var intCheckDigit;
	var intStrLen = num.length;
	var idNumber = num;
	// initialize
	if ((intStrLen != 15) && (intStrLen != 18)) {
	return false;
	}
	// check and set value
	for(i=0;i<intStrLen;i++) {
	varArray[i] = idNumber.charAt(i);
	if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
	return false;
	} else if (i < 17) {
	varArray[i] = varArray[i] * factorArr[i];
	}
	}

	if (intStrLen == 18) {
	// check date
	var date8 = idNumber.substring(6,14);
	if (isDate8(date8) == false) {
	return false;
	}
	// calculate the sum of the products
	for(i=0;i<17;i++) {
	lngProduct = lngProduct + varArray[i];
	}
	// calculate the check digit
	intCheckDigit = parityBit[lngProduct % 11];
	// check last digit
	if (varArray[17] != intCheckDigit) {
	return false;
	}
	}
	else{        // length is 15
	// check date
	var date6 = idNumber.substring(6,12);
	if (isDate6(date6) == false) {

	return false;
	}
	}
	return true;

	}
	/**
	 * 判断是否为"YYYYMM"式的时期
	 * 
	 */
	function isDate6(sDate) {
	if(!/^[0-9]{6}$/.test(sDate)) {
	return false;
	}
	var year, month, day;
	year = sDate.substring(0, 4);
	month = sDate.substring(4, 6);
	if (year < 1700 || year > 2500) return false
	if (month < 1 || month > 12) return false
	return true
	}
	/**
	 * 判断是否为"YYYYMMDD"式的时期
	 * 
	 */
	function isDate8(sDate) {
	if(!/^[0-9]{8}$/.test(sDate)) {
	return false;
	}
	var year, month, day;
	year = sDate.substring(0, 4);
	month = sDate.substring(4, 6);
	day = sDate.substring(6, 8);
	var iaMonthDays = [31,28,31,30,31,30,31,31,30,31,30,31]
	if (year < 1700 || year > 2500) return false
	if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) iaMonthDays[1]=29;
	if (month < 1 || month > 12) return false
	if (day < 1 || day > iaMonthDays[month - 1]) return false
	return true
	}