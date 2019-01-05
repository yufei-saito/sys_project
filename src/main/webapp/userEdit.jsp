<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>编辑用户</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
<!-- MAIN CSS -->
<link rel="stylesheet" href="assets/css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet" href="assets/css/demo.css">
<!-- GOOGLE FONTS -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
	rel="stylesheet">
<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="assets/img/favicon.png">
	
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.post({
			url : "GroupListAjax.action",
			success : function(data){
				$.each(data,function(i,n){
					$("#selectGroup").append("<option value='"+n.gid+"'>"+n.gname+"</option>");
				});
				$("#selectGroup option[value='${editUser.group.gid}']").prop("selected","selected");
			},
			dataType : "json"
			
		});
		
		$.post({
			url : "RoleListAjax.action",
			success : function(data){
				$.each(data,function(i,n){
					$("#rolebox").append("<input type='checkbox' value='"+n.rid+"' name='roles'/>"+n.rname);
				});
				var array = new Array();  
				<c:forEach items="${editUser.roles}" var="r">  
					array.push("${r.rid}");
				</c:forEach> 
				for(var i=0;i<array.length;i++){
					var s = document.getElementsByName("roles");
					for(var j=0;j<s.length;j++){
						if(s[j].value == array[i]){
							s[j].checked = true;
						}
					}
					
				}
			},
			dataType : "json"
			
		});
		

		
		
		
		
	});
</script>
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="main.jsp"><img src="assets/img/logo-dark.png"
					alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth">
						<i class="lnr lnr-arrow-left-circle"></i>
					</button>
				</div>
				<form class="navbar-form navbar-left"></form>

				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="lnr lnr-question-circle"></i>
								<span>帮助</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">关于本系统</a></li>
								<li><a href="#">关于作者</a></li>
								<li><a href="#">提交错误信息</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><span>${MyUser.nickname}</span> <i
								class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/userPassword.jsp"><i class="lnr lnr-cog"></i> <span>修改密码</span></a></li>
								<li><a href="${pageContext.request.contextPath}/UserExit.action"><i class="lnr lnr-exit"></i> <span>登出</span></a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
		<hr/>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<c:forEach items="${modules}" var="m">
							<li><a href="#${m.mid}" data-toggle="collapse"
								<c:if test="${m.mname eq'系统管理'}">class='active'</c:if>>
								<i class="lnr lnr-file-empty"></i> <span>${m.mname}</span> 
								<i class="icon-submenu lnr lnr-chevron-left"></i>
								</a>
								<div id="${m.mid}" 
									<c:choose >
									<c:when test="${m.mname eq'系统管理'}">
										class='collapse in'
									</c:when>
									<c:otherwise>	 
										class='collapse'
									</c:otherwise>
								</c:choose>
								>
									<ul class="nav">
										<c:forEach items="${m.sonModules}" var="s">
											<li><a
												href="${pageContext.request.contextPath}/${s.url}"
												<c:if test="${s.sname eq'用户管理'}">class='active'</c:if>>${s.sname}</a></li>
										</c:forEach>
									</ul>
								</div>
							</li>
						</c:forEach>
					</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="row">
					<div class="col-md-12">
						<form action="${pageContext.request.contextPath}/UserUpdate.action" method="post" class="form-inline">
							<input type="hidden" name="user.uid" value="${editUser.uid}">
							<table class="table table-bordered">
  									<tr>
  										<th><label for="exampleInputUname">用户名</label></th>
  										<td><input type="text" name="user.uname" value="${editUser.uname}" class="form-control"></td>
  										<th><label for="exampleInputNickname">昵称</label></th>
  										<td><input type="text" name="user.nickname" value="${editUser.nickname}" class="form-control"></td>
  									</tr>
  									<tr>
  										<th><label for="exampleInputPhone">电话</label></th>
  										<td><input type="text" name="user.phone" value="${editUser.phone}" class="form-control"></td>
  										<th><label for="exampleInputEmail">邮箱</label></th>
  										<td><input type="text" name="user.email" value="${editUser.email}" class="form-control"></td>
  									</tr>
  									<tr>
  										<th><label for="exampleInputGroup">部门</label></th>
  										<td>
	  										<select name="user.group.gid" id="selectGroup">	
	  											<option value=''>-请选择-</option>
	  										</select>
  										</td>
  										<th><label for="exampleInputGroup">角色</label></th>
  										<td>
	  										<div class="checkbox">
											  <label id="rolebox">
											  </label>
											</div>
			  							</td>
  									</tr>
  									<tr>
  										<th><label for="exampleInputGroup">备注</label></th>
  										<td>
  											<textarea name="user.utext">${editUser.utext}</textarea>
  										</td>
  										<td colspan="2" >
  											<button type="submit" class="btn btn-default btn-lg">修改</button>
  										</td>
  									</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>
		<footer>
			<div class="container-fluid">
				<p class="copyright">鱼非 &copy; 2018.</p>
			</div>
		</footer>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/scripts/klorofil-common.js"></script>
	
</body>
</html>