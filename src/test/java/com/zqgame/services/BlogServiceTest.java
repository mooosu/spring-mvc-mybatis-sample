package com.zqgame.services;

import com.zqgame.AbstractTest;
import com.zqgame.models.Blog;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath:com/zqgame/unittest-mapper.xml"})
public class BlogServiceTest extends AbstractTest {

    @Autowired
    protected BlogService blogService;

    public final void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @Test//(groups="save")
    public final void testBlogService() {
        Blog blog = new Blog();
        blog.setTitle("title");
        blog.setContent("content");
        blog.setComment("comment");
        int id = blogService.save(blog);
        List<Blog> blogs = blogService.findAllBlogs();
        Blog blog2 = blogService.findById(id);
        assertNotNull(blog);
    }
}
