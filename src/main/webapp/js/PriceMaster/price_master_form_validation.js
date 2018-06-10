/**
 * Created by  on 3/22/17.
 */

/*******Price Master validation*************/

/*******Form Submit validation*************/

function validtionCheck() {
    var name=$('#name').val().trim();
    var keyword=$('#keyword').val().trim();

    //Error
    var name_error=$('#name_error');
    var keyword_error=$('#keyword_error');

    //Msg Error
    var msgError="Empty Field";

    if(!name||!keyword){

        if(!name){
            name_error.text(msgError);
            name_error.show();
        }

        if(!keyword){
            keyword_error.text(msgError);
            keyword_error.show();
        }


        return false;
    }else{

        if(name.length<2){
            name_error.text("size must be between 2 and 10");
            name_error.show();
            return false;
        }
        if(keyword.length<2){
            keyword_error.text("size must be between 2 and 10");
            keyword_error.show();
            return false;
        }



        return true;

    }
}

/******* KeyWord On Change validation*************/
function keywordOnChange () {
    var keyword=$('#keyword').val().trim();
    //Error
    var keyword_error=$('#keyword_error');
    //Error Msg
    var msgError="Empty Field";

    if(!keyword){
        keyword_error.text(msgError);
        keyword_error.show();
    }else{

        if(keyword.length<2){
            keyword_error.text("size must be between 2 and 30");
            keyword_error.show();

        }else{
            keyword_error.hide();
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

/*******Price Master validation*************/

