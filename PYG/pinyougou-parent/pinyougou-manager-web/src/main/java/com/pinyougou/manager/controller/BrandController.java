package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return brandService.findPage(page, rows);
    }

    /**
     * 新增
     * @param tbBrand
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand tbBrand) {
        try {
            brandService.add(tbBrand);
            System.out.println("新增成功");
            return new Result(true, "新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("新增失败");
            return new Result(false, "新增失败");
        }
    }

    /**
     * 查找一个实体（根据id）
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbBrand findOne(long id) {
        return brandService.findOne(id);
    }

    /**
     * 修改
     * @param tbBrand
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand) {
        try {
            brandService.update(tbBrand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 条件查询+分页
     * @param tbBrand
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand tbBrand,int page, int rows){
        return brandService.findPage(tbBrand, page, rows);
    }
}
