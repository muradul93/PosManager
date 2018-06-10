/**
 * Created by root on 17/5/17.
 */
window.onload = function () {
    var _ctx = $("meta[name='context-path']").attr("content");

    var dataPriceShop = [];

    $.ajax({
        url: _ctx + 'getPriceList'
    }).then(function (data) {
        $.each(data, function (i, vvl) {

            if (vvl.ps == 's') {
                $.each(vvl.shopPriceList, function (i, item) {
                    console.log(item.date.dayOfMonth+'#'+item.totalPrice);
                    dataPriceShop.push({ x: new Date(item.date.year,item.date.monthValue-1,item.date.dayOfMonth), y:item.totalPrice });
                });
            }
        });





    var chart = new CanvasJS.Chart("chartContainer",
        {
            //backgroundColor: "#18f5be",
            animationEnabled: true,
            animationDuration: 2000,   //change to 1000, 500 etc
            title: {
                text: "Customer Sales",
                fontSize: 18,
                fontColor: "#34cf9d",
                fontWeight: "normal"
            },
            axisY:{
                gridColor: "#ddd",
                prefix: "$"
            },
            axisX: {
                labelFormatter: function (e) {
                    return CanvasJS.formatDate( e.value, "DD MMM");
                },
            },

            data: [

                {
                    type: "spline",
                    showInLegend: true,
                    name: "Customer Sales",
                    dataPoints: dataPriceShop

                }
            ]
        });
    chart.render();

    });
}