(function () {
    'use strict';
 
    angular
        .module('magus')
        .factory('KYCService', KYCService);
 
    KYCService.$inject = ['$http', '$cookieStore', '$rootScope', '$timeout', '$window'];
    function KYCService($http, $cookieStore, $rootScope, $timeout, $window) {
        var service = {};
        service.getOTP = getOTP;
        service.doKYC = doKYC;
        return service;
 
        function getOTP(aadharNumber, callback) {
        	$http({
        		  method: 'GET',
        		  url: 'ws/kyc/otp?aadhar='+aadharNumber
        	}).then(function successCallback(response) {
				console.log("otp(Success) = "+response);
		        callback(response);
        	}, function errorCallback(response) {
        		console.log("otp(Error) = "+response);
        	});
        }
        
        function doKYC(aadhar,otp,callback) {
        	var datax = $.param({aadhar:aadhar,otp:otp});
        	$http({
        		  method: 'PUT',
        		  url: 'ws/kyc/auth?'+datax
        	}).then(function successCallback(response) {
				console.log("doKYC(Success) = "+response);
		        callback(response);
        	}, function errorCallback(response) {
        		console.log("doKYC(Error) = "+response);
        	});
        }
    }

})();
