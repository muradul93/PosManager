/**
 * Created by root on 2/22/17.
 */

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
var masterId;
//Edit Form Value Request from Server
$(window).load(function () {
    // var serverurl = ;
    $.ajax({
        //contentType: 'application/json; charset=utf-8',
        type: 'POST',
        url: _ctx+ 'warehousemaster/editValue',
        // dataType: 'json',
        data: {"pid": '1'},
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (callback) {
            console.log(callback);

            $("#organization_from").val(callback.from);
            $("#organization_to").val(callback.to);
            $('#status').val(callback.status);
            $('#batch_no').val(callback.batchNo);
            masterId = callback.id;


            addAbleViewDataManaeger(callback.detailss);

            var tablerows = $("#wareHouseDetais tr").length;

            console.log("T R" + tablerows)

            if (tablerows == 2) {
                $('#addBtn2').show();
                $('#addBtn2').prop('disabled', false);
                $('#editBtn2').hide();
                $('#pRow2').prop('disabled', false);
                $('#wQty2').prop('disabled', false);

            } else if (tablerows > 2) {


                $("#wareHouseDetais tr:last-child").find("td:last").find("button:nth-child(2)").prop('disabled', false);
                console.log("Last Button Value" + $("#wareHouseDetais tr:last-child").find("td:last").find("button:nth-child(2)").html());
            }
        },
        error: function () {
            alert("error");
        }
    });
});

// Requested Form Value Set Input Field
function addAbleViewDataManaeger(Data) {
    var counter = 1;
    $.each(Data, function (key, value) {
        console.log(value.qty);
        if (counter > 1) {
            addMoreRows(rowCount);
        }
        jQuery('#pSku' + rowCount).val(value.skuQty);
        jQuery('#squeQnty' + rowCount).val(value.baseSkuQnty);
        jQuery('#wQty' + rowCount).val(value.qty);
        jQuery('#pRowValue' + rowCount).val(value.product_id);
        jQuery('#pMouValue' + rowCount).val(value.mou_id);
        jQuery('#pRow' + rowCount).val(value.productName);
        jQuery('#pMou' + rowCount).val(value.mouName);

        counter++;


    });


}


var rowCount = 2;
var productName = [];
var skuQty;

//Form Table Row Add
function addMoreRows(frm) {

    // $('#addBtn' + rowCount).prop('disabled', true);
    $('#addBtn' + frm).hide();
    $('#editBtn' + frm).show();

    // $('#removeBtn' + rowCount).prop('disabled', true);
    $('#pRow' + frm).prop('disabled', true);
    $('#wQty' + frm).prop('disabled', true);

    productName.push($('#pRow' + frm).val());

    rowCount++;

    console.log("on" + rowCount);

    var recRow = '<tr id="rowCount' + rowCount + '"> <td width="20%"><input name="product" type="text" class="form-control" onkeyup="onLetterChange(' + rowCount + ');"  id="pRow' + rowCount + '" placeholder="Product" readonly>' +
        '<span style="color: red;display: none;" id="pSpanValue' + rowCount + '"  />' +
        '<input    type="hidden" id="pRowValue' + rowCount + '" class="A" /></td>' +

        '<td width="20%"><input  name="mou" type="text" id="pMou' + rowCount + '" class="form-control" readonly>' +
        '<input    type="hidden" id="pMouValue' + rowCount + '"  class="B" /></td>' +

        '<td width="20%"><input name="skuQty" type="text" id="pSku' + rowCount + '" class="C form-control"  readonly/>' +
        '<input    type="hidden" id="squeQnty' + rowCount + '"   /></td>' +

        '<td width="20%"><input id="wQty' + rowCount + '" name="qty" onchange="onLetterChangeQty(' + rowCount + ')" class="D form-control" readonly >' +
        '<span style="color: red;display: none;" id="qSpanValue' + rowCount + '"  /></td>' +
        // '<td width="20%" class="text-center">' +
        // '<button type="button" id="removeBtn' + rowCount + '"  onclick="removeRow(' + rowCount + ');"  class="btn btn-danger btn-sm">' +
        // '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>' +
        // '</button>' +
        // '<button type="button" id="addBtn' + rowCount + '" onclick="addMoreRows(' + rowCount + ');" disabled="true"   class="E btn  btn-primary btn-sm">' +
        // '<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>' +
        // '</button>' +
        // '<button type="button" id="editBtn' + rowCount + '" onclick="editClick(' + rowCount + ');" style="display: none;" class="btn btn-primary btn-sm">' +
        // '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>' +
        // '</button>' +
        // '<button type="button" id="saveBtn' + rowCount + '" onclick="saveClick(' + rowCount + ');" style="display: none;" class="btn btn-primary btn-sm">' +
        // '<span class="	glyphicon glyphicon-ok" aria-hidden="true"></span>' +
        // '</button>' +
        // '</td>' +
        '</tr>';
    $('#wareHouseDetais').append(recRow);
}

