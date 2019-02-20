<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="login.jsp" %>

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
<script type="text/javascript">

</script>
</head>
<body>


	<div class="mypets_top">
		<a href="<%=basePath%>/game?op=out">切换用户</a>
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
				<li><a href="<%=basePath%>/game?op=ranking">宠物排行</a></li>
				<li><a href="javascript:;">通讯对战</a></li>
				<li><a href="<%=basePath%>/game?op=battle">野外冒险</a></li>
			</ul>
		</div>
		<c:if test="${not empty user}">
			<div class="mypets_middle_middle2">
			<div class="mypets_middle_middle2_left">
				<div class="mypets_middle_middle2_left_top clearfix">
					<p class="title_type1">
						我的神奇宝贝&nbsp;&nbsp;<span name="pokemonName">${pet.name}</span>
					</p>
					<div class="mypets_middle_middle2_left_top_1">
						<img src="${pet.imgL}" alt="您还没有宠物哦" class="pokemonLargePic" name="pokemon1" />
					</div>
					<ul class="mypets_middle_middle2_left_top_2">
						<li><span name="pokemonName">${pet.name}</span>&nbsp;LV:<span
							name="level">${pet.lv}</span></li>
						<li>交换:<span>允许</span></li>
						<li>属性:<span>${pet.shuxing}</span></li>
						<li>品质:<span>${pet["pinzhi"]}</span></li>
						<li>体力:<span>${pet.bhp}</span>/<span>${pet.rhp}</span></li>
						<li>经验:<span>${pet.exp}</span>[<span>${pet.expMax}</span>]
						</li>
						<li><a href="<%=basePath%>/game?op=delete&deleteNo=${pet.no}">放生</a></li>
					</ul>
					<ul class="mypets_middle_middle2_left_top_2">
						<li>能力详细:</li>
						<li>HP:${pet.rhp}</li>
						<li>攻击:${pet.rwg}</li>
						<li>防御:${pet.rwf}</li>
						<li>特攻:${pet.rtg}</li>
						<li>特防:${pet.rtf}</li>
						<li>速度:${pet.rsd}</li>
					</ul>
					<ul class="mypets_middle_middle2_left_top_2">

						<c:forEach items="${list }" var="petList" varStatus="pl" begin="1">
							<li><a href="<%=basePath%>/game?op=toFirst&n=${pl.index+1}"><i></i><span
									name="pokemonName">${petList.name}</span></a><a class="deletePet"
								href="<%=basePath%>/game?op=delete&deleteNo=${petList.no}">放生</a></li>
						</c:forEach>

					</ul>
				</div>
				<div class="mypets_middle_middle2_left_middle">
					<p class="title_type1">
						<span>${pet.name}</span>的技能
					</p>
					<c:forEach items="${skills}" var="skill">
						<p>${skill.skillName}</p>
					</c:forEach>

				</div>
				<div class="mypets_middle_middle2_left_bottom">
					<p class="title_type1">
						<span>${pet.name}</span>的详细信息
					</p>
					<p>
						亲密程度:<span>开始变得很信任你</span>
					</p>
				</div>
			</div>

			<div class="mypets_middle_middle2_right">
				<div class="mypets_middle_middle2_right_top">
					<p class="title_type1">训练师&nbsp;${user.nickName}的信息</p>
					<br /> <br /> <br /> <a href="<%=basePath%>/game?op=add">领养新Pokemon</a>
					<br /> <br /> <br /> <a href="<%=basePath%>/game?op=recover">治疗</a>
				</div>
				<div class="mypets_middle_middle2_right_bottom">
					<p class="title_type1">宠物图鉴信息</p>
				</div>
			</div>
		</div>

	</div>
	<div class="mypets_bottom"></div>
		</c:if>
	

</body>
</html>
