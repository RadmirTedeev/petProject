<#import "spring.ftl" as spring/>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>Список магазинов</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="text-center container">
    <h3>Домашняя страница</h3>
    <a href="<@spring.url '/shops'></@spring.url>" class="btn btn-success">Войти на сайт</a>
</div>
</body>
</html>