// $('document').ready(function () {
//
//
//     $('#deleteButton').on('click', function (event) {
//         event.preventDefault();
//         var href = $(this).attr('href');
//         $("#confirmDeleteButton").attr('href', href);
//         $('#deleteModal').modal();
//     });
// });

function edit(v) {
    var href = "/locations/findById/?id=" + v.value;

    jQuery.get(href, function (data, status) {
        $('#idEdit').val(data.id);
        $('#locationNameEdit').val(data.locationName);
    });

    $('#editModal').modal();
}




function deleteRecord(v){
    var href = "/locations/delete/?id=" + v.value;

    $("#confirmDeleteButton").attr('href', href);
    $('#deleteModal').modal();
}