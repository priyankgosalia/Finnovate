(function() {
	'use strict';

	var magusApp = angular.module('magus', [ 'ngRoute', 'ngCookies',
			'mobile-angular-ui', 'mobile-angular-ui.gestures' ]);

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
		}).when('/kycAadhar', {
			templateUrl : 'pages/kycAadhar.html',
			controller : 'KYCAadharController',
			controllerAs : 'kca',
			title : 'KYC'
		}).when('/about', {
			title : 'About',
			templateUrl : 'pages/about.html'
		}).when('/onbSuccess', {
			title : 'Success',
			templateUrl : 'pages/onboardingComplete.html',
			controller : 'KYCAadharController',
			controllerAs : 'kca'
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
			var restrictedPage = $.inArray($location.path(), [ '/login', '/about' ]) === -1;
			var loggedIn = $rootScope.globals.currentUser;
			var kycValid = false;
			if (loggedIn) {
				console.log($rootScope.globals.kycValid);
				var kycValid = $rootScope.globals.kycValid;
			}
			if (restrictedPage && !loggedIn) {
				$location.path('/login');
			}
			if (loggedIn && (!kycValid || kycValid == false)) {
				$location.path('/kycAadhar');
			} else if (loggedIn && kycValid == true && next.indexOf("onb")<=0){
				$location.path('/home');
			}
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
