<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>


<#macro m_body>

<form method="POST" action="add" enctype="multipart/form-data">

    <div class="candara">
        <h2>Добавить книгу</h2>

        <div class="form-group">
            <label for="title">Название</label><br>
            <input type="text" name="title" id="title">
        </div>
        <div class="form-group">
            <label for="author">Автор</label><br>
            <input type="text" name="author" id="author">
        </div>
        <div class="form-group">
            <label for="year">Год</label><br>
            <input type="text" name="year" id="year">
        </div>
        <div class="form-group">
            <label for="about">Описание</label><br>
            <input type="text" name="about" id="about">
        </div>
        <div class="form-group">
            <label for="price">Цена</label><br>
            <input type="text" name="price" id="price">
        </div>
        <div class="form-group">
            <label for="category">Жанр</label><br>
            <input type="text" name="category" id="category">
        </div>
        <div>
            Обложка: <input type="file" class="btn btn-default" name="file">
            <br/>
        </div>
        <input type="submit" class="btn btn-default" value="Добавить">
    </div>
</form>

</#macro>

<@main title="Главная" customScripts=[]/>