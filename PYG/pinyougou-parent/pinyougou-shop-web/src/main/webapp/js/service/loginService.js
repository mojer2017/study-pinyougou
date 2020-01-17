app.service("loginService",function ($http) {
    //获取登录用户名称
    this.loginName = function () {
        return $http.get("../login/loginName.do");
    }

});