(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('VirtualRMController', VirtualRMController);
 
    VirtualRMController.$inject = ['$rootScope', '$location', 'AuthenticationService', 'RetailService', '$timeout'];
    function VirtualRMController($rootScope, $location, AuthenticationService, RetailService, $timeout) {
        var vm = this;
        vm.$location = $location;
        vm.$rootScope = $rootScope;
        vm.AuthenticationService = AuthenticationService;
        vm.RetailService = RetailService;
        vm.getBalance = getBalance;
        vm.transferFunds = transferFunds;
        vm.getLoanDetail = getLoanDetail;
        vm.getSpentOn = getSpentOn;
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
      	    'transfer :amount to :friend': function(amount,friend) {
      	    	vm.transferFunds(amount,friend);
      	    },
      	    'find nearest ATM': function() {
      	    	$('#greeting').text('Finding nearest ATM...');
      	    },
      	    ':type expense in last :day day(s)': function(type, day) {
      	    	vm.getSpentOn(type,day);
      	    }
      	    
      	  };
      	  // Add our commands to annyang
      	  annyang.addCommands(commands);
      	  
      	  // Add callbacks
      	  annyang.addCallback('resultNoMatch', function(){
      		  	$('#greeting').html("Sorry, I didn't quite get that. Please try again.");
      		  });
      	  
      	}
        return vm;
        
        function getSpentOn(type, day) {
        	vm.dataLoading = true;
        	console.log("Spent on " + type + " in last " + day + " days");
  	    	$('#greeting').text('Spent on '+type+' in last '+day+' days');
        	//$('#greeting').html('Fetching account balance...');
        	vm.RetailService.getSpentOn(day,type, function(response) {
        		console.log(response.data);
        		if (response.data) {
        			$('#greeting').html('You spent <b>INR '+response.data+'</b> on '+type+' in the last '+ day+' days');
        		} else {
        			$('#greeting').html('Oops! ' + response.data.message);
        		}
        	});
        	vm.dataLoading = false;
        	vm.speakNow();
        };
        
        function transferFunds(amount,friend) {
        	vm.dataLoading = true;
        	console.log("Transfer "+amount+" to "+friend);
        	$timeout(function(){
        		var text = "Transfer <b>INR "+amount+"</b> to <b>"+friend+"</b> ?"+"<br/><br/><button type=\"button\" class=\"btn btn-primary\">Transfer</button> <button type=\"button\" class=\"btn btn-default\">Cancel</button>";
            	$('#greeting').html(text);
            	vm.dataLoading = false;
            	vm.speakNow();
        	},100);
        };
        
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
	        	vm.listening = true;
        	} else {
        		console.log("Listening for audio input (stop)...");
	        	// stop listening
	        	vm.annyang.abort();
	        	vm.listening = false;
        	}
        };
        
        function goBack() {
        	vm.$location.path("/home");
        };
        
    }
 
})();