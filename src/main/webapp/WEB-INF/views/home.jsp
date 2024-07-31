<%@ include file="/WEB-INF/fragments/jsp-header.jspf" %>
<DOCTYPE html>
<html lang="en">
	
<head>
	<meta charset="utf8">
	
	<title>Home</title>
	
<%@ include file="/WEB-INF/fragments/javascript-header.jspf" %>

<%@ include file="/WEB-INF/fragments/css-header.jspf" %>	
	
	<link href="<c:url value='/resources/css/home.css' />" rel="stylesheet" />

</head>
	
<body>
	<div id="main">		

<%@ include file="/WEB-INF/fragments/page-header.jspf" %>			
	
		<div id="content">
			
			<h1 id="pageTitle">Home</h1>
			
			<div id="pageContent">
				
			</div>
			
		</div>
	
<%@ include file="/WEB-INF/fragments/page-footer.jspf" %>

	</div>

</body>

</html>
