
var app = angular.module('app', ['ngRoute']);



app
.config([
		'$httpProvider',
		function($httpProvider) {
			$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
		} ]);
app.config(['$routeProvider',
         function($routeProvider) {
           $routeProvider
             .when('/home', {
               templateUrl: 'index.html',
               controller: 'usersctrl'
             })
             .when('/add', {
               templateUrl: 'addtask.html',
               controller: 'addtaskctrl'
             })
             .when('/comment', {
               templateUrl: 'comment.html',
               controller: 'addcommentctrl'
             })
             .when('/viewcomment/:taskId', {
               templateUrl: 'viewcomment.html',
               controller: 'viewcommentctrl'
             })
              .when('/view/:userId', {
               templateUrl: 'view.html',
               controller: 'viewuserctrl'
             })
             .when('/edit/:id', {
                 templateUrl: 'edit.html',
                 controller: 'edittaskctrl'
               })
         }]);



app.controller('usersctrl', [ '$scope','$rootScope','$http', function($scope,$rootScope, $http) {
	
	
	$scope.title = 'List of Users';
	//$rootScope.users={};
	$scope.auth = {};

	$scope.loadUsers = function() {
		
		var authData = $scope.auth.username + ':' + $scope.auth.password;
	var encodedAuthData = btoa(authData);

		$http({
			method : 'GET',
			url : '/users',     
			headers : {
   					'Authorization' : 'Basic ' + encodedAuthData
   					}
		}).then(function(response) {
			$rootScope.users = response.data;
			$scope.authenticated = true;
	});
	};
} ]);


app.controller('viewuserctrl',[ '$scope','$route','$routeParams', '$rootScope','$http',
	     function($scope,$route,$routeParams,$rootScope, $http)
	     {
	       $scope.index=$routeParams.userId;
	       $scope.x=$rootScope.users[$routeParams.userId-1];
	       
	       // $scope.title = 'List of Comments';
		   	$rootScope.tasks={};

		   		$http({
		   			method : 'GET',
		   			url : '/tasks'
		   		}).then(function(response) {
		   			$rootScope.tasks = response.data;
		   	});
	   
	     }]);



app.controller('addtaskctrl', [ '$scope', '$rootScope','$http', function($scope,$rootScope, $http) {
	$scope.title = 'Add new Task!';
	$scope.inputtask={
			user:{
					}
		};
	
	$scope.saveTasks = function(){
		//Validation
		
		$http({
			method: 'POST',
			url : '/savetask',
			data : $scope.inputtask
		}).then(function(response){
			if(response.data.status){
				alert('Task Added Successfully!');
				$rootScope.tasks = {};
				$rootScope.users.tasks.push($rootScope.tasks);
			} else {
				alert('Task Addition Failed!');
			}
		});
	};

} ]);

/*
app.controller('edittaskctrl',function($scope,$route,$routeParams,$rootScope,$http){
	//$rootScope.q=[];
	$scope.title="Edit task!!"
		 $http({
				method : 'GET',
				url : '/tasks/'+$routeParams.id,
				
			}).then(function(response) {
				$rootScope.a = angular.copy(response.data);
				 
			});
		 $rootScope.q={
				 users:{
					 
				 }
		 };$scope.auth = {};

			$scope.saveTask = function(){	
				
//				var authData = $scope.auth.username + ':' + $scope.auth.password;
//				var encodedAuthData = btoa(authData);

		 $http({
				method: 'POST',
				url : '/edittask',
				data : $rootScope.a,
//				headers : {
//   					'Authorization' : 'Basic ' + encodedAuthData
//   					}
//				
			}).then(function(response){
				if(response.data.status){
					alert('task edit Successfully!');
					$rootScope.a= {};
					//$rootScope.tasks.push($rootScope.a);
				//	$scope.edited = true;
				} else {
					alert('task edit Failed!');
				}
			});
			};
  });







app.controller('addcommentctrl',[ '$scope', '$rootScope','$http',function($scope,$rootScope,$http){
	$scope.title = 'Add new Comment!';
	$scope.inputcomment={
			task:{
					}
		};
	
	$scope.saveComments = function(){
		//Validation
		
		$http({
			method: 'POST',
			url : '/savecomment',
			data : $scope.inputcomment
		}).then(function(response){
			if(response.data.status){
				alert('Comment Added Successfully!');
				$rootScope.comments = {};
				//$rootScope.tasks.push($rootScope.comments);
			} else {
				alert('Comment Addition Failed!');
			}
		});
	};

}]);




app.controller('viewcommentctrl',[ '$scope','$route','$routeParams','$rootScope',
	     function($scope,$route,$routeParams,$rootScope)
	     {
	       $scope.index=$routeParams.taskId;
	       $scope.x=$rootScope.tasks[$routeParams.taskId-1];
	     
	     }]);*/




































/*app.controller('reassignctrl',
	function($scope,$rootScope){
$scope.title="Reassign";
	$rootScope.users.push($rootScope.userId);
$scope.user = {}
$scope.handleSubmit = function() {
 alert('Reassigned to other user ');
}
});
*/
/*app.controller('edittaskctrl',function($scope,$route,$routeParams,$rootScope){
	       $scope.title = 'Edit Task!';
	       $scope.index=$routeParams.userId;
	       $scope.x=$rootScope.users[$routeParams.userId];
	       $rootScope.x=angular.copy($rootScope.users);
	       $scope.temp=$rootScope.users[$routeParams.userId];
	       $scope.onClick=function(){
	    	   $rootScope.users[$routeParams.userId]=$scope.temp;
	    	   alert("edited");
	       };
	       $scope.xyz='afffrewf';
	$rootScope.tasks={};
	$scope.saveTask = function(){
		//Validation
		
		$http({
			method: 'GET',
			url : '/savetask',
			data : $rootScope.tasks
		}).then(function(response){
			if(response.data.status){
				alert('Task Updated Successfully!');
				$rootScope.tasks = {};
			} else {
				alert('Task Updation Failed!');
			}
		});
	};
	
	
	
	
	       $scope.title = 'Edit Task!';
   
	       $scope.index=$routeParams.taskId;
	       $scope.x=$rootScope.users[$routeParams.taskId];
	       
         /*  $scope.xyz=$rootScope.users[0].tasks[0].title;
           $scope.abc=$rootScope.users[0].tasks[0].msg;//
	$scope.saveTask = function(){
		
		$http({
			method: 'POST',
			url : '/savetask',
			data : $rootScope.tasks
		}).then(function(response){
			if(response.data.status){
				alert('Task Updated Successfully!');
				$rootScope.tasks = {};
			} else {
				alert('Task Updation Failed!');
			}
		});
	};

	     });*/