function saveClick(va) {
    $('#wQty' + va).prop('disabled', true);
    $('#editBtn' + va).show();
    $('#saveBtn' + va).hide();
}

function editClick(va) {

    $('#wQty' + va).prop('disabled', false);
    $('#editBtn' + va).hide();
    $('#saveBtn' + va).show();


}

//Form Table Row Remove
function removeRow(removeNum) {

    if (jQuery.inArray($('#pRow' + removeNum).val(), productName) != -1) {
        productName = productName.filter(function (i) {
            return i != $('#pRow' + removeNum).val();
        });
    }


    if (removeNum > 2) {
        //$('#removeBtn' + (removeNum - 1)).prop('disabled', false);
        jQuery('#rowCount' + removeNum).remove();


    }


    var tablerows = $("#wareHouseDetais tr").length;

    console.log("T R" + tablerows)

    if (tablerows == 2) {
        $('#addBtn2').show();
        $('#editBtn2').hide();
        $('#pRow2').prop('disabled', false);
        $('#wQty2').prop('disabled', false);

    } else if (tablerows > 2) {
        $("#wareHouseDetais tr:last-child").find("td:last-child").find("button:nth-child(2)").show();
        $("#wareHouseDetais tr:last-child").find("td:last-child").find("button:nth-child(3)").hide();
        $("#wareHouseDetais tr:last-child").find("td:last-child").find("button:nth-child(4)").hide();
        $("#wareHouseDetais tr:last-child").find("td:nth-child(1)").find("input:nth-child(1)").prop('disabled', false);
        $("#wareHouseDetais tr:last-child").find("td:nth-child(4)").find("input:nth-child(1)").prop('disabled', false);
    }


    if (rowCount > 2) {
        rowCount--;

    }

}

//Form Data Process
function sendDt() {
    var dataA = [];
    var dataB = [];
    var dataC = [];
    var dataD = [];
    var dataABC = [];
    var as = $('#wareHouseDetais').size();

    console.log("Size" + as);


    $('#wareHouseDetais tr .A ').each(function () {
        var textvalue = $.trim($(this).val());
        console.log("A :" + $(this).val());
        if (textvalue.length > 0) {
            dataA.push(textvalue);
        }
    });

    $('#wareHouseDetais tr .B').each(function () {
        var textvalue = $.trim($(this).val());
        console.log("B :" + $(this).val());
        if (textvalue.length > 0) {
            dataB.push(textvalue);
        }

    });

    $('#wareHouseDetais tr .C ').each(function () {

        var textvalue = $.trim($(this).val());

        console.log("C :" + $(this).val());
        if (textvalue.length > 0) {

            dataC.push(textvalue);
        }

    });
    $('#wareHouseDetais tr .D ').each(function () {
        var textvalue = $.trim($(this).val());
        console.log("D :" + $(this).val());
        if (textvalue.length > 0) {
            dataD.push(textvalue);
        }

    });

    for (var i = 0; i < dataA.length; i++) {
        item = {};
        item ["productId"] = dataA[i];
        item ["mouId"] = dataB[i];
        item ["skuQty"] = dataC[i];
        item ["qty"] = dataD[i];
        dataABC.push(item);
    }

    var allABC = {};

    var orgFrom = $("#organization_from").find('option:selected').val();
    var orgTo = $("#organization_to").find('option:selected').val();

    var wStatus = $.trim($('#status').val());
    var wBatch = $.trim($('#batch_no').val());


    var batchErrorField = $('#BachNoError').text("Please Fill the Field");
    var statusErrorField = $('#StatusError').text("Please Fill the Field");
    var fromErrorField = $('#fromErrorFeild').text("Please Select Form");
    var toErrorField = $('#toErrorFeild').text("Please Select To");
    var detailsErrorField = $('#detailsErrorFeild').text("Please Add Ware House Details");


    if (orgFrom != '0' && orgTo != '0' && wStatus.length > 0 && wBatch.length > 0 && dataA.length > 0) {
        var serverurl = _ctx+'warehousemaster/editsave';

        allABC["id"]=masterId;
        allABC["wareHouseStockTransDetailss"] = dataABC;
        allABC["from"] = orgFrom;
        allABC["to"] = orgTo;
        allABC["batchNO"] = wBatch;
        allABC["status"] = wStatus;

        console.log("Rsult sending to server:");
        console.log(JSON.stringify(allABC));

        serverHit(serverurl, "", allABC);

    } else if (orgFrom == '0') {

        fromErrorField.show();
        toErrorField.hide();
        batchErrorField.hide();
        statusErrorField.hide();
        detailsErrorField.hide();

    } else if (orgTo == '0') {

        fromErrorField.hide();
        toErrorField.show();
        batchErrorField.hide();
        statusErrorField.hide();
        detailsErrorField.hide();

    } else if (wBatch.length <= 0) {

        batchErrorField.show();
        statusErrorField.hide();
        fromErrorField.hide();
        toErrorField.hide();
        detailsErrorField.hide();

    } else if (wStatus.length <= 0) {

        statusErrorField.show();
        batchErrorField.hide();
        fromErrorField.hide();
        toErrorField.hide();
        detailsErrorField.hide();

    } else if (dataA.length <= 0) {

        statusErrorField.hide();
        batchErrorField.hide();
        fromErrorField.hide();
        toErrorField.hide();
        detailsErrorField.show();
    }


}

