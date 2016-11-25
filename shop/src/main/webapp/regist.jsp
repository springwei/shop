<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会员注册</title>




<link href="<%=basePath%>/css/common.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>/css/register.css" rel="stylesheet"
	type="text/css" />
<script src="<%=basePath%>/jslib/jquery-1.7.2.min.js"
	type="text/javascript"></script>


<script type="text/javascript">
	var userflag = false;
	var passflag = false;
	var rpassflag = false;
	var emailflag = false;

	$(function() {
		$("#username").blur(function(e) {
			if ($("#username").val() == null || $("#username").val() == "") {
				$("#msg").text("用户名不能为空");
				userflag = true;
			} else {
				$.ajax({
					url : "user/checkuser",
					data : "username=" + $("#username").val(),
					type : 'post',
					success : function(msg) {
						if (msg.code == 500) {

							$("#msg").text(msg.msg);
							userflag = false;
						} else if (msg.code == 200) {

							$("#msg").text(msg.msg);
							userflag = true;
						}
					}
				});
			}
		});

		$("#password").blur(function(e) {

			if ($("#password").val() == null || $("#password").val() == "") {

				$("#passmsg").text("密码不能为空");
				passflag = false;

			} else {

				$("#passmsg").text("");
				passflag = true;
			}

		});

		$("#rpassword").blur(function(e) {

			if ($("#rpassword").val() == null || $("#rpassword").val() == "") {

				$("#rpassmsg").text("密码不能为空");
				rpassflag = false;

			} else if ($("#password").val() != $("#rpassword").val()) {

				$("#rpassmsg").text("两次输入的密码不一致");
				rpassflag = false;
			} else if ($("#password").val() == $("#rpassword").val()) {

				$("#rpassmsg").text("");
				rpassflag = true;
			}

		});

		$("#email")
				.blur(
						function(e) {

							var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

							if ($("#email").val() == null
									|| $("#email").val() == "") {

								$("#emailmsg").text("邮箱不能为空");
								emailflag = false;

							} else if (!filter.test($("#email").val())) {

								$("#emailmsg").text("邮箱格式不正确");
								emailflag = false;
							} else {

								$("#emailmsg").text("");
								emailflag = true;
							}

						});

		$("#button").click(function(e) {

			if (userflag && passflag && rpassflag && emailflag) {

				$("form").submit();
			}

		});

	});
</script>



</head>
<body>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="http://localhost:8080/mango/"> <img
					src="<%=basePath%>/image/r___________renleipic_01/logo.jpg"
					alt="商城">
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="<%=basePath%>/image/header.jpg" width="320" height="50"
					alt="正品保障" title="正品保障">
			</div>
		</div>
		<div class="span10 last">
			<div class="topNav clearfix">
				<ul>
					<c:if test="${session.frontuser==null}">
						<li id="headerLogin" class="headerLogin"
							style="display: list-item;"><a
							href="<%=basePath%>/user/login">登录</a>|</li>
						<li id="headerRegister" class="headerRegister"
							style="display: list-item;"><a
							href="<%=basePath%>/user/toregist">注册</a>|</li>
					</c:if>
					<c:if test="${session.frontuser!=null}">
						<li id="headerLogin" class="headerLogin"
							style="display: list-item;"><a href="javascript:void()">${session.frontuser}</a>|
						</li>

					</c:if>
					<li id="headerUsername" class="headerUsername"></li>
					<li id="headerLogout" class="headerLogout"><a
						href="./index.htm">[退出]</a>|</li>
					<li><a>会员中心</a> |</li>
					<li><a>购物指南</a> |</li>
					<li><a>关于我们</a></li>
				</ul>
			</div>
			<div class="cart">
				<a href="<%=basePath%>/car.jsp">购物车</a>
			</div>
			<div class="phone">
				客服热线: <strong>15726607618</strong>
			</div>
		</div>
		<div class="span24">
			<ul class="mainNav">
				<li><a href="<%=basePath%>/product/frontlist">首页</a> |</li>
				<li><a>男士休闲</a> |</li>
				<li><a>女士休闲</a> |</li>
				<li><a>商城积分</a> |</li>
				<li><a>儿童休闲</a> |</li>
				<li><a>老人休闲</a> |</li>
				<li><a>联系我们</a> |</li>

			</ul>
		</div>

	</div>
	<div class="container register">
		<div class="span24">
			<div class="wrap">
				<div class="main clearfix">
					<div class="title">
						<strong>会员注册</strong>USER REGISTER
					</div>
					<form id="registerForm" method="post" novalidate="novalidate"
						action="<%=basePath%>/user/regist">
						<table>
							${msg}
							<tbody>
								<tr>
									<th><span class="requiredField">*</span>用户名:</th>
									<td><input type="text" id="username" name="username"
										class="text" maxlength="20"> <span style="color: red"
										id="msg"></span></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>密&nbsp;&nbsp;码:</th>
									<td><input type="password" id="password" name="password"
										class="text" maxlength="20" autocomplete="off"> <span
										style="color: red" id="passmsg"></span></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>确认密码:</th>
									<td><input type="password" name="rePassword" class="text"
										maxlength="20" autocomplete="off" id="rpassword"> <span
										style="color: red" id="rpassmsg"></span></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>E-mail:</th>
									<td><input type="text" id="email" name="email"
										class="text" maxlength="200"> <span style="color: red"
										id="emailmsg"></span></td>
								</tr>
								<tr>
									<th>姓名:</th>
									<td><input type="text" name="realname" class="text"
										maxlength="200"></td>
								</tr>
								<tr>
									<th>电话:</th>
									<td><input type="text" name="phone" class="text"
										maxlength="200"></td>
								</tr>


								<tr>
									<th>地址:</th>
									<td><input type="text" name="addr" class="text"
										maxlength="200"></td>
								</tr>

								<tr>
									<th>&nbsp;</th>
									<td><input type="button" class="submit" value="注册"
										id="button"></td>
								</tr>


							</tbody>
						</table>
						<div class="login">
							<div class="ad">
								<dl>
									<dt>注册即享受</dt>
									<dd>正品保障、正规发票</dd>
									<dd>货到付款、会员服务</dd>
									<dd>自由退换、售后上门</dd>
								</dl>
							</div>
							<dl>
								<dt>已经拥有账号了？</dt>
								<dd>
									立即登录即可体验在线购物！ <a href="./login.jsp">立即登录</a>
								</dd>
							</dl>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="./image/footer.jpg" width="950" height="52" alt="我们的优势"
					title="我们的优势">
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a>关于我们</a> |</li>
				<li><a>联系我们</a> |</li>
				<li><a>招贤纳士</a> |</li>
				<li><a>法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>服务声明</a> |</li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
		</div>
	</div>
	<!-- <div id="_my97DP"
		style="position: absolute; top: -1970px; left: -1970px;">
		<iframe style="width: 190px; height: 191px;"
			src="./会员注册 - Powered By Mango Team_files/My97DatePicker.htm"
			frameborder="0" border="0" scrolling="no"></iframe>
	</div> -->
</body>
</html>