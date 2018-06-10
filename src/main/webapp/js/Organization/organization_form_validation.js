/**
 * Created by  on 3/22/17.
 */

/*******Organization validation*************/

/*******Form Submit validation*************/

function validtionCheck() {
    var name=$('#name').val().trim();
    var code=$('#code').val().trim();
    var type=$('#type').val();
    var address=$('#address').val().trim();
    var contact=$('#contact').val().trim();
    var hr_employee_name=$('#hr_employee_name').val();
    var latitude=$('#latitude').val().trim();
    var longitude=$('#longitude').val().trim();





    //Error
    var name_error=$('#name_error');
    var code_error=$('#code_error');
    var type_error=$('#type_error');
    var contact_error=$('#contact_error');
    var address_error=$('#address_error');
    var hr_employee_name_error=$('#hr_employee_name_error');
    var latitude_error=$('#latitude_error');
    var longitude_error=$('#longitude_error');


    //Msg Error
    var msgError="Empty Field";
    var msgSelect="NONE Selected";

    if(!name||!code||!contact||!latitude||!longitude||!address||type==0||hr_employee_name==0){

        if(!name){
            name_error.text(msgError);
            name_error.show();
        }

        if(!contact){
            contact_error.text(msgError);
            contact_error.show();
        }

        if(!address){
            address_error.text(msgError);
            address_error.show();
        }
        if(!latitude){
            latitude_error.text(msgError);
            latitude_error.show();
        }
        if(!longitude){
            longitude_error.text(msgError);
            longitude_error.show();
        }


        if(!code){
            code_error.text(msgError);
            code_error.show();
        }

        if(type==0){
            type_error.text(msgSelect);
            type_error.show();
        }
        if(hr_employee_name==0){
            hr_employee_name_error.text(msgSelect);
            hr_employee_name_error.show();
        }

        return false;
    }else{

        if(name.length<2){
            name_error.text("size must be between 2 and 30");
            name_error.show();
            return false;
        }

        if(code.length<2){
            code_error.text("size must be between 2 and 10");
            code_error.show();
            return false;
        }

        if(contact.length<2){
            contact_error.text("size must be between 2 and 30");
            contact_error.show();
            return false;
        }

        if(address.length<2){
            address_error.text("size must be between 2 and 30");
            address_error.show();
            return false;
        }

        return true;

    }
}

/*******Oraganization Ty on Change validation*************/
function typeOnChange () {
    var type=$('#type').val();
    //Error
    var type_error=$('#type_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(type==0){
        type_error.text(msgSelect);
        type_error.show();
    }else{

        type_error.hide();

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
        if(code.length<2){
            code_error.text("size must be between 2 and 30");
            code_error.show();

        }else {
            code_error.hide();
        }

    }

}


/*******Contact On Change validation by murad*************/
function contactOnChange () {
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
            contact_error.text("size must be between 2 and 30");
            contact_error.show();

        }else {
            contact_error.hide();
        }

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


/*******address On Change validation by murad*************/
function addressOnChange () {
    var address=$('#address').val().trim();
    //Error
    var address_error=$('#address_error');
    //Error Msg
    var msgError="Empty Field";

    if(!address){
        address_error.text(msgError);
        address_error.show();
    }else{
        if(address.length<2){
            address_error.text("size must be between 2 and 30");
            address_error.show();

        }else {
            address_error.hide();
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



/*******Hr Employee Name on Change validation*************/
function hrEmployeeNameOnChange() {
    var hr_employee_name=$('#hr_employee_name').val();
    //Error
    var hr_employee_name_error=$('#hr_employee_name_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(hr_employee_name==0){
        hr_employee_name_error.text(msgSelect);
        hr_employee_name_error.show();
    }else{

        hr_employee_name_error.hide();

    }

}

/*******Organization validation*************/
