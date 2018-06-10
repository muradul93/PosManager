/**
 * Created by Murad on 9/21/2017.
 */



/*******Vant  validation*************/

/*******Form Submit validation*************/


function validationCheckVanType() {
    var name = $('#name').val().trim();

    var code = $('#code').val().trim();


    //Error
    var name_error = $('#name_error');

    var code_error = $('#code_error');


    //Msg Error
    var msgError = "Empty Field";
    var msgSelect = "NONE Selected";



//
    if (!name || !code ) {

        if (!name) {

            name_error.text(msgError);
            name_error.show();
        }




        if (!code) {

            code_error.text(msgError);
            code_error.show();
        }


        return false;
    } else {

        if (name.length < 2) {

            alert("length");
            name_error.text("size must be between 2 and 30");
            name_error.show();
            return false;
        }

        if (code.length < 2) {
            code_error.text("size must be between 2 and 10");
            code_error.show();
            return false;
        }



        return true;

    }
}


/*******Code On Change validation*************/
function codeOnChangeVanType() {
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
            code_error.text("size must be between 2 and 30");
            code_error.show();

        } else {
            code_error.hide();
        }

    }

}




/******* name On Change validation*************/
function nameOnChangeVanType() {
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
            name_error.text("size must be between 2 and 30");
            name_error.show();

        } else {
            name_error.hide();
        }
    }

}

/*******Organization validation*************/




