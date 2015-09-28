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
  <h2><a class="header-link" href="/app">Speciality subject</a></h2>
</div>

<c:choose>
  <c:when test="${specialitySubjects.size() == 0}">
    <p><c:out value="No speciality subjects yet"></c:out></p>
  </c:when>
  <c:otherwise>
    <table>
      <tr>
        <th>Speciality subject ID</th>
        <th>Profession ID</th>
        <th>Subject ID</th>
      </tr>
      <c:forEach items="${specialitySubjects}" var="speciality_subject">
        <tr>
          <td>
            <c:out value="${speciality_subject.getId()}"/>
          </td>
          <td>
            <c:out value="${speciality_subject.getProfessionName()}"/>
          </td>
          <td>
            <c:out value="${speciality_subject.getSubjectName()}"/>
          </td>
          <td>
            <a href="controller?command=deleteSpecialitySubject&id=${speciality_subject.getId()}"><img src="images/delete.png" width="25px" height="25px"></a>
            <a href="controller?command=editSpecialitySubject&id=${speciality_subject.getId()}"><img src="images/edit.jpg" width="25px" height="25px"></a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </c:otherwise>
</c:choose>
<a href="controller?command=addSpecialitySubject"><img src="images/add.png" width="30px" height="30px"></a>
</body>
</html>
