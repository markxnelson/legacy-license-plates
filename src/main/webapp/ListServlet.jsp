<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url value="/res/styles.css" var="stylesURL"/>
    <link rel="stylesheet" href="${stylesURL}" type="text/css"> 
    <title>Plate List</title>
  </head>
  <body>
    <jsp:include page="/templates/header.jsp"/>
    <h1>License Plates</h1>
    <c:if test="${not empty message}">
      <h3>${message}</h3>
    </c:if>
    <table>
      <thead>
        <tr>
          <td>Number</td>
          <td>State</td>
          <td>Owner</td>
          <td>Address</td>
          <td>Image URL</td>
          <td>Timestamp</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="plate" items="${allPlates}">
          <tr>
            <td>
              ${plate.plateNumber}
            </td>
            <td>
              ${plate.state}
            </td>
            <td>
              ${plate.owner}
            </td>
            <td>
              ${plate.address}
            </td>
            <td>
              ${plate.imageURL}
            </td>
            <td>
              ${plate.ts}
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <c:url var="indexUrl" value="/"/><a href="${indexUrl}">Go Home</a><br>
    <c:url var="createPlateUrl" value="/createPlate.jsp"/>
    <a href="${createPlateUrl}">Create plate</a>
  </body>
</html>
