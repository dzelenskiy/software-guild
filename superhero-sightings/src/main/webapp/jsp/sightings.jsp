<%--
    Document   : Sightings
    Created on : Jul 5, 2018, 12:06:45 PM
    Author     : DZ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sightings</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center">Superhero Sightings</h1>
            <hr/>
            <div class="navbar col-md-12">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/sightings">Sightings</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/herovillains">Superheros / Supervillains</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/organizations">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/locations">Locations</a></li>
                </ul>
            </div>
            <h3 style="text-align: center">Sightings</h3>
            <div class="col-md-8">
                <h4 style="text-align: center">Existing Sightings</h4>
                <table class="table table-hover">
                    <tr>
                        <th width="30%">Date</th>
                        <th width="50%">City</th>
                        <th width="10%"></th>
                        <th width="10%"></th>
                    </tr>
                    <c:forEach var="sighting" items="${sightings}">
                        <tr>
                            <td>${sighting.date}</td>
                            <td>${sighting.location.city}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/viewSighting?id=${sighting.id}">View/Edit</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/deleteSighting?id=${sighting.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-4">
                <h4 style="text-align: center">
                    <c:if test="${empty sightView}">Add New Sighting</c:if>
                    <c:if test="${not empty sightView}">View & Edit Sighting</c:if></h4>

                <c:if test="${not empty error}"><p style="text-align: center; color: red">${error}</p></c:if>

                    <form class="form-horizontal" role="form" method="POST"
                    <c:if test="${empty sightView}">action="${pageContext.request.contextPath}/addSighting"</c:if>
                    <c:if test="${not empty sightView}">action="${pageContext.request.contextPath}/editSighting"</c:if> />
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Date:</label>
                        <div class="col-md-9">
                            <input type="date" class="form-control" name="date"
                            <c:if test="${empty sightView}"></c:if>
                            <c:if test="${not empty sightView}">value="${sightView.date}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Location:</label>
                        <div class="col-md-9">
                            <select class="form-control" name="location">
                            <c:if test="${empty sightView}">
                                <option selected>-Select One-</option>
                            </c:if>
                            <c:forEach var="location" items="${locations}">
                                <c:if test="${location.id != sightView.location.id}">
                                    <option value="${location.id}">${location.name}</option>
                                </c:if>
                                <c:if test="${location.id == sightView.location.id}">
                                    <option selected value="${location.id}">${location.name}</option>
                                </c:if>

                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label" style="text-align: left">Superheros  /villains:</label>
                    <div class="col-md-9">
                        <select multiple="multiple" class="form-control" name="heroVillain">
                            <c:forEach var="heroVillain" items="${heroVillains}">
                                <c:choose>
                                    <c:when test="${sightView.heroVillains.contains(heroVillain)}">
                                        <option selected value="${heroVillain.id}">${heroVillain.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${heroVillain.id}">${heroVillain.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-3 col-md-9">
                        <input type="submit" class="btn btn-default"
                               <c:if test="${not empty sightView}">value="Edit Sighting" </c:if>
                               <c:if test="${empty sightView}">value="Add Sighting"</c:if> />
                        </div>
                    </div>
                <c:if test="${not empty sightView}">
                    <div class="form-group">
                        <div class="col-md-offset-3 col-md-9">
                            <input type="submit" formaction="${pageContext.request.contextPath}/cancelEditSighting"
                                   class="btn btn-default" value="Cancel"/>
                        </div>
                    </div>
                </c:if>
                </form>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
