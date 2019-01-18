// JavaScript Document
/*数量*/
$(function(){
			var num1;
			$(".list-table-body-td23").focus(function(){
				num1=$(this).val();
				})	
			$(".list-table-body-td23").blur(function(){
				var num=$(this).val();
				var reg =/^\d+$/;
				if(reg.test($(this).val()) ==true){
					
				}else{
					alert("请输入0-9之间的数字");
					$(this).val(num1);
				}
			})
			var num2;
			$(".list-table-body-td2").focus(function(){
				num2=$(this).val();
				})	
			$(".list-table-body-td2").blur(function(){
				var num3=$(this).val();
				var reg =/^\d*\.{0,1}\d{0,1}$/;
				
				if(reg.test($(this).val()) ==true){
					
				}else{
					alert("请输入整数数字或者小数位1位的数字");
					$(this).val(num2);
				}
			})
			var num4;
			$(".list-table-body-td4").focus(function(){
				num4=$(this).val();
				})	
			$(".list-table-body-td4").blur(function(){
				var num5=$(this).val();
				var reg =/^\d*\.{0,1}\d{0,1}$/;
				
				if(reg.test($(this).val()) ==true){
					
				}else{
					alert("请输入整数数字或者小数位1位的数字");
					$(this).val(num4);
				}
			})
	})
	
	
	
	/*收款*/
	
	