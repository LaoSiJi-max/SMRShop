<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="/SMRShop/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/SMRShop/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="/SMRShop/css/style.css" rel="stylesheet" type="text/css" />
<title>商品信息</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 商品管理 <span class="c-gray en">&gt;</span> 商品信息 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="text-c"></div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="r">共有数据：<strong>${requestScope.count}</strong> 条</span> 
	<form action="adBook" method="post" name="bookSearch">
		<select name="cond">
	  <option value="id">ID</option>
	  <option value="name">书名</option>
	  <option value="author">作者</option>
	  <option value="publisher">出版社</option>
	</select> 
      <label for="textfield"></label>
	    <input type="text" name="keyword" id="textfield">
      <input type="submit" name="button" id="button" value="搜索">
	</form></div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="80">ID</th>
					<th width="150">书名</th>
					<th width="100">作者</th>
					<th width="150">出版社</th>
                    <th width="100">价格</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="#request.result" id="book">
				<tr class="text-c">
					<td>${book.id}</td>
					<td>${book.name}</td>
					<td class="text-c">${book.author}</td>
					<td>${book.publisher}</td>
                    <td>${book.price}</td>
					<td class="td-manage"><a href="adBook_createOrUpdate?id=${book.id}">修改</a> <a href="adBook_delete?id=${book.id}">删除</a></td>
			</s:iterator>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>