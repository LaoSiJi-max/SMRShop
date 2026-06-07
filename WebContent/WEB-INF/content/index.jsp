<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>神秘人商城</title>
<link rel="stylesheet" type="text/css" href="/SMRShop/css/style.css" />

</head>
<body>
<jsp:include page="head.jsp"/>
<div id="wrap">
  <div id="find">
    <form action="book_search" method="post" name="search">
	   <label>图书搜索：</label>
       <input type="text" name="keyword"/>
       <input type="submit" value="搜索" />
  	</form>
  </div>
  <div class="center_content">
       	<div class="left_content">
        	
            <div class="title"><span class="title_icon"><img src="/SMRShop/images/bullet1.gif" alt="" title="" /></span>特色书籍</div>
        
        	<s:iterator begin="1" end="5" value="#request.recBook" id="book">
        	<div class="feat_prod_box">
            
            	<div class="prod_img"><a href="book_detail?id=${book.id}" target="_blank"><img src="${book.image}" alt="${book.name}" title="${book.name}" width="75" height="105" border="0" /></a></div>
                
                <div class="prod_det_box">
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title" target="_blank"><a href="book_detail?id=${book.id}" target="_blank">${book.name}</a></div>
                    <p class="details">${book.introduce}</p>
                    <a href="book_detail?id=${book.id}" class="more" target="_blank">- 更多信息 -</a>
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>	
            </s:iterator>
            
            
           <div class="title"><span class="title_icon"><img src="/SMRShop/images/bullet2.gif" alt="" title="" /></span>最新书籍</div> 
           
           <div class="new_products">
           
           		<s:iterator begin="1" end="6" value="#request.newBook" id="book">
                    <div class="new_prod_box">
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/SMRShop/images/new_icon.gif" alt="" title="" /></span>
                        <a href="book_detail?id=${book.id}" target="_blank"><img src="${book.image}" alt="${book.name}" title="${book.name}"  width="60" height="84" class="thumb" border="0" /></a>
                        <a href="book_detail?id=${book.id}" target="_blank">${book.name}</a>
                        </div>           
                    </div>       
            	</s:iterator>
            </div> 
          
            
        <div class="clear"></div>
        </div><!--end of left content-->
       
       <jsp:include page="right_content.jsp"/>
       
       <div class="clear"></div>
       </div><!--end of center content--> 

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>