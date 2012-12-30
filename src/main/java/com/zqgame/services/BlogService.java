/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.services;

import com.zqgame.mappers.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author roscus
 */
public class BlogService {
    @Autowired(required = true)
    private BlogMapper blogMapper;
    public void setBlogMapper(BlogMapper blogMapper) {
            this.blogMapper = blogMapper;
    }
}
