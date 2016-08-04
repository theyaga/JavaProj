<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Display</title>
</head>
<style>
.hidden{display:none;}
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>  
<script type="text/javascript">
$(document).ready(function() {
var table = document.getElementsByTagName("table")[0];
var tbody = table.getElementsByTagName("tbody")[0];
tbody.onclick = function (e) {
    e = e || window.event;
    var data = [];
    var target = e.srcElement || e.target;
    while (target && target.nodeName !== "TR") {
        target = target.parentNode;
    }
    if (target) {
        var cells = target.getElementsByClassName("hidden");
        for (var i = 0; i < cells.length; i++) {
            data.push(cells[i].innerHTML);
        }
    }
    var id=data;
    //alert(id);
       $.ajax({
     type : "Get", 
     url : "display.html", 
     data : "&Id=" + id ,
     
     success : function(response) {
      $("html").empty();
      $("html").append(response);
     },
     // error : function(e) {
     // alert('Error: ' + e); 
     //}
    });
};

});
</script>
<body>

		<table class="table table-striped" border="2px" >
			<thead>
				<tr>

					<th>First Name</th>
					<th>Last Name</th>
					<th>Mobile Number</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty student}">
					<tr>
						<td colspan="8">No student to Display</td>
					</tr>
				</c:if>
				<c:if test="${not empty student}">

					<c:forEach items="${student}" var="student">
						<tr >
						<td class="hidden" >${student.id}</td>
							<td><a href="#">${student.firstName}</a></td>
							<td>${student.lastName}</td>
							<td>${student.mobile}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div id="displayContent"></div>
</body>
</html>