$(function(){
    $('.tab li').click(function(){
        var tabType = $(this).index();
            $('.tab li').each(function(index){
            	   $(this).css("color :#fff" ,
          		 "opacity : 0.5" );
            if(tabType != index){
                $(this).css("color :#fff" ,
                		 "opacity : 0.5" );
                
            }
        });
            $('.con_wrap>div').eq(tabType).show().siblings('div').hide();
    });
 });