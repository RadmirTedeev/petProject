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
<div class="container">
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th class="text-center d-none d-md-table-cell">Название магазина</th>
            <th class="text-center d-none d-md-table-cell">Адрес</th>
        </tr>
        </thead>
        <tbody>
        <#list shops as shop>
            <tr>
                <td class="text-center d-none d-md-table-cell">${shop.name}</td>
                <td class="text-center d-none d-md-table-cell">${shop.address}</td>
                <td><a href="<@spring.url '/shops/products'></@spring.url>/${shop.id?c}" class="btn btn-primary">Посмотреть товары</a></td>
                <td><a href="<@spring.url '/shops/edit'></@spring.url>/${shop.id?c}" class="btn btn-warning">Изменить</a></td>
                <td><a href="<@spring.url '/shops/delete'></@spring.url>/${shop.id?c}" class="btn btn-danger">Удалить</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <div style="margin-bottom: 5px">
        <a href="<@spring.url '/shops/add'></@spring.url>" class="btn btn-success">Добавить магазин</a>
    </div>
    <form action="@{/logout}" method="post">
        <input type="submit" value="Выйти"/>
    </form>
</div>
</body>
</html>