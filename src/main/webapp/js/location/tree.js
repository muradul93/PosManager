/**
 * Created by root on 29/5/17.
 */

jQuery(document).ready(function ($) {

    var _ctx = $("meta[name='context-path']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $('#container').jstree({
        'core' : {
            'data' : {
                url: _ctx+ 'location/locationTree'
            },
            "check_callback" :  function (op, node, par, pos, more) {
                return true;
            }
        },
        "types" : {
            "default" : {
                "icon" : "glyphicon glyphicon-gift file-node"
            }
        },
        "plugins" : ["search","contextmenu", "themes","json_data","ui","crrm","sort", "hotkeys", "types", "contextmenu"],
        "contextmenu": {
            "items": function ($node) {
                var tree = $("#container").jstree(true);
                return {
                    "Create": {
                        "label": "Create New Location",
                        "icon" : _ctx+"images/tree_icon/add.png",
                        "action": function (obj) {
                            $node = tree.create_node($node);
                            tree.edit($node);
                        }
                    },
                   /* "Rename": {
                        "label": "Rename",
                        "action": function (obj) {
                            tree.edit($node);
                        }
                    },
                    "Remove": {
                        "separator_before": true,
                        "separator_after": false,
                        "label": "Remove Existing Location",
                        "icon" :  _ctx+"images/tree_icon/min.png",
                        "action": function (obj) {
                            tree.delete_node($node);
                        }
                    }*/
                };
            }
        }


    }).bind("loaded.jstree", function (event, data) {
        $(this).jstree("open_all");
    });


    $('#container').on('set_text.jstree', function(e, data) {

        $.ajax({
            type: 'POST',
            url: _ctx+ 'location/addNewNodeTree',
            data: {     "ntext":  data.text,
                "nid": data.obj.id,
                "npid": data.obj.parent
            },
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function (data) {

                if(data.status == 'add') {
                    $('#container').jstree(true).settings.core.data = {'url': _ctx+ 'location/locationTree'};
                    $('#container').jstree(true).refresh(true);
                    successMoved(data.mess);
                }
            },
            error: function () {
                console.log("error");
            }
        });
    });

    $('#container').on('delete_node.jstree', function(e, data) {
        console.log(data.node.id);
        $.ajax({
            type: 'POST',
            url: _ctx+ 'location/deleteNodeTree',
            data: {     "nid":  data.node.id  },
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function (data) {
                successDelete(data.status);
            },
            error: function () {
                console.log("error");
            }
        });
    });


    $('#container').on('move_node.jstree', function(e, data) {
        /*  console.log('ID ', data.node.id);
         console.log('New parent', data.parent);*/

        $.ajax({
            type: 'POST',
            url: _ctx+ 'location/moveTree',
            data: {     "nid":  data.node.id,
                "npid": data.parent
            },
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function (data) {
//                            console.log("OK"+data.name);
                successMoved(data.name+' Changed Based on Its Position');
            },
            error: function () {
                console.log("error");
            }
        });
    });

    $("#s").submit(function(e) {
        e.preventDefault();
        $("#container").jstree(true).search($("#q").val());
    });

});


function successMoved(name) {
    notify({
        type: "success", //alert | success | error | warning | info
        title: "Node Rearranging",
        message: name,
        position: {
            x: "right", //right | left | center
            y: "bottom" //top | bottom | center
        },
        icon: '<img id="im"/>', //<i>
        size: "normal", //normal | full | small
        overlay: true, //true | false
        closeBtn: true, //true | false
        overflowHide: false, //true | false
        spacing: 20, //number px
        theme: "dark-theme", //default | dark-theme
        autoHide: true, //true | false
        delay: 1500, //number ms
        onShow: null, //function
        onClick: null, //function
        onHide: null, //function
        template: '<div class="notify"><div class="notify-text"></div></div>'
    });
    var BASE_IMAGE_PATH = $('meta[name=image-path]').attr("content");
    document.getElementById('im').src=BASE_IMAGE_PATH;
}

function successDelete(name) {
        notify({
                   type: "error", //alert | success | error | warning | info
                   title: "Deleted",
                   message: name,
                   position: {
                       x: "right", //right | left | center
                       y: "bottom" //top | bottom | center
                   },
                   icon: '<img id="im"/>', //<i>
                   size: "normal", //normal | full | small
                   overlay: true, //true | false
                   closeBtn: true, //true | false
                   overflowHide: false, //true | false
                   spacing: 20, //number px
                   theme: "dark-theme", //default | dark-theme
                   autoHide: true, //true | false
                   delay: 1500, //number ms
                   onShow: null, //function
                   onClick: null, //function
                   onHide: null, //function
                   template: '<div class="notify"><div class="notify-text"></div></div>'
               });
    var BASE_IMAGE_PATH = $('meta[name=image-path]').attr("content");
    document.getElementById('im').src=BASE_IMAGE_PATH;
}