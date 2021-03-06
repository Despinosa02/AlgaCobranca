$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
    var button = $(event.relatedTarget);

    var codigoTitulo = button.data('codigo');

    var descricaoTitulo = button.data('descricao');

    var modal = $(this);

    var form = modal.find('form');
    
    var action = form.data('url-base');

    if (!action.endsWith('/')){
        action += '/';
    }

    form.attr('action', action+codigoTitulo);

    modal.find('.modal-body span').html('Tem certeza que deseja excluir o titulo <strong>'+ descricaoTitulo + '</strong')
});

$('.datepicker').datepicker();

$(function(){
    $('[rel="tooltip"]').tooltip();
    $('.js-currency').maskMoney({decimal:',', thousands:'.', allowZero:true});
    $('.js-atualizar-status').on('click', function (event) 
    { event.preventDefault();
        var botaoReceber = $(event.currentTarget);
        var urlReceber = botaoReceber.attr('href');
        var response = $.ajax({
            type: 'PUT',
            url: urlReceber,
        });

        response.done(function(e){
            var codigoTitulo = botaoReceber.data('codigo');
            $('[data-role='+ codigoTitulo + ']').html('<label class="badge bg-success">'+ e +'</label>')
            botaoReceber.hide();
        });

        response.fail(function(e){
            console.log(e);
            alert('Erro recebendo cobrança');
        });






    });
});