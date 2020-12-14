<%--
    Document   : organizations
    Created on : Jul 5, 2018, 12:08:25 PM
    Author     : DZ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Organizations</title>
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
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/organizations">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/locations">Locations</a></li>
                </ul>
            </div>
            <h3 style="text-align: center">Organizations</h3>
            <div class="col-md-8">
                <h4 style="text-align: center">Existing Organizations</h4>
                <table class="table table-hover">
                    <tr>
                        <th width="40%">Name</th>
                        <th width="30%">City</th>
                        <th width="10%">State</th>
                        <th width="10%"></th>
                        <th width="10%"></th>
                    </tr>
                    <c:forEach var="organization" items="${organizations}">
                        <tr>
                            <td>${organization.name}</td>
                            <td>${organization.city}</td>
                            <td>${organization.state}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/viewOrganization?id=${organization.id}">View/Edit</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/deleteOrganization?id=${organization.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-4">
                <h4 style="text-align: center">
                    <c:if test="${empty orgView}">Add New Superhero / Organization</c:if>
                    <c:if test="${not empty orgView}">View & Edit Superhero / Organization</c:if></h4>

                <c:if test="${not empty error}"><p style="text-align: center; color: red">${error}</p></c:if>

                    <form class="form-horizontal" role="form" method="POST"
                    <c:if test="${empty orgView}">action="${pageContext.request.contextPath}/addOrganization"</c:if>
                    <c:if test="${not empty orgView}">action="${pageContext.request.contextPath}/editOrganization"</c:if> />
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Name:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="name"
                            <c:if test="${empty orgView}">placeholder="Name"</c:if>
                            <c:if test="${not empty orgView}">value="${orgView.name}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Description:</label>
                        <div class="col-md-9">
                            <textarea type="text" class="form-control" name="description"
                            <c:if test="${empty orgView}">placeholder="Description"></textarea></c:if>
                        <c:if test="${not empty orgView}">>${orgView.description}</textarea></c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Address:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="address"
                            <c:if test="${empty orgView}">placeholder="Address"</c:if>
                            <c:if test="${not empty orgView}">value="${orgView.address}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">City:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="city"
                            <c:if test="${empty orgView}">placeholder="City"</c:if>
                            <c:if test="${not empty orgView}">value="${orgView.city}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">State:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="state"
                            <c:if test="${empty orgView}">placeholder="State"</c:if>
                            <c:if test="${not empty orgView}">value="${orgView.state}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Phone:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="phone"
                            <c:if test="${empty orgView}">placeholder="Phone"</c:if>
                            <c:if test="${not empty orgView}">value="${orgView.phone}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Email:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="email"
                            <c:if test="${empty orgView}">placeholder="Email"</c:if>
                            <c:if test="${not empty orgView}">value="${orgView.email}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Website:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="website"
                            <c:if test="${empty orgView}">placeholder="Website"</c:if>
                            <c:if test="${not empty orgView}">value="${orgView.website}"</c:if> />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" style="text-align: left">Superheros  /villains:</label>
                        <div class="col-md-9">
                            <select multiple="multiple" class="form-control" name="heroVillain">
                            <c:forEach var="heroVillain" items="${heroVillains}">
                                <c:choose>
                                    <c:when test="${orgView.heroVillains.contains(heroVillain)}">
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
                               <c:if test="${not empty orgView}">value="Edit Organization" </c:if>
                               <c:if test="${empty orgView}">value="Add Organization"</c:if> />
                        </div>
                    </div>
                <c:if test="${not empty orgView}">
                    <div class="form-group">
                        <div class="col-md-offset-3 col-md-9">
                            <input type="submit" formaction="${pageContext.request.contextPath}/cancelEditOrganization"
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
