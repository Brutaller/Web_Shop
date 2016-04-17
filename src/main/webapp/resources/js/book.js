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

function deleteBook(bookId, userId) {
    $.ajax({
        url: "/deletefrombasket",
        type: "POST",
        data: {
            id: bookId
        },
        success: function(){
            updateBasket(userId);
        }
    })
}

function updateBasket(id) {
    $.ajax({
        url:"basket/getAll/"+id,
        type:"GET",
        dataType: "html",
        success: function(data) {
            $("#js-items").html(data);
        }
    })
}