<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>神秘人商城 - 我的订单</title>
<link rel="stylesheet" type="text/css" href="/SMRShop/css/style.css"/>
</head>
<body>
<div id="wrap">
       <div class="center_content">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="/SMRShop/images/bullet1.gif" alt="" title="" /></span>我的购物车</div>
        
        	<div class="feat_prod_box_details">
            
            <table class="cart_table">
            	<tr class="cart_title">
                	<td>商品图片</td>
                	<td>书籍名称</td>
                    <td>单价</td>         
                    <td>操作</td> 
                </tr>
                
                <s:iterator value="#request.cart" id="book">
            	<tr>
                	<td><a href="book_detail?id=${book.id}"><img src="/SMRShop/images/cart_thumb.gif" alt="${book.name}" title="${book.name}" border="0" class="cart_thumb" width="60" height="84" /></a></td>
                	<td><a href="book_detail?id=${book.id}">${book.name}</a></td>
                    <td>${book.price}</td>  
                    <td><a href="user_cart_remove?b_id=${book.id}">删除</a></td>        
                </tr>           
                </s:iterator>
                
                <tr>
                <td colspan="4" class="cart_total"><span class="red">合计:</span></td>
                <td>¥ ${sum}</td>                
                </tr>                  
            
            </table>
            <a href="user_cart_sub" class="checkout">结账 &gt;</a>
            

             
            
            </div>	

        <div class="clear"></div>
        </div><!--end of left content-->
        
       <div class="clear"></div>
       </div><!--end of center content-->

</div>

</body>
</html>