<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>神秘人商城 - 商品详情</title>
<link rel="stylesheet" type="text/css" href="/SMRShop/css/style.css" />
	<link rel="stylesheet" href="/SMRShop/css/lightbox.css" type="text/css" media="screen" />
	
	<script src="/SMRShop/js/prototype.js" type="text/javascript"></script>
	<script src="/SMRShop/js/scriptaculous.js?load=effects" type="text/javascript"></script>
	<script src="/SMRShop/js/lightbox.js" type="text/javascript"></script>
    <script type="text/javascript" src="/SMRShop/js/java.js"></script>
</head>
<body>
<jsp:include page="head.jsp"/>
<div id="wrap">
       
       <div class="center_content">
       	<div class="left_content">
        	<div class="crumb_nav">
            <a href="index">首页</a> &gt;&gt;书籍名称</div>
            <div class="title"><span class="title_icon"><img src="/SMRShop/images/bullet1.gif" alt="" title="" /></span>${requestScope.book.name}</div>
        
        	<div class="feat_prod_box_details">
            
            	<div class="prod_img"><a href="book_detail?${requestScope.book.id}"><img src="${requestScope.book.image}" alt="" title="" border="0" width="75" height="" /></a>
                <br /><br />
                <a href="${requestScope.book.image}" rel="lightbox"><img src="/SMRShop/images/zoom.gif" alt="" title="" border="0" /></a>
                </div>
                
                <div class="prod_det_box">
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">详细信息</div>
                    <p class="details">作者：${requestScope.book.author}</br>出版社：${requestScope.book.publisher}</p>
                    <div class="price"><strong>价格</strong> <span class="red">￥ ${requestScope.book.price}</span></div>
                    <a href="user_cart_add?b_id=${requestScope.book.id}" target="_blank" class="more"><img src="/SMRShop/images/cart.gif" alt="加入购物车" title="加入购物车" border="0" />加入购物车</a>
                    <div class="clear"></div>
                    </div>
                    
                </div>  
                <div class="feat_prod_box_details"><p class="details">${requestScope.book.introduce}</p></div>  
            <div class="clear"></div>
            </div>	
		<jsp:include page="right_content.jsp"/>
            
        <div class="clear"></div>
        </div><!--end of left content-->
        
       <div class="clear"></div>
       </div><!--end of center content-->
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>