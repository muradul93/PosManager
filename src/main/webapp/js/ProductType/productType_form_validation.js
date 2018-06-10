/**
 * Created by  on 3/22/17.
 */

/*******Look Up validation*************/

/*******Form Submit validation*************/

function validtionCheck() {
    var name=$('#name').val().trim();

    //Error
    var name_error=$('#name_error');

    //Msg Error
    var msgError="Empty Field";

    if(!name){

        if(!name){
            name_error.text(msgError);
            name_error.show();
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

