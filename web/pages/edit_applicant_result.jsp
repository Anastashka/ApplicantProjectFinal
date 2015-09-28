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
  <h2><a class="header-link" href="/app">Applicant results</a></h2>
</div>
<h3>Add result</h3>

<form method="post" action="controller?command=saveApplicantResults">
  <p>Applicant</p>
  <c:choose>
    <c:when test="${applicantResult ne null}">

      <select name="applicant_id">
        <c:forEach items="${applicants}" var="applicant">
          <option value="${applicant.getId()}">
            <c:out value="${applicant.getFirstName()}"/>
            <c:out value="${applicant.getLastName()}"/>
          </option>
        </c:forEach>
      </select>

    </c:when>
    <c:otherwise>
      <select name="applicant_id">
        <c:forEach items="${applicants}" var="applicant">
          <option value="${applicant.getId()}">
            <c:out value="${applicant.getFirstName()}"/>
            <c:out value="${applicant.getLastName()}"/>
          </option>
        </c:forEach>
      </select>
    </c:otherwise>

  </c:choose>

  <c:choose>
    <c:when test="${applicantResult ne null}">
      <input type="hidden" name="applicant_result_id" value="${applicantResult.getId()}"/>
    </c:when>

  </c:choose>


  <p>Mark</p>
  <c:choose>
    <c:when test="${applicantResult ne null}">
      <input type="text" name="mark" value="${applicantResult.getMark()}"/>
    </c:when>
    <c:otherwise>
      <input type="text" name="mark" value=""/>
    </c:otherwise>
  </c:choose>

  <p>Subject</p>
  <c:choose>
    <c:when test="${applicantResult ne null}">

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


  <input type="submit"name="accept_button" value="Input">

</form>
</body>
</html>
