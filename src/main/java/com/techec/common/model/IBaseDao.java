package com.techec.common.model;

import com.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;




/**
 * 通用DAO接口定义了新增、修改、删除、查询单个记录、查询记录列表、分页查询列表的方法
 * 
 *
 * @param <T>
 */
public interface IBaseDao<T> {
    /**
     * 插入数据
     * 
     * @param entity
     * @return
     * @throws Exception
     * @throws
     */
    int insert(T entity) throws Exception;

    /**
     * 更新数据
     * 
     * @param entity
     * @return
     * @throws Exception
     * @throws
     */
    int updateByPrimaryKey(T entity) throws Exception;
    
    /**
     * 插入数据(选择性地)
     * 
     * @param entity
     * @return
     * @throws Exception
     * @throws
     */
    int insertSelective(T entity) throws Exception;

    /**
     * 更新数据(选择性地)
     * 
     * @param entity
     * @return
     * @throws Exception
     * @throws
     */
    int updateByPrimaryKeySelective(T entity) throws Exception;

    /**
     * 删除数据
     * 
     * @param id
     * @throws Exception
     * @throws
     */
    int deleteByPrimaryKey(int id) throws Exception;

    /**
     * 删除数据
     * 
     * @param id
     * @throws Exception
     * @throws
     */
    int delete(T entity) throws Exception;

    /**
     * 根据id查询单个记录
     * 
     * @param id
     * @return
     * @throws Exception
     * @throws
     */
    T selectByPrimaryKey(int id);

    /**
     * 根据对象查询单个记录
     * 
     * @param id
     * @return
     * @throws Exception
     * @throws
     */
    T getOne(T entity);

    /**
     * 根据对象查询信息
     * 
     * @param obj
     * @return
     * @throws Exception
     * @throws
     */
    Object getObject(Object obj);

    /**
     * 获取记录 分页
     * 
     * @param entity
     * @return
     * @throws Exception
     * @throws
     */
    PageResult<T> queryByPage(@Param("t") PageResult<T> t, @Param("entity") T entity);
   List<T> getPage(T entity);

   PageResult<T> queryByPageFront(@Param("t") PageResult<T> t, @Param("entity") T entity);
   List<T> getPageFront(T entity);
    /**
     * 查询总数
     * 
     * @param entity
     * @return
     * @throws Exception
     * @throws
     */
    int getCount(T entity);
    
    List<T> getAll();
    List<T> getAllBySelect(T entity);
     
}

