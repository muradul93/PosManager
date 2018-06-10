/**
 * Created by Murad on 10/8/2017.
 */


/*******Form Submit validation*************/



function validtionCheckWareInventory() {

    var to=$('#to').val();
    var ware=$('#ware').val();

    //Error
    var to_error=$('#to_error');
    var ware_error=$('#ware_error');

    //Msg Error
    var msgError="Empty Field";
    var msgSelectorError="NONE Selected";
    var msgNumberError="Number Only";

    console.log("to :"+to);
    console.log("from :"+ware);

    if(to==0||ware==0){


        if(to==0){
            to_error.text(msgSelectorError);
            to_error.show();
        }


        if(ware==0){
            ware_error.text(msgSelectorError);
            ware_error.show();
        }

        return false;
    }else{



        // if(skuCode.length<2){
        //     skuCode_error.text("size must be between 2 and 10");
        //     skuCode_error.show();
        //     return false;
        // }
        //
        // if(!isValidateNumber(skuQty)){
        //     var skuQty=$('#skuQty').val().trim("");
        //     productName_error.text(msgNumberError);
        //     productName_error.show();
        // }


        return true;

    }
}

/*******Product Type on Change validation*************/
function fromWareOnChange () {
    var ware=$('#ware').val();
    //Error
    var ware_error=$('#ware_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(ware==0){
        ware_error.text(msgSelect);
        ware_error.show();
    }else{

        ware_error.hide();

    }

}

/*******Mou Name on Change validation*************/
function toWareOnChange () {
    var to=$('#to').val();
    //Error
    var to_error=$('#to_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(to==0){
        to_error.text(msgSelect);
        to_error.show();
    }else{

        to_error.hide();

    }

}


/*******Product validation*************/

/*******Number validation*************/
function isValidateNumber(Value) {
    var temp = parseFloat(Value);
    return !isNaN(temp);
}