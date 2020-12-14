<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Superhero Sightings Home</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center">Superhero Sightings</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/sightings">Sightings</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/herovillains">Superheros / Supervillains</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/organizations">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/locations">Locations</a></li>
                </ul>
            </div>
            <h3 style="text-align: center">Home</h3>
            <div class="col-md-12">
                <h4 style="text-align: center">About Superhero Sightings</h4>
                <p>With the rising popularity of superhero movies there has been a heightened awareness of superheroes in our midst.
                    The frequency of superhero (and supervillain) sightings is increasing at an alarming rate.  Given this development,
                    the Hero Education and Relationship Organization (HERO) has decided to develop a web application Superhero Sightings.
                    Superhero Sightings is a place where you can keep track of recent sightings of you favorite superhero or
                    supervillain.  You can view, add, edit and delete superheros, supervillains, organizations, locations
                    and sightings.
            </div>
            <br />
            <div>
                <h4 style="text-align: center">Last Ten Sightings</h4>
                <table class="table table-hover">
                    <tr>
                        <th width="10%">Date</th>
                        <th width="15%">Location Name</th>
                        <th width="15%">Address</th>
                        <th width="10%">City</th>
                        <th width="5%">State</th>
                        <th width="45%">Superheros / Villains</th>
                    </tr>
                    <c:forEach var="sighting" items="${sightings}">
                        <tr>
                            <td>${sighting.date}</td>
                            <td>${sighting.location.name}</td>
                            <td>${sighting.location.address}</td>
                            <td>${sighting.location.city}</td>
                            <td>${sighting.location.state}</td>
                            <td>
                                <c:forEach var="heroVillain" items="${sighting.heroVillains}">
                                    ${heroVillain.name}.
                                </c:forEach>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

