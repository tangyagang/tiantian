// JavaScript Document$(function(){
//图片轮播；
$(function(){
    $(".leftNav>ul>li").mouseenter(function(){
        $(this).children(".zj").show(500);
    }).mouseleave(function(){
        $(this).children(".zj").hide(500);
    });

})


$(function(){
    //图片轮播；
    var index=0;
    $(".num>li").mouseover(function(){
        index=$(this).index();
        show(index);
        clearInterval(clearTime);

    })
    $(".num>li").mouseout(function(){
        index=$(this).index();
        clearTime=setInterval(addTime,1500);
    })
    $(".slide_box>li").mouseover(function(){
        index=$(this).index();
        show(index);
        clearInterval(clearTime);

    })
    $(".slide_box>li").mouseout(function(){
        index=$(this).index();
        clearTime=setInterval(addTime,1500);
    })
    function addTime(){
        if(index>2){
            index=0;
        }
        show(index);
        index++;
    }
    var clearTime=setInterval(addTime,1500);
    function show(index){
        $(".num>li:eq("+index+")").siblings().removeClass("active");
        $(".num>li:eq("+index+")").addClass("active");
        $(".slide_box>li:eq("+index+") ").fadeIn(500);
        $(".slide_box>li:eq("+index+") ").siblings().fadeOut(500);
    }
})
$(document).ready(function(){
    var top=0;
    function autoscroll(){
        top =top-1;
        //这里的25px是#express的高度
        $("#express>li:first").animate({"marginTop":top+"px"},1,function(){
            var $first=$(this);
            if((-top)>$first.height()){
                $first.css({"margin-top":0}).appendTo($("#express"));
                top=0;
            }
        })/*$first.css("margin-top","0px")这里也许会有人搞不明白，为什么又设为0。因为在ul向上移的时候，其第一个li会添加到ul的末尾，如果ul的margin-top不设
		      为0的话，整个ul就会慢慢移出它的父盒子，最后使得它的父盒子变空，实现不了原本想要实现的效果。*/
    }
    var clearTime=setInterval(autoscroll,50);
    $("#express>li").mouseover(function(){
        clearInterval(clearTime);
    })
    $("#express>li").mouseout(function(){
        clearTime=setInterval(autoscroll,50);
    })
    /*function autoscroll(){
        var marginTop = 0;
        marginTop=marginTop-1;
        $("#express>li:first").animate(
        //alert($("#express").children("li").first().marginTop());
            {"margin-top":marginTop+"px"},0,function(){
                var $first=$(this);
                if(!$first.is(":animated")){
                    if((-marginTop)>first.height()){
                        alert($first.html());
                        $first.css({"margin-top":0}).appendTo($("#express"));
                        marginTop=0;
                    }
                }
            }
        )
    }*/
})