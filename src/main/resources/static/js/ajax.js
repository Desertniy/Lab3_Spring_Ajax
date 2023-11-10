
function getProperties() {
    $.ajax({
        url: 'https://localhost:9090/property',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#table_of_objects').find('tr:gt(0)').remove();
            data.forEach(function (property) {
                $('<tr>').append($('<td>').text(property.address))
                .append($('<td>').text(property.monthlyRent))
                .append($('<td>').text(property.price))
                .appendTo('#table_of_objects');
                });
            },
        error: function (error) {
            console.error('Ошибка при получении списка объектов: ' + error.responseText);
        }
    });
}

$('#add_object').on('submit', function (e) {
    var address = $('#addres_add').val();
    var montlyRent = $('#rental_period_add').val();
    var price = $('#price_add').val();

    var propertiesData = {
        address: address,
        monthlyRent: montlyRent,
        price: price
    };

    $.ajax({
        url: 'https://localhost:9090/property',
        type: 'POST',
        headers: {'X-XSRF-TOKEN': $("meta[name='_csrf']").attr("content")},
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(propertiesData),
        success: function (response) {
            alert('Успешное добавление объекта!');
            $('#addres_add').val('');
            $('#rental_period_add').val('');
            $('#price_add').val('');
            getProperties();
        },
        error: function (error) {
            $('#addres_add').val('');
            $('#rental_period_add').val('');
            $('#price_add').val('');
        }
    });
    e.preventDefault();
});


$('#del_obj').on('submit', function (e) {
    var street = $('#addres_del').val();
    $.ajax({
        url: 'https://localhost:9090/property',
        type: 'DELETE',
        headers: {'X-XSRF-TOKEN': $("meta[name='_csrf']").attr("content")},
        contentType: 'application/json',
        data: JSON.stringify({address: street}),
        success: function () {
            alert('Объект успешно удален: ');
            $('#addres_del').val('');
            getProperties();
        },
        error: function (xhr) {
            $('#addres_del').val('');
        }
    });
    e.preventDefault();
});

$('#get_obj').on('submit', function (e) {
    var street = $('#addres_get').val();
    console.log(street)
    $.ajax({
        url: 'https://localhost:9090/property/' + street,
        type: 'GET',
        dataType: 'json',
        success: function (response, xhr) {
            alert('Объект успешно найден');
            $('#addres_get').val(response.address + ' ' + response.monthlyRent + ' ' + response.price);
        },
        error: function (xhr) {
            $('#addres_get').val('');
        }
    });
    e.preventDefault();
});

$('#put_obj').on('submit', function (e) {
    var address = $('#addres_put').val();
    var montlyRent = $('#rental_period_put').val();
    var price = $('#price_put').val();

    var propertiesData = {
        address: address,
        monthlyRent: montlyRent,
        price: price
    };


    $.ajax({
        url: 'https://localhost:9090/property',
        type: 'PUT',
        headers: {'X-XSRF-TOKEN': $("meta[name='_csrf']").attr("content")},
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(propertiesData),
        success: function (response) {
            alert('Изменения вступили в силу! ');
            $('#addres_put').val('');
            $('#rental_period_put').val('');
            $('#price_put').val('');
            getProperties();
        },
        error: function (xhr) {
        }
    });
    e.preventDefault();
});

$(document).ready(function(){
    getProperties();
});