<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>神秘人商城 - 用户登录</title>
<link rel="stylesheet" type="text/css" href="/SMRShop/css/style.css" />
</head>
<body>
<div id="wrap">

       <div class="center_content">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="/SMRShop/images/bullet1.gif" alt="" title="" /></span>用户登录</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">&nbsp;</p>
            
              	<div class="contact_form">
                <div class="form_subtitle">请输入您的登录名和密码</div>
                 <form name="login" action="user_login_sub" method="post">          
                    <div class="form_row">
                    <label class="contact"><strong>登录名:</strong></label>
                    <input name="user.logName" type="text" class="contact_input" pattern="[a-zA-Z0-9]+$" required/>
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>密码:</strong></label>
                    <input name="user.pwd" type="password" class="contact_input" pattern="[a-zA-Z0-9!@#$%^&*]+$" required/>
                    </div>                     
                  
                    <div class="form_row">
                    <input type="submit" class="register" value="登录" />
                    </div>   
                    ${requestScope.mess }
                  </form>     
                    
                </div>  
            
            </div>	
            
              

            

            
        <div class="clear"></div>
        </div><!--end of left content-->
      <div class="clear"></div>
       </div><!--end of center content-->
       
     

</div>

</body>
</html>