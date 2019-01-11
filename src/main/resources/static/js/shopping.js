// JavaScript Document
$(function(){
	//商品购物清单；
	//var index;  //选中的下标；
	var num;  //单个商品数量；
	var money;  //单个商品总价；
    $(".J_btnAddCount").click(function(){
		var index=$(this).parents("li").index();
        num=parseInt($(".J_inputCount:eq("+index+")").val());
		//得到单个商品的总价格；
		money=$(".J_smallTotalPrice:eq("+index+")").html();
		money=Number(money.substring(1,money.length));  //单个商品的总价格；
		//单个商品的单价=总价/单个商品数量；
		var price=money*10/num/10;
		
		num++;                          //每单击一次数量加1；
		//单个商品总价=单价*数量；
		money=price*10*num/10;
        $(".J_inputCount:eq("+index+")").val(num);
        $(".J_smallTotalPrice:eq("+index+")").html("￥"+money);
		//判断是否选中
        if($(".li_input:eq("+index+")").is(':checked')) {
            $(".J_count:eq("+index+")").html("共"+num+"件商品");
            totalPrice();
        }

    });
	$(".J_btnDelCount").click(function(){
		var index=$(this).parents("li").index();
        num=parseInt($(".J_inputCount:eq("+index+")").val());
		if(num>1){
			//得到单个商品的总价格；
			money=$(".J_smallTotalPrice:eq("+index+")").html();
			money=Number(money.substring(1,money.length));  //单个商品的总价格；
			//单个商品的单价=总价/单个商品数量；
			var price=money*10/num/10;
			num--;
			//单个商品总价=单价*数量；
			money=price*10*num/10;
			$(".J_smallTotalPrice:eq("+index+")").html("￥"+money);
			$(".J_inputCount:eq("+index+")").val(num);
            //判断是否选中
            if($(".li_input:eq("+index+")").is(':checked')) {
                $(".J_count:eq("+index+")").html("共"+num+"件商品");
                totalPrice();
            }
		}else{
			del(index);
			var totalNum=totalPrice();
			if(totalNum==0){
				noshop();
			}
		}
	});
	//单击删除按钮；
	$(".close").click(function(){
		var index=$(".close").index(this);
		del(index);
		var totalNum=totalPrice();
		if(totalNum==0){
			noshop();
		}
	});
	var taocanNum;
	$(".J_inputCount").focus(function(){
		taocanNum=$(this).val();
	});
	//失去焦点计算总价和数量
	$(".J_inputCount").blur(function(){
		num = $(this).val();	
		var reg =/^\d+$/;
		if(reg.test($(this).val()) ==true){
			var index=$(this).parents("li").index();
			num ;
			//得到单个商品的总价格；
			money=$(".price:eq("+index+")").html();
			money=Number(money.substring(1,money.length));  //单个商品的总价格；
			var prices;
			prices=money*num*10000/10000;
			
			$(".J_smallTotalPrice:eq("+index+")").html("￥"+prices.toFixed(1));
			$(".J_inputCount:eq("+index+")").val(num);
			
		}else{
			alert("请输入0-9之间的数字");
			$(this).val(taocanNum);
		}
		totalPrice();
	})
	//单击结算结算按钮；
	$(".buy>a").click(function(){
		totalPrice();
	});
	//批量删除
	$(".buy_delete").click(function () {
        var ck = $(".li_input:checked[name='store']");
        if(ck.length == 0){
            alert("请选择,然后进行删除");
            return;
        }
        var allDel=confirm("确认删除!!");
        if(!allDel){
            return;
        }
        $(".li_input").each(function (index,element) {
            if (element.checked){
                $(element).parents("li").remove();
            }
        });
		totalPrice();
        noshop();
    })
});
//商品减到剩下一件时的删除操作；
function del(index){
    var del=confirm("确定要删除？");
    if(del==true){
        $(".shop>ul:first li:eq("+index+")").remove();
    }
}
//购物车无商品时，显示为空，购物清单隐藏；
function noshop(){
	var isExist = $(".last ul li").length;
	if (isExist == 0){
        $(".shop").hide();
        $(".noshop").show();
	}
}
//全部选中
function checkboxAllOnclick(checkbox){
    if ( checkbox.checked == true){
        $("input:checkbox").attr("checked",true);
    }else{
        $("input:checkbox").attr("checked",false);
    }
    totalPrice();
}
//单独选中
function checkboxOnclick(checkbox){
    if ( checkbox.checked == true){
        $(this).attr("checked",true);
    }else{
        $(this).attr("checked",false);
    }
    totalPrice();
}
//合计总价
function totalPrice(){
    var totalPrice=0;  //总价；
    var totalCount=0;  //总数
    for(var i=0;i<$(".J_smallTotalPrice").length;i++){
        if ($(".li_input:eq("+i+")").is(':checked')) {
            var price=$(".J_smallTotalPrice:eq("+i+")").html();  //价格；
            var count=$(".J_inputCount:eq("+i+")").val();    //数量；
            price=Number(price.substring(1,price.length));
            count=Number(count);
            totalPrice=totalPrice+price;
            totalCount=totalCount+count;
        }
    }
    $(".J_totalPrice").html("￥"+totalPrice.toFixed(1))	;
    $(".J_totalCount").html("("+totalCount+")");
    return totalCount;
}


