/**
 * Created by root on 2/22/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
var rowCount = 1;

var shopName = [];

function addMoreRows(frm) {


    shopName.push( $('#shopName' + frm).val());
    rowCount++;
    var recRow = '<tr id="rowCount' + rowCount + '">' +
        '<td width="40%"><input name="shop" type="text" class="form-control" onkeyup="onLetterChange(' + rowCount + ');"  id="shopName' + rowCount + '" placeholder="shop"> ' +
        '<span style="color: red;display: none;" id="pSpanValue' + rowCount + '"  />' +
        '<input name="shopName" id="shopId' + rowCount + '" type="hidden" class="A " /></td>' +
        '<td><input name="shopOrder" type="text" class="B form-control" /></td>' +
        '<td><input name="midShop" type="checkbox" class="C form-control" /></td>' +
        '<td><button type="button" id="removeBtn' + rowCount + '"  onclick="removeRow(' + rowCount + ');"  class="btn btn-danger btn-sm">' +
        '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>' +
        '</button>' +
        '<button type="button" id="addBtn' + rowCount + '" onclick="addMoreRows(' + rowCount + ');" disabled="true"   class="E btn  btn-primary btn-sm">' +
        '<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>' +
        '</button></td>' +
        '</tr>';

    $('#shop-id').append(recRow);

}

function removeRow(removeNum) {
    jQuery('#rowCount' + removeNum).remove();
}

function sendDt() {
    var dataA = [];
    var dataB = [];
    var dataC = [];
    var dataABC = [];

    $('#shop-id tr .A').each(function () {
        console.log( "..........."+$(this).val());
        dataA.push($(this).val());
    });

    $('#shop-id tr .B').each(function () {
        dataB.push($(this).val());
    });

    $('#shop-id tr .C').each(function () {
        dataC.push($(this).is(":checked") ? "true" : "false");
    });

    for (var i = 0; i < dataA.length; i++) {
        item = {};
        item ["shopid"] = dataA[i];
        item ["shopOrder"] = dataB[i];
        item ["midShop"] = dataC[i];
        dataABC.push(item);
    }

    var allABC = {};
    allABC["shops"] = dataABC;
    allABC["code"] = $("#code-no").val();
    allABC["roadName"] = $("#road-name").val();
    allABC["roadNumber"] = $("#road-number").val();
    allABC["locationId"] = $("#location-id").find('option:selected').val();


    console.log("Rsult sending to server:");
    console.log(JSON.stringify(allABC));

    $.ajax({
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        url: _ctx + 'road/save',
        dataType: 'json',
        data: JSON.stringify(allABC),
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (callback) {
           // window.location.replace("/road/allRoad");
        },
        error: function () {
            alert("error");
        }
    });


}


function onLetterChange(va) {

    var shopValue = $.trim($('#shopName' + va).val());
    var unitnameErrorField = $('#pSpanValue' + va).text("Please Fill the Field");


    if (shopValue.length > 0) {
        unitnameErrorField.hide();
        autocompleteServerHit(va, unitnameErrorField);
    } else {

        if (shopName.length > 0) {
            shopName.pop();
        }
        unitnameErrorField.show();
    }
}

// Auto Complete Request
function autocompleteServerHit(va, error) {
    var shopNameStrig = jQuery('#shopName' + va).val();
    var locationId= $("#location-id").find('option:selected').val();

    $.ajax({
        type: 'POST',
        url: _ctx + 'retailShop/find',
        data: {"pid": shopNameStrig,"locationId":locationId},
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (callback) {
            console.log(callback);

            var availableName = [];

            $.each(callback, function (key, value) {
                console.log(value.shopName);
                if (jQuery.inArray(value.shopName, shopName) == -1) {
                    availableName.push(value.shopName);
                }

            });

            $('#shopName' + va).autocomplete({
                source: availableName,
                select: function (event, ui) {

                    $.each(callback, function (key, value) {
                        console.log(value.shopName);

                        if (ui.item.value == value.shopName) {
                            //error.hide();

                            //if(rowCount==va) {
                           $('#addBtn' + va).prop('disabled', false);
                            $('#shopId' + va).val(value.shopId);
                            //}
                            console.log("select" + value.shopId);
                            //productName.push(value.productName);

                        }

                    });

                }
            });

        },
        error: function () {
            alert("error");
        }
    });
}

