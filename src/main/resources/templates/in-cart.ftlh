<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FlowerShop</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f9f9f9;
        }
        .product {
            margin: 20px 0;
            padding: 15px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            background: white;
            border-radius: 8px;
            overflow: hidden;
        }
        .product img {
            width: 200px;
            height: auto;
            border-radius: 8px;
            display: block;
        }
        .product-title {
            font-size: 18px;
            font-weight: bold;
        }
        .product a {
            text-decoration: none;
            color: #4CAF50;
            margin-top: 10px;
            display: inline-block;
        }
        .product a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<h1>FlowerShop</h1>
<hr>

<h4>Все товары</h4>

<#list products as product>
    <div class="product">
            <img src="/images/${product.images[0].id}" alt="Изображение ${product.title}"> <!-- Отображаем первое изображение -->

        <p class="product-title">${product.title}</p>
        <p>${product.price} руб.</p>
        <a href="/product/${product.id}">Купить...</a>
    </div>
<#else>
    <h3>Товаров нет</h3>
</#list>

</body>
</html>