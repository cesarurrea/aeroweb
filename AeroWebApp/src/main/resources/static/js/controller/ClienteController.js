aerowebApp.controller("clienteController", function($scope, clienteService) {

	$scope.Cliente = {
		idcliente : '',
		tipodocumento : '',
		nrodocumento : '',
		nombrescliente : '',
		apellidoscliente : '',
		emailcliente : '',
		movilcliente : '',
		telefonocliente : ''
	}

	$scope.ClienteSeleccionado = {};
	$scope.accion = '';

	$scope.onloadFun = function() {
		getClientes();
	}

	function getClientes() {

		$scope.clientes = {};

		var requestResponse = clienteService.getAll();

		requestResponse.then(function(response) {
			$scope.clientes = response.data;
		}, function() {

		})
	}
	;

	$scope.adicionar = function(data) {

		if (data.idcliente) {
			var requestResponse = clienteService.update(data);

			requestResponse.then(function(response) {
				getClientes();
				$('#formModal').modal('hide');
			}, function() {

			})

		} else {

			var requestResponse = clienteService.create(data);

			requestResponse.then(function(response) {
				getClientes();
			}, function() {

			})
		}

		$scope.Cliente = {};
		$scope.ClienteSeleccionado = {};

	}

	$scope.confirmUpdate = function(data) {

		$scope.accion = 'Editar Cliente';

		$scope.ClienteSeleccionado = angular.copy(data);
		$('#formModal').modal('show');
	}

	$scope.createDialog = function() {
		$scope.accion = 'Nuevo Cliente';
		$scope.ClienteSeleccionado = {};
		$('#formModal').modal('show');
	}

	$scope.confirmDelete = function(data) {
		
		$scope.Cliente = data;
		
		$('#EliminarModal').modal('show');

	}

	$scope.eliminar = function() {

		var requestResponse = clienteService.destroy($scope.Cliente.idcliente);

		requestResponse.then(function(response) {
			getClientes();
			$('#EliminarModal').modal('hide');
		}, function() {

		})

		$scope.Cliente = {};

	}

});