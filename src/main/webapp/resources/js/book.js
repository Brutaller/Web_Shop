$(document).ready(function () {
    $("#js-addbook").on("click", function () {
        addBook();
    });

    $(document).on('click', '#js-minus', function () {
        var i = Number($(this).parent().find('input').val());
        if (i>0) {
            $(this).parent().find('input').val(i - 1);
            sum = Number(($('#basket-sum').text()).replace(',',''));
            bookPrice = Number($(this).parent().parent().find('#js-basket-price').text());
            $('#basket-sum').text(sum - bookPrice);
        }
    });

    $(document).on('click', '#js-plus', function () {
        var i = Number($(this).parent().find('input').val());
        $(this).parent().find('input').val(i + 1);
        sum = Number(($('#basket-sum').text()).replace(',', ''));
        bookPrice = Number($(this).parent().parent().find('#js-basket-price').text());
        $('#basket-sum').text(sum + bookPrice);
    });

    var inputNum;
    $(document).on('focus', '#js-inp', function(){
        inputNum = Number($(this).val());
    });

    $(document).on('input', '#js-inp', function(){
        if ($(this).val().match('[^0-9]')){
            $(this).val(inputNum);
        }else {
            currentNum = $(this).val();
            sum = Number(($('#basket-sum').text()).replace(',', ''));
            bookPrice = Number($(this).parent().parent().find('#js-basket-price').text());
            sum = sum - (inputNum * bookPrice) + (currentNum * bookPrice);
            inputNum = currentNum;
            $('#basket-sum').text(sum);
        }
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
            //updateBasket(userId);
        }
    })
}


//function updateBasket(id) {
//    $.ajax({
//        url:"basket/getAll/"+id,
//        type:"GET",
//        dataType: "html",
//        success: function(data) {
//            $("#js-items").html(data);
//        }
//    })
//}