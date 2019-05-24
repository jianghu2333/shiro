package com.shiro.repository;

import com.shiro.domain.User;

/**
 * @author: jiangyong
 * @date: 2019/1/10 14:21
 * @version:
 * @Copyright:
 * @modifier:
 */
public interface UserRepository extends BaseRepository<User,Long>{
    User findByName(String name);
}
