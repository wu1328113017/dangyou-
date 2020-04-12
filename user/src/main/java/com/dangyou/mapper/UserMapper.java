package com.dangyou.mapper;

import com.dangyou.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 插入单条数据
     */
    void insert(User user);
    /**
     * 根据id删除单条数据
     */
    void delete(String id);
    /**
     * 根据id查询单条数据
     */
    User selectById(String id);
    /**
     * 根据id修改单条数据
     */
    void updateById(String id);
    /**
     * 查询在数据库中的条数
     */
    int selectLength(User user);
}
