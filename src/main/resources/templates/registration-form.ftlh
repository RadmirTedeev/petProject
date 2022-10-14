<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
<form name="registration_form" method="POST" action="/process_registration">
    <label for="username">Введите имя пользователя: </label>
    <input type="text" name="username" id="username">
    <br/>
    <label for="password">Введите пароль: </label>
    <input type="text" name="password" id="password">
    <br/>
    <label for="email">Введите адрес электронной почты: </label>
    <input type="text" name="email" id="email">
    <br/>
    <input type="submit" value="Sign up">
</form>
</body>
</html>