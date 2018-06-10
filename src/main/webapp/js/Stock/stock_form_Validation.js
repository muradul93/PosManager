/**
 * Created by Murad on 10/9/2017.
 */



/*******Form Submit validation*************/



function validtionCheckStock() {
    var inware=$('#inware').val();
    //Error
    var inware_error=$('#inware_error');
    //Msg Error
    var msgError="Empty Field";
    var msgSelectorError="NONE Selected";
    var msgNumberError="Number Only";

    console.log("inware :"+inware);
   // console.log("from :"+ware);


    if(inware==0){

        if(inware==0){
            inware_error.text(msgSelectorError);
            inware_error.show();
        }



        return false;
    }else{






        return true;

    }
}



/*******Mou Name on Change validation*************/
function inwareOnChange () {
    var inware=$('#inware').val();
    //Error
    var inware_error=$('#inware_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(inware==0){
        inware_error.text(msgSelect);
        inware_error.show();
    }else{

        inware_error.hide();

    }

}


