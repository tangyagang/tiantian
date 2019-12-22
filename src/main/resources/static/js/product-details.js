var num;//数量
var stock;//库存
$(function(){
	//数量加
	$(".number3").click(function(){
		stock = $(".number-n2-no").html();
		num=$(".number2").val();
		if (num < Number(stock)){
            num++;
            $(".number2").val(num);
		}else {
            alert("库存不够请修改数量！");
		}
	});
	//数量减
	$(".number1").click(function(){
		num=$(".number2").val();
		if(num>1){
			num--;
		$(".number2").val(num);
		}
	})

	//直接输入数量
	var num1;
	$(".number2").focus(function(){
		num1=$(this).val();
	})

	$(".number2").blur(function(){
		num=$(this).val();
		var reg =/^\d+$/;
		if(reg.test($(this).val()) ==true){
            stock = $(".number-n2-no").html();
            if (num > Number(stock)){
                alert("库存不够请修改数量！");
                $(this).val(num1);
            }
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