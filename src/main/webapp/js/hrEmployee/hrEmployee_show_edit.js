/**
 * Created by  on 3/2/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
function sendFromDataProcess() {

    var isError=false;

   // console.log($.trim($('#roleName').val()));
/*
    if(!$.trim($('#tradeName').val())){
        var unitnameErrorField =$("#nameError").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }*/

  if(!isError) {

      var item = {};
      item ["id"] = $('#empId').val();
      item ["code"] = $.trim($('#code').val());
      item ["empName"] = $('#empName').val();
      item ["contact"] = $('#contact').val();
      item ["altContact"] = $('#altContact').val();
      item ["nationalId"] = $('#nId').val();
      item ["designation"] = $('#designation').val();
      item ["postingArea"] = $('#postingArea').val();
      item ["salary"] = $('#salarry').val();
      item ["presentAddress"] = $('#preAddress').val();
      item ["permanentAddress"] = $('#perAddress').val();
      item ["startDate"] = $('#startDate').val();
      item ["endDate"] = $('#endDate').val();


      console.log("Rsult sending to server:");
     // console.log(JSON.stringify(item));
      sendDataToserver(item);
  }
}
    
function sendDataToserver(item) {
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: 'POST',
            url: _ctx+ 'hrEmployee/popupEdit',
            dataType : 'json',
            data : JSON.stringify(item),
            beforeSend: function(xhr) {

                xhr.setRequestHeader(header, token);
            },
            success : function(callback) {
                console.log(callback)
                if (callback) {
                    window.location.replace("/hrEmployee/allType");
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


