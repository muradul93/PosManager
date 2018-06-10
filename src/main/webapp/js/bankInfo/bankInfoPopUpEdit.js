/**
 * Created by abc on 23/3/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
function sendFromDataProcess() {

    var isError=false;

    console.log($.trim($('#roleName').val()));

    if(!$.trim($('#branchName').val())){
        var unitnameErrorField =$("#branchName").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }

    if(!$.trim($('#bankName').val())){
        var unitnameErrorField =$("#bankName").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }

    if(!$.trim($('#accountName').val())){
        var unitnameErrorField =$("#accountName").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }

    if(!$.trim($('#accountNumber').val())){
        var unitnameErrorField =$("#accountNumber").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }


  if(!isError) {

      var item = {};
      item ["id"] = $('#roleId').val();
      item ["name"] = $.trim($('#bankName').val());
      item ["accountName"] = $('#accountName').val();
      item ["accountNumber"] = $('#accountNumber').val();
      item ["branchName"] = $('#branchName').val();


      console.log("Rsult sending to server:");
     // console.log(JSON.stringify(item));
      sendDataToserver(item);
  }
}
    
function sendDataToserver(item) {
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: 'POST',
            url:  _ctx+ 'bankInfo/popupEdit',
            dataType : 'json',
            data : JSON.stringify(item),
            beforeSend: function(xhr) {

                xhr.setRequestHeader(header, token);
            },
            success : function(callback) {
                console.log(callback)
                if (callback) {
                    window.location.replace("/bankInfo/list");
                }else{
                    var unitnameErrorField =$("#nameError").text("Same Name Exist");
                    unitnameErrorField.show();
                }


                // alert("success");
            },
            error : function(){

                alert("error");
            }
        });
}


