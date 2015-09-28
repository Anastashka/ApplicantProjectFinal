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

<div class="header">
  <h2><a class="header-link" href="/app">Speciality subject</a></h2>
</div>
<h3>Add speciality subject</h3>
<form method="post" action="controller?command=saveSpecialitySubject">
  <p>Profession Id</p>
  <c:choose>
    <c:when test="${specialitySubject ne null}">

      <select name="profession_id">
        <c:forEach items="${professions}" var="profession">
          <option value="${profession.getId()}"><c:out value="${profession.getProfessionName()}"/></option>
        </c:forEach>
      </select>
    </c:when>
    <c:otherwise>
      <select name="profession_id">
        <c:forEach items="${professions}" var="profession">
          <option value="${profession.getId()}"><c:out value="${profession.getProfessionName()}"/></option>
        </c:forEach>
      </select>
    </c:otherwise>

  </c:choose>

  <p>Subject</p>
  <c:choose>

    <c:when test="${specialitySubject ne null}">
      <select name="subject_id">
        <c:forEach items="${subjects}" var="subject">
          <option value="${subject.getId()}"><c:out value="${subject.getSubjectName()}"/></option>
        </c:forEach>
      </select>

    </c:when>

    <c:otherwise>
      <select name="subject_id">
        <c:forEach items="${subjects}" var="subject">
          <option value="${subject.getId()}"><c:out value="${subject.getSubjectName()}"/></option>
        </c:forEach>
      </select>
    </c:otherwise>
  </c:choose>

  <c:choose>
    <c:when test="${specialitySubject ne null}">
      <input type="hidden" name="sp_sb_id" value="${specialitySubject.getId()}"/>
    </c:when>

  </c:choose>

  <input type="submit"name="accept_button" value="input">
</form>
</body>
</html>

