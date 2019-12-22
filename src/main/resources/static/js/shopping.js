//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPath=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPath+projectName);
}
var path = getRootPath();

$(function(){
    //商品购物清单；
    //var index;  //选中的下标；
    var num;  //单个商品数量；
    var money;  //单个商品总价；
    $(".J_btnAddCount").click(function(){
        var index=$(this).parents("li").index();
        var buyCarId = $(".shop ul li input:hidden:eq("+index+")").val();
        num=parseInt($(".J_inputCount:eq("+index+")").val());
        //得到单个商品的单价格；
        money=$(".price:eq("+index+")").html();
        var price=Number(money.substring(1,money.length));  //单个商品的单价格；
        //单个商品的单价=总价/单个商品数量；
        //var price=money*10/num/10;
        num++;                          //每单击一次数量加1；
        //修改数量
        $.get(path+"/userManager/modifyNum","buyCarId="+buyCarId+"&num="+num,function (data) {

            if (data){
                //单个商品总价=单价*数量；
                money=price*1000*num/1000;
                $(".J_inputCount:eq("+index+")").val(num);
                $(".J_smallTotalPrice:eq("+index+")").html("￥"+money);
                //判断是否选中
                if($(".li_input:eq("+index+")").is(':checked')) {
                    $(".J_count:eq("+index+")").html("共"+num+"件商品");
                    totalPrice();
                }
            }else {
                $(".J_inputCount:eq("+index+")").val(1);
                alert("库存不足，请修改数量！");
            }
        });
    });
    $(".J_btnDelCount").click(function(){
        var index=$(this).parents("li").index();
        var buyCarId = $(".shop ul li input:hidden:eq("+index+")").val();
        num=parseInt($(".J_inputCount:eq("+index+")").val());
        if(num>1){
            //得到单个商品的单价格；
            money=$(".price:eq("+index+")").html();
            var price=Number(money.substring(1,money.length));  //单个商品的总价格；
            //单个商品的单价=总价/单个商品数量；
            //var price=money*10/num/10;
            num--;
            //修改数量
            $.get(path+"/userManager/modifyNum","buyCarId="+buyCarId+"&num="+num,function (data) {
                if (data){
                    //单个商品总价=单价*数量；
                    money=price*1000*num/1000;
                    $(".J_smallTotalPrice:eq("+index+")").html("￥"+money);
                    $(".J_inputCount:eq("+index+")").val(num);
                    //判断是否选中
                    if($(".li_input:eq("+index+")").is(':checked')) {
                        $(".J_count:eq("+index+")").html("共"+num+"件商品");
                        totalPrice();
                    }
                }else {
                    $(".J_inputCount:eq("+index+")").val(1);
                    alert("库存不足，请修改数量！");
                }
            });
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
            var buyCarId = $(".shop ul li input:hidden:eq("+index+")").val();
            num ;
            //修改数量
            $.get(path+"/userManager/modifyNum","buyCarId="+buyCarId+"&num="+num,function (data) {
                if (data){
                    var money=$(".price:eq("+index+")").html();
                    money=Number(money.substring(1,money.length));   //得到单个商品的单价；
                    var prices;
                    prices=money*num*10000/10000;//单个商品的总价

                    $(".J_smallTotalPrice:eq("+index+")").html("￥"+prices.toFixed(1));
                    $(".J_inputCount:eq("+index+")").val(num);
                } else {
                    $(".J_inputCount:eq("+index+")").val(1);
                    alert("库存不足，请修改数量！");
                }
            });
        }else{
            alert("请输入0-9之间的数字");
            $(this).val(taocanNum);
        }
        totalPrice();
    });
    //单击删除按钮；
    $(".buy>a:first").click(function(){
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
    });
    //立即结算
    $(".buy_count").click(function () {
        var buyCarIds = new Array();//存放购物车所有商品
        var totalPrice = $(".J_totalPrice").text();//总金额
        totalPrice = totalPrice.substr(1,totalPrice.length);
        if(parseInt(totalPrice)>0){
            $.get(path+"/userManager/checkPrice?totalPrice="+totalPrice,function (data) {
                if (data > 0){
                    //余额够买商品
                    for(var i=0;i<$(".J_smallTotalPrice").length;i++){
                        if ($(".li_input:eq("+i+")").is(':checked')) {
                            var buyCarId = $(".shop ul li input:hidden:eq("+i+")").val();
                            buyCarIds.push(buyCarId);
                        }
                    }
                    if (buyCarIds.length > 0){
                        $.getJSON(path+"/userManager/doSent?buyCarIds="+buyCarIds,"totalPrice="+totalPrice,function (data) {
                            if (data == 7){
                                window.location.href = path + "/userManager/userOrder";
                            }else {
                                alert("订单生成失败！");
                            }
                        });
                    }
                } else {
                    alert("余额不足，请充值！");
                }
            })
        }


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




