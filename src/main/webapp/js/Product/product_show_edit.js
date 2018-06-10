/**
 * Created by  on 3/2/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
function sendFormData() {

    var isError=false;

    console.log($.trim($('#product_name').val()));

    if(!$.trim($('#product_name').val())){
        var unitnameErrorField =$("#product_errors").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }

  if(!isError) {

      // $("#product_id").val(id)
      // $("#product_name").val(name)
      // $("#product_sku_code").val(code)
      // $("#product_mou_id").val(organizationtype)
      // $("#sku_quntity").val(adreess)
      // $("#product_type_id").val(contact)
      // $("#product_active").val(contact)
      // $("#image_id").val(contact)

      var item = {};
      item ["id"] = $('#product_id').val();
      item ["productName"] = $.trim($('#product_name').val());
      item ["skuCode"] = $('#product_sku_code').val();
      item ["mouId"] = $('#product_mou_id').val();
      item ["skuQty"] = $('#sku_quntity').val();
      item ["productTypeId"] = $('#product_type_id').val();
      // item ["productActive"] = $('#product_active').val();
      item ["imageId"] = $('#image_id').val();

      if ($('#product_active').is(":checked")) {
          item ["productActive"] = true;
      } else {

          item ["Active"] = false;
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
            url: _ctx+ 'Product/editshow',
            dataType : 'json',
            data : JSON.stringify(item),
            beforeSend: function(xhr) {

                xhr.setRequestHeader(header, token);
            },
            success : function(callback) {
                console.log(callback)
                if (callback) {
                    window.location.replace("/Product/allProduct");
                }else{
                    var unitnameErrorField =$("#product_errors").text("Same Name Exist");
                    unitnameErrorField.show();
                }


                // alert("success");
            },
            error : function(){

                alert("error");
            }
        });
}


