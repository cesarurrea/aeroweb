aerowebApp.controller("tarifaController", function($scope, tarifaService) {

	$scope.Tarifa = {
		idtarifa : '',
		valor : '',
		observaciones : ''
	}

	$scope.TarifaSeleccionado = {};
	$scope.accion = '';

	$scope.onloadFun = function() {
		getTarifas();
	}

	function getTarifas() {

		$scope.tarifas = {};

		var requestResponse = tarifaService.getAll();

		requestResponse.then(function(response) {
			$scope.tarifas = response.data;
		}, function() {

		})
	}
	;

	$scope.adicionar = function(data) {

		if (data.idtarifa) {
			var requestResponse = tarifaService.update(data);

			requestResponse.then(function(response) {
				getTarifas();
				$('#formModal').modal('hide');
			}, function() {

			})

		} else {

			var requestResponse = tarifaService.create(data);

			requestResponse.then(function(response) {
				getTarifas();
			}, function() {

			})
		}

		$scope.Tarifa = {};
		$scope.TarifaSeleccionado = {};

	}

	$scope.confirmUpdate = function(data) {

		$scope.accion = 'Editar Tarifa';

		$scope.TarifaSeleccionado = angular.copy(data);
		$('#formModal').modal('show');
	}

	$scope.createDialog = function() {
		$scope.accion = 'Nueva Tarifa';
		$scope.TarifaSeleccionado = {};
		$('#formModal').modal('show');
	}

	$scope.confirmDelete = function(data) {

		$scope.Tarifa = data;

		$('#EliminarModal').modal('show');

	}

	$scope.eliminar = function() {

		var requestResponse = tarifaService.destroy($scope.Tarifa.idtarifa);

		requestResponse.then(function(response) {
			getTarifas();
			$('#EliminarModal').modal('hide');
		}, function() {

		})

		$scope.Tarifa = {};

	}

});