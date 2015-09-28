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
    <h2><a class="header-link" href="/app">Professions</a></h2>
</div>

<c:if test="${professions.size() == 0}">
    No professions
</c:if>
<table>
    <tr>
        <th>Profession Id</th>
        <th>Profession Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${professions}" var="profession">
        <tr>
            <td><c:out value="${profession.getId()}"/></td>
            <td><c:out value="${profession.getProfessionName()}"/></td>
            <td><a href="controller?command=deleteProfession&id=${profession.getId()}"><img src="images/delete.png" width="25px" height="25px"></a>
                <a href="controller?command=editProfession&id=${profession.getId()}"><img src="images/edit.jpg" width="25px" height="25px"></a></td>
        </tr>
    </c:forEach>
</table>
<div>
    <a href="controller?command=addProfession"><img src="images/add.png" width="30px" height="30px"></a>
</div>

</body>
</html>
