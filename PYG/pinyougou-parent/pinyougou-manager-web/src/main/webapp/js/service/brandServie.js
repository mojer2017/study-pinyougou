app.service("brandService", function ($http) {
    //查询品牌列表
    this.findAll = function () {
        return $http.get('../brand/findAll.do');
    };

    //分页查询
    this.findPage = function () {
        return $http.get("../brand/findPage.do?page="+page+"&rows="+size);
    };

    //添加
    this.add = function (entity) {
        return $http.post("../brand/add.do",entity);
    };

    //修改
    this.update = function (entity) {
        return $http.post("../brand/update.do",entity);
    };

    //查询一个实体
    this.findOne = function (id) {
        return $http.get("../brand/findOne.do?id="+id);
    };

    //删除
    this.dele = function (selectIds) {
        return $http.get("../brand/delete.do?ids="+selectIds);
    };

    //条件查询
    this.search = function (page,size,searchEntity) {
        return $http.post("../brand/search.do?page="+page+"&rows="+size,searchEntity);
    }

    //查询下拉框数据
    this.selectOptionList = function () {
        return $http.get("../brand/selectOptionList.do");
    }

});