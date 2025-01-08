<!DOCTYPE html>
<html>
<head>
    <title>FlowerShop</title>
</head>
<body>
<h4>Панель администратора</h4>
<table>
    <tr>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Бан</th>
        <th>Редактирование</th>
        <th>Подробная информация</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th>${user.numberPhone}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th>
                <form action="admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Редактирование</a></th>
        </tr>
        <#else>
        <h3>Пользователей нет</h3>
    </#list>
</table>
    <hr>
    <h3>Создать новый товар</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Название букета: <input type="text" name="title"/><br><br>
        Описание букета: <input type="text" name="description"/><br><br>
        Цена букета: <input type="number" name="price"/><br><br>
        Поставщик букета: <input type="text" name="supplier"/><br><br>
        Первая фотография: <input type="file" name="file1"/><br><br>
        Вторая фотография: <input type="file" name="file2"/><br><br>
        Третья фотография: <input type="file" name="file3"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить товар"/>
    </form>
<form action="/create" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Резервная копи базы данных">
</form>


</body>
</html>