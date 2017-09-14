<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Market</title>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
</head>
<body>
<style>
    .kilo{
        display: none;
    }
</style>

<form action="AddToBasketServlet" method="post">
    <p><h3>ТОВАР</h3></p>

    <div id="select" onchange=" if ($('#select option:selected').val() == 'C') {
        $('.kilo').show();
    };if ($('#select option:selected').val() != 'C') {
        $('.kilo').hide();
    };">
        <select name="product">
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
            <option value="E">E</option>
        </select>
    </div>
    <br>
    <div class="kilo">
        <input name="inputKg" type="text" id="putKilo">
        <label for="putKilo">кг</label><br>
    </div>


    <input type="submit" value="Добавить">
</form>
<form action="FinalBasketServlet" method="post">
    <input type="submit" value="Расчитать">
</form>
</body>
</html>