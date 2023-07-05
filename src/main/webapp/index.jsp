<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Homework1</title>
</head>
<body>

<form action="survey" method="POST">
    <h2>What gender are you?</h2>
    <label><input type="radio" name="gender" value="male">male</label>
    <label><input type="radio" name="gender" value="female" checked="checked">female</label>
    <br>
    <h2>How old are you?</h2>
    <label><input type="radio" name="age" value="youth">less than 18</label>
    <label><input type="radio" name="age" value="adult" checked="checked">18 and older</label>
    <br>
    <br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
