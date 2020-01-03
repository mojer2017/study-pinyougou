app.controller("loginController",function ($scope,loginService) {
    $scope.loginName = function () {
        loginService.loginName().success(
            function (response) {
                $scope.loginName = response.loginName;
            }
        );
    }
});