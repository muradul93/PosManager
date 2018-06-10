/**
 * Created by  on 3/2/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
function sendFormData() {

    var isError=false;

    console.log($.trim($('#organization_name').val()));

    if(!$.trim($('#organization_name').val())){
        var unitnameErrorField =$("#organization_errors").text("Empty Field");
        unitnameErrorField.show();
        isError=true;
    }

  if(!isError) {

      // $("#organization_id").val(id)
      // $("#organization_name").val(name)
      // $("#organization_Code").val(code)
      // $("#organization_type").val(organizationtype)
      // $("#organization_address").val(adreess)
      // $("#organization_contact").val(contact)

      var item = {};
      item ["id"] = $('#organization_id').val();
      item ["organizationName"] = $.trim($('#organization_name').val());
      item ["organizationCode"] = $('#organization_Code').val();
      item ["organizationType"] = $('#organization_type').val();
      item ["organizationAddress"] = $('#organization_address').val();
      item ["organizationContact"] = $('#organization_contact').val();

      console.log("Rsult sending to server:");
      console.log(JSON.stringify(item));
      sendDataToserver(item);
  }
}
    
function sendDataToserver(item) {
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: 'POST',
            url: _ctx+ 'Organization/editshow',
            dataType : 'json',
            data : JSON.stringify(item),
            beforeSend: function(xhr) {

                xhr.setRequestHeader(header, token);
            },
            success : function(callback) {
                console.log(callback)
                if (callback) {
                    window.location.replace("/Organization/all_organization");
                }else{
                    var unitnameErrorField =$("#organization_errors").text("Same Name Exist");
                    unitnameErrorField.show();
                }


                // alert("success");
            },
            error : function(){

                alert("error");
            }
        });
}


