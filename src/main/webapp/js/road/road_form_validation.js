/**
 * Created by Murad on 9/20/2017.
 */


/**
 * Created by Murad on 9/13/2017.
 */

/*******Customer  validation*************/

/*******Form Submit validation*************/


function validationCheckRoad() {
    var roadName = $('#roadName').val().trim();

    var roadNumber = $('#roadNumber').val().trim();

    var locationId = $('#locationId').val();


    //Error
    var roadName_error = $('#roadName_error');

    var roadNumber_error = $('#roadNumber_error');

    var locationId_error = $('#locationId_error');


    //Msg Error
    var msgError = "Empty Field";
    var msgSelect = "NONE Selected";



//
    if (!roadName || !roadNumber || locationId == 0) {



        if (!roadName) {

            roadName_error.text(msgError);
            roadName_error.show();
        }


        if (!roadNumber) {

            roadNumber_error.text(msgError);
            roadNumber_error.show();
        }

        if (locationId == 0) {
            locationId_error.text(msgSelect);
            locationId_error.show();
        }
        return false;
    } else {

        if (roadName.length < 2) {

            roadName_error.text("size must be between 2 and 30");
            roadName_error.show();
            return false;
        }

        if (roadNumber.length < 2) {
            roadNumber_error.text("size must be between 2 and 10");
            roadNumber_error.show();
            return false;
        }


        return true;

    }
}

/*******Oraganization Ty on Change validation*************/
function locationIdOnChange() {


    var locationId = $('#locationId').val();
    //Error


    var locationId_error = $('#locationId_error');
    //Error Msg
    var msgSelect = "NONE Selected";

    if (locationId == 0) {
        locationId_error.text(msgSelect);
        locationId_error.show();
    } else {

        locationId_error.hide();

    }
}
/*******roadNumber On Change validation*************/
function roadNumberOnChanges() {

    var roadNumber = $('#roadNumber').val().trim();
    //Error
    var roadNumber_error = $('#roadNumber_error');
    //Error Msg
    var msgError = "Empty Field";



    if (!roadNumber) {
        roadNumber_error.text(msgError);
        roadNumber_error.show();
    } else {
        if (roadNumber.length < 2) {
            roadNumber_error.text("size must be between 2 and 30");
            roadNumber_error.show();

        } else {
            roadNumber_error.hide();
        }

    }

}




function roadNameOnChange() {
    var roadName = $('#roadName').val().trim();
    //Error

    var roadName_error = $('#roadName_error');
    //Error Msg
    var msgError = "Empty Field";

    if (!roadName) {
        roadName_error.text(msgError);
        roadName_error.show();
    } else {

        if (roadName.length < 2) {
            roadName_error.text("size must be between 2 and 30");
            roadName_error.show();

        } else {
            roadName_error.hide();
        }
    }

}




/*******Organization validation*************/



