<!DOCTYPE html>
<html>
<head>
    <title>FlowerShop</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #F9F9F9;
            color: #333;
        }

        h1 {
            font-size: 2.5em;
            text-align: center;
            color: #5B3F8D;
        }

        h4 {
            font-size: 2em;
            color: #5B3F8D;
        }

        img {
            border-radius: 10px;
            margin: 10px 0;
        }

        .product-info {
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 20px;
            background-color: #ffffff;
            margin-bottom: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        b {
            font-weight: bold;
        }

        input[type="submit"] {
            background-color: #5B3F8D;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 150px;
            margin-top: 10px;
            font-size: 1em;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #4E2F6D;
        }

        #notification {
            display: none;
            position: fixed;
            top: 20px;
            right: 20px;
            padding: 10px;
            background-color: green;
            color: white;
            border-radius: 5px;
            z-index: 1000;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>
<h1>FlowerShop</h1>
<hr>
<h4>Подробная информация о товаре</h4>

<div class="product-info">
    <#list images as img>
        <img src="/images/${img.id}" height="200px" alt="Изображение товара"/><br>
    </#list>
    <b>Название товара:</b> ${product.title}<br>
    <b>Описание товара:</b> ${product.description}<br>
    <b>Цена товара:</b> ${product.price} руб.<br>
    <b>Поставщик:</b> ${product.supplier}<br>
</div>


<form id="addToCartForm-${product.id}" action="/product/add-to-cart/${product.id}" method="post" onsubmit="showNotification(event)">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Добавить в корзину"/>
</form>

<form action="/cart" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Содержимое корзины"/>
</form>

<form action="/product/delete/${product.id}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Удалить товар"/>
</form>

<!-- Уведомление -->
<div id="notification">
    Товар добавлен в корзину!
</div>

<script>
    function showNotification(event) {
        event.preventDefault();

        const notification = document.getElementById("notification");
        notification.style.display = "block";

        setTimeout(() => {
            notification.style.display = "none";
        }, 3000);

        event.target.submit();
    }
</script>
</body>
</html>