/**
 * Created by Murad on 9/21/2017.
 */

/*******Van  validation*************/

/*******Form Submit validation*************/


function validationCheckVan() {
    var name = $('#name').val().trim();

    var code = $('#code').val().trim();

    var vanTypeId = $('#vanTypeId').val();
    var hrEmployeeInfoId = $('#hrEmployeeInfoId').val();

    var vanNumber = $('#vanNumber').val().trim();
    var driverName = $('#driverName').val().trim();

    var registrationNumber = $('#registrationNumber').val().trim();

    //Error
    var name_error = $('#name_error');

    var code_error = $('#code_error');

    var vanTypeId_error = $('#vanTypeId_error');
    var hrEmployeeInfoId_error = $('#hrEmployeeInfoId_error');
    var registrationNumber_error = $('#registrationNumber_error');

    var vanNumber_error = $('#vanNumber_error');
    var driverName_error = $('#driverName_error');
    //Msg Error
    var msgError = "Empty Field";
    var msgSelect = "NONE Selected";



//
    if (!name || !driverName|| !code || !registrationNumber || !vanNumber || vanTypeId == 0||hrEmployeeInfoId==0) {



        if (!name) {

            name_error.text(msgError);
            name_error.show();
        }

        if (!registrationNumber) {

            registrationNumber_error.text(msgError);
            registrationNumber_error.show();
        }

        if (!vanNumber) {

            vanNumber_error.text(msgError);
            vanNumber_error.show();
        }


        if (!driverName) {

            driverName_error.text(msgError);
            driverName_error.show();
        }


        if (!code) {

            code_error.text(msgError);
            code_error.show();
        }


        if (vanTypeId == 0) {
            vanTypeId_error.text(msgSelect);
            vanTypeId_error.show();
        }


        if (hrEmployeeInfoId == 0) {
            hrEmployeeInfoId_error.text(msgSelect);
            hrEmployeeInfoId_error.show();
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

        if (registrationNumber.length < 2) {
            registrationNumber_error.text("size must be between 2 and 30");
            registrationNumber_error.show();
            return false;
        }

        if (vanNumber.length < 2) {
            vanNumber_error.text("size must be between 2 and 30");
            vanNumber_error.show();
            return false;
        }

        return true;

    }
}

/*******Oraganization Ty on Change validation*************/
function typeOnChangeVan() {
    var vanTypeId = $('#vanTypeId').val();
    //Error
    var vanTypeId_error = $('#vanTypeId_error');
    //Error Msg
    var msgSelect = "NONE Selected";

    if (vanTypeId == 0) {
        vanTypeId_error.text(msgSelect);
        vanTypeId_error.show();
    } else {

        vanTypeId_error.hide();

    }

}

/*******Oraganization Ty on Change validation*************/
function hrtypeOnChanges() {
    var hrEmployeeInfoId = $('#hrEmployeeInfoId').val();
    //Error
    var hrEmployeeInfoId_error = $('#hrEmployeeInfoId_error');
    //Error Msg
    var msgSelect = "NONE Selected";

    if (hrEmployeeInfoId == 0) {
        hrEmployeeInfoId_error.text(msgSelect);
        hrEmployeeInfoId_error.show();
    } else {

        hrEmployeeInfoId_error.hide();

    }

}




/*******Code On Change validation*************/
function codeOnChangeVan() {
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




/*******driverName On Change validation*************/
function driverNameOnChanges() {
    var driverName = $('#driverName').val().trim();
    //Error
    var driverName_error = $('#driverName_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!driverName) {
        driverName_error.text(msgError);
        driverName_error.show();
    } else {
        if (driverName.length < 2) {
            driverName_error.text("size must be between 2 and 30");
            driverName_error.show();

        } else {
            driverName_error.hide();
        }

    }

}


/*******registrationNumber On Change validation by murad*************/
function registrationNumberOnChanges() {
    var registrationNumber = $('#registrationNumber').val().trim();
    //Error
    var registrationNumber_error = $('#registrationNumber_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!registrationNumber) {
        registrationNumber_error.text(msgError);
        registrationNumber_error.show();
    } else {
        if (registrationNumber.length < 2) {
            registrationNumber_error.text("size must be between 2 and 30");
            registrationNumber_error.show();

        } else {
            registrationNumber_error.hide();
        }

    }

}


/*******vanNumber On Change validation by murad*************/
function vanNumberOnChanges() {
    var vanNumber = $('#vanNumber').val().trim();
    //Error
    var vanNumber_error = $('#vanNumber_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!vanNumber) {
        vanNumber_error.text(msgError);
        vanNumber_error.show();
    } else {
        if (vanNumber.length < 2) {
            vanNumber_error.text("size must be between 2 and 30");
            vanNumber_error.show();

        } else {
            vanNumber_error.hide();
        }

    }

}

/******* name On Change validation*************/
function nameOnChangeVan() {
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


