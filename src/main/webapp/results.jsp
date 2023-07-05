<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Survey Results</title>
</head>
<body>
<h2>Gender:</h2>
<p>Male count: <%= request.getAttribute("maleCount") %></p>
<p>Female count: <%= request.getAttribute("femaleCount") %></p>

<h2>Age:</h2>
<p>Youth count: <%= request.getAttribute("youthCount") %></p>
<p>Adult count: <%= request.getAttribute("adultCount") %></p>

<a href="index.jsp">Take the survey again</a>
</body>
</html>
