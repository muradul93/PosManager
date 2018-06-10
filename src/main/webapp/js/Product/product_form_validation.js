/**
 * Created by  on 3/22/17.
 */

/*******Product validation*************/

/*******Form Submit validation*************/

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");

function validtionCheckProduct() {
    var pro_id=$('#product_id').val().trim();
    var productName=$('#productName').val().trim();
    var skuCode=$('#skuCode').val().trim();
    var mouName=$('#mouName').val();
    var skuQty=$('#skuQty').val().trim();
    var productType=$('#productType').val();

    //Error
    var productName_error=$('#productName_error');
    var skuCode_error=$('#skuCode_error');
    var mouName_error=$('#mouName_error');
    var skuQty_error=$('#skuQty_error');
    var productType_error=$('#productType_error');

    //Msg Error
    var msgError="Empty Field";
    var msgSelectorError="NONE Selected";
    var msgNumberError="Number Only";

    if(!productName||!skuCode ||mouName==0||!skuQty||productType==0){

        if(!productName){
            productName_error.text(msgError);
            productName_error.show();
        }

        if(!skuCode){
            skuCode_error.text(msgError);
            skuCode_error.show();
        }

        if(mouName==0){
            mouName_error.text(msgSelectorError);
            mouName_error.show();
        }

        if(!skuQty){
            skuQty_error.text(msgError);
            skuQty_error.show();
        }

        if(productType==0){
            productType_error.text(msgSelectorError);
            productType_error.show();
        }


        return false;
    }else{

        if(productName.length<2){
            productName_error.text("size must be between 2 and 10");
            productName_error.show();
            return false;
        }

        /*$.ajax({
            type: 'POST',
            url: _ctx + 'Product/checkProductNameUnique',
            data: {"pid": pro_id,
                    "productName": productName
            },
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function (callback) {
                if (callback==='true') {
                    // return true;
                    console.log("True");
                }else {
                    // return false;
                }
            },
            error: function () {
                alert("error");
            }
        });*/


        if(skuCode.length<2){
            skuCode_error.text("size must be between 2 and 10");
            skuCode_error.show();
            return false;
        }

        if(!isValidateNumber(skuQty)){
            var skuQty=$('#skuQty').val().trim("");
            productName_error.text(msgNumberError);
            productName_error.show();
        }



        return true;

    }
}

/*******Product Type on Change validation*************/
function productTypeOnChange () {
    var productType=$('#productType').val();
    //Error
    var productName_error=$('#productType_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(productType==0){
        productName_error.text(msgSelect);
        productName_error.show();
    }else{

        productName_error.hide();

    }

}

/*******Mou Name on Change validation*************/
function mouNameOnChange () {
    var mouName=$('#mouName').val();
    //Error
    var mouName_error=$('#mouName_error');
    //Error Msg
    var msgSelect="NONE Selected";

    if(mouName==0){
        mouName_error.text(msgSelect);
        mouName_error.show();
    }else{

        mouName_error.hide();

    }

}

/******* Sku Qty On Change validation*************/
function skuQtyOnChange () {
    var skuQty=$('#skuQty').val().trim();
    //Error
    var skuQty_error=$('#skuQty_error');
    //Error Msg
    var msgError="Empty Field";
    var msgNumber="Only Number"

    if(!skuQty){
        skuQty_error.text(msgError);
        skuQty_error.show();
    }else{

        if(!isValidateNumber(skuQty)){
            $('#skuQty').val("");
            skuQty_error.text(msgNumber);
            skuQty_error.show();

        }else{
            skuQty_error.hide();
        }
    }

}

/******* Sku Code On Change validation*************/
function skuCodeOnChange () {
    var skuCode=$('#skuCode').val().trim();
    //Error
    var skuCode_error=$('#skuCode_error');
    //Error Msg
    var msgError="Empty Field";

    if(!skuCode){
        skuCode_error.text(msgError);
        skuCode_error.show();
    }else{

        if(skuCode.length<2){
            skuCode_error.text("size must be more then 2");
            skuCode_error.show();

        }else{
            skuCode_error.hide();
        }
    }

}



/******* Name On Change validation*************/
function productNameOnChanges() {
    var productName=$('#productName').val().trim();
    //Error
    var productName_error=$('#productName_error');
    //Error Msg
    var msgError="Empty Field";

    if(!productName){
        productName_error.text(msgError);
        productName_error.show();
    }else{

        if(productName.length<2){
            productName_error.text("size must be between 2 and 30");
            productName_error.show();

        }else{
            productName_error.hide();
        }
    }

}

/*******Product validation*************/

/*******Number validation*************/
function isValidateNumber(Value) {
    var temp = parseFloat(Value);
    return !isNaN(temp);
}