<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
 <h2>Submitted Student Information</h2>
    <table>
        <tr>
            <td>ID :</td>
            <td>${id}</td>
        </tr>
        <tr>
            <td>First Name :</td>
            <td>${firstName}</td>
        </tr>
          <tr>
            <td>Last Name :</td>
            <td>${lastName}</td>
        </tr>
        <tr>
            <td>Contact Number :</td>
            <td>${mobile}</td>
        </tr>
    </table>
</body>
</html>