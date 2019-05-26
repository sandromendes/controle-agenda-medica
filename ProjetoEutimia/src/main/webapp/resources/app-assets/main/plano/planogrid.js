$(document).ready(function() {
    $("#planogrid").jsGrid({
        width: "100%",
        filtering: !0,
        editing: !0,
        inserting: !0,
        sorting: !0,
        paging: !0,
        autoload: !0,
        pageSize: 15,
        pageButtonCount: 5,
        deleteConfirm: "Realmente deseja remover este registro?",
        controller: db,
        fields: [{
            name: "aPlanoSaudeNome",
            type: "text",
            width: 150
        }, {
            name: "aPlanoSaudeDtInicioVigencia",
            type: "text",
            width: 100
        }, {
            name: "aPlanoSaudeDtFimVigencia",
            type: "text",
            width: 100
        }, {
            type: "control"
        }]
    }), $("#sort").on("click", function() {
        var field = $("#sortingField").val();
        $("#sorting-table").jsGrid("sort", field)
    }), $("#pager").on("change", function() {
        var page = parseInt($(this).val(), 10);
        $("#loading").jsGrid("openPage", page)
    }), $(".config-panel input[type=checkbox]").on("click", function() {
        var $cb = $(this);
        $("#customView").jsGrid("option", $cb.attr("id"), $cb.is(":checked"))
    });
    var selectedItems = [],
        selectItem = function(item) {
            selectedItems.push(item)
        },
        unselectItem = function(item) {
            selectedItems = $.grep(selectedItems, function(i) {
                return i !== item
            })
        },
        deleteClientsFromDb = function(deletingClients) {
            db.planos = $.map(db.planos, function(plano) {
                return $.inArray(plano, deletingClients) > -1 ? null : plano
            })
        };
});