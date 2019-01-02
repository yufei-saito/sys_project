<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>用户管理</title>
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
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="index.html"><img src="assets/img/logo-dark.png"
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
								<span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">Basic Use</a></li>
								<li><a href="#">Working With Data</a></li>
								<li><a href="#">Security</a></li>
								<li><a href="#">Troubleshooting</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><span>${user.nickname}</span> <i
								class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="lnr lnr-user"></i> <span>My
											Profile</span></a></li>
								<li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
								<li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
								<li><a href="#"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
							</ul></li>

					</ul>
				</div>
			</div>
		</nav>
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
						<form class="form-inline" method="post" action="">
							<div class="col-md-3">
								<div class="input-group input-group-lg">
									<span class="input-group-addon" id="sizing-addon1">用户名</span>
									<input type="text" class="form-control" name="uname" id="exampleInputName2"  aria-describedby="sizing-addon1">
								</div>
							</div>	
							<div class="col-md-3">
								<div class="input-group input-group-lg">
									<span class="input-group-addon" id="sizing-addon2">昵称</span>
									<input type="text"class="form-control" name="nickname" id="exampleInputNickname2" id="sizing-addon2">
								</div>
							</div>	
							<div class="col-md-3">
								<div class="input-group input-group-lg">
									<span class="input-group-addon" id="sizing-addon3">部门</span>
									<select class="form-control" name="group.gid" id="selectGroup" id="sizing-addon3">
										<option value="">-请选择-</option>
									</select>
								</div>
								<div class="pull-right">
									<button type="submit" class="btn btn-default btn-lg">查询</button>
								</div>
							</div>
							<div class="col-md-3">		
								<div class="pull-right">
									<button class="btn btn-primary btn-lg">添加</button>
								</div>
							</div>
						</form>
				</div>
				<hr/>
				<div class="row">
					<div class="col-md-12">
						<table class="table table-bordered">
							<tr>
								<td>序号</td>
								<td>用户名</td>
								<td>昵称</td>
								<td>电话</td>
								<td>邮箱</td>
								<td>部门</td>
								<td>状态</td>
								<td>备注</td>
							</tr>
							<c:forEach items="${list}" var="u" varStatus="status">
								<tr>
									<td>${status.count}</td>
									<td>${u.uname}</td>
									<td>${u.nickname}</td>
									<td>${u.phone}</td>
									<td>${u.email}</td>
									<td>${u.group.gname}</td>
									<td>${u.ustatus}</td>
									<td>${u.utext}</td>
								</tr>
							</c:forEach>
						</table>
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