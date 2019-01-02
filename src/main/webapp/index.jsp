<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.min.js"></script>
</head>
<body>
	<!-- contact-form -->
	<div class="message warning">
		<div class="inset">
			<div class="login-head">
				<h1>登陆</h1>

			</div>
			<form action="${pageContext.request.contextPath}/UserLogin.action" method="post" >
				<li><input type="text" name="uname" class="text" placeholder="用户名" >
					<a href="#" class=" icon user"></a>
				</li>
				<div class="clear"></div>
				<li><input type="password" name="upassword" placeholder="密码">
					<a href="#" class="icon lock"></a>
				</li>
				<div class="clear"></div>
				<div class="submit">
					<input type="submit"  value="登陆">
					<h4>
						${msg}
					</h4>
					<div class="clear"></div>
				</div>

			</form>
		</div>
	</div>
	<div class="clear"></div>
	<!--- footer --->
	<div class="footer">
		<p>鱼非 &copy; 2018.</p>
	</div>
</body>
</html>