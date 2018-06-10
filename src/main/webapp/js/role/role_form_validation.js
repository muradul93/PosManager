/**
 * Created by  on 3/22/17.
 */

/*******Role validation*************/

/*******Form Submit validation*************/

function validtionCheck() {
    var name=$('#name').val().trim();
    var description=$('#description').val();

   // description

    //Error
    var name_error=$('#name_error');
    var description_error=$('#description_error');

    //Msg Error
    var msgError="Empty Field";

    if(!name||!description){

        if(!name){
            name_error.text(msgError);
            name_error.show();
        }
        if(!description){
            description_error.text(msgError);
            description_error.show();
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


/******* Name On Change validation *************/
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



/******* Name On Change validation*************/
function descriptionOnChange () {
    var description=$('#description').val().trim();
    //Error
    var description_error=$('#description_error');
    //Error Msg
    var msgError="Empty Field";

    if(!description){
        description_error.text(msgError);
        description_error.show();
    }else{

        if(description.length<2){
            description_error.text("size must be between 2 and more");
            description_error.show();

        }else{
            description_error.hide();
        }
    }

}

/*******Role validation*************/

