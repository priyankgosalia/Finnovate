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
        vm.getLoanDetail = getLoanDetail;
        vm.goBack = goBack;
        vm.speakNow = speakNow;
        vm.userFirstName = AuthenticationService.GetUserFirstName();
        vm.username = AuthenticationService.GetUsername();
        vm.dataLoading = false;
        vm.annyang = annyang;
        vm.listening = false;
        
        if (annyang) {
      	  var commands = {
      	    'my balance': function() {
      	    	vm.getBalance();
      	    },
      	    'my loan': function() {
      	    	vm.getLoanDetail();
      	    },
      	    'find nearest ATM': function() {
      	    	$('#greeting').text('Finding nearest ATM...');
      	    }
      	    
      	  };
      	  // Add our commands to annyang
      	  annyang.addCommands(commands);
      	  
      	}
        return vm;
        
        function getBalance() {
        	vm.dataLoading = true;
        	console.log("Retrieving balance for account");
        	$('#greeting').html('Fetching account balance...');
        	vm.RetailService.getAccountBalance("5555666677770328", function(response) {
        		console.log(response.data);
        		if (response.data.accountno) {
        			$('#greeting').html('Account Balance for Account # <b>'+response.data.accountno+'</b> is INR <b>'+response.data.balance+'</b>');
        		} else {
        			$('#greeting').html('Oops! ' + response.data.message);
        		}
        	});
        	vm.dataLoading = false;
        	vm.speakNow();
        };
        
        function getLoanDetail() {
        	vm.dataLoading = true;
        	console.log("Retrieving Loan details for account");
        	$('#greeting').html('Fetching Loan Account details...');
        	vm.RetailService.getLoanAccountDetails("LBMUM11112220001", function(response) {
        		var loanData = response.data.loanDetails[0];
        		console.log(loanData);
        		if (loanData) {
        			$('#greeting').html('Loan Account Details for Account # <b>'+'LBMUM11112220001'+'</b><br/>'+'Loan Amount: INR '+loanData.loanAmount+'<br/>Outstanding Amount: INR '+loanData.principal_outstanding+'<br/>Rate of Interest: '+loanData.roi+'<br/>Type: '+loanData.type_of_loan);
        		} else {
        			$('#greeting').html('Oops! Something went wrong. Please try again.');
        		}
        	});
        	vm.dataLoading = false;
        	vm.speakNow();
        };
        
        function speakNow() {
        	if (vm.listening == false) {
	        	console.log("Listening for audio input (start)...");
	        	// start listening
	        	vm.annyang.start();
	        	vm.annyang.debug(true);
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
        };
        
        function goBack() {
        	vm.$location.path("/home");
        };
        
    }
 
})();