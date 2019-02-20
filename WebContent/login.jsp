<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<style>
</style>
</head>

<body>
	<div id="login_background">
		<div id="login">
			<div class="login_top">
				<div class="login_top_img"></div>
				<span>pokemon</span>
			</div>
			<div class="login_middle">
				<div class="login_middle_1">
					<div id="login_middle_right">
						<div id="login_middle_right_top">
							打开 <a href=""> pokenmon手机APP</a>
							<p>扫描二维码登陆</p>
						</div>
						<div id="login_middle_right_bottom" onmouseenter="changeToRight()"
							onmouseleave="changeToleft()">
							<img src="img/login/QQ图片20170920084103.png" />
						</div>
					</div>
					<div id="login_middle_left">
						<img src="img/login/QQ图片20170920084459.png" />
					</div>
				</div>
				<div class="login_middle_2">
					<div class="login_middle_2_top">其他方式登陆</div>
					<div class="login_middle_2_middle">
						<ul class="login_middle_2_ul">
							<li><a href="javascript:;" target="_blank"><img
									src="img/login/QQ.png" /></a></li>
							<li><a href="javascript:;" target="_blank "><img
									src="img/login/微信.png" /></a></li>
							<li><a href="javascript:; " target="_blank "><img
									src="img/login/新浪微博.png" /></a></li>
							<li><a href="javascript:;" target="_blank"><img
									src="img/login/百度.png" /></a></li>
						</ul>
						<ul class="login_middle_2_ul">
							<li><a href="javascript:;" target="_blank"><img
									src="img/login/腾讯微博.png" /></a></li>
							<li><a href="javascript:;" target="_blank"><img
									src="img/login/人人网.png" /> </a></li>
						</ul>
					</div>
					<div class="login_middle_2_bottom">
						<a href="javascript:;F" target="_blank">短信登陆</a>
					</div>
				</div>
				<div class="login_middle_3">
					<form>
						<div class="login_middle_3_top">
							<div class="login_middle_3_top_left">
								<select>
									<option selected="selected">中国大陆</option>
									<option>美国/加拉大</option>
									<option>德国</option>
									<option>法国</option>
								</select>
							</div>
							<div class="login_middle_3_top_right">
								<input class="login_middle_3_input" type="text" name="uname"
									oninput="mobileTest(this)" />
								<p>请输入手机号</p>
								<span style="color: red;"></span>
							</div>
						</div>
						<div id="login_middle_3_middle">
							<input type="password" class="login_middle_3_input"
								id="login_middle_3_password" name="password"
								oninput="passwordTest(this);submitColorChange(this)" />
							<p>请输入密码</p>
							<span style="color: red;"></span>
							<div id="login_middle_3_middle_change"></div>
							<div class="login_middle_3_forget">
								<a href="javascript:;">忘记密码</a>
								<div class="login_middle_3_hidden">
									<span>忘记密码了?</span><br /> <a href="javascript:;"
										target="_blank">找回密码</a><br /> <a href="javascript:;"
										target="_blank">短信登陆</a>
								</div>
							</div>
						</div>
						<div id="login_middle_3_bottom">
							<input class="submitbutton" type="button" id="tologin" value="登陆" />
						</div>
					</form>

				</div>
				<div class="login_middle_4">
					<form>
						<div class="login_middle_3_top">
							<div class="login_middle_3_top_left">
								<select>
									<option selected="selected">中国大陆</option>
									<option>美国/加拉大</option>
									<option>德国</option>
									<option>法国</option>
								</select>
							</div>
							<div class="login_middle_3_top_right">
								<input class="login_middle_3_input" type="text" name="uname"
									oninput="mobileRegister(this)" />
								<p>请输入手机号</p>
								<span style="color: red;"></span>
							</div>
						</div>
						<div class="login_middle_4_middle">
							<div class="login_middle_3_top_right">
								<input class="login_middle_3_input" type="password" name="password"
									oninput="passwordTest(this);submitColorChange(this)" />
								<p>请输入密码</p>
								<span style="color: red;"></span>
							</div>
						</div>
						<div class="login_middle_4_middle">
							<div class="login_middle_3_top_right">
								<input class="login_middle_3_input" type="text" name="nickName"
									oninput="nickNameTest(this)" />
								<p>请输入昵称</p>
								<span style="color: red;"></span>
							</div>
						</div>
						<div id="login_middle_4_bottom">
							<input class="submitbutton" type="button" id="toregister"
								value="注册" />
						</div>
					</form>
				</div>
			</div>
			<div class="login_bottom">
				<a href="javascript:;" id="login_zhuce">注册</a>
				<div id="login_bottom_char">
					<a id="login_zhanghao">账号密码登陆</a> <a id="login_saoma1">手机扫码登陆</a> <span>|</span>
					<a id="login_other" href="javascript:;">其他登陆</a> <a
						id="login_saoma2" href="javascript:;">手机扫码登陆</a>
				</div>
			</div>
		</div>
	</div>
	<!--  		<a href="javascript:;" id="login_start" onclick="openLogin()">登陆</a>  -->
	<!-- 		<a href="javascript:;" id="login_start" onclick="openZhuce()">注册</a> -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
	<script src="js/login.js"></script>
	<script type="text/javascript">
