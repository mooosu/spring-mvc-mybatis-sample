package com.zqgame.mapper;

import com.zqgame.model.Blog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository(value="blogMapper")
public interface BlogMapper {
	Blog findById(@Param("id") int id );
}
