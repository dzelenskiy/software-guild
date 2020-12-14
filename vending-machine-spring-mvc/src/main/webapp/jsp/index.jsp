<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body{
                background-color: #29293d;
            }
            h1{
                color: #9999ff;
            }
            hr{
                border: solid 1px;
                border-color: #0040ff;
            }
            #mainDiv{
                background-color: #d0d0e1;
                border: solid 4px;
                border-color: white;
                border-radius: 10px;
            }
            #displayDiv{
                background-color: #e6e6ff;
                border: solid 1px;
                border-color: #0040ff;
                border-radius: 8px;
                margin-top: 3%;
            }
            .color{
                background-color: white;
                border: solid 1px;
                border-radius: 8px;
                border-color: white;
                color: #00004d;
                margin: 2%;
            }
            .color:hover {
                background-color: #ccccff;
                border: solid 1px;
                border-radius: 8px;
                border-color: #ffffe6;
                color: #0040ff;
                margin: 2%;
            }
            .space{
                margin: 2%;
            }

        </style>
    </head>
    <body>
        <h1 class="text-center">Vending Machine</h1><hr />
        <div id = "mainDiv" class="container">
            <div id="itemsDiv" class="col-md-9" style="margin-right: -7%">
                <c:forEach var="currentItem" items="${itemList}">
                    <form action="${pageContext.request.contextPath}/selectItem" method="POST">
                        <button id="item${currentItem.id}Div" class="col-md-3 color" type="submit">
                            <input type="hidden" name="id" value="${currentItem.id}" />
                            <input type="hidden" name="name" value="${currentItem.name}" />
                            <input type="hidden" name="price" value="${currentItem.price}" />
                            <input type="hidden" name="quantity" value="${currentItem.quantity}" />
                            <p id="item${currentItem.id}Id" class="text-left itemId">${currentItem.id}</p>
                            <p id="item${currentItem.id}Name" class="text-center itemName">${currentItem.name}</p><br />
                            <p id="item${currentItem.id}Price" class="text-center itemPrice">$${currentItem.price}</p><br /><br />
                            <p id="item${currentItem.id}Quantity" class="text-center itemQuantity">Quantity Left: ${currentItem.quantity}</p>
                        </button>
                    </form>
                </c:forEach>
            </div>
            <div id="displayDiv" class="col-md-3">
                <div id="cashInDiv" class="col-md-12 text-center space" style="padding: 0%">
                    <h3>Total $ In</h3>
                    <input id="cashDisplay" type="text" class="form-control" placeholder="$${cash}" readonly />
                    <div class="col-md-6">
                        <form action="${pageContext.request.contextPath}/inputCash" method="POST">
                            <button id="dollarButton" type="submit" class="btn btn-default space">
                                Add Dollar
                                <input type="hidden" name="cash" value="1.00" />
                            </button>
                        </form>
                        <form action="${pageContext.request.contextPath}/inputCash" method="POST">
                            <button id="quarterButton" type="submit" class="btn btn-default space">
                                Add Quarter
                                <input type="hidden" name="cash" value="0.25" />
                            </button>
                        </form>
                    </div>
                    <div class="col-md-6">
                        <form action="${pageContext.request.contextPath}/inputCash" method="POST">
                            <button id="dimeButton" type="submit" class="btn btn-default space">
                                Add Dime
                                <input type="hidden" name="cash" value="0.10" />
                            </button>
                        </form>
                        <form action="${pageContext.request.contextPath}/inputCash" method="POST">
                            <button id="nickelButton" type="submit" class="btn btn-default space">
                                Add Nickel
                                <input type="hidden" name="cash" value="0.05" />
                            </button>
                        </form>
                    </div>
                </div>
                <div id="messagesDiv" class="col-md-12 text-center space" style="border-top: solid 1px; border-bottom: solid 1px; border-color: #0040ff; padding: 0%">
                    <h3 style="margin-top: 3%">Messages</h3>
                    <form action="${pageContext.request.contextPath}/vendItem" method="POST">
                        <input id="messageDisplay" type="text" class="form-control space" placeholder="${message}" readonly />
                        <label for="itemDisplay" class="control-label space" style="display: inline-block; max-width: 30%">Item: </label>
                        <input id="itemDisplay" type="text" class="form-control" style="display: inline-block; max-width: 70%" placeholder="${name}"readonly />
                        <button id="purchaseButton" type="submit" class="btn btn-default space" style="padding: 5%">Make Purchase</button>
                    </form>
                </div>
                <div id="changeDiv" class="col-md-12 text-center space" style="padding: 0%">
                    <h3 style="margin-top: 0%">Change</h3>
                    <form action="${pageContext.request.contextPath}/getChange" method="POST">
                        <button id="returnChangeButton" type="submit" class="btn btn-default space">Return Change</button>
                        <textarea id="changeDisplay" type="textarea" class="form-control" rows="5" placeholder="${change}" readonly></textarea>
                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

