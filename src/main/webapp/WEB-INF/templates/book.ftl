<#include "main-template.ftl"/>

<script> var bookid = "${book.id}";
function f() {
    return bookid;
}
</script>
<#macro m_body>

<div class="pad alo col-lg-8 col-lg-offset-2">
    <div class="post panel panel-default">
        <div class="candara form mynavbar">
            <div class="panel-body post-body">
                <table width="100%" cellspacing="0" cellpadding="0">
                    <tr>
                        <td class="leftcol"><img src="${book.imagePath}" alt="${book.title}" width="200" align="left"
                                                 vspace="5" hspace="5"></td>
                        <td class="rightcol" valign="top">
                            <h3>Название: ${book.title}</h3>
                            <h3>Автор: ${book.author}</h3>
                            <h3>Год: ${book.year}</h3>
                            <h3>Жанр: ${book.category.name} </h3>
                        </td>
                    </tr>
                </table>
                <p>${book.about}</p>

            </div>
            <div align="right" class="panel-footer post-footer">
                <span id="result"></span>
            ${book.price} rub
                <a href="/buy?id=${book.id}">Купить</a>
                <button type="submit" id="js-addbook" class="btn btn-default">Добавить в корзину</button>
            </div>

        </div>
    </div>
</div>


</#macro>
<@main title="Книга" customScripts = ["/resources/js/book.js"]/>