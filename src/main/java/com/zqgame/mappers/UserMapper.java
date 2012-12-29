package com.zqgame.mappers;

import com.zqgame.models.User;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository(value="userMapper")
public interface UserMapper {
	User findById(@Param("id") int id );
	User findByUsername(@Param("username") String username );
	@Insert("insert into shiro_user(username, email, password, salt, created_at) values (#{username},#{email},#{password},#{salt},CURDATE())")
	int save( User user );
}
