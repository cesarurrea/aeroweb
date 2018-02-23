aerowebApp.service('tarifaService', function($http) {
	$this = this;

	$this.getAll = function() {
		var request = $http({
			method : 'GET',
			url : '/services/tarifa'
		});
		return request;
	}

	$this.create = function(entity) {
		var request = $http({
			method : 'PUT',
			url : '/services/tarifa',
			data : JSON.stringify(entity),
			dataType : "json"
		});
		return request;
	}

	$this.update = function(entity) {
		var request = $http({
			method : 'POST',
			url : '/services/tarifa',
			data : JSON.stringify(entity),
			dataType : "json"
		});
		return request;
	}

	$this.destroy = function(id) {
		var request = $http({
			method : 'DELETE',
			url : '/services/tarifa' + id
		});
		return request;

	}

})