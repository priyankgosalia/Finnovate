(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('LoansController', LoansController);
 
    LoansController.$inject = ['$rootScope', '$location', 'LoansService', 'AuthenticationService'];
    function LoansController($rootScope, $location, LoansService, AuthenticationService) {
        var vm = this;
        vm.$location = $location;
        vm.$rootScope = $rootScope;
        vm.AuthenticationService = AuthenticationService;
        vm.getOTP = getOTP;
        vm.doKYC = doKYC;
        vm.startBanking = startBanking;
        vm.aadhar = "";
        vm.userFirstName = AuthenticationService.GetUserFirstName();
        vm.username = AuthenticationService.GetUsername();
        vm.otpGenerated = false;
        vm.dataLoading = false;
        return vm;
        
        function getOTP() {
        	vm.dataLoading = true;
        	console.log("Performing OTP generation for "+vm.userFirstName+", username="+vm.username+", aadhar="+vm.aadhar);
        	LoansService.getOTP(vm.aadhar, function(response) {
        		console.log(response.data);
        		if (response.data) {
        			vm.kycFailure = false;
        			vm.otpGenerated = true;
        		} else {
        			vm.kycFailure = true;
        			vm.failureMessage = response.message;
        		}
        		vm.dataLoading = false;
        	});
        };
        
        function doKYC() {
        	vm.dataLoading = true;
        	console.log("Performing KYC for "+vm.userFirstName+", username="+vm.username+", aadhar="+vm.aadhar);
        	LoansService.doKYC(vm.aadhar, vm.otp, function(response) {
        		console.log(response.data);
        		if (response.data) {
        			vm.kycFailure = false;
        			vm.otpGenerated = true;
        			AuthenticationService.SetKYCValid(true);
        			vm.dataLoading = false;
        			vm.$location.path('/onbSuccess');
        		} else {
        			vm.kycFailure = true;
        			vm.failureMessage = response.message;
        			vm.dataLoading = false;
        		}
        	});
        };
        
        function startBanking() {
        	vm.$location.path('/home');
        };
    }
 
})();