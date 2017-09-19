<%@ page import="java.net.UnknownHostException" %>
<%@ page import="java.net.InetAddress" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url value="/res/styles.css" var="stylesURL"/>
    <link rel="stylesheet" href="${stylesURL}" type="text/css"> 
    <title>License Plates</title>
  </head>
  <body>
    <jsp:include page="/templates/header.jsp"/>
    <h1>Welcome to the License Plate application</h1>
    <c:url value="/UpdateUserServlet" var="updateUserURL" />
    <form action="${updateUserURL}" method="POST">
      User:
      <input type="text" value="${plateUser}" name="user"/>
      <input type="submit" value="update"/>
    </form>

    <h2 style="text-align: center"><c:url var="listPlatesUrl" value="/ListServlet"/><a href="${listPlatesUrl}">View Plate List</a></h2>
    <h2 style="text-align: center"><c:url var="createPlateUrl" value="/createPlate.jsp"/><a href="${createPlateUrl}">Create Plate</a></h2>
    <h2 style="text-align: center"><c:url var="setupUrl" value="/setup.jsp"/><a href="${setupUrl}">Create Default Data</a></h2>

    <%
      String hostname, serverAddress;
      hostname = "error";
      serverAddress = "error";
      try {
        InetAddress inetAddress;
        inetAddress = InetAddress.getLocalHost();
        hostname = inetAddress.getHostName();
        serverAddress = inetAddress.toString();
      } catch (UnknownHostException e) {

        e.printStackTrace();
      }
    %>

    <li>InetAddress: <%=serverAddress %>
    <li>InetAddress.hostname: <%=hostname %>

  </body>
</html>
