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

function initMap() {
    directionsDisplay = new google.maps.DirectionsRenderer;

    mapLoad();
    mapdraw();
    //calcRoute();



}



function mapLoad() {
    var mapOptions = {
        zoom: 14,
        center: new google.maps.LatLng(23.811837, 90.421386),
    }
    map = new google.maps.Map(document.getElementById('mapp'), mapOptions);
    directionsDisplay.setMap(map);
}

function trackShop() {
    var shopid = $('#shopid').val();

    if (shopid == 0) {
        mapdraw();
    }else {

        $.ajax({
            type: 'POST',
            url: _ctx + 'customerTracking/point',
            data: {"pid": shopid},

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
                                infowindow.setContent(value.retailShopName);
                                infowindow.open(map, marker);
                            }
                        })(marker, key));

                        // waypts.push({
                        //     location: new google.maps.LatLng(value.latitude, value.longitude),
                        //     stopover: true
                        // });
                    });
                    //calcRoute(waypts);
                }
            },
            error: function () {
                alert("error");
            }
        });

    }
}


/*function onchangeTab() {
    rowCount = 0;
    $('#table').empty();

    $.each(LocationObject, function (key, value) {
        addMoreRows();

        $('#location' + rowCount).text(value.oderLocationName);
        $('#date' + rowCount).text(value.date);
        $('#time' + rowCount).text(value.time);


    });
}*/


/*function addMoreRows() {


    console.log("working " + rowCount);

    rowCount++;


    var recRow = '<div class="col-md-15" id="row' + rowCount + '" >' +
        '<div class="single_profile"  >' +
        '<div class="thumbnail">' +
        '<div class="caption">' +
        '<div class="profile-image">' +
        '</div>' +
        '<h4 id="date' + rowCount + '"></h4>' +
        '<h4 id="time' + rowCount + '"></h4>' +
        '<p id="location' + rowCount + '"></p>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</div>';
    $('#table').append(recRow);
}*/


/*function calcRoute(waypts) {


    var directionsService = new google.maps.DirectionsService;
    var request = {
        origin: new google.maps.LatLng(LocationObject[0].lat, LocationObject[0].lon),
        destination: new google.maps.LatLng(LocationObject[LocationObject.length - 1].lat, LocationObject[LocationObject.length - 1].lon),
        waypoints: waypts,
        optimizeWaypoints: true,

        travelMode: 'WALKING'
    };


    directionsService.route(request, function (response, status) {
        if (status == 'OK') {

            directionsDisplay.setDirections(response);
            //map.fitBounds(directionsDisplay.getDirections().routes[0].bounds);


        }
    });
}*/


//Validation And Auto Complete Request Method Call
/*function onLetterChange() {

    var user = $.trim($('#user').val());

    console.log(user + "1")

    if (user.length > 0) {
        console.log(user)
        autocompleteServerHit(user);
    }
}*/

/*function autocompleteServerHit(va) {

    console.log(va + "2")

    $.ajax({
        type: 'POST',
        url: _ctx + 'retailShop/find/user',
        data: {"pid": va},
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (callback) {
            console.log(callback);

            var availableName = [];

            $.each(callback, function (key, value) {
                console.log(value.name);

                availableName.push(value.shopName);


            });

            $('#user').autocomplete({
                source: availableName,
                select: function (event, ui) {

                    $.each(callback, function (key, value) {
                        if (ui.item.value == value.shopName) {

                            userID = value.id;
                        }
                    });
                }
            });

        },
        error: function () {
            alert("error");
        }
    });
}*/




function mapdraw() {

    mapLoad();

    $.ajax({
        type: 'POST',
        url: _ctx + 'customerTracking/all',
        data: {"pid": userID},

        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (callback) {
            console.log(callback);
            LocationObject = callback;
            if (callback.length) {
                waypts = [];
                $.each(callback, function (key, value) {

                    var marker = new google.maps.Marker({
                        position: new google.maps.LatLng(value.latitude, value.longitude),
                        map: map

                    });
                    console.log(value.dealerName+" index "+key);
                    var infowindow = new google.maps.InfoWindow();
                    google.maps.event.addListener(marker, 'click', (function(marker, key) {
                        return function() {
                            infowindow.setContent(value.retailShopName);
                            infowindow.open(map, marker);
                        }
                    })(marker, key));

                    // waypts.push({
                    //     location: new google.maps.LatLng(value.latitude, value.longitude),
                    //     stopover: true
                    // });
                });
                //calcRoute(waypts);
            }
        },
        error: function () {
            alert("error");
        }
    });
    //}

}




