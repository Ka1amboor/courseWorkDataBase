<!DOCTYPE html>
<html>
<head>
    <title>flowerShop</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #EAD6F1;
            color: #5B3F8D;
            text-align: center;
            padding: 50px;
        }

        h1 {
            font-size: 2.5em;
            margin-bottom: 20px;
        }

        hr {
            border: 1px solid #5B3F8D;
            width: 50%;
            margin: 20px auto;
        }

        h4 {
            font-size: 1.5em;
            margin-bottom: 20px;
        }

        form {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            display: inline-block;
            width: 300px;
        }

        input[type="email"], input[type="password"] {
            width: 100%;
            padding: 10px;
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
            background-color: #EE82EE;
        }

        .register-button {
            margin-top: 15px;
            background-color: #EE82EE; /* Зеленый цвет кнопки регистрации */
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-size: 1em;
            transition: background-color 0.3s;
        }

        .register-button:hover {
            background-color: #EE82EE; /* Более темный зеленый при наведении */
        }

        a {
            display: none; /* Скрываем ссылку на регистрацию, заменяя на кнопку */
        }
    </style>
</head>
<body>
<h1>flowerShop</h1>
<hr>
<h4>Авторизация</h4>
<form action="/login" method="post">
    Эл. почта: <input type="email" name="username" required><br>
    Пароль: <input type="password" name="password" required><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход"/>
    <button type="button" class="register-button" onclick="location.href='/registration'">Зарегистрироваться</button>
</form>
</body>
</html>