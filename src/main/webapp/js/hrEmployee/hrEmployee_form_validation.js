/**
 * Created by  on 3/22/17.
 */

/*******HR Employee validation*************/

/*******Form Submit validation*************/

function validtionCheck() {
    var name = $('#name').val().trim();
    var code = $('#code').val().trim();
    var email = $('#email').val().trim();
    var nID = $('#nID').val().trim();
    var salary = $('#salary').val().trim();
    var startDate = $('#startDate').val().trim();
    var endDate = $('#endDate').val().trim();
    var contact = $('#contact').val().trim();
    var designation = $('#designation').val().trim();
    var postingArea = $('#postingArea').val().trim();


    //Error
    var name_error = $('#name_error');
    var code_error = $('#code_error');
    var email_error = $('#email_error');
    var nID_error = $('#nID_error');
    var salary_error = $('#salary_error');
    var sDate_error = $('#sDate_error');
    var eDate_error = $('#eDate_error');
    var contact_error = $('#contact_error');
    var designation_error = $('#designation_error');
    var postingArea_error = $('#postingArea_error');

    //Msg Error
    var msgError = "Empty Field";
    var msgDateError = "Invalid!(Date Format Must MM/DD/YY )";
    var msgNumberError = "Only Number";
    var msgEmailError = "Invalid Email!";



    if (!name || !code || !nID ||!contact||!designation||!postingArea|| !salary || !startDate) {

        if (!name) {
            name_error.text(msgError);
            name_error.show();
        }
        if (!code) {
            code_error.text(msgError);
            code_error.show();
        }
        if (!nID) {
            nID_error.text(msgError);
            nID_error.show();
        }
        if (!salary) {
            salary_error.text(msgError);
            salary_error.show();
        }
        if (!contact) {
            contact_error.text(msgError);
            contact_error.show();
        }
        if (!designation) {
            designation_error.text(msgError);
            designation_error.show();
        }

        if (!postingArea) {
            postingArea_error.text(msgError);
            postingArea_error.show();
        }

        if (!startDate) {
            sDate_error.text(msgError);
            sDate_error.show();
        }


        return false;
    } else {

        if (name.length < 2) {
            name_error.text("size must be between 2 and 30");
            name_error.show();
            return false;
        }
        if (!isValidEmailAddress(email)) {
            $('#email').val("");
            email_error.text(msgEmailError);
            email_error.show();
            return false;
        }

        if (!isValidateNumber(salary)) {
            $('#salary').val("");
            salary_error.text(msgNumberError);
            salary_error.show();
            return false;
        }

        if (!isValidateDate(startDate)) {
            $('#startDate').val("");
            sDate_error.text(msgDateError);
            sDate_error.show();
            return false;
        }

       /* if (!isValidateDate(endDate)) {
            $('#endDate').val("");
            eDate_error.text(msgDateError);
            eDate_error.show();
            return false;
        }*/


        return true;

    }
}

/*******Start Date On Change validation*************/
function startDateOnChange() {
    var startDate = $('#startDate').val().trim();
    //Error
    var sDate_error = $('#sDate_error');
    //Error Msg
    var msgDateError = "Invalid!(Date Format Must MM/DD/YY )";
    var msgError = "Empty Field";

    if (!startDate) {
        sDate_error.text(msgError);
        sDate_error.show();
    } else {
        if (!isValidateDate(startDate)) {
            $('#startDate').val("");
            sDate_error.text(msgError);
            sDate_error.show();
        } else {
            sDate_error.hide();
        }
    }

}


/*******Salary On Change validation*************/
function salaryOnChange() {
    var salary = $('#salary').val().trim();
    //Error
    var salary_error = $('#salary_error');
    //Error Msg
    var msgNumberError = "Only Number";
    var msgError = "Empty Field";
    if (!salary) {
        salary_error.text(msgError);
        salary_error.show();
    } else {
        if (!isValidateNumber(salary)) {
            $('#salary').val("");
            salary_error.text(msgNumberError);
            salary_error.show();
        } else {
            salary_error.hide();
        }
    }

}


/*******contact On Change validation*************/
function contactOnChange() {
    var contact = $('#contact').val().trim();
    //Error
    var contact_error = $('#contact_error');
    //Error Msg
    var msgNumberError = "Only Number";
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


/*******postingArea On Change validation*************/
function postingAreaOnChange() {
    var postingArea = $('#postingArea').val().trim();
    //Error
    var postingArea_error = $('#postingArea_error');
    //Error Msg
    var msgNumberError = "Only Number";
    var msgError = "Empty Field";
    if (!postingArea) {
        postingArea_error.text(msgError);
        postingArea_error.show();
    } else {
        if (postingArea.length < 2) {
            postingArea_error.text("size must be between 2 and 30");
            postingArea_error.show();

        } else {
            postingArea_error.hide();
        }

    }

}


/*******designation On Change validation*************/
function designationOnChange() {
    var designation = $('#designation').val().trim();
    //Error
    var designation_error = $('#designation_error');
    //Error Msg
    var msgNumberError = "Only Number";
    var msgError = "Empty Field";
    if (!designation) {
        designation_error.text(msgError);
        designation_error.show();
    } else {
        if (designation.length < 2) {
            designation_error.text("size must be between 2 and 30");
            designation_error.show();

        } else {
            designation_error.hide();
        }

    }

}



/*******National ID on Change validation*************/
function nationalIdOnChange() {
    var nID = $('#nID').val().trim();
    //Error
    var nID_error = $('#nID_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!nID) {
        nID_error.text(msgError);
        nID_error.show();
    } else {
        nID_error.hide();

    }

}
/*******Code On Change validation*************/
function codeOnChange() {
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
            code_error.text("size must be between 2 and 10");
            code_error.show();

        } else {
            code_error.hide();
        }

    }

}
/******* Name On Change validation*************/
function nameOnChange() {
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

/*******HR Employee validation*************/

/******* Email validation*************/
function isValidEmailAddress(emailAddress) {
    var pattern = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
    return pattern.test(emailAddress);
}

/*******Date validation*************/
function isValidateDate(dtValue) {
    var dtRegex = new RegExp(/\b\d{1,2}[\/-]\d{1,2}[\/-]\d{4}\b/);
    return dtRegex.test(dtValue);
}

/*******Number validation*************/
function isValidateNumber(Value) {
    var temp = parseFloat(Value);
    return !isNaN(temp);
}
