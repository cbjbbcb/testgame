<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript">
		$.ajax({
			url : "${pageContext.request.contextPath}/json",
			//请求资源的路径
			type : "get",//请求方式
			dataType : "json",//请求的数据类型
			// 			data : {},//请求的参数
			success : function(data) {//数据请求成功的回调函数
				alert(data.name);
				alert(data.age);
			},
			error : function(data) {//数据请求错误时回调函数

			}
		})
	</script>
</body>
</html>