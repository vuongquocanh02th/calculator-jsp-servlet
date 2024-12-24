<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Simple Calculator</title>
</head>
<body>
<h1>Simple calculator</h1>
<form action="${pageContext.request.contextPath}/calculate" method="post">
  <fieldset>
    <legend>Calculator</legend>
    First operand: <input type="number" name="firstOperand" required/><br/>
    Operator:
    <select name="operator">
      <option value="add">Addition</option>
      <option value="sub">Subtraction</option>
      <option value="mul">Multiplication</option>
      <option value="div">Division</option>
    </select><br/>
    Second operand: <input type="number" name="secondOperand" required/><br/>
    <button type="submit">Calculate</button>
  </fieldset>
</form>
</body>
</html>