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
    <table class="table table-hover">
        <h3 class="text-center">Список продуктов</h3>
        <#if products?has_content>
            <thead>
            <tr>
                <th class="text-center d-none d-md-table-cell">Наименование</th>
                <th class="text-center d-none d-md-table-cell">Цена</th>
            </tr>
            </thead>
            <tbody>
            <#list products as product>
                <tr>
                    <td class="text-center d-none d-md-table-cell">${product.name}</td>
                    <td class="text-center d-none d-md-table-cell">${(((product.price)!0)/100)?string['0.##;; roundingMode=halfUp']}</td>
                    <td><a href="<@spring.url '/shops/products/edit'></@spring.url>/${shop.id?c}/${product.id?c}"
                           class="btn btn-warning">Изменить</a></td>
                    <td><a href="<@spring.url '/shops/products/delete'></@spring.url>/${shop.id?c}/${product.id?c}"
                           class="btn btn-danger">Удалить</a></td>
                </tr>
            </#list>
            </tbody>
        <#else>
            <div class="text-center">
                <span>Продукты не найдены.</span>
            </div>
        </#if>
    </table>
    <div class="form-group">
        <div class="col-sm-6 controls">
            <a href="<@spring.url '/shops/products/add'></@spring.url>/${shop.id?c}" class="btn btn-success">Добавить продукт</a>
        </div>
        <div style="margin-top: 5px" class="col-sm-6 controls">
            <a href="<@spring.url '/shops'></@spring.url>" class="btn btn-secondary">Назад</a>
        </div>
    </div>
</div>
</body>
</html>