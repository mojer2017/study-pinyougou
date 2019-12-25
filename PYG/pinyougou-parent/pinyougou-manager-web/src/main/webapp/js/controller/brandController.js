app.controller("brandController",function($scope,brandService,$controller){

    $controller("baseController",{$scope:$scope});//继承

    //查询品牌列表
    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.brandList = response;
            }
        );
    };

    //分页查询方法
    $scope.findPage = function (page,size) {
        brandService.findPage.success(
            function (response) {
                $scope.brandList = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    };

    //保存
    $scope.save = function () {
        var object = null;
        if ($scope.entity.id != null) {
            object = brandService.update($scope.entity);
        } else {
            object = brandService.add($scope.entity);
        }
        object.success(
            function (response) {
                if (response.success) {
                    $scope.reload();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    };

    //查询一个实体
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    };

    //删除
    $scope.dele = function () {
        brandService.dele($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reload();//重新加载
                } else {
                    alert(response.message);
                }
            }
        )
    };


    $scope.searchEntity = {};//定义搜索对象
    //条件查询
    $scope.search = function (page,size) {
        brandService.search(page,size,$scope.searchEntity).success(
            function (response) {
                $scope.brandList = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }

});