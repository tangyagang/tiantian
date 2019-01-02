// JavaScript Document
$(function(){
	$(".tableBtn").click(function(){
		//验证手机号；
		var phone=document.getElementsByName("phone")[0];
		//alert($(phone).val())
		if(phone.validity.valueMissing==true){
			phone.setCustomValidity("手机号不能为空");
		}else if(phone.validity.patternMismatch==true){
			phone.setCustomValidity("手机格式不正确");
		}else{
			phone.setCustomValidity("");
		}
		//验证密码；
		var pwd=document.getElementsByName("password")[0];
		if(pwd.validity.valueMissing==true){
			pwd.setCustomValidity("密码不能为空");
		}else if(pwd.validity.patternMismatch==true){
			pwd.setCustomValidity("密码格式不正确");
		}else{
			pwd.setCustomValidity("");
		}
		//验证第二次输入的密码；
		var repwd=document.getElementsByName("rePassword")[0];
		if(repwd.validity.valueMissing==true){
			repwd.setCustomValidity("密码不能为空");
		}else if(repwd.validity.patternMismatch==true){
			repwd.setCustomValidity("密码格式不正确");
		}else if($(pwd).val()!=$(repwd).val()){
			repwd.setCustomValidity("两次输入的密码不一致");
		}else{
			repwd.setCustomValidity("");
		}
	})
	//验证码倒计时，从59S-0S；
	var sec=5;
	var myTime;
	$(".tableText").click(function(){
		if(sec>=5){
			myTime=setInterval(function(){
				if(sec>0){
					sec--;
					$(".tableText").html("（"+sec+"秒）重发");
				}else{
					sec=5;
					$(".tableText").html("获取验证码");
					clearTime();
				}
			},1000);
		}
	})
	function clearTime(){
		clearInterval(myTime);
	}
	
	
	




})