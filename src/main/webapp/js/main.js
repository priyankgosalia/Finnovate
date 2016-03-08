var app = angular.module('magus', [
  'ngRoute',
  'mobile-angular-ui',
  'mobile-angular-ui.gestures'
]);

app.run(function($transform) {
  window.$transform = $transform;
});

app.config(function($routeProvider) {
	  $routeProvider.when('/',              {templateUrl: 'home.html', reloadOnSearch: false});
	  $routeProvider.when('/scroll',        {templateUrl: 'scroll.html', reloadOnSearch: false}); 
	});

app.controller('magusRootController', function($rootScope, $scope){
	  $scope.swiped = function(direction) {
	    alert('Swiped ' + direction);
	  };

	  $scope.userAgent = navigator.userAgent;
	  
	  // Needed for the loading screen
	  $rootScope.$on('$routeChangeStart', function(){
	    $rootScope.loading = true;
	  });

	  $rootScope.$on('$routeChangeSuccess', function(){
	    $rootScope.loading = false;
	  });

	  //
	  // 'Forms' screen
	  //  
	  $scope.rememberMe = true;
	  $scope.email = 'priyank';
	  
	  $scope.login = function() {
	    alert('You submitted the login form');
	  };

	});