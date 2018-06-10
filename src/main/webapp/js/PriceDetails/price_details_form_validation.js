/**
 * Created by  on 3/22/17.
 */

/*******PriceDetails validation*************/

/*******Form Submit validation*************/

function validtionCheck() {
    var master=$('#master').val();
    var productName=$('#productName').val();
    var itemValue=$('#itemValue').val().trim();
    var effectiveStartDate=$('#effectiveStartDate').val();

    //Error
    var master_error=$('#master_error');
    var productName_error=$('#productName_error');
    var itemValue_error=$('#itemValue_error');
    var effectiveStartDate_error=$('#effectiveStartDate_error');
    //Msg Error
    var msgError="Empty Field";
    var msgSelect="NONE Selected";
    var msgNumber="Only Number"

    if(master==0||productName==0||!itemValue||!effectiveStartDate){

        if(master==0){
            master_error.text(msgSelect);
            master_error.show();
        }

        if(productName==0){
            productName_error.text(msgSelect);
            productName_error.show();
        }

        if(!itemValue){
            itemValue_error.text(msgError);
            itemValue_error.show();
        }
        if(!effectiveStartDate){
            effectiveStartDate_error.text(msgError);
            effectiveStartDate_error.show();
        }

        return false;
    }else{

        if(!isValidateNumber(itemValue)){
            $('#itemValue').val("");
            itemValue_error.text(msgNumber);
            itemValue_error.show();
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

/*******effectiveStartDate on Change validation*************/
function effectiveStartDateOnChange () {
    var effectiveStartDate=$('#effectiveStartDate').val();
    //Error
    var effectiveStartDate_error=$('#effectiveStartDate_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(effectiveStartDate==0){
        effectiveStartDate_error.text(msgSelect);
        effectiveStartDate_error.show();
    }else{

        effectiveStartDate_error.hide();

    }

}


/******* item value On Change validation*************/
function itemValueOnChange () {
    var itemValue=$('#itemValue').val().trim();
    //Error
    var itemValue_error=$('#itemValue_error');
    //Error Msg
    var msgError="Empty Field";
    var msgNumber="Only Number"

    if(!itemValue){
        itemValue_error.text(msgError);
        itemValue_error.show();
    }else{

        if(!isValidateNumber(itemValue)){
            $('#itemValue').val("");
            itemValue_error.text(msgNumber);
            itemValue_error.show();

        }else{
            itemValue_error.hide();
        }
    }

}

/*******PriceDetails validation*************/

/*******Number validation*************/
function isValidateNumber(Value) {
    var temp = parseFloat(Value);
    return !isNaN(temp);
}