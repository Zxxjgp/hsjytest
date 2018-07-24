$(function(){
	gotonotice();
	/**判断banner图*/
	if(bannerBgurl ==null || bannerBgurl ==''){
		$(".head").attr('style', 'background-image: url('+path+'/static/images/no_banner.jpg)');
	}else{
		$(".head").attr('style', 'background-image: url('+path+'/uploadController/download/sysSeting/'+bannerBgurl+')');
	}
	
	$('.bigTitle1').on('click',function(){
		$('.bg-cl').show();
	})
	$('.bigTitle2').on('click',function(){
		$('.bg-cl').eq(0).show();
		$('.bg-cl').eq(0).nextAll().hide();
		$('.bg-lanse').eq(0).click();
	})
	$('.bigTitle3').on('click',function(){
		$('.bg-cl').eq(1).show();
		$('.bg-cl').eq(0).hide();
		$('.bg-cl').eq(1).nextAll().hide();
		$('.bg-lanse').eq(1).click();
	})
	$('.bigTitle4').on('click',function(){
		$('.bg-cl').eq(2).show();
		$('.bg-cl').eq(0).hide();
		$('.bg-cl').eq(1).hide();
		$('.bg-cl').eq(2).nextAll().hide();
		$('.bg-lanse').eq(2).click();
	})
	$('.bigTitle5').on('click',function(){
		$('.bg-cl').eq(3).show();
		$('.bg-cl').eq(0).hide();
		$('.bg-cl').eq(1).hide();
		$('.bg-cl').eq(2).hide();
		$('.bg-cl').eq(3).nextAll().hide();
		$('.bg-lanse').eq(3).click();
	})
	$('.bigTitle6').on('click',function(){
		$('.bg-cl').eq(4).show();
		$('.bg-cl').eq(0).hide();
		$('.bg-cl').eq(1).hide();
		$('.bg-cl').eq(2).hide();
		$('.bg-cl').eq(3).hide();
		$('.bg-cl').eq(4).nextAll().hide();
		$('.bg-lanse').eq(4).click();
	})
	$('.bigTitle7').on('click',function(){
		$('.bg-cl').eq(5).show();
		$('.bg-cl').eq(0).hide();
		$('.bg-cl').eq(1).hide();
		$('.bg-cl').eq(2).hide();
		$('.bg-cl').eq(3).hide();
		$('.bg-cl').eq(4).hide();
		$('.bg-cl').eq(5).nextAll().hide();
		$('.bg-lanse').eq(5).click();
	});
	
	
	//鼠标移入左侧显示效果
	$('.navbar-header').on('click',function(){
		var nh_width = $('#side-menu').width();
//		alert(nh_width)
		if(nh_width<70){
			$('.bg-cl').each(function(index,ele){
				$(ele).mouseover(function(){
					$(ele).children().eq(1).addClass('show_');
					$(ele).addClass('height50px');
					$('.slimScrollDiv>*').css('overflow','visible');
				})
				$(ele).mouseout(function(){
					$(ele).children().eq(1).removeClass('show_');
					$('.slimScrollDiv>*').css('overflow','hidden');
				})
			})
		}
		else{
			$('.bg-cl').each(function(index,ele){
				$(ele).mouseover(function(){
					$(ele).children().eq(1).removeClass('show_');
					$(ele).removeClass('height50px');
				})
				$(ele).mouseout(function(){
					$(ele).children().eq(1).removeClass('show_');
					$(ele).removeClass('height50px');
				})
			})
		}
	})
})
/**小铃铛跳转*/
function gotonotice(){
//	$("#warn").on('click',function(){
//		$("#uc").parent().parent().attr("href",path+"/userCenterController/gotoUserCenter?anchor=ms3");
//		$("#uc").click();
//		//$("#uc").parent().parent().attr("href",path+"/userCenterController/gotoUserCenter?anchor=ms1");
//	})
}
