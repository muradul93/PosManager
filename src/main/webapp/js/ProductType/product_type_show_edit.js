/**
 * Created by  on 3/2/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
function sendFromData() {

    var isError=false;

    console.log($.trim($('#product_type_name').val()));

    if(!$.trim($('#product_type_name').val())){
        var unitnameErrorField =$("#product_type_name_error").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }

  if(!isError) {
      // $('#product_type_active').val();

      var item = {};
      item ["id"] = $('#product_type_id').val();
      item ["name"] = $.trim($('#product_type_name').val());
      item ["description"] = $('#product_type_description').val();

      if ($('#product_type_active').is(":checked")) {
          item ["productTypeActive"] = true;
      } else {

      item ["productTypeActive"] = false;
    }
      console.log("Rsult sending to server:");
      console.log(JSON.stringify(item));
      sendDataToserver(item);
  }
}
    
function sendDataToserver(item) {
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: 'POST',
            url: _ctx+ 'productType/editshow',
            dataType : 'json',
            data : JSON.stringify(item),
            beforeSend: function(xhr) {

                xhr.setRequestHeader(header, token);
            },
            success : function(callback) {
                console.log(callback)
                if (callback) {
                    window.location.replace("/productType/allType");
                }else{
                    var unitnameErrorField =$("#product_type_name_error").text("Same Name Exist");
                    unitnameErrorField.show();
                }


                // alert("success");
            },
            error : function(){

                alert("error");
            }
        });
}


