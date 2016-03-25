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
        vm.initiateTransfer = initiateTransfer;
        vm.goBack = goBack;
        vm.speakNow = speakNow;
        vm.userFirstName = AuthenticationService.GetUserFirstName();
        vm.username = AuthenticationService.GetUsername();
        vm.dataLoading = false;
        vm.annyang = annyang;
        vm.transferAmount = 0;
    	vm.transferFriend = "";
    	vm.transferSource = "5555666677770329";
		vm.transferDestination = "5555666677779999";
		vm.transferDesc = "DTH";
		vm.transferPayeeId = 593;
		vm.trasnferPayeeDesc = "A9999";
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
        	$timeout(function() {
        		vm.transferAmount = amount;
            	vm.transferFriend = friend;
            	vm.dataLoading = false;
            	vm.speakNow();
            	$rootScope.Ui.turnOn('fundTransferFriendOverlay');
            	$timeout(function(){
            		$timeout(function(){
                		$rootScope.globals.showOTPNotificationForFundsTransfer = true;
                		$("#notificationTransfer").fadeIn("slow");
                	},1000);
                	$timeout(function(){
               		 	$rootScope.globals.showOTPNotificationForFundsTransfer = false;
                	},7000);
            	});
        	},200);
        };
        
        function initiateTransfer() {
        	console.log("Initiating funds transfer");
        	$timeout(function() {
        		vm.RetailService.transferFunds(vm.transferSource, vm.transferDestination, vm.transferAmount, vm.transferPayeeId, vm.transferPayeeDesc, vm.transferDesc, function(response) {
            		console.log(response.data);
            		if (response.data.code >= 0) {
            			if (response.data.code == 0) {
            				vm.transferSuccess = true;
            				vm.transferRef = response.data.referenceNumber;
                			vm.transferRefDateTime = response.data.transactionDate;
            			} else {
            				vm.transferSuccess = false;
            			}
            			$rootScope.Ui.turnOff('fundTransferFriendOverlay');
            			$rootScope.Ui.turnOn('fundTransferComplete');
            		}
            	});
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