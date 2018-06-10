/**
 * Created by  on 3/22/17.
 */

/*******Look Up validation*************/

/*******Form Submit validation*************/

function validtionCheck() {
    var name=$('#name').val().trim();
    var code=$('#code').val().trim();
    var module=$('#module').val().trim();
    //Error
    var name_error=$('#name_error');
    var code_error=$('#code_error');
    var module_error=$('#module_error');
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

        if(!module){
            module_error.text(msgError);
            module_error.show();
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

/*******Module on Change validation*************/
function moduleOnChange () {
    var module=$('#module').val().trim();
    //Error
    var module_error=$('#module_error');
    //Error Msg
    var msgError="Empty Field";

    if(!module){
        module_error.text(msgError);
        module_error.show();
    }else{

        module_error.hide();

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

/*******Look Up validation*************/

