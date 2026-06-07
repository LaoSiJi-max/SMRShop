<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="/SMRShop/lib/html5.js"></script>
<script type="text/javascript" src="/SMRShop/lib/respond.min.js"></script>
<script type="text/javascript" src="/SMRShop/lib/PIE_IE678.js"></script>
<![endif]-->
<link href="/SMRShop/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/SMRShop/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="/SMRShop/css/style.css" rel="stylesheet" type="text/css" />
<link href="/SMRShop/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="/SMRShop/http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>神秘人商城 - 后台登录</title>
<meta name="keywords" content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<s:if test="#request.mess!=null"><script type="text/javascript">alert('${requestScope.mess}')</script></s:if>
<input type="hidden" id="TenantId" name="TenantId" value="" />

<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="admin_login_sub" method="post">
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-8">
          <input id="" name="admin.logName" type="text" placeholder="登录名" class="input-text size-L" pattern="[a-zA-Z0-9]+$" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-8">
          <input id="" name="admin.pwd" type="password" placeholder="密码" class="input-text size-L" pattern="[a-zA-Z0-9!@#$%^&*]+$" required>
        </div>
      </div>
      <div class="row cl">
        
      </div>
      <div class="row"></div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript" src="/SMRShop/js/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/SMRShop/js/H-ui.js"></script> 
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>