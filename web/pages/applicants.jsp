<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title></title>
</head>
<style>
  <%@include file='style.css' %>

</style>
<body>
<div class="header">
  <h2><a class="header-link" href="/app">Applicants</a></h2>
</div>

<c:choose>
  <c:when test="${applicants.size() == 0}">
    <p><c:out value="No applicants yet"></c:out></p>
  </c:when>
  <c:otherwise>
    <table>
      <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Profession ID</th>
        <th>Entrance Year</th>
        <th>Actions</th>
      </tr>
      <c:forEach items="${applicants}" var="applicant">
        <tr>
          <td>
            <c:out value="${applicant.getId()}"/>
          </td>
          <td>
            <c:out value="${applicant.getFirstName()}"/>
          </td>
          <td>
            <c:out value="${applicant.getLastName()}"/>
          </td>
          <td>
            <c:out value="${applicant.getProfessionName()}"/>
          </td>
          <td>
            <c:out value="${applicant.getEntranceYear()}"/>
          </td>
          <td>
            <a href="controller?command=deleteApplicants&id=${applicant.getId()}"><img src="images/delete.png" width="25px" height="25px"></a>
            <a href="controller?command=editApplicants&id=${applicant.getId()}">><img src="images/edit.jpg" width="25px" height="25px"></a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </c:otherwise>
</c:choose>
<a href="controller?command=addApplicants"><img src="images/add.png" width="30px" height="30px"></a>
</body>
</html>
