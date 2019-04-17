var apiUrlStates = 'https://servicodados.ibge.gov.br/api/v1/localidades/estados';

var stateCallBack = function(states){
	let options = `<option value="">Selecione</option>`;
	
	if(isNullOrEmpty(states)){
		return new Array();
	}
	
	states.sort(sortByProperty('sigla'));
	
	states.forEach(item => {
		options += `<option id="${item.id}">${item.sigla}</option>`;
	});

	$('.inputState').html(options);
};

var cityCallBack = function(cities){
	let options = `<option value="">Selecione</option>`;
	
	if(isNullOrEmpty(cities)){
		return new Array();
	}
	
	cities.sort(sortByProperty('nome'));
	
	cities.forEach(item => {
		options += `<option id="${item.id}">${item.nome}</option>`;
	});

	$('.inputCity').html(options);
};

var callBackJsonResponse = function(data) {
	return data.json();
};

var callBackError = function(error){
	console.error(error);
};

var response = function(data){
	return data.then(callBackJsonResponse).catch(callBackError);
}

$(document).ready(function(){
	
	response(fetch(apiUrlStates)).then(stateCallBack);
	
	$('.inputState').change(function(){
		let uf = $(this).children('option:selected').attr('id');
		let urlCity = `https://servicodados.ibge.gov.br/api/v1/localidades/estados/${uf}/municipios`;
		response(fetch(urlCity)).then(cityCallBack);
	});
	
});
