// JavaScript Document
$(function(){
		var num;
			$("#qw").focus(function(){
				num=$(this).val();
				})	
			$("#qw").blur(function(){
				var num1=$(this).val();
				var reg =/^\d*\.{0,1}\d{0,1}$/;
				if(reg.test($(this).val()) ==true){
					
				}else{
					alert("请输入整数数字或者小数位1位的数字");
					$(this).val(num);
				}
			})
			var number;
			$("#qq").focus(function(){
				number=$(this).val();
				})
			$("#qq").blur(function(){
				var number1=$(this).val();
				var re =/^\d+$/;
				if(re.test($(this).val())==true){
				}else{
					alert("请输入整数");
					$(this).val(number);
				}
				})
	})