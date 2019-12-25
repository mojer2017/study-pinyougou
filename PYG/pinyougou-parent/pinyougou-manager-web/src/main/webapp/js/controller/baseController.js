app.controller("baseController",function ($scope) {
    //分页控件配置 currentPage：当前页 totalItems：总记录数  itemsPerPage：每页记录数 perPageOptions：分页选项 onChange：当页码变更时触发的方法
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reload();//重新加载
        }
    };

    //刷新页面
    $scope.reload = function(){
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    };

    //用户勾选的ID集合
    $scope.selectIds = [];
    //更新集合
    $scope.updateSelection = function ($event,id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id);//push向集合添加元素
        } else {
            var index = $scope.selectIds.indexOf(id);//查找值的位置
            $scope.selectIds.splice(index, 1);//参数1：移除的位置  参数2：移除的个数
        }
    };

});