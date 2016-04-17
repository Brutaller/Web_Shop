<#if items??>
<h2>Ваша корзина:</h2>
<table class="table">
    <thead>
    <tr>
        <th>№</th>
        <th>Название</th>
        <th>Автор</th>
        <th>Цена</th>
    </tr>
    </thead>
    <tbody>
        <#list items as item>
            <tr>
                <td>${item_index + 1}</td>
                <td><a class="mya" href="/books/${item.book_id}">${item.title}</a></td>
                <td>${item.author}</td>
                <td>${item.price} rub</td>
                <td>
                    <a href="" onclick="deleteBook(${item.id}, ${user.id})">
                        <span class="glyphicon glyphicon-trash"></span>
                    </a></td>
            </tr>
        </#list>
    </tbody>
</table>
<#else>
<h2>Ваша корзина пуста!</h2>
</#if>