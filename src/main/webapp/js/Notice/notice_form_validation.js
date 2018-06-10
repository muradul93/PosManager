/**
 * Created by Marketing on 06-Jul-17.
 */



/*******Role validation*************/

/*******Form Submit validation*************/

function validtionCheck() {
    var noticeName=$('#noticeName').val().trim();


    // description

    //Error
    var noticeName_error=$('#noticeName_error');


    //Msg Error
    var msgError="Empty Field";

    if(!noticeName){

        if(!noticeName){
            noticeName_error.text(msgError);
            noticeName_error.show();
        }




        return false;
    }else{

        if(noticeName.length<2){
            noticeName_error.text("size must be between 2 and 30");
            noticeName_error.show();
            return false;
        }else{
            return true;
        }
    }
}


/******* Name On Change validation*************/
function noticeNameOnChange () {
    var noticeName=$('#noticeName').val().trim();
    //Error
    var noticeName_error=$('#noticeName_error');
    //Error Msg
    var msgError="Empty Field";

    if(!noticeName){
        noticeName_error.text(msgError);
        noticeName_error.show();
    }else{

        if(noticeName.length<2){
            noticeName_error.text("size must be between 2 and 30");
            noticeName_error.show();

        }else{
            noticeName_error.hide();
        }
    }

}







/*******Role validation*************/


