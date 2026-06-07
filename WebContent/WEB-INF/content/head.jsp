<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="wrap">
		<div class="header">
       		<div class="logo"><a href="index"><img src="/SMRShop/images/logo.gif" alt="" title="" border="0" /></a></div>            
        <div id="menu">
          <ul>                                                                       
            <li class="selected"><a href="index">首页</a></li>
            <li><a href="book">图书</a></li>
            <li><a href="user_register">注册</a></li>
            <li><a href="index_about">关于我们</a></li>
            <li id="login"><s:if test="#session.loginUser==null"><a href="user_login">登录</a></s:if><s:else><a href="user">${sessionScope.loginUser.nickName}</a></s:else></li>
            </ul>
        </div>
	   </div>
</div>
