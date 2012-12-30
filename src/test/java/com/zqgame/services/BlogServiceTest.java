package com.zqgame.services;

import com.zqgame.AbstractTest;
import com.zqgame.models.Blog;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = { "classpath:com/zqgame/unittest-mapper.xml" })
public class BlogServiceTest extends AbstractTest {
  @Autowired
  protected BlogService blogService;

  public final void setBlogService(BlogService blogService) {
    this.blogService = blogService;
  }
  @Test
  public final void testBlogService() {
    Blog blog = null;
    assertNotNull(blog);
  }
}