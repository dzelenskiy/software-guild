<%--
    Document   : locations
    Created on : Jul 5, 2018, 12:09:56 PM
    Author     : DZ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Locations</title>
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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/herovillains">Superheros / Supervillains</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/organizations">Organizations</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/locations">Locations</a></li>
                </ul>
            </div>
            <h3 style="text-align: center">Locations</h3>
            <div class="col-md-8">
                <h4 style="text-align: center">Existing Locations</h4>
                <table class="table table-hover">
                    <tr>
                        <th width="20%">Name</th>
                        <th width="30%">Address</th>
                        <th width="20%">City</th>
                        <th width="10%">State</th>
                        <th width="10%"></th>
                        <th width="10%"></th>
                    </tr>
                    <c:forEach var="location" items="${locations}">
                        <tr>
                            <td>${location.name}</td>
                            <td>${location.address}</td>
                            <td>${location.city}</td>
                            <td>${location.state}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/viewLocation?id=${location.id}">View/Edit</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/deleteLocation?id=${location.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-4">
                <h4 style="text-align: center">
                    <c:if test="${empty locView}">Add New Location</c:if>
                    <c:if test="${not empty locView}">View & Edit Location</c:if></h4>

                <c:if test="${not empty error}"><p style="text-align: center; color: red">${error}</p></c:if>

                    <form class="form-horizontal" role="form" method="POST"
                    <c:if test="${empty locView}">action="${pageContext.request.contextPath}/addLocation"</c:if>
                    <c:if test="${not empty locView}">action="${pageContext.request.contextPath}/editLocation"</c:if> />
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Name:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="name"
                            <c:if test="${empty locView}">placeholder="Name"</c:if>
                            <c:if test="${not empty locView}">value="${locView.name}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Description:</label>
                        <div class="col-md-9">
                            <textarea type="text" class="form-control" name="description"
                            <c:if test="${empty locView}">placeholder="Description"></textarea></c:if>
                        <c:if test="${not empty locView}">>${locView.description}</textarea></c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Address:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="address"
                            <c:if test="${empty locView}">placeholder="Address"</c:if>
                            <c:if test="${not empty locView}">value="${locView.address}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">City:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="city"
                            <c:if test="${empty locView}">placeholder="City"</c:if>
                            <c:if test="${not empty locView}">value="${locView.city}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">State:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="state"
                            <c:if test="${empty locView}">placeholder="State"</c:if>
                            <c:if test="${not empty locView}">value="${locView.state}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Latitude:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="latitude"
                            <c:if test="${empty locView}">placeholder="Latitude"</c:if>
                            <c:if test="${not empty locView}">value="${locView.latitude}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Longitude:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="longitude"
                            <c:if test="${empty locView}">placeholder="Longitude"</c:if>
                            <c:if test="${not empty locView}">value="${locView.longitude}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-3 col-md-9">
                            <input type="submit" class="btn btn-default"
                            <c:if test="${not empty locView}">value="Edit Location" </c:if>
                            <c:if test="${empty locView}">value="Add Location"</c:if> />
                        </div>
                    </div>
                <c:if test="${not empty locView}">
                    <div class="form-group">
                        <div class="col-md-offset-3 col-md-9">
                            <input type="submit" formaction="${pageContext.request.contextPath}/cancelEditLocation"
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
