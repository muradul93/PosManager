/**
 * Created by  on 3/2/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var BASE_CONTEXT_PATH = $('meta[name=context-path]').attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
function sendFormData() {

    var isError=false;

    console.log($.trim($('#lookup_name').val()));

    if(!$.trim($('#lookup_name').val())){
        var unitnameErrorField =$("#show_all_look_up_errors").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }

  if(!isError) {

      var item = {};
      item ["id"] = $('#allllokup_id').val();
      item ["allLookUpName"] = $.trim($('#lookup_name').val());
      item ["allLookUpCode"] = $('#lookup_code').val();
      item ["allLookUpModule"] = $('#lookup_module').val();
      item ["allLookUpDescription"] = $('#Description').val();

      console.log("Rsult sending to server:");
     // console.log(JSON.stringify(item));
      sendDataToserver(item);
  }
}
    
function sendDataToserver(item) {
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: 'POST',
            url:  _ctx+ 'allLookUp/editshow',
            dataType : 'json',
            data : JSON.stringify(item),
            beforeSend: function(xhr) {

                xhr.setRequestHeader(header, token);
            },
            success : function(callback) {
                console.log(callback)
                if (callback) {
                    window.location.replace(BASE_CONTEXT_PATH);
                }else{
                    var unitnameErrorField =$("#show_all_look_up_errors").text("Same Name Exist");
                    unitnameErrorField.show();
                }

                // alert("success");
            },
            error : function(){

                alert("error");
            }
        });
}


