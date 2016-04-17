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


    <div class="book-list col-lg-7 candara mynavbar alo" id="right">
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
                        <#assign sum = 0/>
                        <#list items as item>
                            <#assign sum = sum + item.price/>
                            <tr>
                                <td>${item_index + 1}</td>
                                <td><a class="mya" href="/books/${item.book_id}">${item.title}</a></td>
                                <td>${item.author}</td>
                                <td id="js-basket-price">${item.price}</td>
                                <td id="js-num">
                                    <button id="js-minus" style="color: #000" type="button">-</button>
                                    <input type="text" id="js-inp" style="color: #000" size="3" maxlength="3" value="1">
                                    <button id="js-plus" style="color: #000" type="button">+</button>
                                </td>
                                <td>
                                    <a href="" onclick="deleteBook(${item.id}, ${user.id})">
                                        <span class="glyphicon glyphicon-trash"></span>
                                    </a></td>
                            </tr>
                        </#list>
                    </div>

                    </tbody>
                </table>
                <button class="btn btn-default" type="button">Купить все из корзины</button>
                <h1>Итого: <div id="basket-sum">${sum}</div></h1>
            <#else>
                <h2>Ваша корзина пуста!</h2>
            </#if>
        </div>
    </div>
</div>
</#macro>

<@main title="Корзина" customScripts = ["/resources/js/book.js"]/>