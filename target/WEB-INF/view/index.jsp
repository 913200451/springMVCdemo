<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!--输出,条件,迭代标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> <!--数据格式化标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%> <!--数据库相关标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> <!--常用函数标签库-->
<%@ page isELIgnored="false"%> <!--支持EL表达式，不设的话，EL表达式不会解析-->
<!DOCTYPE html>
<html>
<head>
	<title>论文格式检测</title>
	<link rel="stylesheet" href="css/style.css">
	<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="File Upload widget Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

		
</head>

<body>
<h1>论文格式检测</h1>
<div class="agile-its">
	<h2>上传.docx文件</h2>
	<div class="agileinfo">

	</div>
	<div class="w3layouts">
		<div class="photos-upload-view">
			<form id="upload" action="springUpload.do" method="POST" enctype="multipart/form-data">
				<label>选择院校：</label>
				<select align="center" id="type_id" class="aestype" name="id">
					<c:forEach items="${collages}" var="collage">
						<option value="${collage.id}">${collage.collage_name}</option>
					</c:forEach>
				</select>
				<input type="hidden" id="MAX_FILE_SIZE" name="MAX_FILE_SIZE" value="300000" />
					<div class="agileinfo">
						<input align="center" type="file" id="fileselect" name="file" multiple="multiple" />
						<h3>OR</h3>
						<div id="filedrag">拖动文件到这里..</div>
					</div>
					<input align="center" type="submit" value="提交">
			</form>
			<div id="messages">
				<p>文件属性</p>
			</div>
		</div>
		<div class="clearfix"></div>
		<script src="js/filedrag.js"></script>

		</div>
</div>
<div class="footer">
	<p> © 2016 File Upload widget. All Rights Reserved | Design by  <a href="http://w3layouts.com/"> W3layouts</a></p>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>

</div>
</body>
</html>