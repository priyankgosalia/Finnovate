(function () {
    'use strict';
 
    angular
        .module('magus')
        .factory('RetailService', RetailService);
 
    RetailService.$inject = ['$http', '$rootScope', '$timeout'];
    function RetailService($http, $rootScope, $timeout) {
        var service = {};
        service.getAccountBalance = getAccountBalance;
        return service;
        
        function getAccountBalance(accountNumber, callback) {
        	$http({
        		  method: 'GET',
        		  url: 'ws/retail/balance?accountNumber='+accountNumber
        	}).then(function successCallback(response) {
				console.log("balance(Success) = "+response);
		        callback(response);
        	}, function errorCallback(response) {
        		console.log("balance(Error) = "+response);
        	});
        }
    }

})();
