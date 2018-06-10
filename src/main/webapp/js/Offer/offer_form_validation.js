/**
 * Created by shitul on 3/22/17.
 */

/*******PriceDetails validation*************/

/*******Form Submit validation***********/

function validtionCheck() {
    var master=$('#master').val();
    var productName=$('#productName').val();
    var offerName=$('#offerName').val().trim();
    var startDateString=$('#startDateString').val().trim();
    var endDateString=$('#endDateString').val().trim();
    //Error
    var master_error=$('#master_error');
    var productName_error=$('#productName_error');
    var offerName_error=$('#offerName_error');
    var startDate_error=$('#startDate_error');
    var endDate_error=$('#endDate_error');
    //Msg Error
    var msgError="Empty Field";
    var msgSelect="NONE Selected";
    var msgNumber="Only Number"

    if(master==0||productName==0||!offerName||!startDateString||!endDateString){

        if(master==0){
            master_error.text(msgSelect);
            master_error.show();
        }

        if(productName==0){
            productName_error.text(msgSelect);
            productName_error.show();
        }

        if(!offerName){
            offerName_error.text(msgError);
            offerName_error.show();
        }

        if(!startDateString){
            startDate_error.text(msgError);
            startDate_error.show();
        }
        if(!endDateString){
            endDate_error.text(msgError);
            endDate_error.show();
        }

        return false;
    }else{

        if(offerName.length<1){

            offerName_error.text(msgNumber);
            offerName_error.show();
            return false;
        }


            return true;

    }
}

/*******Price Master on Change validation*************/
function masterOnChange () {
    var master=$('#master').val();
    //Error
    var master_error=$('#master_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(master==0){
        master_error.text(msgSelect);
        master_error.show();
    }else{

        master_error.hide();

    }

}
/*******Product Name on Change validation*************/
function productNameOnChange () {
    var productName=$('#productName').val();
    //Error
    var productName_error=$('#productName_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(productName==0){
        productName_error.text(msgSelect);
        productName_error.show();
    }else{

        productName_error.hide();

    }

}



/*******Start Date on Change validation*************/
function startDateOnChange () {
    var startDateString=$('#startDateString').val();
    //Error
    var startDate_error=$('#startDate_error');
    //Error Msg

      var msgError="Empty Field";

    if(!startDateString){
        startDate_error.text(msgError);
        startDate_error.show();
    }else{

        startDate_error.hide();

    }

}








/*******End Date on Change validation*************/
function endDateOnChange () {
    var endDateString=$('#endDateString').val();
    //Error
    var endDate_error=$('#endDate_error');
    //Error Msg

    var msgError="Empty Field";

    if(!endDateString){
        endDate_error.text(msgError);
        endDate_error.show();
    }else{

        endDate_error.hide();

    }

}

/******* item value On Change validation*************/
function offerNameOnChange () {
    var offerName=$('#offerName').val().trim();
    //Error
    var offerName_error=$('#offerName_error');
    //Error Msg
    var msgError="Empty Field";
    var msgNumber="Only Number"

    if(!offerName){
        offerName_error.text(msgError);
        offerName_error.show();
    }else{

        if(offerName.length<1){

            offerName_error.text(msgNumber);
            offerName_error.show();

        }else{
            offerName_error.hide();
        }
    }

}

/*******PriceDetails validation*************/

/*******Number validation*************/
function isValidateNumber(Value) {
    var temp = parseFloat(Value);
    return !isNaN(temp);
}


/*******Date validation*************/
function isValidateDate(dtValue) {
    var dtRegex = new RegExp(/\b\d{1,2}[\/-]\d{1,2}[\/-]\d{4}\b/);
    return dtRegex.test(dtValue);
}