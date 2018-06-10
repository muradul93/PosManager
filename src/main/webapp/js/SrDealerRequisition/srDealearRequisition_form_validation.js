/**
 * Created by Murad on 10/15/2017.
 */
/**
 * Created by Murad on 9/21/2017.
 */



/*******Vant  validation*************/

/*******Form Submit validation*************/


function validationCheckDealearType() {
    var dealerName = $('#dealerName').val();




    //Error
    var dealerName_error = $('#dealerName_error');




    //Msg Error
    var msgError = "Empty Field";
    var msgSelect = "NONE Selected";



//
    if (dealerName==0 ) {

        if (dealerName==0) {

            dealerName_error.text(msgError);
            dealerName_error.show();
        }







        return false;
    } else {







        return true;

    }
}





/******* dealerName On Change validation*************/
function dealerNameOnChanges() {
    var dealerName = $('#dealerName').val();
    //Error
    var dealerName_error = $('#dealerName_error');
    //Error Msg
    var msgError = "Empty Field";

    if (dealerName==0) {
        dealerName_error.text(msgError);
        dealerName_error.show();
    } else {


            dealerName_error.hide();

    }

}

/*******Organization validation*************/




