/**
 * Created by  on 3/2/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
function sendFromDataProcess() {

    var isError=false;

   // console.log($.trim($('#retailShopName').val()));
/*
    if(!$.trim($('#tradeName').val())){
        var unitnameErrorField =$("#nameError").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }*/

  if(!isError) {



      var item = {};
      item ["id"] = $('#ssId').val();
      item ["mtCode_id"] = $.trim($('#mtCode').val());
      item ["ssCode"] = $('#ssCode').val();
      item ["contact"] = $('#contact').val();
      item ["outletNo"] = $('#outletNo').val();
      item ["lat"] = $('#lat').val();
      item ["longt"] = $('#lon').val();
      item ["address"] = $('#address').val();
      item ["srId"] = $('#userId').val();
      item ["locationId"] = $('#locationId').val();


      console.log("Rsult sending to server:");
      console.log(JSON.stringify(item));
      sendDataToserver(item);
  }
}
    
function sendDataToserver(item) {
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: 'POST',
            url: _ctx+ 'SuperShop/popupEdit',
            dataType : 'json',
            data : JSON.stringify(item),
            beforeSend: function(xhr) {

                xhr.setRequestHeader(header, token);
            },
            success : function(callback) {
                console.log(callback)
                if (callback) {
                    window.location.replace("/SuperShop/superShopAll");
                }else{
                    var unitnameErrorField =$("#nameError").text("Same Name Exist");
                    unitnameErrorField.show();
                }


               //  alert("success");
            },
            error : function(){

                alert("error");
            }
        });
}


