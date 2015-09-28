<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title></title>
</head>
<body>
<style>
  <%@include file='style.css' %>

</style>
<body>
<div class="header">
  <h2><a class="header-link" href="/app">Applicant results</a></h2>
</div>

<c:choose>
  <c:when test="${applicants.size() == 0}">
    <p><c:out value="No applicants yet"></c:out></p>
  </c:when>
  <c:otherwise>
    <table>
      <tr>
        <th>ID</th>
        <th>Applicant ID</th>
        <th>Subject ID</th>
        <th>Mark</th>
      </tr>
      <c:forEach items="${applicantResults}" var="applicantResult">
        <tr>
          <td>
            <c:out value="${applicantResult.getId()}"/>
          </td>
          <td>
            <c:out value="${applicantResult.getApplicantName()}"/>
          </td>
          <td>
            <c:out value="${applicantResult.getSubjectName()}"/>
          </td>
          <td>
            <c:out value="${applicantResult.getMark()}"/>
          </td>
          <td>
            <a href="controller?command=deleteApplicantResults&id=${applicantResult.getId()}"><img src="images/delete.png" width="25px" height="25px"></a>
            <a href="controller?command=editApplicantResults&id=${applicantResult.getId()}"><img src="images/edit.jpg" width="25px" height="25px"></a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </c:otherwise>
</c:choose>
<a href="controller?command=addApplicantResults"><img src="images/add.png" width="30px" height="30px"></a>
</body>
</html>
