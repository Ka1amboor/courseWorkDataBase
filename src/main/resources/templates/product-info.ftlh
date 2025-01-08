<!DOCTYPE html>
<html>
<head>
    <title>FlowerShop</title>
    <style>
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
        }
    </style>
</head>
<body>
<h1>flowerShop</h1><hr>
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/images/${img.id}" height="200px"/><br><br>
</#list>
<b>Название товара:</b> ${product.title}<br><br>
<b>Описание товара:</b> ${product.description}<br><br>
<b>Цена товара:</b> ${product.price} руб.<br><br>
<b>Поставщик:</b> ${product.supplier}<br><br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Удалить товар"/>
</form>

<form id="addToCartForm-${product.id}" action="/product/add-to-cart/${product.id}" method="post" onsubmit="showNotification(event)">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Добавить в корзину"/>
</form>
<form action="/cart" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Содержимое корзины"/>
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