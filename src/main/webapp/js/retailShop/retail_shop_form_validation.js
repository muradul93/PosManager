/**
 * Created by  on 3/22/17.
 */

/*******Retail Shop validation*************/

function validtionCheck() {
    var name=$('#name').val().trim();
    var code=$('#code').val().trim();
    var latitude=$('#latitude').val().trim();
    var longitude=$('#longitude').val().trim();
    var contact=$('#contact').val().trim();
    var location=$('#location').val();
    var road_name=$('#road_name').val();
    var hr_employee_name=$('#hr_employee_name').val();

    //Error
    var name_error=$('#name_error');
    var code_error=$('#code_error');
    var contact_error=$('#contact_error');
    var location_error=$('#location_error');
    var locationId_error=$('#locationId_error');
    var latitude_error=$('#latitude_error');
    var longitude_error=$('#longitude_error');
    var hr_employee_name_error=$('#hr_employee_name_error');
    var roadId_error = $('#roadId_error');
    //Msg Error
    var msgError="Empty Field";
    var msgSelect="NONE Selected";






    if(!name||!code||!contact||!latitude||!longitude|| road_name==0||hr_employee_name==0){

        if(!name){
            name_error.text(msgError);
            name_error.show();
        }

        if(!code){
            code_error.text(msgError);
            code_error.show();
        }

        if(!contact){
            contact_error.text(msgError);
            contact_error.show();
        }

        if(!latitude){
            latitude_error.text(msgError);
            latitude_error.show();
        }
        if(!longitude){
            longitude_error.text(msgError);
            longitude_error.show();
        }


        if(road_name==0){
            roadId_error.text(msgSelect);
            roadId_error.show();
        }

        if (hr_employee_name == 0) {
            hr_employee_name_error.text(msgSelect);
            hr_employee_name_error.show();
            return false;
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

        return true;

    }
}

function roadNameOnChangeCheck() {

    var road_name = $('#road_name').val();
    //Error


    var roadId_error = $('#roadId_error');
    //Error Msg
    var msgSelect = "NONE Selected";

    if (road_name == 0) {
        roadId_error.text(msgSelect);
        roadId_error.show();
    } else {

        roadId_error.hide();

    }
}
/*******User on Change validation*************/
function userOnChange () {
    var user=$('#user').val();
    //Error
    var user_error=$('#user_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(user==0){
        user_error.text(msgSelect);
        user_error.show();
    }else{

        user_error.hide();

    }

}

/*******location on Change validation*************/
function locationOnChange() {
    var location=$('#location').val();
    //Error
    var location_error=$('#location_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(location==0){
        location_error.text(msgSelect);
        location_error.show();
    }else{

        location_error.hide();

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

/*******Code On Change validation*************/
function codeOnChange() {
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
            code_error.text("size must be between 2 and 20");
            code_error.show();

        }else {
            code_error.hide();
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

/*******Retail Shop validation*************/

