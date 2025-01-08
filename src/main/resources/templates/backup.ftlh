<!DOCTYPE html>
<html>
<head>
    <title>Создание резервной копии</title>
</head>
<body>
<h1>Создание резервной копии базы данных</h1>
<hr>
<#if message??>
    <p style="color: green;">${message}</p>
</#if>
<#if error??>
    <p style="color: red;">${error}</p>
</#if>
<form action="/create" method="post">
    <input type="submit" value="Создать резервную копию"/>
</form>
</body>
</html>