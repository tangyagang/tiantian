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
			$(".qq").focus(function(){
				number1=$(this).val();
				})
			$(".qq").blur(function(){
				var number2=$(this).val();
				var re =/^\d+$/;
				if(re.test($(this).val())==true){
				}else{
					alert("请输入整数");
					$(this).val(number1);
				}
				})*/
			
		//删除
		$(".buy_delete").click(function () {
        var ck = $(".li_input:checked");
		
		if(ck.length == 0){
            alert("请选择,然后进行删除");
            return;
        }
        var allDel=confirm("确认删除!!");
        if(allDel){
            //获取商品ID数组
            var proIds = new Array();
            for(var i=0;i<($(".li_input").length);i++){
                if ($(".li_input:eq("+i+")").is(':checked')) {
                    var proId = $("input:hidden:eq("+i+")").val();
                    proIds.push(proId);
                }
            }
            publicDel(proIds);
            /* $.each(ck,function(){
                 $(this).parents("from[class='delete']").remove();
             })*/
        }
    })

	//下架
	$(".quanxuan").click(function () {
        var ck = $(".li_input:checked");
		if(ck.length == 0){
            alert("请选择,然后进行下架");
            return;
        }
        var allDel=confirm("确认下架!!");
        if(allDel){
            //获取商品ID数组
            var proIds = new Array();
            for(var i=0;i<($(".li_input").length);i++){
                if ($(".li_input:eq("+i+")").is(':checked')) {
                    var proId = $("input:hidden:eq("+i+")").val();
                    proIds.push(proId);
                }
            }
            lowerShelf(proIds);
            /*$.each(ck,function(){
                $(this).parents("div[class='yz-table-td-div']").css("background-color","#FF7700");
            })*/
        }
    })

	//上架
    $(".shangjiaa").click(function () {
        var ck = $(".li_input:checked");
        if(ck.length == 0){
            alert("请选择,然后进行上架");
            return;
        }
        //获取商品ID数组
        var proIds = new Array();
        for(var i=0;i<($(".li_input").length);i++){
            if ($(".li_input:eq("+i+")").is(':checked')) {
                var proId = $("input:hidden:eq("+i+")").val();
                proIds.push(proId);
            }
        }
        upperShelf(proIds);
        /*$.each(ck,function(){
            $(this).parents("div[class='yz-table-td-div']").removeAttr("background-color");
        })*/
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
//单独选中
/*function checkboxOnclick(checkbox){
    if ( checkbox.checked == true){
        $(this).attr("checked",true);
    }else{
        $(this).attr("checked",false);
    }
}*/

//上架
function upperShelf(proIds) {
    $.get(path+"/adminManager/upperShelf?proIds="+proIds,function (data) {
        if (data){
            window.location.href=path+"/adminManager/productList";
        } else {
            alert("未成功上架！");
        }
    });
}
//下架
function lowerShelf(proIds) {
    $.get(path+"/adminManager/lowerShelf?proIds="+proIds,function (data) {
        if (data){
            window.location.href=path+"/adminManager/productList";
        } else {
            alert("未成功下架！");
        }
    });
}
//删除
function publicDel(proIds) {
    $.get(path+"/adminManager/delProductByProIds?proIds="+proIds,function (data) {
        if (data){
            window.location.href=path+"/adminManager/productList";
        } else {
            alert("未删除成功！");
        }
    });
}








	