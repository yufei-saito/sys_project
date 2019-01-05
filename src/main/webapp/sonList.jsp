<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>子模块管理</title>
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
												<c:if test="${s.sname eq'模块管理'}">class='active'</c:if>>${s.sname}</a></li>
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
								<div class="pull-left">
									<a href="${pageContext.request.contextPath}/SonModuleAddUI.action?mid=${ModuleId}">
										<input class="btn btn-info btn-lg" type="button" value="添加">
									</a>
								</div>
							</div>
				</div>
				<hr/>
				<div class="row">
					<div class="col-md-12">
						<table class="table table-bordered">
							<tr>
								<td>序号</td>
								<td>子模块名</td>
								<td>URL</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${page.list}" var="s" varStatus="status">
								<tr>
									<td>${status.count}</td>
									<td>${s.sname}</td>
									<td>${s.url}</td>
									<td>
										 <a class="btn btn-default" role="button" href="${pageContext.request.contextPath}/SonModuleEdit.action?sid=${s.sid}">编辑</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12" align="center">
						<nav aria-label="Page navigation">
						  <ul class="pagination pagination-lg">
						  	<li <c:if test="${page.pageNum ==1}">class="active"</c:if>>
						  		<a href="${pageContext.request.contextPath}/SonModuleList.action?mid=${ModuleId}&pageNum=1">
							  		首页
							  		<span class="sr-only">(current)</span>
						  		</a>
						  	</li>
						    <li <c:if test="${page.pageNum ==1}">class="disabled"</c:if>>
						    	<a href="${pageContext.request.contextPath}/SonModuleList.action?mid=${ModuleId}&pageNum=${page.pageNum -1}" aria-label="Previous">
						    		<span aria-hidden="true">&laquo;</span>
						    	</a>
						    </li>
						    <c:choose>
						    	<c:when test="${page.maxPage<=5}">
						    		<c:set var="begin" value="1"/>
           							<c:set var="end" value="${page.maxPage}"/>
						    	</c:when>
						    	<c:otherwise>
						    		<c:set var="begin" value="${page.pageNum -2}"/>
           							<c:set var="end" value="${page.pageNum +2}"/>
           							 <c:if test="${begin -2 <= 0}">
						                <c:set var="begin" value="1"/>
						                <c:set var="end" value="5"/>
						            </c:if>
						             <c:if test="${end +2 >= page.maxPage}">
						                <c:set var="begin" value="${page.maxPage -4}"/>
						                <c:set var="end" value="${page.maxPage}"/>
						            </c:if>
						    	</c:otherwise>
						    </c:choose>
						    
						    <c:forEach var="i" begin="${begin}" end="${end}">
						        <c:choose>
						            <c:when test="${i == page.pageNum}">
						                <li class="active"><a href="#">${i}</a></li>
						            </c:when>
						            <c:otherwise>
						                <li><a href="${pageContext.request.contextPath}/SonModuleList.action?mid=${ModuleId}&pageNum=${i}">${i}</a></li>
						            </c:otherwise>
						        </c:choose>
						    </c:forEach>
						    <li <c:if test="${page.pageNum == page.maxPage}">class="disabled"</c:if>>
						    	<a href="${pageContext.request.contextPath}/SonModuleList.action?mid=${ModuleId}&pageNum=${page.pageNum +1}" aria-label="Next">
						    		<span aria-hidden="true">&raquo;</span>
						    	</a>
						    </li>
						    <li <c:if test="${page.pageNum == page.maxPage}">class="active"</c:if>>
						    	<a href="${pageContext.request.contextPath}/SonModuleList.action?mid=${ModuleId}&pageNum=${page.maxPage}">
						    		尾页
						    		<span class="sr-only">(current)</span>
						   		</a>
						    </li>
						  </ul>  
						</nav>
					</div>
					<div align="center">
						<h4> 共${page.maxCount}条记录</h4>
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