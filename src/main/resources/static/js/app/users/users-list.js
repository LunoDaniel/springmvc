
$(document).ready(function(){
	dataTables.layoutDefault.dom = 'Bfrtip';
	dataTables.layoutDefault.buttons = [
		{
			extend: 'excelHtml5', 
    		text: 'Exportar para Excel',
    		exportOptions: {
	        	modifier: {
	          		page: 'all', search : 'none'
	        	}
    		},
		}
	];
	
	$('.users-list').DataTable($.extend(dataTables.layoutDefault, null));
	$('.btn.btn-secondary.buttons-excel.buttons-html5').removeClass('btn-secondary').addClass('btn-primary');
	$('div.dt-buttons.btn-group').addClass('pading-bottom');
});