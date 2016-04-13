<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<@security.authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
    <@security.authentication property="principal.username" var="username"/>
</@security.authorize>



<#--NAVBAR-->
<nav class="navbar navbar-default navbar-fixed-top mynavbar">
<div class="container-fluid">
    <div class="navbar-header col-md-6 col-md-offset-3">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/">Black Book Store</a>
    </div>

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

<#if username??>


    <ul class="nav navbar-nav navbar-right">
        <li><a href="/logout">Выйти</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right" id="who">
        <li> Вы вошли как <strong>${username}</strong></li>
    </ul>
<#else>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="/registration">Зарегистрироваться</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="/login">Войти</a></li>
    </ul>

</#if>

</div>
</div>
</nav>
