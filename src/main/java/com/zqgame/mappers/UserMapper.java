package com.zqgame.mappers;

import com.zqgame.models.User;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository(value="userMapper")
public interface UserMapper {
	User findById(@Param("id") int id );
	User findByUsername(@Param("username") String username );
	int save(User User);
}

