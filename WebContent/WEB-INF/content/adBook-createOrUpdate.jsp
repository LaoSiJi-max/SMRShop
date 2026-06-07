<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="/SMRShop/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/SMRShop/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<title>商品发布</title>
</head>
<body>
<div class="pd-20">
	<form action="adBook_createOrUpdate_sub" method="post" class="form form-horizontal" id="form-article-add">
	<input name="book.id" type="hidden" value="${requestScope.book.id}">
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>书名：</label>
			<div class="formControls col-10">
				<input type="text" class="input-text" value="${requestScope.book.name}" placeholder="" id="" name="book.name" required>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2">作者：</label>
			<div class="formControls col-10">
				<input type="text" class="input-text" value="${requestScope.book.author}" placeholder="" id="" name="book.author" required>
			</div>
		</div>
		<div class="row cl">
		  <label class="form-label col-2">出版社：</label>
			<div class="formControls col-10">
				<input type="text" name="book.publisher" id="" placeholder="" value="${requestScope.book.publisher}" class="input-text" required>
			</div>
		</div>
		<div class="row cl">
		  <label class="form-label col-2">价格：</label>
			<div class="formControls col-4">
				<input type="text" name="book.price" id="" placeholder="" value="${requestScope.book.price}" class="input-text" style="width:90%" required>
				元</div>
		</div>
	  <div class="row cl">
	    <label class="form-label col-2">详细介绍：</label>
			<div class="formControls col-10">
			  <textarea name="book.introduce" cols="50" rows="4" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="textarealength(this,200)">${requestScope.book.introduce}</textarea>
				<p class="textarea-numberbar"><em class="textarea-length"></em></p>
			</div>
	  </div>
	  <div class="row cl">
	    <label class="form-label col-2">图片上传：</label>
			<div class="formControls col-10">
				<div class="uploader-list-container">
					<div class="queueList">
						<div id="dndArea" class="placeholder">
							<div id="filePicker-2"></div>
						</div>
					</div>
					<div class="statusBar" style="display:none;">
						</div>
						<div class="info"></div>
						<div class="btns">
							<div id="filePicker2"></div>
						</div>
					</div>
				</div>
			</div>
	  </div>
		
		<div class="row cl">
			<div class="col-10 col-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
</div>
</body>
</html>