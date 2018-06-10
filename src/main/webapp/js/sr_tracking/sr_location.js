/**
 * Created by dream71 on 25/10/17.
 */

var map;
var directionsDisplay;
var waypts = [];
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var _ctx = $("meta[name='context-path']").attr("content");
var rowCount;
var LocationObject = [];
var userID = 0;
var xaa;


function initMap() {
    directionsDisplay = new google.maps.DirectionsRenderer;

    mapLoad();


}




window.onload = function trackSr() {

        $.ajax({
            url: _ctx + 'srTracking/point',

            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function (callback) {
                console.log(callback);
                LocationObject = callback;
                if (callback.length) {
                    waypts = [];
                    $.each(callback, function (key, value) {


                        var mapOptions = {
                            zoom: 14,
                            center: new google.maps.LatLng(value.latitude, value.longitude),
                        }
                        map = new google.maps.Map(document.getElementById('mapp'), mapOptions);
                        directionsDisplay.setMap(map);


                        var marker = new google.maps.Marker({
                            position: new google.maps.LatLng(value.latitude, value.longitude),
                            map: map

                        });
                        console.log(value.dealerName + " index " + key);
                        var infowindow = new google.maps.InfoWindow();
                        google.maps.event.addListener(marker, 'click', (function (marker, key) {
                            return function () {
                                infowindow.setContent(value.srName);
                                infowindow.open(map, marker);
                            }
                        })(marker, key));

                    });
                    //calcRoute(waypts);
                }
            },
            error: function () {
                alert("error");
            }
        });

}

