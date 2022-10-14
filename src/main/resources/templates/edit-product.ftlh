<#import "spring.ftl" as spring/>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>Список Продуктов</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <br>
    <h3 class="text-center">${shop.name}</h3>
    <br>
    <h3 class="text-center">Данные продукта</h3>
    <form method="POST" name="edit-product" enctype="multipart/form-data" class="form-horizontal">
        <input type="hidden" name="p_id" id="p_id" value="${(product.id)!0?c}">

        <div style="margin-bottom: 25px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input name="name" id="name" class="form-control" placeholder="Наименование продукта" required autofocus
                   value="${(product.name)!}"/>
        </div>

        <div style="margin-bottom: 25px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input name="price" id="price" class="form-control" placeholder="Цена" required autofocus
                   value="${(((product.price)!0)/100)?string['0.##;; roundingMode=halfUp']}"/>
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