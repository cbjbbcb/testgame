<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/mypets.css" />
<link rel="stylesheet" href="css/mypets8.css" />
</head>
<style>
#ball {
	width: 30px;
	height: 30px;
	position: absolute;
	left: 100px;
	display: none;
}
</style>
<body>

	<div class="mypets_top"></div>
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
		<div class="mypets_middle_middle8">
			<div class="mypets_middle_middle8_top">
				<div class="mypets_middle_middle8_p" id="pet2">
					<img name="imgL2" src=${pet2.imgL } />
				</div>
				<div class="mypets_middle_middle8_x">
					<p>
						<span name="name2">${pet2.name}</span>&nbsp; &nbsp;<span
							name="bhp2">${pet2.bhp}</span>/<span name="rhp2">${pet2.rhp}</span>&nbsp;&nbsp;LV:<span>${pet2.lv}</span>
					</p>
				</div>
			</div>
			<div class="mypets_middle_middle8_middle">
				<div class="mypets_middle_middle8_p" id="pet1">
					<img name="imgL1" src=${pet.imgL } />
				</div>
				<div id="ball">
					<img name="ball1" src="img/ball1.png" style="width: 30px" />
				</div>
				<div class="mypets_middle_middle8_x">
					<p>
						<span name="name1">${pet.name}</span>&nbsp;&nbsp;<span name="bhp1">${pet.bhp}</span>/<span
							name="rhp1">${pet.rhp}</span>&nbsp;&nbsp;LV:<span>${pet.lv}</span>
					</p>
				</div>
			</div>

			<div class="mypets_middle_middle8_bottom">
				<div class="mypets_middle_middle8_bottom_left">
					<c:choose>
						<c:when test="${battleResult.win==-1}">
							<p>
								野生的<span>${pet2.name }</span>出现了
							</p>
							<p>
								去吧<span>${pet.name }</span>!
							</p>
						</c:when>
						<c:when test="${battleResult.win==0}">
							<c:if test="${battleResult.first==1}">
								<p>
									<span>${pet.name}</span>使用了<span>${battleResult.skill1}</span>命中了<span>${pet2.name }</span>,<span>${pet2.name }</span>受到了<span>${battleResult.hurt1}</span>点伤害
								</p>
								<p>
									<span>${pet2.name}</span>使用了<span>${battleResult.skill2}</span>命中了<span>${pet.name }</span>,<span>${pet.name }</span>受到了<span>${battleResult.hurt2}</span>点伤害
								</p>
							</c:if>
							<c:if test="${battleResult.first==2}">
								<p>
									<span>${pet2.name}</span>使用了<span>${battleResult.skill2}</span>命中了<span>${pet.name }</span>,<span>${pet.name }</span>受到了<span>${battleResult.hurt2}</span>点伤害
								</p>
								<p>
									<span>${pet.name}</span>使用了<span>${battleResult.skill1}</span>命中了<span>${pet2.name }</span>,<span>${pet2.name }</span>受到了<span>${battleResult.hurt1}</span>点伤害
								</p>
							</c:if>
						</c:when>
						<c:when test="${battleResult.win==1}">
							<c:if test="${battleResult.first==1}">
								<p>
									<span>${pet.name}</span>使用了<span>${battleResult.skill1}</span>命中了<span>${pet2.name }</span>,<span>${pet2.name }</span>受到了<span>${battleResult.hurt1}</span>点伤害
								</p>
								<p>
									<span>${pet2.name}</span>倒下了
								</p>
								<p>
									<span>${pet.name}</span>获得了<span>${battleResult.exp}</span>点经验值
								</p>
								<c:if test="${battleResult.up==1}">
									<p>
										<span>${pet.name}</span>升到了<span>${pet.lv}</span>级!
									</p>
								</c:if>
							</c:if>
							<c:if test="${battleResult.first==2}">
								<p>
									<span>${pet2.name}</span>使用了<span>${battleResult.skill2}</span>命中了<span>${pet.name }</span>,<span>${pet.name }</span>受到了<span>${battleResult.hurt2}</span>点伤害
								</p>
								<p>
									<span>${pet.name}</span>使用了<span>${battleResult.skill1}</span>命中了<span>${pet2.name }</span>,<span>${pet2.name }</span>受到了<span>${battleResult.hurt1}</span>点伤害
								</p>
								<p>
									<span>${pet2.name}</span>倒下了
								</p>
							</c:if>
						</c:when>
						<c:when test="${battleResult.win==2}">
							<c:if test="${battleResult.first==1}">
								<p>
									<span>${pet.name}</span>使用了<span>${battleResult.skill1}</span>命中了<span>${pet2.name }</span>,<span>${pet2.name }</span>受到了<span>${battleResult.hurt1}</span>点伤害
								</p>
								<p>
									<span>${pet2.name}</span>使用了<span>${battleResult.skill2}</span>命中了<span>${pet.name }</span>,<span>${pet.name }</span>受到了<span>${battleResult.hurt2}</span>点伤害
								</p>
								<p>
									<span>${pet.name}</span>倒下了
								</p>
							</c:if>
							<c:if test="${battleResult.first==2}">
								<p>
									<span>${pet2.name}</span>使用了<span>${battleResult.skill2}</span>命中了<span>${pet.name }</span>,<span>${pet.name }</span>受到了<span>${battleResult.hurt2}</span>点伤害
								</p>
								<p>
									<span>${pet.name}</span>倒下了
								</p>
							</c:if>
						</c:when>
						<c:when test="${battleResult.win==20}">

						</c:when>
						<c:when test="${battleResult.win==21}">

						</c:when>
						<c:when test="${battleResult.win==22}">

						</c:when>

					</c:choose>

				</div>


				<div class="mypets_middle_middle8_bottom_right">

					<div class="mypets_middle_middle8_bottom_right_0">
						<c:choose>
							<c:when test="${battleResult.win>0}">
								<a href="javascipt:;">攻击对方</a>
								<a href="javascipt:;">更换宠物</a>
								<br />
								<a href="javascipt:;">道具使用</a>
							</c:when>
							<c:otherwise>
								<a href="javascipt:;" id="attack">攻击对方</a>
								<a href="javascipt:;">更换宠物</a>
								<br />
								<a href="javascipt:;" id="catch">道具使用</a>
							</c:otherwise>

						</c:choose>

						<a id="battleRemove" href="javascript:;">重新遇敌</a>
					</div>
					<div class="mypets_middle_middle8_bottom_right_1">
						<c:forEach items="${skills}" var="skill" varStatus="sk">
							<a class="atk" name="${sk.index+1}" href="javascipt:;">${skill.skillName}</a>
						</c:forEach>


					</div>
				</div>
			</div>
		</div>




		<div class="mypets_bottom"></div>
		<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
		<script type="text/javascript" src="js/mypets8.js"></script>
		<script type="text/javascript">
	$(".atk").click(function(){
var atk=$(this).attr("name");
var str;
		$.ajax({
			url : "<%=basePath%>/game?op=battle",
			//请求资源的路径
			type : "get",//请求方式
			dataType : "json",//请求的数据类型
		data : {"atk":atk},
		//请求的参数
			success : function(data) {//数据请求成功的回调函数
			if(data.win==-1){
				$("img[name='imgL2']").attr("src",data.imgL2);
				$("[name='name2']").text(data.name2);
				$("[name='rhp2']").text(data.rhp2);
				$("[name='bhp2']").text(data.bhp2);
					$("#pet2").hide();
					$("#pet1").hide();
					str = "<p>野生的<span>" + data.name2 + "</span>出现了</p>";
					$(".mypets_middle_middle8_bottom_left").html(str);
					setTimeout(function() {
						$(".mypets_middle_middle8_bottom_left").html(str);
						$("#pet2").fadeIn();
					}, 100)
					setTimeout(function() {
						str += "<p>去吧<span>" + data.name1 + "</span>!</p>";
						$(".mypets_middle_middle8_bottom_left").html(str);
						$("#pet1").fadeIn();
					}, 2000)
			}else if(data.win==0){
			if(data.first==1){
				$("#pet1").animate({"left":"1000px","bottom":"100px"});
				$("#pet1").animate({"left":"200px","bottom":"0"});
			str="<p><span>"+data.name1+"</span>使用了<span>"+data.skill1+"</span>命中了<span>"+data.name2+"</span>,<span>"+data.name2+"</span>受到了<span>"+data.hurt1+"</span>点伤害</p>";
			$(".mypets_middle_middle8_bottom_left").html(str);
			$("[name='bhp2']").text(data.bhp2);
			
			setTimeout(function() {
				$("#pet2").animate({"right":"1000px","bottom":"-100px"});
				$("#pet2").animate({"right":"200px","bottom":"0"});
				str+="<p><span>"+data.name2+"</span>使用了<span>"+data.skill2+"</span>命中了<span>"+data.name1+"</span>,<span>"+data.name1+"</span>受到了<span>"+data.hurt2+"</span>点伤害</p>";
				$(".mypets_middle_middle8_bottom_left").html(str);
				$("[name='bhp1']").text(data.bhp1);
			}, 2000)
			$(".mypets_middle_middle8_bottom_right").children().hide();
			$(".mypets_middle_middle8_bottom_right_0").show();
			
			}else{
				$("#pet2").animate({"right":"1000px","bottom":"-100px"});
				$("#pet2").animate({"right":"200px","bottom":"0"});
				str="<p><span>"+data.name2+"</span>使用了<span>"+data.skill2+"</span>命中了<span>"+data.name1+"</span>,<span>"+data.name1+"</span>受到了<span>"+data.hurt2+"</span>点伤害</p>";
				$(".mypets_middle_middle8_bottom_left").html(str);
				$("[name='bhp1']").text(data.bhp1);
			
			
			setTimeout(function() {
				$("[name='bhp2']").text(data.bhp2);
				$("#pet1").animate({"left":"1000px","bottom":"100px"});
				$("#pet1").animate({"left":"200px","bottom":"0"});
			str+="<p><span>"+data.name1+"</span>使用了<span>"+data.skill1+"</span>命中了<span>"+data.name2+"</span>,<span>"+data.name2+"</span>受到了<span>"+data.hurt1+"</span>点伤害</p>";
			$(".mypets_middle_middle8_bottom_left").html(str);
			}, 2000)
		
							}
			}else if(data.win==1){
				if(data.first==2){
					$("#pet2").animate({"right":"1000px","bottom":"-100px"});
					$("#pet2").animate({"right":"200px","bottom":"0"});
					str="<p><span>"+data.name2+"</span>使用了<span>"+data.skill2+"</span>命中了<span>"+data.name1+"</span>,<span>"+data.name1+"</span>受到了<span>"+data.hurt2+"</span>点伤害</p>";
					$(".mypets_middle_middle8_bottom_left").html(str);
					$("[name='bhp1']").text(data.bhp1);
				}
				$("#pet1").animate({"left":"1000px","bottom":"100px"});
				$("#pet1").animate({"left":"200px","bottom":"0"});
				str="<p><span>"+data.name1+"</span>使用了<span>"+data.skill1+"</span>命中了<span>"+data.name2+"</span>,<span>"+data.name2+"</span>受到了<span>"+data.hurt1+"</span>点伤害</p>";
				$(".mypets_middle_middle8_bottom_left").html(str);
				setTimeout(function() {
					$("[name='bhp2']").text(data.bhp2);
					str+="<p><span>"+data.name2+"</span>倒下了</p>";
					str+="<p><span>"+data.name1+"</span>获得了<span>"+data.exp+"</span>点经验值</p>";
				if(data.up==1){
					str+="<p><span>"+data.name1+"</span>的等级提升了!</p>";
				}$(".mypets_middle_middle8_bottom_left").html(str);
				}, 2000)
				
			
			}else if(data.win==2){
				if(data.first==1){
					$("#pet1").animate({"left":"1000px","bottom":"100px"});
					$("#pet1").animate({"left":"200px","bottom":"0"});
				str="<p><span>"+data.name1+"</span>使用了<span>"+data.skill1+"</span>命中了<span>"+data.name2+"</span>,<span>"+data.name2+"</span>受到了<span>"+data.hurt1+"</span>点伤害</p>";
				$(".mypets_middle_middle8_bottom_left").html(str);
				$("[name='bhp2']").text(data.bhp2);
				}
				$("#pet2").animate({"right":"1000px","bottom":"-100px"});
				$("#pet2").animate({"right":"200px","bottom":"0"});
				str="<p><span>"+data.name2+"</span>使用了<span>"+data.skill2+"</span>命中了<span>"+data.name1+"</span>,<span>"+data.name1+"</span>受到了<span>"+data.hurt2+"</span>点伤害</p>";
				str+="<p><span>"+data.name2+"</span>倒下了</p>";
				$(".mypets_middle_middle8_bottom_left").html(str);
				$("[name='bhp1']").text(data.bhp1);
				
				
			}
			$(".mypets_middle_middle8_bottom_right").children().hide();
			$(".mypets_middle_middle8_bottom_right_0").show();
				
				
				
				},
				error : function(data) {//数据请求错误时回调函数

				}
			})

		})
		
		

		
			$("#battleRemove").click(function(){
		$.ajax({
					url : "<%=basePath%>/game?op=battleRemove",
					//请求资源的路径
					type : "get",//请求方式
					dataType : "json",//请求的数据类型
					data : {},
					//请求的参数
					success : function(data) {//数据请求成功的回调函数
						$("img[name='imgL2']").attr("src", data.imgL2);
						$("[name='name2']").text(data.name2);
						$("[name='rhp2']").text(data.rhp2);
						$("[name='bhp2']").text(data.bhp2);
						$("#pet2").hide();
						$("#pet1").hide();
						str = "<p>野生的<span>" + data.name2 + "</span>出现了</p>";
						$(".mypets_middle_middle8_bottom_left").html(str);
						setTimeout(function() {
							$(".mypets_middle_middle8_bottom_left").html(str);
							$("#pet2").fadeIn();
						}, 100)
						setTimeout(function() {
							str += "<p>去吧<span>" + data.name1 + "</span>!</p>";
							$(".mypets_middle_middle8_bottom_left").html(str);
							$("#pet1").fadeIn();
						}, 2000)

					},
					error : function(data) {//数据请求错误时回调函数

					}
				})

			})
			
			$("#catch").click(function(){
				var rhp2=$("span[name='rhp2']:eq(0)").text();
					var bhp2=$("span[name='bhp2']:eq(0)").text();
					if(bhp2>0){
						$.ajax({
							url : "<%=basePath%>/game?op=catchpet",
												type : "get",
												dataType : "json",
												data : {
													"rhp2" : rhp2,
													"bhp2" : bhp2
												},
												success : function(data) {
													console.log(data.count);
													console.log(data.br);
													function pet2hide() {
														$("#pet2").hide()
													}
													$("#ball").css({
														"left" : "100px",
														"bottom" : "0"
													})
													str = "<p>去吧，精灵球!</p>";
													$(".mypets_middle_middle8_bottom_left").html(str);
													$("#ball").fadeIn();
													$("#ball").animate({
														"left" : "1000px",
														"bottom" : "160px"
													}, 500);
													setTimeout(pet2hide, 1000);
													function ball() {
														$("#ball").animate({
															"left" : "960px",
															"bottom" : "155px"
														}, 100);
														$("#ball").animate({
															"left" : "1000px",
															"bottom" : "160px"
														}, 100);
														$("#ball").animate({
															"left" : "1040px",
															"bottom" : "155px"
														}, 100);
														$("#ball").animate({
															"left" : "980px",
															"bottom" : "155px"
														}, 100);
														$("#ball").animate({
															"left" : "1000px",
															"bottom" : "160px"
														}, 100);
														$("#ball").animate({
															"left" : "1020px",
															"bottom" : "155px"
														}, 100);

													}
													function catchs(br) {
														str = "<p>" + br.name2
																+ "被抓住了</p>";
														$(
																".mypets_middle_middle8_bottom_left")
																.html(str);
													}
													function catchf(br) {
														$("#pet2").show();
														$("#ball").hide();
														str = "<p>野生的"
																+ br.name2
																+ "逃了出来</p>";
														$(
																".mypets_middle_middle8_bottom_left")
																.html(str);

														setTimeout(
																function() {
																	$("#pet2")
																			.animate(
																					{
																						"right" : "1000px",
																						"bottom" : "-100px"
																					});
																	$("#pet2")
																			.animate(
																					{
																						"right" : "200px",
																						"bottom" : "0"
																					});
																	str += "<p><span>"
																			+ br.name2
																			+ "</span>使用了<span>"
																			+ br.skill2
																			+ "</span>命中了<span>"
																			+ br.name1
																			+ "</span>,<span>"
																			+ br.name1
																			+ "</span>受到了<span>"
																			+ br.hurt2
																			+ "</span>点伤害</p>";
																	if (br.win == 22) {
																		str += "<p><span>"
																				+ br.name2
																				+ "</span>倒下了</p>";
																	}
																	$(
																			".mypets_middle_middle8_bottom_left")
																			.html(
																					str);
																	$(
																			"[name='bhp1']")
																			.text(
																					br.bhp1);

																}, 1000)

													}

													for (var i = 0; i < data.count + 1; i++) {
														setTimeout(ball,
																1000 * (i + 1));
														if (i == data.count) {
															if (data.count > 3) {
																setTimeout(
																		catchs,
																		1000 * (i + 1) + 700,
																		data.br);
															} else {
																setTimeout(
																		catchf,
																		1000 * (i + 1) + 700,
																		data.br);
															}
														}
													}

												},
												error : function(data) {
													alert("异常")
												}

											})

								}

							})
		</script>
</body>
</html>

