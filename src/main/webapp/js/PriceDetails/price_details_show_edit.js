/**
 * Created by  on 3/2/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
function sendFormData() {

    var isError=false;

    //console.log($.trim($('#product_name').val()));

    // if(!$.trim($('#product_name').val())){
    //     var unitnameErrorField =$("#product_errors").text("Empty Field");
    //     unitnameErrorField.show();
    //     isError=true;
    // }

  if(!isError) {



      var item = {};
      item ["id"] = $('#price_details_id').val();
      item ["priceMasterId"] =$('#price_details_price_master_id').val();
      item ["productId"] = $('#price_details_product_id').val();
      item ["itemValue"] = $('#price_details_item_value').val();
      item ["effectiveStartDate"] = $('#effective_start_date').val();
      item ["effectiveEndtDate"] = $('#effective_end_date').val();


      console.log("Rsult sending to server:");
     // console.log(JSON.stringify(item));
      sendDataToserver(item);
  }
}
    
function sendDataToserver(item) {
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: 'POST',
            url: _ctx+ 'PriceDetails/editshow',
            dataType : 'json',
            data : JSON.stringify(item),
            beforeSend: function(xhr) {

                xhr.setRequestHeader(header, token);
            },
            success : function(callback) {
                console.log(JSON.stringify(callback));
                // var Priceresponse=jQuery.parseJSON(callback);

               // console.log("res"+callback.success);
                var PriceMasterErrorField = $("#price_master_errors").text("PriceMaster Not Selected");
                var productErrorField = $("#product_errors").text("Product Not Selected ");
                if (callback.success) {
                    window.location.replace("/PriceDetails/allPriceDetails");
                }else{
                    if(callback.priceMasterIDisNone) {
                        productErrorField.hide();
                        PriceMasterErrorField.show();
                    }else if(callback.productIDisNone) {
                        PriceMasterErrorField.hide();
                        productErrorField.show();
                    }else{

                        PriceMasterErrorField.show();
                        productErrorField.show();
                    }
                }

            },
            error : function(){

                alert("error");
            }
        });
}


