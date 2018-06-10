/**
 * Created by Murad on 9/21/2017.
 */

/*******Van  validation*************/

/*******Form Submit validation*************/


function validationCheckFinance() {

    var saleDropId = $('#saleDropId').val();

    //Error

    var saleDropId_error = $('#saleDropId_error');
    //Msg Error
    var msgError = "Empty Field";
    var msgSelect = "NONE Selected";



//
    if (saleDropId == 0) {

        if (saleDropId == 0) {
            saleDropId_error.text(msgSelect);
            saleDropId_error.show();
        }

        return false;
    } else {

        return true;

    }
}

/*******Oraganization Ty on Change validation*************/
function saleDropIdOnChange() {
    var saleDropId = $('#saleDropId').val();
    //Error
    var saleDropId_error = $('#saleDropId_error');
    //Error Msg
    var msgSelect = "NONE Selected";

    if (saleDropId == 0) {
        saleDropId_error.text(msgSelect);
        saleDropId_error.show();
    } else {

        saleDropId_error.hide();

    }

}
