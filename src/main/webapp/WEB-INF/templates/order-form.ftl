<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>

<#macro m_body>

<div class="book-list col-lg-10">
    <#if book??>
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
    </#if>
</div>

<div class="pad alo col-lg-5 col-lg-offset-3">
    <div class="candara form" xmlns="http://www.w3.org/1999/html">
        <@sf.form action="/buy" method="post" modelAttribute="buyingform">
            <h2>Заполните поля для покупки</h2>
            <div class="form-group">
                <label for="email">E-mail</label>
                <@sf.input path="email" id="email" cssClass="form-control" placeholder="E-mail"/>
                <@sf.errors path="email"/>
            </div>
            <div class="form-group">
                <label for="name">Имя</label>
                <@sf.input path="name" id="name" cssClass="form-control" placeholder="Имя"/>
                <@sf.errors path="name"/>
            </div>
            <div class="form-group">
                <label for="surname">Фамилия</label>
                <@sf.input path="surname" id="surname" cssClass="form-control" placeholder="Фамилия"/>
                <@sf.errors path="surname"/>
            </div>
            <div class="form-group">
                <label for="address">Адрес</label>
                <@sf.input path="address" id="address" cssClass="form-control" placeholder="Адрес"/>
            </div>
            <div class="form-group">
                <label for="postIndex">Почтовый индекс</label>
                <@sf.input path="postIndex" id="postIndex" cssClass="form-control" placeholder="Почтовый индекс"/>
            </div>
            <div class="form-group">
                <label for="phoneNumber">Мобильный номер телефона</label>
                <@sf.input path="phoneNumber" id="phoneNumber" cssClass="form-control" placeholder="Номер телефона"/>
            </div>
            <center><button type="submit" class="btn btn-default">Готово</button></center>
        </@sf.form>
    </div>
</div>

</#macro>
<@main title="Покупка" customScripts = []/>