<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>神秘人商城</title>
<link rel="stylesheet" type="text/css" href="/SMRShop/css/style.css"/>
</head>
<body>
<jsp:include page="head.jsp"/>
<div id="wrap">
	<div class="center_content">
  <div id="find">
    <form action="book_search" method="post" name="search">
	   <label>图书搜索：</label>
       <input type="text" name="keyword" value="${requestScope.keyword}"/>
       <input type="submit" value="搜索" />
  	</form>
  </div>
       	<div class="left_content">
        	<div class="crumb_nav">
            <a href="index">首页</a> &gt;&gt; 书籍名称
            </div>
            	${requestScope.mess}
            <div class="title"><span class="title_icon"><img src="/SMRShop/images/bullet1.gif" alt="" title="" /></span>书籍分类</div>
           
           <div class="new_products">
           
           <s:iterator begin="#request.start" end="#request.end" value="#request.result" id="book">
                    <div class="new_prod_box">
                        
                      <div class="new_prod_bg">
                        <a href="book_detail?id=${book.id}" target="_blank"><img src="${book.image}" alt="${book.name}" title="${book.name}" width="70" height="105" class="thumb" border="0" /></a>
                        </div>  
                        <a href="book_detail?id=${book.id}" target="_blank">${book.name}</a>
                        <div class="new_prod_price">¥ ${book.price}</div>         
                    </div>
           </s:iterator>
            <div class="pagination">
            <span class="disabled"></span>
            	<s:if test="#request.thisPage==1">
	            	上一页
	            </s:if>
	            <s:else>
	            	<a href="book_search?page=${requestScope.thisPage-1}">上一页</a>
	            </s:else>
	             ${requestScope.thisPage }/${requestScope.max}
				<s:if test="#request.thisPage==#request.max">
	            	下一页
	            </s:if>
	            <s:else>
	            	<a href="book_search?page=${requestScope.thisPage+1}">下一页</a>
	            </s:else>
            </div>  
            
            </div> 
          
            
        <div class="clear"></div>
        </div><!--end of left content-->
        
        <jsp:include page="right_content.jsp"/>
       <div class="clear"></div>
       </div><!--end of center content-->
       
</div>
</body>
</html>