// JavaScript Document
$(function(){
		/*var num;
			$("#qw1").focus(function(){
				num=$(this).val();
				})	
			$("#qw1").blur(function(){
				var num1=$(this).val();
				var reg =/^\d*\.{0,1}\d{0,1}$/;
				if(reg.test($(this).val()) ==true){
					
				}else{
					alert("请输入整数数字或者小数位1位的数字");
					$(this).val(num);
				}
			})*/
			var number;
			
		
			$(".list-table-input").focus(function(){
				number=$(this).val();
				})
			$(".list-table-input").blur(function(){
				var number1=$(this).val();
				var re =/^\d+$/;
				if(re.test($(this).val())==true){
				}else{
					alert("请输入整数");
					$(this).val(number);
				}
				})
					var num1;
			$(".qw").focus(function(){
				num1=$(this).val();
				})	
			$(".qw").blur(function(){
				var num2=$(this).val();
				var reg =/^\d*\.{0,1}\d{0,1}$/;
				if(reg.test($(this).val()) ==true){
					
				}else{
					alert("请输入整数数字或者小数位1位的数字");
					$(this).val(num1);
				}
			})
			/*var number1;
			$(".list-table-input").focus(function(){
				number1=$(this).val();
				})
			$(".list-table-input").blur(function(){
				var number2=$(this).val();
				var re =/^\d+$/;
				if(re.test($(this).val())==true){
				}else{
					alert("请输入整数");
					$(this).val(number1);
				}
				})*/
					
					$(".list-table2-body-td").click(function(){
						var index=$(".list-table2-body-td").index(this);
					del(index);

					})
					
			//按钮下架
			$(".shangjia").click(function () {
				//var index=$(this).parents(".yz-table2-td-div-box").index();
				$(this).parents(".yz-table2-td-div-box").children(".yz-table-td-div").css("background-color","#78C0F5");
			
				})
		//按钮删除
		$(".shanchu").click(function () {
				//var index=$(this).parents(".yz-table2-td-div-box").index();
				$(this).parents(".yz-table2-td-div-box").remove();;
			
				})
		
		//全选删除		
		$(".buy_delete").click(function () {
        var ck = $(".li_input:checked");
		alert(ck.length);
		if(ck.length == 0){
            alert("请选择,然后进行删除");
            return;
        }
        var allDel=confirm("确认删除!!");
        if(!allDel){
            return;
        }
		
        $.each(ck,function(){
			$(this).parents("div[class='yz-table2-td-div-box']").remove();
		})
		
    })
	
	//全选上架
	$(".shangjiaa").click(function () {
        var ck = $(".li_input:checked");
		alert(ck.length);
		if(ck.length == 0){
            alert("请选择,然后进行删除");
            return;
        }
        var allDel=confirm("确认删除!!");
        if(!allDel){
            return;
        }
		
        $.each(ck,function(){
			$(this).parents("div[class='yz-table-td-div']").css("background-color","#78C0F5");
		})
		
    })
	
	
	
	
	
	
	//全选下架
	$(".quanxuan").click(function () {
        var ck = $(".li_input:checked");
		alert(ck.length);
		if(ck.length == 0){
            alert("请选择,然后进行下架");
            return;
        }
        var allDel=confirm("确认下架!!");
        if(!allDel){
            return;
        }
		
        $.each(ck,function(){
			$(this).parents("div[class='yz-table-td-div']").css("background-color","#FF7700");
		})
		
    })
			
				
})
//全选
	function checkboxAllOnclick(checkbox){
    if ( checkbox.checked == true){
        $("input:checkbox").attr("checked",true);
    }else{
        $("input:checkbox").attr("checked",false);
    }
}