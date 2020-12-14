<%--
    Document   : herovillains
    Created on : Jul 5, 2018, 12:07:30 PM
    Author     : DZ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Superheros / Supervillains</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center">Superhero Sightings</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/sightings">Sightings</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/herovillains">Superheros / Supervillains</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/organizations">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/locations">Locations</a></li>
                </ul>
            </div>
            <h3 style="text-align: center">Superheros / Supervillains</h3>
            <div class="col-md-8">
                <h4 style="text-align: center">Existing Superheros / Supervillains</h4>
                <table class="table table-hover">
                    <tr>
                        <th width="30%">Name</th>
                        <th width="50%">Power</th>
                        <th width="10%"></th>
                        <th width="10%"></th>
                    </tr>
                    <c:forEach var="heroVillain" items="${heroVillains}">
                        <tr>
                            <td>${heroVillain.name}</td>
                            <td>${heroVillain.power}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/viewHeroVillain?id=${heroVillain.id}">View/Edit</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/deleteHeroVillain?id=${heroVillain.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-4">
                <h4 style="text-align: center">
                    <c:if test="${empty hvView}">Add New Superhero / Supervillain</c:if>
                    <c:if test="${not empty hvView}">View & Edit Superhero / Supervillain</c:if></h4>

                <c:if test="${not empty error}"><p style="text-align: center; color: red">${error}</p></c:if>

                    <form class="form-horizontal" role="form" method="POST"
                    <c:if test="${empty hvView}">action="${pageContext.request.contextPath}/addHeroVillain"</c:if>
                    <c:if test="${not empty hvView}">action="${pageContext.request.contextPath}/editHeroVillain"</c:if> />
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Name:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="name"
                            <c:if test="${empty hvView}">placeholder="Name"</c:if>
                            <c:if test="${not empty hvView}">value="${hvView.name}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Description:</label>
                        <div class="col-md-9">
                            <textarea type="text" class="form-control" name="description"
                            <c:if test="${empty hvView}">placeholder="Description"></textarea></c:if>
                        <c:if test="${not empty hvView}">>${hvView.description}</textarea></c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Power:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="power"
                            <c:if test="${empty hvView}">placeholder="Power"</c:if>
                            <c:if test="${not empty hvView}">value="${hvView.power}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-3 col-md-9">
                            <input type="submit" class="btn btn-default"
                            <c:if test="${not empty hvView}">value="Edit Superhero / Supervillain" </c:if>
                            <c:if test="${empty hvView}">value="Add Superhero / Supervillain"</c:if> />
                        </div>
                    </div>
                <c:if test="${not empty hvView}">
                    <div class="form-group">
                        <div class="col-md-offset-3 col-md-9">
                            <input type="submit" formaction="${pageContext.request.contextPath}/cancelEditHeroVillain"
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
