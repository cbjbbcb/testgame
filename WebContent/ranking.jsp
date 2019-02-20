<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'mygame.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/mypets.css" />
</head>
<body>
	<div class="mypets_top">
		<a href="<%=basePath%>/game?op=out">登出</a>
	</div>
	<div class="mypets_middle">
		<div class="mypets_middle_top clearfix">
						<img src="img/bg_dream.jpg" />
			<ul>
				<li><a href="javascript:;">最新动态</a></li>
				<li><a href="<%=basePath%>/game?op=mypets">我的宠物</a></li>
				<li><a href="javascript:;">我的道具</a></li>
				<li><a href="javascript:;">道具商店</a></li>
				<li><a href="javascript:;">宠物中心</a></li>
				<li><a href="javascript:;">宠物排行</a></li>
				<li><a href="javascript:;">通讯对战</a></li>
				<li><a href="<%=basePath%>/game?op=battle">野外冒险</a></li>
			</ul>
		</div>
		<div class="mypets_middle_middle6">
			<table>
				<tr>
					<td></td>
					<td>宠物名称</td>
					<td>等级</td>
					<td>品质</td>
					<td>生命值</td>
					<td>物攻</td>
					<td>物防</td>
					<td>特攻</td>
					<td>特防</td>
					<td>速度</td>
					<td>训练师</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<c:forEach items="${petsRanking}" var="petRanking">

					<tr>
						<td><img src="${petRanking.imgL}" /></td>
						<td>${petRanking.name}</td>
						<td>${petRanking.lv}</td>
						<td>${petRanking.pinzhi}</td>
						<td>${petRanking.rhp}</td>
						<td>${petRanking.rwg}</td>
						<td>${petRanking.rwf}</td>
						<td>${petRanking.rtg}</td>
						<td>${petRanking.rtf}</td>
						<td>${petRanking.rsd}</td>
						<td>${petRanking.ownerName}&nbsp;&nbsp;</td>
						<td>发送交换请求(未实现)&nbsp;&nbsp;</td>
						<td>模拟对战(未实现)&nbsp;&nbsp;</td>
						<td>通讯对战(未实现)&nbsp;&nbsp;</td>
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>
