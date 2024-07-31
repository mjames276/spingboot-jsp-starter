<%@ include file="/WEB-INF/fragments/jsp-header.jspf" %>
<DOCTYPE html>
<html lang="en">
	
<head>
	<meta charset="utf8">
	
	<title>Login</title>
	
<%@ include file="/WEB-INF/fragments/javascript-header.jspf" %>

<%@ include file="/WEB-INF/fragments/css-header.jspf" %>	
	
	<link href="<c:url value='/resources/css/login.css' />" rel="stylesheet" />

</head>
	
<body>
	<div id="main">

<%@ include file="/WEB-INF/fragments/page-header.jspf" %>		
		
		<div id="content">			
			<h1 id="pageTitle">Login</h1>
			
			<div id="pageContent">
				
				<form action="<c:url value='/login' />" method="post">               
		            <fieldset>
		                <legend>Login</legend>		                
						<p>
		                	<label for="username">Email</label>
		                	<input type="text" id="username" name="username"/>
						</p>
						<p>        
		                	<label for="password">Password</label>
		                	<input type="password" id="password" name="password"/>
						</p>    
		                <p>
		                    <button type="submit" class="btn">Log in</button>
		                </p>
						
<c:if test="${param.error != null}">				
						<p class="error">Authentication failure</p>				
</c:if>	
						
		            </fieldset>
		        </form>
				
			
			</div>
			
		</div>	
			
	</div>
</body>

</html>
