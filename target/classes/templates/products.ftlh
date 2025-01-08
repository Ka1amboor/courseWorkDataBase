<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FlowerShop</title>
    <style>
        /* Общий стиль */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #EAD6F1;
            color: #333;
        }

        header {
            background-color: #EE82EE;
            color: white;
            padding: 1em 0;
            text-align: center;
        }

        h1 {
            margin: 0;
        }

        h3, h4 {
            margin: 20px;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            background: white;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        /* Кнопки */
        .button {
            background-color: #EE82EE;
            color: white;
            padding: 10px 20px;
            margin: 5px 0;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
        }

        .button:hover {
            background-color: #EE82EE;
        }

        .logout-button {
            float: right;
        }

        /* Поле поиска */
        form {
            margin-bottom: 20px;
        }

        input[type="text"] {
            padding: 10px;
            margin-top: 10px;
            margin-right: 5px;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #EE82EE;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }

        input[type="submit"]:hover {
            background-color: #EE82EE;
        }

        /* Список продуктов */
        .product {
            background: #f4f4f4;
            margin: 20px 0;
            padding: 15px;
            border-radius: 5px;
            border: 1px solid #ddd;
        }

        .product p {
            margin: 0;
        }

        /* Ссылки */
        a {
            color: #EE82EE;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        footer {
            background-color: #EE82EE;
            color: white;
            text-align: center;
            padding: 1em 0;
            margin-top: 1em;
        }
    </style>
</head>
<body>

<header>
    <h1>FlowerShop</h1>
</header>
<h1></h1>
<div class="container">
    <#if user.email??>
        <h3>Добро пожаловать, <i>${user.name}</i>!</h3>
        <form action="/logout" method="post" style="display: inline;">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input class="button logout-button" type="submit" value="Выйти">
        </form>

        <#if user.isAdmin()>
            <a href="/admin" class="button">Панель администратора</a>
        </#if>

    <#else>
        <a href="/login" class="button">Войти</a>
    </#if>

    <hr>

    <h4>Все товары</h4>
    <form action="/" method="get">
        <label>Поиск товара по названию:</label><br>
        <input type="text" name="title" placeholder="Введите название товара...">
        <input type="submit" value="Поиск">
    </form>

    <#list products as product>
        <div class="product">
            <p><b>${product.title}</b> — ${product.price} руб.</p>
            <img src="/images/${product.images[0].id}" alt="Изображение ${product.title}">
            <p><a href="/product/${product.id}" class="button">Просмотр товара</a></p>
        </div>
    <#else>
        <h3>Товаров нет.</h3>
    </#list>
</div>

<footer>

</footer>

</body>
</html>