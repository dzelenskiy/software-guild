/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.testingtinymce;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DZ
 */
@Controller
public class BlogController {

    @Inject
    JdbcTemplate jdbc;

    @PostMapping("postBlog")
    public String postBlog(HttpServletRequest request) {
        jdbc.update(
                "insert into post (content) values (?)",
                request.getParameter("blogPost")
        );
        return "redirect:/";
    }

}
