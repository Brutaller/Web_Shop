<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>
<#macro m_body>

<div class="pad alo col-lg-5 col-lg-offset-3">
    <div class="candara form" xmlns="http://www.w3.org/1999/html">
        <@sf.form action="/registration" method="post" modelAttribute="userform">
            <h2>Регистрация</h2>
            <div class="form-group">
                <label for="username">Логин</label>
                <@sf.input path="username" id="username" cssClass="form-control" placeholder="Логин"/>
                <@sf.errors path="username"/>
            </div>
            <div class="form-group">
                <label for="password">Пароль</label>
                <@sf.input path="password" id="password" cssClass="form-control" placeholder="Пароль"/>
                <@sf.errors path="password"/>
            </div>
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
            <center><button type="submit" class="btn btn-default">Готово</button></center>
        </@sf.form>
    </div>
</div>

</#macro>
<@main title="Главная"/>