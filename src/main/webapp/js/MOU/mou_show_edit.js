/**
 * Created by  on 3/2/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var BASE_CONTEXT_ALL = $('meta[name=context-all]').attr("content");
var BASE_CONTEXT_EDIT = $('meta[name=context-edit]').attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
function sendFromData() {

    var isError=false;

    console.log($.trim($('#unit_name').val()));

    if(!$.trim($('#unit_name').val())){
        var unitnameErrorField =$("#unit_name_error").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }

  if(!isError) {
      var item = {};
      item ["id"] = $('#mou_id').val();
      item ["unitName"] = $.trim($('#unit_name').val());
      item ["discription"] = $('#desc').val();

      console.log("Rsult sending to server:");
     // console.log(JSON.stringify(item));
      sendDataToserver(item);
  }
}
    
function sendDataToserver(item) {
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: 'POST',
            url: BASE_CONTEXT_EDIT,
            dataType : 'json',
            data : JSON.stringify(item),
            beforeSend: function(xhr) {

                xhr.setRequestHeader(header, token);
            },
            success : function(callback) {
                console.log(callback)
                if (callback) {
                    window.location.replace(BASE_CONTEXT_ALL);
                }else{
                    var unitnameErrorField =$("#unit_name_error").text("Same Name Exist");
                    unitnameErrorField.show();
                }


                // alert("success");
            },
            error : function(){
                alert("error");
            }
        });
}


