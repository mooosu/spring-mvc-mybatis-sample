package com.zqgame.mappers;

import com.zqgame.models.Blog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository(value="blogMapper")
public interface BlogMapper {
	Blog findById(@Param("id") int id );
	@Insert("insert into blogs(title , content , comment,created_at) values (#{title},#{content},#{comment},#{created_at})")
	int save(Blog blog);
}
