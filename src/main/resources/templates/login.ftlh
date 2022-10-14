<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<form name="login_form" method="POST" action="/process_login">
    <label for="username">Введите имя пользователя: </label>
    <input type="text" name="username" id="username">
    <br/>
    <label for="password">Введите пароль: </label>
    <input type="text" name="password" id="password">
    <br/>
    <input type="submit" value="Login">
</form>
</body>
</html>