<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head><title>Struts dice</title>
<s:head />
</head>

<body>
<s:form action="dice">
 	  <s:textfield name="sides" label="Sides" />
   	  <s:submit label="Roll" />   	  
</s:form>
<s:property value="rollResult" />
</body>
</html>