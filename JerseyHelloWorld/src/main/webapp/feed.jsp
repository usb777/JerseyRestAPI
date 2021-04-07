<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>  
<!DOCTYPE html>
<body>
<h2>Hello World!</h2>


 <br>

<%=request.getAttribute("message") %>
 <br>

<%
Map<String, String> model = (Map<String, String>)request.getAttribute("mod");
out.print(model.get("key1")+"<br>") ;
out.print(model.get("key2")+"<br>") ;
//List<Menu> listMenu = (List<Menu>)request.getAttribute("menu");

%>
</body>
</html>
