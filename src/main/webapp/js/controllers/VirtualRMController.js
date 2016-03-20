(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('VirtualRMController', VirtualRMController);
 
    VirtualRMController.$inject = ['$rootScope', '$location', 'AuthenticationService', 'RetailService'];
    function VirtualRMController($rootScope, $location, AuthenticationService, RetailService) {
        var vm = this;
        vm.$location = $location;
        vm.$rootScope = $rootScope;
        vm.AuthenticationService = AuthenticationService;
        vm.RetailService = RetailService;
        vm.getBalance = getBalance;
        vm.goBack = goBack;
        vm.speakNow = speakNow;
        vm.userFirstName = AuthenticationService.GetUserFirstName();
        vm.username = AuthenticationService.GetUsername();
        vm.dataLoading = false;
        vm.annyang = annyang;
        vm.listening = false;
        
        if (annyang) {
      	  // Let's define our first command. First the text we expect, and then the function it should call
      	  var commands = {
      	    'my balance': function() {
      	    	vm.getBalance();
      	    },
      	    'my loan': function() {
      	    	$('#greeting').text('you said - my loan');
      	    },
      	    'find nearest ATM': function() {
      	    	$('#greeting').text('you said - find nearest ATM');
      	    }
      	    
      	  };
      	  // Add our commands to annyang
      	  annyang.addCommands(commands);
      	  
      	}
        return vm;
        
        function getBalance() {
        	vm.dataLoading = true;
        	console.log("Retrieving balance for account");
        	vm.RetailService.getAccountBalance("5555666677770328", function(response) {
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
        	$('#greeting').text('you said - my balance');
        	
        };
        
        function speakNow() {
        	if (vm.listening == false) {
	        	console.log("Listening for audio input (start)...");
	        	// start listening
	        	vm.annyang.start();
	        	$('#speakbtn').text("Listening");
	        	$('#btnspk').toggleClass("round-button-clicked");
	        	$('#btnspkcircle').toggleClass("round-button-clicked-circle");
	        	$('#speakbtn').toggleClass("round-button-clicked");
	        	
	        	vm.listening = true;
        	} else {
        		console.log("Listening for audio input (stop)...");
	        	// stop listening
	        	vm.annyang.abort();
	        	$('#speakbtn').text("Speak Now");
	        	$('#btnspk').toggleClass("round-button");
	        	$('#btnspkcircle').toggleClass("round-button-circle");
	        	$('#speakbtn').toggleClass("round-button");
	        	
	        	vm.listening = false;
        	}
        }
        
        function goBack() {
        	vm.$location.path("/home");
        };
        
    }
 
})();