//Server Hit For Save Form Data
function serverHit(serverUrl, redirectUrl, jsonObject) {
    $.ajax({
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        url: serverUrl,
        dataType: 'json',
        data: JSON.stringify(jsonObject),
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (callback) {
            //window.location.replace("/warehousemaster/alldetails");
        },
        error: function () {
            alert("error");
        }
    });
}

//Validation
function onLetterChangeQty(va) {

    var pvalue = $.trim($('#wQty' + va).val());
    var unitnameErrorField = $('#qSpanValue' + va).text("Please Fill the Field");
    if (pvalue.length > 0) {
        var qvalue = $.trim($('#wQty' + va).val());

        var qntytyvalue = parseInt(qvalue, 10);
        skuQty = $.trim( jQuery('#squeQnty' + va).val());
        var sqtyvalue = parseInt(skuQty, 10);

        console.log(skuQty+" v "+sqtyvalue);

        if (!isNaN(qntytyvalue)) {
            sqtyvalue = sqtyvalue * qntytyvalue;
            $('#pSku' + va).val(sqtyvalue);
        } else {
            $('#pSku' + va).val(skuQty);
        }


        unitnameErrorField.hide();

    } else {

        unitnameErrorField.show();
    }

    // if(){}
}

//Validation And Auto Complete Request Method Call
function onLetterChange(va) {

    var pvalue = $.trim($('#pRow' + va).val());
    var unitnameErrorField = $('#pSpanValue' + va).text("Please Fill the Field");


    if (pvalue.length > 0) {
        unitnameErrorField.hide();
        autocompleteServerHit(va, unitnameErrorField);
    } else {
        jQuery('#pSku' + va).val("");
        jQuery('#pRowValue' + va).val("");
        jQuery('#pMouValue' + va).val("");
        jQuery('#pMou' + va).val("");
        if (productName.length > 0) {
            productName.pop();
        }
        unitnameErrorField.show();
    }
}

// Auto Complete Request
function autocompleteServerHit(va, error) {
    var pp = jQuery('#pRow' + va).val();


    $.ajax({
        type: 'POST',
        url: _ctx+ 'warehousemaster/find',
        data: {"pid": pp},
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (callback) {
            console.log(callback);

            var availableName = [];

            $.each(callback, function (key, value) {
                console.log(value.productName);
                if (jQuery.inArray(value.productName, productName) == -1) {
                    availableName.push(value.productName);
                }

            });

            $('#pRow' + va).autocomplete({
                source: availableName,
                select: function (event, ui) {

                    $.each(callback, function (key, value) {
                        console.log(value.productName);

                        if (ui.item.value == value.productName) {
                            error.hide();
                            jQuery('#pSku' + va).val(value.skuQty);
                            jQuery('#squeQnty' + va).val(value.skuQty);
                            jQuery('#pRowValue' + va).val(value.id);
                            jQuery('#pMouValue' + va).val(value.mouId);
                            jQuery('#pMou' + va).val(value.mouName);
                            skuQty = value.skuQty;
                            //if(rowCount==va) {
                            $('#addBtn' + va).prop('disabled', false);
                            //}
                            console.log("select" + value);
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








