/**
 * Created by  on 3/22/17.
 */

/*******Location validation*************/

/*******Form Submit validation*************/

function validtionCheck() {
    var name=$('#name').val().trim();
    var code=$('#code').val().trim();

    //Error
    var name_error=$('#name_error');
    var code_error=$('#code_error');

    //Msg Error
    var msgError="Empty Field";

    if(!name||!code||!module){

        if(!name){
            name_error.text(msgError);
            name_error.show();
        }

        if(!code){
            code_error.text(msgError);
            code_error.show();
        }


        return false;
    }else{

        if(name.length<2){
            name_error.text("size must be between 2 and 30");
            name_error.show();
            return false;
        }else{
            return true;
        }
    }
}


/*******Code On Change validation*************/
function codeOnChange () {
    var code=$('#code').val().trim();
    //Error
    var code_error=$('#code_error');
    //Error Msg
    var msgError="Empty Field";

    if(!code){
        code_error.text(msgError);
        code_error.show();
    }else{

            code_error.hide();

    }

}
/******* Name On Change validation*************/
function nameOnChange () {
    var name=$('#name').val().trim();
    //Error
    var name_error=$('#name_error');
    //Error Msg
    var msgError="Empty Field";

    if(!name){
        name_error.text(msgError);
        name_error.show();
    }else{

        if(name.length<2){
            name_error.text("size must be between 2 and 30");
            name_error.show();

        }else{
            name_error.hide();
        }
    }

}

/*******Location validation*************/
