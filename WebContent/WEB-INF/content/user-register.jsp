<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>神秘人商城 - 用户注册</title>
<link rel="stylesheet" type="text/css" href="/SMRShop/css/style.css" />
</head>
<body>
<jsp:include page="head.jsp"/>
<div id="wrap">

      <div class="center_content">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="/SMRShop/images/bullet1.gif" alt="" title="" /></span>用户注册</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
             
            </p>
            
              	<div class="contact_form">
                <div class="form_subtitle">注册信息</div>
                 <form name="register" action="user_register_sub" method="post">          
                   <div class="form_row">
                    <label class="contact"><strong>登录名:</strong></label>
                    <input name="user.logName" type="text" class="contact_input" pattern="[a-zA-Z0-9]+$" required/>
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>密码:</strong></label>
                    <input name="user.pwd" type="password" class="contact_input" pattern="[a-zA-Z0-9!@#$%^&*]+$" required/>
                    </div> 

                    <div class="form_row">
                    <label class="contact"><strong>确认密码:</strong></label>
                    <input type="password" class="contact_input" pattern="[a-zA-Z0-9!@#$%^&*]+$" required/>
                    </div>


                    <div class="form_row">
                    <label class="contact"><strong>昵称:</strong></label>
                    <input name="user.nickName" type="text" class="contact_input" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>电话:</strong></label>
                    <input name="user.phoneNum" type="text" class="contact_input" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>邮箱:</strong></label>
                    <input name="user.email" type="text" class="contact_input" />
                    </div>                    
                    
                    <div class="form_row">
                    <input type="submit" class="register" value="注册" />
                    </div>   
                  </form>     
                </div>  
            
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