/**
 * Created by  on 3/2/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
function sendFormData() {

    var isError=false;

    console.log($.trim($('#organization_type_name').val()));

    if(!$.trim($('#organization_type_name').val())){
        var unitnameErrorField =$("#organization_type_name_error").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }

  if(!isError) {

      var item = {};
      console.log($('#organization_type_id').val());
      item ["id"] = $('#organization_type_id').val();
      item ["name"] = $.trim($('#organization_type_name').val());
      item ["organizationDescription"] = $('#organization_type_description').val();


      console.log("Rsult sending to server:");
      console.log(JSON.stringify(item));
      sendDataToserver(item);
  }
}
    
function sendDataToserver(item) {
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: 'POST',
            url: _ctx+ 'OrganizationType/editshow',
            dataType : 'json',
            data : JSON.stringify(item),
            beforeSend: function(xhr) {

                xhr.setRequestHeader(header, token);
            },
            success : function(callback) {
                console.log(callback)
                if (callback) {
                    window.location.replace("/OrganizationType/all_organization_type");
                }else{
                    var unitnameErrorField =$("#organization_type_name_error").text("Same Name Exist");
                    unitnameErrorField.show();
                }


                // alert("success");
            },
            error : function(){

                alert("error");
            }
        });
}


