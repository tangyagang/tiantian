var num;
$(function(){
	$(".number3").click(function(){
		num=$(".number2").val();
		num++;
		$(".number2").val(num);
	})

	$(".number1").click(function(){
		num=$(".number2").val();
		if(num>1){
			num--;
		$(".number2").val(num);
		}
	})

	var num1;
	$(".number2").focus(function(){
		num1=$(this).val();
	})

	$(".number2").blur(function(){
		num=$(this).val();
		var reg =/^\d+$/;
		if(reg.test($(this).val()) ==true){

		}else{
			alert("请输入0-9之间的数字");
			$(this).val(num1);
		}
	});
})
			
			
			
			
			
			
			
			
			
			
		/*$(function(){
			var reg =/^\d+$/;
			if(reg.test($(this).val()) ==true){
				$(".number3").click(function(){
					var num=$(".number2").val();
					num++;
					$(".number2").val(num);
				})
				$(".number1").click(function(){
					var num=$(".number2").val();
					if(num>1){
					num--;
					$(".number2").val(num);
					}
				})
			}else{
				alert("请输入0-9之间的数字");
			$(this).val(taocanNum);
			}
		})*/