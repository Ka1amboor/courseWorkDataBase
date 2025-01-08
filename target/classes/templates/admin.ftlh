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

        h4 {
            font-size: 2em;
            margin-bottom: 20px;
            color: #5B3F8D;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #5B3F8D;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        form {
            margin-bottom: 20px;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #ffffff;
        }

        input[type="text"], input[type="number"], input[type="file"] {
            width: 100%;
            padding: 8px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #5B3F8D;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-size: 1em;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #4E2F6D;
        }

        .no-users {
            text-align: center;
            color: red;
            font-size: 1.2em;
        }
    </style>
</head>
<body>
<h4>Панель администратора</h4>
<table>
    <tr>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Бан</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.email}</td>
            <td>${user.numberPhone}</td>
            <td><#if user.active>true<#else>false</#if></td>
            <td>
                <form action="admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан">
                </form>
            </td>
        </tr>
    </#list>
    <#if (users?size == 0)>
        <tr>
            <td colspan="4" class="no-users">Пользователей нет</td>
        </tr>
    </#if>
</table>

<hr>

<h3>Создать новый товар</h3>
<form id="productForm" action="/product/create" method="post" enctype="multipart/form-data">
    Название букета: <input type="text" name="title" required/><br><br>
    Описание букета: <input type="text" name="description" required/><br><br>
    Цена букета: <input type="number" name="price" required/><br><br>
    Поставщик букета: <input type="text" name="supplier" required/><br><br>
    Первая фотография: <input type="file" name="file1" accept="image/*"/><br><br>
    Вторая фотография: <input type="file" name="file2" accept="image/*"/><br><br>
    Третья фотография: <input type="file" name="file3" accept="image/*"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить товар"/>
</form>
<div id="error-message" style="color: red; font-size: 1.2em; display: none;">
    Пожалуйста, добавьте хотя бы одну фотографию!
</div>
<form action="/create" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Резервная копи базы данных"/>
</form>
<script>
    document.getElementById('productForm').addEventListener('submit', function (event) {
        const file1 = document.querySelector('input[name="file1"]');
        const file2 = document.querySelector('input[name="file2"]');
        const file3 = document.querySelector('input[name="file3"]');

        const hasFile1 = file1 && file1.files.length > 0;
        const hasFile2 = file2 && file2.files.length > 0;
        const hasFile3 = file3 && file3.files.length > 0;

        // Если ни один файл не добавлен
        if (!hasFile1 && !hasFile2 && !hasFile3) {
            event.preventDefault(); // Предотвращаем отправку формы
            const errorMessage = document.getElementById('error-message');
            errorMessage.style.display = 'block'; // Показываем сообщение об ошибке
        } else {
            const errorMessage = document.getElementById('error-message');
            errorMessage.style.display = 'none'; // Скрываем сообщение об ошибке, если файл добавлен
        }
    });
</script>


</body>
</html>