<#include "main-template.ftl"/>
<#macro m_body>

<div class="pad alo col-lg-5 col-lg-offset-3" xmlns="http://www.w3.org/1999/html">
<div class="candara">
    <h2>Вход</h2>
    <form action="/login/process" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Логин</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Логин" name="username">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Пароль</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Пароль" name="password">
        </div>
        <#if error??>
            <p>Неправильный логин или пароль</p>
        </#if>
        <center><button type="submit" class="btn btn-default">Submit</button></center>
    </form>
</div>
</div>

</#macro>
<@main title="Логин"/>