package cn.edu.yangtzeu.dao;

import cn.edu.yangtzeu.entity.Privilege;

import java.util.List;

public interface PrivilegeDao extends BaseDao<Privilege> {
    List<Privilege> findTopList();

    List<String> findAllPrivilegeUrl();
}
