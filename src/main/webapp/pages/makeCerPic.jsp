<%@ page contentType="image/jpeg"%>
<jsp:useBean id="image" class="cn.xc.service.impl.MakeCertPicServicesImpl" />
<%
	String str = image.getCerPic(0, 0, response.getOutputStream());
	out.clear();
	out = pageContext.pushBody();
	session.setAttribute("certCode", str);
%>
