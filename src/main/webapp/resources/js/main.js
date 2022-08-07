$('.si').on('click', function(){
       var categoryId = $(this).attr('value')
       console.log(categoryId)
       $(".si").each(function(index, el){
          $(el).removeClass("active")
          $(".menuItem_ul").empty                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ()
       })
       $(this).addClass("active")
       if($(this).hasClass("active") == true){
         $.ajax({
             url: "requestObject",
             type: "POST",
             contentType: "application/json; charset=euc-kr",
             dataType: "text",
             data: JSON.stringify({
          'categoryId': categoryId
          }),
            success: function(data){
             var html = ""
          $.each(JSON.parse(data), function(index, el){
             html = "<li class='menuItem'><a class='modal-btn' data-toggle='modal' data-target='#exampleModal' >"
             html += "<img src=/java-cafe/resources/menuImg/" + el.image.imgName + ">"
             html += "<p class='menu_text'>" + el.menuName + "<br>" + el.menuPrice + "원</p></a><li>"
             $(".menuItem_ul").append(html)
          })   
           },
           error: function(){
               alert("simpleWithObject err");
           }
       });         
 }
});
   
   $(document).on('click', '.modal-btn', function() {
	   console.log($(this))
	   let imgName = $(this).find('img').attr('src').split('/')[4]
	   console.log(imgName)
	   $(".modal-body").empty();
	   $.ajax({
	               url: "requestForModal",
	               type: "POST",
	               contentType: "application/json; charset=utf-8",
	               dataType: "text",
	               data: JSON.stringify({
	            'imgName': imgName
	            }),
	              success: function(data){
	            
	               console.log(JSON.parse(data))
	               var data = JSON.parse(data)
	              var html = '<form name="form" class="modal-form"><img src=/java-cafe/resources/menuImg/' + data.image.imgName + '>'
	            html += '<input type="hidden" name="imgName" value="' + data.image.imgName + '">'
	            html += '<div class="text-area"><span class="menu_name">'+ data.menuName+'</span>'
	            html += '<input type="hidden" name="menuName" value="' + data.menuName + '">'
	            html += '<span class="menu_price">' + data.menuPrice + '원</span>'
	            html += '<input type="hidden" name="menuPrice" value="' + data.menuPrice + '">'
	            html += '<input type="number" class="numberInput" name="quantity" value="1" />'
	            html += '<div class="text-area_btngrp"><button class="cart_in" type="submit" formaction="main" formmethod="post">카트담기</button>'
	            $(".modal-body").append(html)
	            
	             },
	             error: function(){
	                 alert("simpleWithObject err");
	             }
	         });
	})
   window.onload = function(){
   var total = $(".total_price")
   var sum = 0
   $(".cart_menuPrice").each(function(index, el){
      let money = $(el).text().split("원")[0]
      console.log(money)
      sum += Number(money)
   })
   total.text(sum + "원")
   
};

 $('.remove').on("click", function(){
	let imgName = $(this).next().attr("src").split("/")[4]
	console.log(imgName)
	 $(this).parents(".cart_content").remove();
	 var total = $(".total_price")
   var sum = 0
   	$(".cart_menuPrice").each(function(index, el){
      let money = $(el).text().split("원")[0]
      console.log(money)
      sum += Number(money)
   })
   total.text(sum + "원")
   $.ajax({
            url: "requestDelete",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            dataType: "text",
            data: JSON.stringify({
         'imgName': imgName
         }),
           success: function(data){
            console.log(JSON.parse(data))
          },
          error: function(){
              alert("simpleWithObject err");
          }
    });
   $(this).parents(".cart_content").remove()
   
})
 

 