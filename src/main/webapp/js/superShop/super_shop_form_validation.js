/**
 * Created by  on 3/22/17.
 */

/*******Retail Shop validation*************/

/*******Form Submit validation*************/

function validtionCheck() {
    var modern=$('#modern').val();
    var shopCode=$('#shopCode').val().trim();
    var contact=$('#contact').val().trim();
    var outlet=$('#outlet').val().trim();

    //Error
    var modern_trade_error=$('#modern_trade_error');
    var shopCode_error=$('#shopCode_error');
    var contact_error=$('#contact_error');
    var outlet_error=$('#outlet_error');

    //Msg Error
    var msgError="Empty Field";
    var msgSelect="NONE Selected";

    if(!outlet||!shopCode||!contact||modern==0){

        if(!shopCode){
            shopCode_error.text(msgError);
            shopCode_error.show();
        }

        if(!outlet){
            outlet_error.text(msgError);
            outlet_error.show();
        }

        if(!contact){
            contact_error.text(msgError);
            contact_error.show();
        }

        if(modern==0){
            modern_trade_error.text(msgSelect);
            modern_trade_error.show();
        }



        return false;
    }else{

        if(shopCode.length<2){
            shopCode_error.text("size must be between 2 and 20");
            shopCode_error.show();
            return false;
        }


            return true;

    }
}



/*******Modern on Change validation*************/
function modernOnChange() {
    var modern=$('#modern').val();
    //Error
    var modern_trade_error=$('#modern_trade_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(modern==0){
        modern_trade_error.text(msgSelect);
        modern_trade_error.show();
    }else{

        modern_trade_error.hide();

    }

}

/*******Contact On Change validation*************/
function contactOnChange() {
    var contact=$('#contact').val().trim();
    //Error
    var contact_error=$('#contact_error');
    //Error Msg
    var msgError="Empty Field";

    if(!contact){
        contact_error.text(msgError);
        contact_error.show();
    }else{
        if(contact.length<2){
            contact_error.text("size must be between 2 and 20");
            contact_error.show();

        }else {
            contact_error.hide();
        }

    }

}

/*******Shop Code On Change validation*************/
function shopCodeOnChange() {
    var shopCode=$('#shopCode').val().trim();
    //Error
    var shopCode_error=$('#shopCode_error');
    //Error Msg
    var msgError="Empty Field";

    if(!shopCode){
        shopCode_error.text(msgError);
        shopCode_error.show();
    }else{
        if(shopCode.length<2){
            shopCode_error.text("size must be between 2 and 20");
            shopCode_error.show();

        }else {
            shopCode_error.hide();
        }

    }

}
/******* Outlet On Change validation*************/
function outletOnChange () {
    var outlet=$('#outlet').val().trim();
    //Error
    var outlet_error=$('#outlet_error');
    //Error Msg
    var msgError="Empty Field";

    if(!outlet){
        outlet_error.text(msgError);
        outlet_error.show();
    }else{

        if(outlet.length<2){
            outlet_error.text("size must be between 2 and 20");
            outlet_error.show();

        }else{
            outlet_error.hide();
        }
    }

}

/*******Retail Shop validation*************/

