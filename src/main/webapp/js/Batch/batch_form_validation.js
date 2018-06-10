/**
 * Created by Murad on 9/21/2017.
 */



/*******Vant  validation*************/

/*******Form Submit validation*************/


function validationCheckBatch() {
    var batchNo = $('#batchNo').val().trim();
    var manufactureDateStr = $('#manufactureDateStr').val().trim();
    var expirationDateStr=$('#expirationDateStr').val();



    //Error
    var batchNo_error = $('#batchNo_error');
    var manufactureDateStr_error = $('#manufactureDateStr_error');
    var expirationDateStr_error=$('#expirationDateStr_error');



    //Msg Error
    var msgError = "Empty Field";
    var msgSelect = "NONE Selected";



//
    if (!batchNo || !manufactureDateStr ||!expirationDateStr) {

        if (!batchNo) {

            batchNo_error.text(msgError);
            batchNo_error.show();
        }




        if (!manufactureDateStr) {

            manufactureDateStr_error.text(msgError);
            manufactureDateStr_error.show();
        }

        if (!expirationDateStr) {

            expirationDateStr_error.text(msgError);
            expirationDateStr_error.show();
        }


        return false;
    } else {

        if (batchNo.length < 2) {

            alert("length");
            batchNo_error.text("size must be between 2 and 30");
            batchNo_error.show();
            return false;
        }





        return true;

    }
}


/*******Code On Change validation*************/
function manufactureDateStrOnChange() {
    var manufactureDateStr = $('#manufactureDateStr').val().trim();
    //Error
    var manufactureDateStr_error = $('#manufactureDateStr_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!manufactureDateStr) {
        manufactureDateStr_error.text(msgError);
        manufactureDateStr_error.show();
    } else {

        manufactureDateStr_error.hide();
        }



}




/******* batchNo On Change validation*************/
function batchNoOnChange() {
    var batchNo = $('#batchNo').val().trim();
    //Error
    var batchNo_error = $('#batchNo_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!batchNo) {
        batchNo_error.text(msgError);
        batchNo_error.show();
    } else {

        if (batchNo.length < 2) {
            batchNo_error.text("size must be between 2 and 30");
            batchNo_error.show();

        } else {
            batchNo_error.hide();
        }
    }

}

/*******Organization validation*************/


function expirationDateStrOnChange () {
    var expirationDateStr=$('#expirationDateStr').val();
    //Error
    var expirationDateStr_error=$('#expirationDateStr_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(expirationDateStr==0){
        expirationDateStr_error.text(msgSelect);
        expirationDateStr_error.show();
    }else{

        expirationDateStr_error.hide();

    }

}




