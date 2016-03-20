(function () {
    'use strict';
 
    angular
        .module('magus')
        .factory('RetailService', RetailService);
 
    RetailService.$inject = ['$http', '$rootScope', '$timeout'];
    function RetailService($http, $rootScope, $timeout) {
        var service = {};
        service.getAccountBalance = getAccountBalance;
        service.getLoanAccountDetails = getLoanAccountDetails;
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
        
        function getLoanAccountDetails(accountNumber, callback) {
        	$http({
        		  method: 'GET',
        		  url: 'ws/retail/loanAccountSummary/'+accountNumber
        	}).then(function successCallback(response) {
				console.log("loandetails(Success) = "+response);
		        callback(response);
        	}, function errorCallback(response) {
        		console.log("loandetails(Error) = "+response);
        	});
        }
    }

})();
