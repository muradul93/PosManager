/**
 * Created by Murad on 9/13/2017.
 */

function validationCheckCustomer() {
    var customerName = $('#customerName').val().trim();
    var type = $('#type').val();
    var contact = $('#contact').val().trim();
    var latitude=$('#latitude').val().trim();
    var longitude=$('#longitude').val().trim();
    var road_name=$('#road_name').val();
    var hr_employee_name=$('#hr_employee_name').val();
    var master=$('#master').val();

    //Error
    var customerName_error = $('#customerName_error');
    var type_error = $('#type_error');
    var contact_error = $('#contact_error');
    var latitude_error=$('#latitude_error');
    var longitude_error=$('#longitude_error');
    var master_error=$('#master_error');
    var hr_employee_name_error=$('#hr_employee_name_error');
    var roadId_error = $('#roadId_error');


    //Msg Error
    var msgError = "Empty Field";
    var msgSelect = "NONE Selected";



//
    if (!customerName || !contact ||!latitude||!longitude|| master==0|| road_name==0||hr_employee_name==0|| type == 0) {

        if (!customerName) {

            customerName_error.text(msgError);
            customerName_error.show();
        }

        if (!contact) {

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

        if(master==0){
            master_error.text(msgSelect);
            master_error.show();
        }


        if (hr_employee_name == 0) {
            hr_employee_name_error.text(msgSelect);
            hr_employee_name_error.show();
        }


        if (type == 0) {
            type_error.text(msgSelect);
            type_error.show();
        }

        return false;
    } else {

        if (customerName.length < 2) {

            alert("length");
            customerName_error.text("size must be between 2 and 30");
            customerName_error.show();
            return false;
        }


        if (contact.length < 2) {
            contact_error.text("size must be between 2 and 30");
            contact_error.show();
            return false;
        }



        return true;

    }
}

/*******Oraganization Ty on Change validation*************/
function typeOnChanges() {
    var type = $('#type').val();
    //Error
    var type_error = $('#type_error');
    //Error Msg
    var msgSelect = "NONE Selected";

    if (type == 0) {
        type_error.text(msgSelect);
        type_error.show();
    } else {

        type_error.hide();

    }

}


function masterOnChange() {
    var master = $('#master').val();
    //Error
    var master_error = $('#master_error');
    //Error Msg
    var msgSelect = "NONE Selected";

    if (master == 0) {
        master_error.text(msgSelect);
        master_error.show();
    } else {

        master_error.hide();

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


/*******Contact On Change validation by murad*************/
function contactOnChanges() {
    var contact = $('#contact').val().trim();
    //Error
    var contact_error = $('#contact_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!contact) {
        contact_error.text(msgError);
        contact_error.show();
    } else {
        if (contact.length < 2) {
            contact_error.text("size must be between 2 and 30");
            contact_error.show();

        } else {
            contact_error.hide();
        }

    }

}

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

/******* customerName On Change validation*************/
function customerNameOnChange() {
    var customerName = $('#customerName').val().trim();
    //Error
    var customerName_error = $('#customerName_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!customerName) {
        customerName_error.text(msgError);
        customerName_error.show();
    } else {

        if (customerName.length < 2) {
            customerName_error.text("size must be between 2 and 30");
            customerName_error.show();

        } else {
            customerName_error.hide();
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


/*******Organization validation*************/


