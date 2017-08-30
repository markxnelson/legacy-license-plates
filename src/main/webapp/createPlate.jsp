<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url value="/res/styles.css" var="stylesURL"/>
    <link rel="stylesheet" href="${stylesURL}" type="text/css"> 
    <title>Create Plate</title>
  </head>
  <body>
    <jsp:include page="/templates/header.jsp"/>
    <h1>Create auction</h1>
    <c:url value="/CreatePlateServlet" var="createURL" />
    <form action="${createURL}" enctype="multipart/form-data" method="post">
      <table>
        <tr>
          <td>Plate number:</td>
          <td><input type="text" name="plateNumber"></td>
        </tr>
        <tr>
          <td>State:</td>
          <td><input type="text" name="state"></td>
        </tr>
        <tr>
          <td>Owner:</td>
          <td><input type="text" name="owner" ></td>
        </tr>
        <tr>
          <td>Owner address:</td>
          <td><input type="text" name="address" ></td>
        </tr>
        <tr>
          <td>Image URL:</td>
          <td><input type="text" name="imageURL" ></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><input type="submit" value="Create"></td>
        </tr>
      </table>
    </form>

    <c:url var="indexUrl" value="/"/><a href="${indexUrl}">Go Home</a><br>
    <c:url value="/ListServlet" var="listURL"/>
    <a href="${listURL}">Back to plate list</a>

  </body>
</html>
