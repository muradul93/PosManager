/**
 * Created by Marketing on 17-Jul-17.
 */


var monthNames = ["January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
];


var TodayDate = new Date();

var currentMonth = TodayDate.getMonth();


window.onload = function () {
        var dataPoints1 = [];
        var splineDataPoints1 = [];
        var splineDataPoints2 = [];


        var dataPoints = [];
        var splineDataPoints= [];
        var splineDataPoints0 = [];

        var _ctx = $("meta[name='context-path']").attr("content");
        var mymes = $("meta[name='mess']").attr("content");



        $.ajax({
            url: _ctx+ 'hrEmployee/getPieChartData'
        }).then(function(data) {
            $.each(data, function (i, item) {
//

                dataPoints1.push({  y: item.y , legendText:item.ps,  indexLabel: item.label});
                /*..............*/
                splineDataPoints1.push({y: item.y});
                splineDataPoints2.push({y: item.y});
//




            }




            );




            var chart = new CanvasJS.Chart("chartContainer",
                {
                    title:{
                        text: "SR TotalRequisition Vs TotalSales  in Current Month"
                    },
                    animationEnabled: true,
                    legend:{
                        verticalAlign: "bottom",
                        horizontalAlign: "center"
                    },
//











                    data: [
                        {
                            indexLabelFontSize: 20,
                            indexLabelFontFamily: "Monospace",
                            indexLabelFontColor: "darkgrey",
                            indexLabelLineColor: "darkgrey",
                            indexLabelPlacement: "outside",
                            type: "pie",
                            showInLegend: true,
                            toolTipContent: "{y} - <strong>#percent%</strong>",

                            dataPoints: dataPoints1

                        }
                    ]
                });
            chart.render();


        });



        /*....................................*/
        $.ajax({
            url: _ctx+ 'hrEmployee/getSplineChartData'
        }).then(function(data) {
            $.each(data, function (i, item) {
//

                //dataPoints.push({  y: item.y , legendText:item.ps,  indexLabel: item.label});
                /*..............*/
//

//                    splineDataPoints.push({y: item.y,indexLabel: item.month});
//                    splineDataPoints0.push({y: item.x,indexLabel: item.month});
                var d = new Date(item.year, item.month - 1);
                splineDataPoints.push({y: item.totalOderAmount, x: d});
                splineDataPoints0.push({y: item.totalSalesAmount, x: d});
                console.log(item.month);
                console.log(currentMonth);
                console.log(rowCount);


                if (rowCount <= currentMonth) {

                    addMoreRows();


                    if (item.month - 1 == currentMonth) {

                        jQuery('#pmonth' + rowCount).text(monthNames[d.getMonth()]);
                        jQuery('#row' + rowCount).css("background-color", "#ddd");
                        jQuery('#pnumberOfOder' + rowCount).text(item.numberOfOder);
                        jQuery('#ptotalOderAmount' + rowCount).text(item.totalOderAmount);

                    } else {
                        jQuery('#pmonth' + rowCount).text(monthNames[d.getMonth()]);
                        jQuery('#pnumberOfOder' + rowCount).text(item.numberOfOder);
                        jQuery('#ptotalOderAmount' + rowCount).text(item.totalOderAmount);
                    }


                }


                if (currentMonth >= rowCounts ) {

                    addMoreRowss();



                if (item.month - 1 == currentMonth) {// change colour for current month


                    jQuery('#pmonths' + rowCounts).text(monthNames[d.getMonth()]);
                    jQuery('#rows' + rowCounts).css("background-color", "#ddd");
                    jQuery('#pnumberOfSaless' + rowCounts).text(item.numberOfSales);

                    jQuery('#ptotalSalesAmounts' + rowCounts).text(item.totalSalesAmount);


                } else {

                    jQuery('#pmonths' + rowCounts).text(monthNames[d.getMonth()]);
                    console.log("month  :" + (monthNames[d.getMonth()] ));

                    jQuery('#pnumberOfSaless' + rowCounts).text(item.numberOfSales);
                    jQuery('#ptotalSalesAmounts' + rowCounts).text(item.totalSalesAmount);


                }


            }




/*               secondary salse order   **********************/

                    if (sOrderRowCount <= currentMonth) {

                        addMoreRowSOrder();


                        if (item.month - 1 == currentMonth) {

                            jQuery('#pmontho' + sOrderRowCount).text(monthNames[d.getMonth()]);
                            jQuery('#SorderRow' + sOrderRowCount).css("background-color", "#ddd");
                            jQuery('#psecondaryNumberOfOder' + sOrderRowCount).text(item.secondaryNumberOfOder);
                            jQuery('#psecondaryTotalOderAmount' + sOrderRowCount).text(item.secondaryTotalOderAmount);

                        } else {
                            jQuery('#pmontho' + sOrderRowCount).text(monthNames[d.getMonth()]);
                            jQuery('#psecondaryNumberOfOder' + sOrderRowCount).text(item.secondaryNumberOfOder);
                            jQuery('#psecondaryTotalOderAmount' + sOrderRowCount).text(item.secondaryTotalOderAmount);
                        }


                    }







                    /*           ***********    secondary salse delivered  **********************/



                    if (sSalesCounts <= currentMonth) {

                        addMoreRowSeles();


                        if (item.month - 1 == currentMonth) {

                            jQuery('#pmonthos' + sSalesCounts).text(monthNames[d.getMonth()]);
                            jQuery('#SsalesRow' + sSalesCounts).css("background-color", "#ddd");
                            jQuery('#psecondaryNumberOfSales' + sSalesCounts).text(item.secondaryNumberOfSales);
                            jQuery('#psecondaryTotalSalesAmount' + sSalesCounts).text(item.secondaryTotalSalesAmount);

                        } else {
                            jQuery('#pmonthos' + sSalesCounts).text(monthNames[d.getMonth()]);
                            jQuery('#psecondaryNumberOfSales' + sSalesCounts).text(item.secondaryNumberOfSales);
                            jQuery('#psecondaryTotalSalesAmount' + sSalesCounts).text(item.secondaryTotalSalesAmount);
                        }


                    }




//

            }


            );



            var chart1 = new CanvasJS.Chart("chartContainer1",
                {
                    title:{
                        text: " Order  Vs Sales",
                        fontSize: 18,
                        fontColor: "#34cf9d",
                        fontWeight: "normal"
                    },
                    animationEnabled: true,
                    data: [
                        {
                            type: "splineArea",
                            color: "rgba(76,88,164,.7)",
                            dataPoints: splineDataPoints0,
                            legendText: "Sales",
                            showInLegend: true
                        },
                        {
                            type: "splineArea",
                            color: "rgba(0,196,132,.7)",
                            dataPoints: splineDataPoints,
                            legendText: "Order",
                            showInLegend: true
                        }

                    ]
                });

            chart1.render();





        });









    var rowCount = 0;
    var rowCounts = 0;
    var sOrderRowCount = 0;
    var sSalesCounts = 0;


//Form Table Row Add
    function addMoreRows() {

        rowCount++;


        console.log("on"+rowCount);



        var recRow = '<tr id="row' + rowCount + '"> ' +


            '<td width="20%"><span  name="month" type="text"   id="pmonth' + rowCount + '"  ></td>' +

            '<td width="20%"><span  name="numberOfOder" type="text"   id="pnumberOfOder' + rowCount + '"  ></td>' +
            '<td width="20%"><span  name="totalOderAmount" type="text"   id="ptotalOderAmount' + rowCount + '" ></td>' +






            '</tr>';
        $('#oder').append(recRow);
    }









//Form Table Row Add
    function addMoreRowss() {





        rowCounts++;

        console.log("on2"+rowCounts);



        var recRow = '<tr id="rows' + rowCounts + '"> ' +


            '<td width="20%"><span  name="months" type="text"   id="pmonths' + rowCounts + '"  ></td>' +

            '<td width="20%"><span  name="numberOfSaless" type="text"   id="pnumberOfSaless' + rowCounts + '"  ></td>' +
            '<td width="20%"><span  name="totalSalesAmounts" type="text"   id="ptotalSalesAmounts' + rowCounts + '" ></td>' +






            '</tr>';
        $('#sales').append(recRow);
    }




    //Form Table Row Add  secondary sales Order
    function addMoreRowSOrder() {

        sOrderRowCount ++;


        console.log("on"+sOrderRowCount);



        var recRow = '<tr id="SorderRow' + sOrderRowCount + '"> ' +


            '<td width="20%"><span  name="montho" type="text"   id="pmontho' + sOrderRowCount + '"  ></td>' +

            '<td width="20%"><span  name="secondaryNumberOfOder" type="text"   id="psecondaryNumberOfOder' + sOrderRowCount + '"  ></td>' +
            '<td width="20%"><span  name="secondaryTotalOderAmount" type="text"   id="psecondaryTotalOderAmount' + sOrderRowCount + '" ></td>' +






            '</tr>';
        $('#secondaryOder').append(recRow);
    }












    //Form Table Row Add  secondary sales delivered
    function addMoreRowSeles() {

        sSalesCounts ++;


        console.log("on"+sSalesCounts);



        var recRow = '<tr id="SsalesRow' + sSalesCounts + '"> ' +


            '<td width="20%"><span  name="monthos" type="text"   id="pmonthos' + sSalesCounts + '"  ></td>' +

            '<td width="20%"><span  name="secondaryNumberOfSales" type="text"   id="psecondaryNumberOfSales' + sSalesCounts + '"  ></td>' +
            '<td width="20%"><span  name="secondaryTotalSalesAmount" type="text"   id="psecondaryTotalSalesAmount' + sSalesCounts + '" ></td>' +






            '</tr>';
        $('#secondarySales').append(recRow);
    }




}
