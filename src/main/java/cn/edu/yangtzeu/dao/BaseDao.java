package cn.edu.yangtzeu.dao;

import java.util.List;

/**
 * dao 的基本操作接口类
 * @author 魏志文
 * @param T T为任意类型
 */
public interface BaseDao<T> {
    //添加
    void add(T t);

    //修改
    void update(T t);

    //删除
    void delete(T t);

    //根据id查询
    T findOne(int id);
    T findOne(short id);
    T findOne(Long id);
    T findOne(String id);

    // 根据ids查询部分
    List<T> findSome(Integer[] ids);

    //查询所有
    List<T> findAll();
}
