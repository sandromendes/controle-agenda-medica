(function() {

    var db = {

        loadData: function(filter) {
            return $.grep(this.planos, function(plano) {
                return (!filter.aPlanoSaudeNome || plano.aPlanoSaudeNome.indexOf(filter.Nome) > -1)
                    && (!filter.aPlanoSaudeDtInicioVigencia || plano.aPlanoSaudeDtInicioVigencia === filter.Inicio)
                    && (!filter.aPlanoSaudeDtFimVigencia || plano.aPlanoSaudeDtFimVigencia.indexOf(filter.Fim) > -1);
            });
        },

        insertItem: function(insertingClient) {
            this.planos.push(insertingClient);
        },

        updateItem: function(updatingClient) { },

        deleteItem: function(deletingClient) {
            var planoIndex = $.inArray(deletingClient, this.planos);
            this.planos.splice(planoIndex, 1);
        }

    };

    window.db = db;

    var arrayPlanos;
    
    $.ajax({
        url: '/ProjetoEutimia/main/plano/listarTodos',
        type: 'POST',
        dataType: 'JSON',
        success: function(data) {
        	arrayPlanos = data; 
        },
        error : function(msg) {
            alert('Erro: ' + msg);
        }    
    });
    
    db.planos = arrayPlanos;
}());