/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
   $("#slidebarCollapse").on('click',function(){
   $("#slidebar").toggleClass('active') ;   
   });
});
//xử lý đọc ảnh
$(document).on("click", ".browse", function() {
  var file = $(this).parents().find(".file");
  file.trigger("click");
});
$('input[type="file"]').change(function(e) {
  var fileName = e.target.files[0].name;
  $("#file").val(fileName);

  var reader = new FileReader();
  reader.onload = function(e) {
    // get loaded data and render thumbnail.
    document.getElementById("preview").src = e.target.result;
  };
  // read the image file as a data URL.
  reader.readAsDataURL(this.files[0]);
});

//dọc url
$('.table #modal').on('click', function(event){
    event.preventDefault();
    var href=$(this).attr('href');
    $('#deleteModal #delRef').attr('href', href);
    $("#deleteModal").modal();
});

//chi cho nhap so
 function onlyNumberKey(evt) {
          
        var ASCIICode = (evt.which) ? evt.which : evt.keyCode;
        if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
            return false;
        return true;
    }
   $(document).ready(function() {
    $('.js-example-basic-single').select2();
});

function loadCreateModal(){
    $('#createModal').modal('show');
}
//$('document').ready(function(){
//    $('.table .btn').on('click',function(event){
//        event.preventDefault();
//        
//        $.get(href, function(prescription)){
//            ${presID}
//        }
//    });
//});
