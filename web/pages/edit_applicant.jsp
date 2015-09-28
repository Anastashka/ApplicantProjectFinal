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
    <h2><a class="header-link" href="/app">Applicants</a></h2>
</div>
<h3>Add applicant</h3>

<form method="post" action="controller?command=saveApplicants">
    <p>Name</p>
  <c:choose>
    <c:when test="${applicant ne null}">
      <input type="text" name="first_name" value="${applicant.getFirstName()}"/>
    </c:when>
    <c:otherwise>
      <input type="text" name="first_name" value=""/>
    </c:otherwise>
  </c:choose>

    <c:choose>
        <c:when test="${applicant ne null}">
            <input type="hidden" name="applicant_id" value="${applicant.getId()}"/>
        </c:when>

    </c:choose>


    <p>Last Name</p>
    <c:choose>
        <c:when test="${applicant ne null}">
            <input type="text" name="last_name" value="${applicant.getLastName()}"/>
        </c:when>
        <c:otherwise>
            <input type="text" name="last_name" value=""/>
        </c:otherwise>
    </c:choose>

    <p>Entrance year</p>
    <c:choose>
        <c:when test="${applicant ne null}">
            <input type="text" name="entrance_year" value="${applicant.getEntranceYear()}"/>
        </c:when>
        <c:otherwise>
            <input type="text" name="entrance_year" value=""/>
        </c:otherwise>
    </c:choose>

    <p>Profession</p>
    <c:choose>
        <c:when test="${applicant ne null}">

            <select name="professionId">
                <c:forEach items="${professions}" var="profession">
                    <option value="${profession.getId()}"><c:out value="${profession.getProfessionName()}"/></option>
                </c:forEach>
            </select>

        </c:when>
        <c:otherwise>
            <select name="professionId">
                <c:forEach items="${professions}" var="profession">
                    <option value="${profession.getId()}"><c:out value="${profession.getProfessionName()}"/></option>
                </c:forEach>
            </select>
        </c:otherwise>

    </c:choose>


    <br>
    <input type="submit"name="accept_button" value="Input">


</form>
</body>
</html>