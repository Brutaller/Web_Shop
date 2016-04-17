<#include "main-template.ftl"/>
<script> var num = 0;</script>


<#macro m_body>
<div  class="alo mynavbar" id="columns">

    <div class="col-lg-2 col-md-2 col-sm-3 col-lg-offset-2 alo mynavbar" id="basket">
        <#if user?? >
            <h3>Профиль</h3>
            <div>Логин: ${user.username}</div>
            <div>Имя: ${user.name}</div>
            <div>Фамилия: ${user.surname}</div>
            <br>
            <br>

            <div class="btns">
                <center>
                    <a href="/logout" class="btn btn-default">Выйти</a>
                </center>
            </div>

        </#if>
    </div>


    <div class="book-list col-lg-6 candara mynavbar alo" id="right">
        <div id="js-items">
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
                    <div id="js-items">
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
                    </div>

                    </tbody>
                </table>
            <#else>
                <h2>Ваша корзина пуста!</h2>
            </#if>
        </div>
    </div>
</div>
</#macro>

<@main title="Корзина" customScripts = ["/resources/js/book.js"]/>