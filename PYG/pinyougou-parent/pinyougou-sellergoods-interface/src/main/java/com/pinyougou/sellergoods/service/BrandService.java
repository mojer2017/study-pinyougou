package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/***
 * 品牌接口
 * @author 毛杰
 */
public interface BrandService {

    public List<TbBrand> findAll();

    /**
     * 分页查询
     *
     * @param pageNum  第几页
     * @param pageSize 每页大小
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);

    /**
     * 新增
     *
     * @param tbBrand
     */
    public void add(TbBrand tbBrand);

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    public TbBrand findOne(Long id);

    /**
     * 修改
     *
     * @param tbBrand
     */
    public void update(TbBrand tbBrand);

    /**
     * 删除
     *
     * @param ids id的数组
     */
    public void delete(Long[] ids);

    /**
     * 条件查询并分页
     *
     * @param tbBrand
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize);

    /**
     * 返回下拉列表数据
     * @return
     */
    public List<Map> selectOptionList();

}
