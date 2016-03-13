(function () {
    'use strict';
    
    var magusApp = angular.module('magus',
    								['ngRoute', 'ngCookies', 'mobile-angular-ui', 'mobile-angular-ui.gestures']);
    
    magusApp.config(function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'pages/login.html'
            })
            .when('/login', {
                templateUrl: 'pages/login.html',
                controller: 'LoginController',
                controllerAs: 'lc'
            })
            .when('/about', {
            	title: 'About',
                templateUrl: 'pages/about.html'
            })
            .otherwise({ redirectTo: '/login' });
    });
    
    magusApp.run(function run($rootScope, $location, $cookieStore, $http) {
    	console.log("Running magus");
    	$rootScope.userAgent = navigator.userAgent;
    	console.log($rootScope.userAgent);
    	
        // Needed for the loading screen
        $rootScope.$on('$routeChangeStart', function(){
    	    $rootScope.loading = true;
    	});
        
        // dynamically change page title based on view
        $rootScope.$on('$routeChangeSuccess', function(event,current,previous){
    	    $rootScope.loading = false;
    	    $rootScope.title = current.$$route.title;
    	});
    	
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
        	$rootScope.globals = $cookieStore.get('globals') || {};
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/about']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    });
    
    magusApp.controller('MainController', function($rootScope, $scope){

    	  $scope.swiped = function(direction) {
    	    alert('Swiped ' + direction);
    	  };

    	  // User agent displayed in home page
    	  $scope.userAgent = navigator.userAgent;
    	  
    	  // Needed for the loading screen
    	  $rootScope.$on('$routeChangeStart', function(){
    	    $rootScope.loading = true;
    	  });

    	  $rootScope.$on('$routeChangeSuccess', function(){
    	    $rootScope.loading = false;
    	  });
    });
    
})();

