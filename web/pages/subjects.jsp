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
  <h2><a class="header-link" href="/app">Subjects</a></h2>
</div>

<c:if test="${subjects.size() == 0}">
  No subjects
</c:if>
<table>
  <tr>
    <th>Subjects Id</th>
    <th>Subjects Name</th>
    <th>Actions</th>
  </tr>
  <c:forEach items="${subjects}" var="subject">
    <tr>
      <td><c:out value="${subject.getId()}"/></td>
      <td><c:out value="${subject.getSubjectName()}"/></td>
      <td><a href="controller?command=deleteSubject&id=${subject.getId()}"><img src="images/delete.png" width="25px" height="25px"></a>
        <a href="controller?command=editSubject&id=${subject.getId()}"><img src="images/edit.jpg" width="25px" height="25px"></a></td>
    </tr>
  </c:forEach>
</table>
<div>
  <a href="controller?command=addSubject"><img src="images/add.png" width="30px" height="30px"></a>
</div>
</body>
</html>
