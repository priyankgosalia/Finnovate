(function() {
	'use strict';

	var magusApp = angular.module('magus', [ 'ngRoute', 'ngCookies',
			'mobile-angular-ui', 'mobile-angular-ui.gestures', 'chart.js' ]);

	magusApp.config(function config($routeProvider) {
		$routeProvider.when('/home', {
			templateUrl : 'pages/home.html',
			title : 'Home',
			controller: 'HomeController',
			controllerAs: 'hc'
		}).when('/login', {
			templateUrl : 'pages/login.html',
			controller : 'LoginController',
			controllerAs : 'lc',
			title : 'Login'
		}).when('/logout', {
			templateUrl : 'pages/logout.html',
			controller : 'LogoutController',
			controllerAs : 'oc',
			title : 'Logout',
		}).when('/kycAadhar', {
			templateUrl : 'pages/kycAadhar.html',
			controller : 'KYCAadharController',
			controllerAs : 'kca',
			title : 'e-KYC'
		}).when('/virtualrm', {
			templateUrl : 'pages/virtualrm.html',
			controller : 'VirtualRMController',
			controllerAs : 'vc',
			title : 'iAssist'
		}).when('/about', {
			title : 'About',
			templateUrl : 'pages/about.html',
			controller: 'AboutController',
			controllerAs : 'ac'
		}).when('/onbSuccess', {
			title : 'Success',
			templateUrl : 'pages/onboardingComplete.html',
			controller : 'KYCAadharController',
			controllerAs : 'kca'
		}).when('/onbESign', {
			title : 'KYC Confirmation',
			templateUrl : 'pages/onboardingESign.html',
			controller : 'KYCAadharController',
			controllerAs : 'kca'
		}).when('/expenses', {
			templateUrl : 'pages/expenseTracking.html',
			controller : 'ExpenseController',
			controllerAs : 'ec',
			title : 'Expense Tracker'
		}).otherwise({
			redirectTo : '/login'
		});
	});

	magusApp.run(function run($rootScope, $location, $cookieStore, $http) {
		console.log("Running magus");
		$rootScope.userAgent = navigator.userAgent;
		console.log($rootScope.userAgent);

		// Needed for the loading screen
		$rootScope.$on('$routeChangeStart', function() {
			$rootScope.loading = true;
		});

		// dynamically change page title based on view
		$rootScope.$on('$routeChangeSuccess',
				function(event, current, previous) {
					$rootScope.loading = false;
					$rootScope.title = current.$$route.title;
				});

		// keep user logged in after page refresh
		$rootScope.globals = $cookieStore.get('globals') || {};
		if ($rootScope.globals.currentUser) {
			$http.defaults.headers.common['Authorization'] = 'Basic '
					+ $rootScope.globals.currentUser.authdata; // jshint ignore:line
		}

		$rootScope.$on('$locationChangeStart', function(event, next, current) {
			$rootScope.globals = $cookieStore.get('globals') || {};
			// redirect to login page if not logged in and trying to access a restricted page
			var restrictedPage = $.inArray($location.path(), [ '/login', '/logout', '/about' ]) === -1;
			var protectedPage = $.inArray($location.path(), ['/virtualrm','/loans','/accounts','/expenses']) === -1;
			var loggedIn = $rootScope.globals.currentUser;
			var kycValid = false;
			
			$rootScope.globals.showOTPNotification = false;
			$rootScope.globals.showOTPNotificationForFundsTransfer = false;
			
			if (loggedIn) {
				console.log("Logged in. KYC Valid = "+$rootScope.globals.kycValid);
				 kycValid = $rootScope.globals.kycValid;
			}
			console.log(next.indexOf("logout"));
			if (next.indexOf("logout")>0) {
				console.log("Setting path to logout...");
				$location.path('/logout');
			}
			console.log("here 1.");
			if (restrictedPage && !loggedIn) {
				$location.path('/login');
				console.log("here 1-a.");
			}
			console.log("here 2.");
			if (loggedIn && (!kycValid || kycValid == false)) {
				$location.path('/kycAadhar');
				console.log("here 2-a.");
			} else if (loggedIn && kycValid == true && next.indexOf("onb")<=0 && next.indexOf("logout")<=0 && restrictedPage && protectedPage){
				$location.path('/home');
				console.log("here 2-b.");
			}
			console.log("here 3.");
		});
	});

	magusApp.controller('MainController', MainController);
	MainController.$inject = [ '$rootScope', '$location', 'AuthenticationService' ];

	function MainController($rootScope, $scope, $location, AuthenticationService) {
		var svc = this;
		svc.AuthenticationService = AuthenticationService;

		(function initController() {
			$scope.swiped = function(direction) {
				alert('Swiped ' + direction);
			};

			// User agent displayed in home page
			$scope.userAgent = navigator.userAgent;

			// Needed for the loading screen
			$rootScope.$on('$routeChangeStart', function() {
				$rootScope.loading = true;
			});

			$rootScope.$on('$routeChangeSuccess', function() {
				$rootScope.loading = false;
			});
			$rootScope.AuthenticationService = AuthenticationService;
        })();

	}

})();
