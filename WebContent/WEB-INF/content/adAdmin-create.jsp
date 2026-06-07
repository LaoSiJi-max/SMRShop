<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="/SMRShop/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/SMRShop/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>添加管理员</title>
</head>
<body>
<div class="pd-20">
	<form action="adAdmin_create_sub" method="post" class="form form-horizontal" id="form-admin-add">
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>管理员：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" id="user-name" name="admin.logName" pattern="[a-zA-Z0-9]+$" required>
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>密码：</label>
			<div class="formControls col-5">
				<input name="admin.pwd" type="password" value="" class="input-text" pattern="[a-zA-Z0-9!@#$%^&*]+$" required>
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
		  <label class="form-label col-3">等级：</label>
			<div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" name="admin.level" size="1">
					<option value="普通管理员">普通管理员</option>
					<option value="系统管理员">系统管理员</option>
					<option value="超级管理员">超级管理员</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<div class="col-9 col-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</div> 
</body>
</html>