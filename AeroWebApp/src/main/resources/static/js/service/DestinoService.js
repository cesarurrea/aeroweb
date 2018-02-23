aerowebApp.service('destinoService', function($http) {
	$this = this;

	$this.getAll = function() {
		var request = $http({
			method : 'GET',
			url : '/services/destino'
		});
		return request;
	}

	$this.create = function(entity) {
		var request = $http({
			method : 'PUT',
			url : '/services/destino',
			data : JSON.stringify(entity),
			dataType : "json"
		});
		return request;
	}

	$this.update = function(entity) {
		var request = $http({
			method : 'POST',
			url : '/services/destino',
			data : JSON.stringify(entity),
			dataType : "json"
		});
		return request;
	}

	$this.destroy = function(id) {
		var request = $http({
			method : 'DELETE',
			url : '/services/destino' + id
		});
		return request;

	}
	
	$this.getTarifas = function() {
		var request = $http({
			method : 'GET',
			url : '/services/tarifa'
		});
		return request;
	}
	

})