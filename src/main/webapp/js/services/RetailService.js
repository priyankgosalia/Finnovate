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
        service.getSpentOn = getSpentOn;
        return service;
        
        //spentOnLast?accountNumber=5555666677770329&days=2&type=DTH
        function getSpentOn(day, type, callback) {
        	$http({
        		  method: 'GET',
        		  url: 'ws/retail/spentOnLast?accountNumber='+5555666677770329+'&days='+day+'&type='+type
        	}).then(function successCallback(response) {
				console.log("spentOn(Success) = "+response);
		        callback(response);
        	}, function errorCallback(response) {
        		console.log("spentOn(Error) = "+response);
        	});
        }
        
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
