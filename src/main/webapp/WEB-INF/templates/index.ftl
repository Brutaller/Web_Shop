<#include "main-template.ftl"/>


<#macro m_body>


<div class="category row">
    <div class="col-lg-2 col-md-2 col-sm-3 alo mynavbar" id="category-div">
        <h2>Категории</h2>
        <div class="list-group table-of-contents">
            <!--<a class="list-group-item" href="/category/dystopia">Антиутопия</a>
            <a class="list-group-item" href="/category/detective">Детектив</a>
            <a class="list-group-item" href="/category/child">Детская литература</a>
            <a class="list-group-item" href="/category/science_fiction">Научная фантастика</a>
            <a class="list-group-item" href="/category/novel">Роман</a>
            <a class="list-group-item" href="/category/horror">Ужасы</a>
            <a class="list-group-item" href="/category/fantasy">Фентези</a>-->

            <#list categories as category>
                <a class="list-group-item" href="/category/${category.id}">${category.name}</a>
            </#list>

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

                        <#if "${user.role}" == "ROLE_USER">
                            <a href="/basket/${user.id}" class="btn btn-default">Корзина</a>
                        <#else>
                            <a href="/add" class="btn btn-default">Добавить книгу</a>
                        </#if>
                    </center>
                </div>

            </#if>

        </div>
    </div>


    <div class="logo alo col-lg-10">
        <img src="/resources/image/logo.jpg" alt="альтернативный текст" width="400">
    </div>
    <div class="book-list col-lg-10">
        <h2>${category}:</h2>
        <#if books??>
            <#list books as book>

                <div class="post panel panel-default">
                    <div class="panel-body post-body">
                        <table width="100%" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="leftcol"><img src="${book.imagePath}" alt="${book.title}" width="130"
                                                         height="150" align="left"
                                                         vspace="5" hspace="5"></td>
                                <td class="rightcol" valign="top">
                                    <h2><a class="mya" href="/books/${book.id}">${book.title}</a></h2>
                                    <div>
                                        <span class="label"> Автор: </span>
                                        <span> ${book.author}</span>
                                    </div>
                                    <div>
                                        <span class="label"> Год: </span>
                                        <span> ${book.year}</span>
                                    </div>
                                    <div>
                                        <span class="label"> Жанр: </span>
                                        <span> ${book.category}</span>
                                    </div>

                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="panel-footer post-footer">
                    ${book.price}₽
                    </div>
                </div>
            </#list>
        </#if>


    </div>


</div>



</#macro>

<@main title="Главная" customScripts=[]/>