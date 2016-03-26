(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('KYCAadharController', KYCAadharController);
 
    KYCAadharController.$inject = ['$rootScope', '$location', 'KYCService', 'AuthenticationService', '$timeout'];
    function KYCAadharController($rootScope, $location, KYCService, AuthenticationService, $timeout) {
        var vm = this;
        vm.$location = $location;
        vm.$rootScope = $rootScope;
        vm.AuthenticationService = AuthenticationService;
        vm.getOTP = getOTP;
        vm.doKYC = doKYC;
        vm.completeKYC = completeKYC;
        vm.onbESignFinal = onbESignFinal;
        vm.startBanking = startBanking;
        vm.aadhar = "";
        vm.pan = "AAK9D2212J";
        vm.addr = "Test Address";
        vm.userFirstName = AuthenticationService.GetUserFirstName();
        vm.username = AuthenticationService.GetUsername();
        vm.otpGenerated = false;
        vm.dataLoading = false;
        $rootScope.globals.showOTPNotification = false;
        return vm;
        
        function getOTP() {
        	vm.dataLoading = true;
        	console.log("Performing OTP generation for "+vm.userFirstName+", username="+vm.username+", aadhar="+vm.aadhar);
        	KYCService.getOTP(vm.aadhar, function(response) {
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
        	$timeout(function(){
        		$rootScope.globals.showOTPNotification = true;
        		$("#notification").fadeIn("slow");
        	},1000);
        	$timeout(function(){
       		 	$rootScope.globals.showOTPNotification = false;
        	},7000);
        };
        
        function doKYC() {
        	vm.dataLoading = true;
        	console.log("Performing KYC for "+vm.userFirstName+", username="+vm.username+", aadhar="+vm.aadhar);
        	KYCService.doKYC(vm.aadhar, vm.otp, function(response) {
        		console.log(response.data);
        		if (response.data) {
        			vm.kycFailure = false;
        			vm.otpGenerated = true;
        			AuthenticationService.SetKYCValid(true);
        			vm.dataLoading = false;
        			vm.$location.path('/onbESign');
        		} else {
        			vm.kycFailure = true;
        			vm.failureMessage = response.message;
        			vm.dataLoading = false;
        		}
        	});
        };
        
        function onbESignFinal() {
        	console.log("Completing KYC for "+vm.userFirstName+", username="+vm.username+", aadhar="+vm.aadhar);
        	console.log(vm.addr);
        	vm.$location.path('/onbESignConfirm');
        };
        
        function completeKYC() {
        	console.log("Completing KYC for "+vm.userFirstName+", username="+vm.username+", aadhar="+vm.aadhar);
        	vm.$location.path('/onbSuccess');
        };
        
        
        function startBanking() {
        	vm.$location.path('/home');
        };
    }
 
})();