if("${empty user}"=="true"){
	openLogin();
}

/*
 * 正则部分
 */


//手机号
function mobileTest(dom) {
	var phone = $(dom).val().trim();
	if(phone == "") {
		$(dom).next().next().text("手机号不能为空");
		return false;
	}
	if(!/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/.test(phone)) {
		$(dom).next().next().text("请输入正确的手机号");
		return false;
	}
	$(dom).next().next().text("");
	return true;
}

//手机号注册
function mobileRegister(dom){
	if(mobileTest(dom)==1){
		//ajax对手机号进行判断，是否已经注册
		var phone=$(dom).val().trim();
		
		$.ajax({
			url : "<%=basePath%>/game?op=showUnames",
			//请求资源的路径
			type : "post",//请求方式
			dataType : "json",//请求的数据类型
		data : {"phone":phone},
		success:function(data){
			if(data.result==1){
				$(dom).next().next().text("该手机号可用");
			}else if(data.result==0){
				$(dom).next().next().text("该手机号已注册");
			}
			
		}
		})
		
		
	}
	
}

//密码
function passwordTest(dom) {
		var pwd = $(dom).val().trim();
		if(pwd == "") {
			$(dom).next().next().text("密码不能为空");
			return false;
		}
		if(!/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9a-zA-Z]{6,12}$/.test(pwd)) {
			$(dom).next().next().text("密码必须为6到12位的数字字母组合");
			return false;
		}
		$(dom).next().next().text("");
		return true;
}

//昵称
function nickNameTest(dom) {
		var nickName = $(dom).val().trim();
		if(nickName == "") {
			$(dom).next().next().text("昵称不能为空");
			return false;
		}
		if(!/^[\u4e00-\u9fa5a-zA-Z0-9_]{2,12}$/.test(nickName)) {
			$(dom).next().next().text("昵称为2-12位中文数字字母组合");
			return false;
		}
		$(dom).next().next().text("");
		return true;
}



$("#tologin").click(function(){
		if(mobileTest($(".login_middle_3 input[name='uname']").get(0))==1){
			if(passwordTest($(".login_middle_3 input[name='password']").get(0))==1){
				var uname=$(".login_middle_3 input[name='uname']").val();
				var password=$(".login_middle_3 input[name='password']").val();
						$.ajax({
							url : "<%=basePath%>/game?op=login",
							//请求资源的路径
							type : "get",//请求方式
							dataType : "json",//请求的数据类型
						data : {"uname":uname,"password":password},
						//请求的参数
							success : function(data) {//数据请求成功的回调函数
								if(data.code==1){
									location.href="<%=basePath%>/game?op=mypets"
													} else {
														$(
																".login_middle_3 input[name='password']")
																.next()
																.next()
																.text(
																		"对不起，您的密码错误");
													}
												},
												error : function(data) {//数据请求错误时回调函数
													alert("发生错误")
												}
											})
								}

							}

						})
	</script>

</body>
</html>
