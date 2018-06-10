/**
 * Created by  on 3/22/17.
 */

/*******Dealer validation*************/

/*******Form Submit validation*************/

function validtionDealerCheck() {

    var name = $('#name').val().trim();
    var code = $('#code').val().trim();
    var credit_limit = $('#creditLimit').val().trim();
    var contact = $('#contact').val().trim();
    var user = $('#user').val();
    //Error
    var name_error = $('#name_error');
    var password_error = $('#password_error');
    var code_error = $('#code_error');
    var credit_limit_error = $('#creditLimit_error');
    var crontact_error = $('#crontact_error');
    var user_error = $('#user_error');
    var location_error = $('#location_error');
    var latitude_error=$('#latitude_error');
    var longitude_error=$('#longitude_error');
    //Msg Error
    var msgError = "Empty Field";
    var msgNONE = "NONE Selected"

    if (!name || !code || !credit_limit || !contact) {


        if (!name) {
            name_error.text(msgError);
            name_error.show();
        }


        if (!code) {
            code_error.text(msgError);
            code_error.show();
        }

        if (!credit_limit) {
            credit_limit_error.text(msgError);
            credit_limit_error.show();
        }

        if (!contact) {
            crontact_error.text(msgError);
            crontact_error.show();
        }


        return false;
    } else {

        if (name.length < 2) {
            name_error.text("size must be between 2 and 10");
            name_error.show();
            return false;
        }

        if (code.length < 2) {
            code_error.text("size must be between 2 and 10");
            code_error.show();
            return false;
        }

        var temp = parseFloat(credit_limit);
        if (isNaN(temp)) {
            $('#creditLimit').val("");
            credit_limit_error.text("Only Number");
            credit_limit_error.show();
            return false
        }


        return true;

    }
}

/*******Location On Change validation*************/
function locationOnChange() {
    var location = $('#location').val();
    //Error
    var location_error = $('#location_error');
    //Error Msg
    var msgNONE = "NONE Selected"

    if (location==0) {
        location_error.text(msgNONE);
        location_error.show();
    } else {
        location_error.hide();
    }

}

/*******User On Change validation*************/
function userOnChange() {
    var user = $('#user').val();
    //Error
    var user_error = $('#user_error');
    //Error Msg
    var msgNONE = "NONE Selected"

    if (user==0) {
        user_error.text(msgNONE);
        user_error.show();
    } else {
        user_error.hide();
    }

}

/*******Contact On Change validation*************/
function contactOnChange() {
    var contact = $('#contact').val().trim();
    //Error
    var crontact_error = $('#crontact_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!contact) {
        crontact_error.text(msgError);
        crontact_error.show();
    } else {
            crontact_error.hide();
    }

}



/*******latitude On Change validation*************/
function latitudeOnChange() {
    var latitude=$('#latitude').val().trim();
    //Error
    var latitude_error=$('#latitude_error');
    //Error Msg
    var msgError="Empty Field";

    if(!latitude){
        latitude_error.text(msgError);
        latitude_error.show();
    }else{
        if(latitude.length<2){
            latitude_error.text("size must be between 2 and 20");
            latitude_error.show();

        }else {
            latitude_error.hide();
        }

    }

}



/*******longitude On Change validation*************/
function longitudeOnChange() {
    var longitude=$('#longitude').val().trim();
    //Error
    var longitude_error=$('#longitude_error');
    //Error Msg
    var msgError="Empty Field";

    if(!longitude){
        longitude_error.text(msgError);
        longitude_error.show();
    }else{
        if(longitude.length<2){
            longitude_error.text("size must be between 2 and 20");
            longitude_error.show();

        }else {
            longitude_error.hide();
        }

    }

}



/*******CreditLimit on Change validation*************/
function creditLimitOnChange() {
    var creditLimit = $('#creditLimit').val().trim();
    //Error
    var credit_limit_error = $('#creditLimit_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!creditLimit) {
        credit_limit_error.text(msgError);
        credit_limit_error.show();
    } else {
        var temp = parseFloat(creditLimit);
        if (isNaN(temp)) {
            $('#creditLimit').val("");
            credit_limit_error.text("Only Number");
            credit_limit_error.show();
        } else {
            credit_limit_error.hide();
        }

    }

}

/*******password on Change validation*************/
function dealerpasswordOnChange() {
    var password = $('#password').val().trim();
    //Error
    var password_error = $('#password_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!password) {
        password_error.text(msgError);
        password_error.show();
    } else {
        if (password.length < 2) {
            password_error.text("size must be between 2 and 10");
            password_error.show();
        } else {
            password_error.hide();
        }

    }

}
/*******Code On Change validation*************/
function codeOnChange() {
    var code = $('#code').val().trim();
    //Error
    var code_error = $('#code_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!code) {
        code_error.text(msgError);
        code_error.show();
    } else {
        if (code.length < 2) {
            code_error.text("size must be between 2 and 10");
            code_error.show();

        } else {
            code_error.hide();
        }

    }

}
/******* Name On Change validation*************/
function nameOnChange() {
    var name = $('#name').val().trim();
    //Error
    var name_error = $('#name_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!name) {
        name_error.text(msgError);
        name_error.show();
    } else {

        if (name.length < 2) {
            name_error.text("size must be between 2 and 10");
            name_error.show();

        } else {
            name_error.hide();
        }
    }

}

/*******Dealer validation*************/

