aerowebApp.controller("destinoController", function($scope, destinoService) {

	$scope.Destino = {
		iddestino : '',
		origen : '',
		destino : '',
		esidayvuelta : '',
		esinternacional : '',
		idtarifa : {
			idtarifa : 0,
			valor : 0,
			observaciones : ''
		}
	}

	$scope.DestinoSeleccionado = {};
	$scope.accion = '';

	$scope.onloadFun = function() {
		getDestinos();
		getTarifas();
	}

	function getTarifas() {

		$scope.tarifas = {};

		var requestResponse = destinoService.getTarifas();

		requestResponse.then(function(response) {
			$scope.tarifas = response.data;		
			
		}, function() {

		})
	}
	;

	function getDestinos() {

		$scope.destinos = {};

		var requestResponse = destinoService.getAll();

		requestResponse.then(function(response) {
			$scope.destinos = response.data;
		}, function() {

		})
	}
	;

	$scope.adicionar = function(data) {

		if (data.iddestino) {
			var requestResponse = destinoService.update(data);

			requestResponse.then(function(response) {
				getDestinos();
				$('#formModal').modal('hide');
			}, function() {

			})

		} else {

			var requestResponse = destinoService.create(data);

			requestResponse.then(function(response) {
				getDestinos();
			}, function() {

			})
		}

		$scope.Destino = {};
		$scope.DestinoSeleccionado = {};

	}

	$scope.confirmUpdate = function(data) {

		$scope.accion = 'Editar Destino';

		$scope.DestinoSeleccionado = angular.copy(data);
		
		angular.forEach($scope.tarifas, function(tarifa){
			if($scope.DestinoSeleccionado.idtarifa.idtarifa == tarifa.idtarifa){
				$scope.DestinoSeleccionado.idtarifa = tarifa;
			}
		});
		
		
		$('#formModal').modal('show');
	}

	$scope.createDialog = function() {
		$scope.accion = 'Nuevo Destino';
		//$scope.DestinoSeleccionado = {};
		$scope.DestinoSeleccionado = angular.copy($scope.Destino);
		$scope.DestinoSeleccionado.esidayvuelta = 'N';
		$scope.DestinoSeleccionado.esinternacional = 'N';
		$('#formModal').modal('show');
	}

	$scope.confirmDelete = function(data) {

		$scope.Destino = data;

		$('#EliminarModal').modal('show');

	}

	$scope.eliminar = function() {

		var requestResponse = destinoService.destroy($scope.Destino.iddestino);

		requestResponse.then(function(response) {
			getDestinos();
			$('#EliminarModal').modal('hide');
		}, function() {

		})

		$scope.Destino = {};

	}

});