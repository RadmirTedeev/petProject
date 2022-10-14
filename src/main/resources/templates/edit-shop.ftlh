<#import "spring.ftl" as spring/>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>Добавление Нового Магазина</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <br>
    <h3>Введите данные магазина</h3>
    <form method="POST" name="edit-shop" enctype="multipart/form-data" class="form-horizontal">
        <input type="hidden" name="s_id" id="s_id" value="${(shop.id)!0?c}">

        <div style="margin-bottom: 25px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input name="name" id="name" class="form-control" placeholder="Название магазина" required autofocus value="${(shop.name)!}"/>
        </div>

        <div style="margin-bottom: 25px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input name="address" id="address" class="form-control" placeholder="Адрес магазина" required autofocus value="${(shop.address)!}"/>
        </div>

        <div style="margin-top: 10px" class="form-group">
            <div class="col-sm-6 controls">
                <a href="<@spring.url '/shops'></@spring.url>" class="btn btn-secondary">Назад</a>
                <button type="submit" class="btn btn-success">Готово</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>