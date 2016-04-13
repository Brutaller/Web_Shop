$(document).ready(function () {
    $("#js-addbook").on("click", function () {
        addBook();
    });
});


function addBook() {
    $.ajax({
        url: "/addtobasket",
        type: "POST",
        data: {
            id: f()
        },
        success: $('#result').text("Книга добавлена в вашу корзину!")
    })
}