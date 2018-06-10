/**
 * Created by  on 3/2/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
function sendFromDataProccess() {

    var isError=false;

    console.log($.trim($('#price_master_name').val()));

    if(!$.trim($('#price_master_name').val())){
        var unitnameErrorField =$("#price_master_name_error").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }

  if(!isError) {

      // $("#price_master_id").val(id);
      // $("#price_master_name").val(name);
      // $("#price_master_keyword").val(keyword);
      // $("#price_master_description").val(desc);

      var item = {};
      item ["id"] = $('#price_master_id').val();
      item ["name"] = $.trim($('#price_master_name').val());
      item ["keyword"] = $('#price_master_keyword').val();
      item ["description"] = $('#price_master_description').val();

      console.log("Rsult sending to server:");
     // console.log(JSON.stringify(item));
      sendDataToserver(item);
  }
}
    
function sendDataToserver(item) {
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: 'POST',
            url: _ctx+ 'priceMaster/editshow',
            dataType : 'json',
            data : JSON.stringify(item),
            beforeSend: function(xhr) {

                xhr.setRequestHeader(header, token);
            },
            success : function(callback) {
                console.log(callback)
                if (callback) {
                    window.location.replace("/priceMaster/allType");
                }else{
                    var unitnameErrorField =$("#price_master_name_error").text("Same Name Exist");
                    unitnameErrorField.show();
                }


                // alert("success");
            },
            error : function(){

                alert("error");
            }
        });
}


