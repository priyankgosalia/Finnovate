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
        service.spentOnPercentages = spentOnPercentages;
        service.transferFunds = transferFunds;
        return service;
        
        //spentOnLast?accountNumber=5555666677770329&days=2&type=DTH
        function spentOnPercentages(day, callback) {
        	$http({
        		  method: 'GET',
        		  url: 'ws/retail/spentOnPercentages?accountNumber='+5555666677770329+'&days='+day
        	}).then(function successCallback(response) {
				console.log("spentOn(Success) = "+response);
		        callback(response);
        	}, function errorCallback(response) {
        		console.log("spentOn(Error) = "+response);
        	});
        }

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
        
        function transferFunds(sourceAccount, destAccount, amount, payeeId, payeeDesc, description, callback) {
        	$http({
        		  method: 'GET',
        		  url: 'ws/retail/fundsTransfer?srcAccount='+sourceAccount+'&destAccount='+destAccount+'&amt='+amount+'&type='+description+'&payeeId='+payeeId+'&payeeDesc='+payeeDesc
        	}).then(function successCallback(response) {
				console.log("transferFunds(Success) = "+response);
		        callback(response);
        	}, function errorCallback(response) {
        		console.log("transferFunds(Error) = "+response);
        	});
        }
    }

})();
