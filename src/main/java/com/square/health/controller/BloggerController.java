package com.square.health.controller;

import com.square.health.dto.BloggerDTO;
import com.square.health.dto.PostDTO;
import com.square.health.service.BloggerService;
import com.square.health.util.error_handle.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Alauddin Tuhin
 * @project health
 * @created 9/28/21 at 1:23 AM
 **/

@RestController
@RequestMapping("/api/v1/blogger")
public class BloggerController {

    private final BloggerService bloggerService;

    @Autowired
    public BloggerController(BloggerService bloggerService) {
        this.bloggerService = bloggerService;
    }

    @PostMapping("/register")
    ResponseEntity<ErrorDetails> registerBlogger(@RequestBody BloggerDTO blogger) {
      return   bloggerService.registerBlogger(blogger);
    }

    @PostMapping("/add/comment")
    ResponseEntity<ErrorDetails> addCommentToPost(@RequestParam Long bloggerId,
                                                  @PathVariable String comment) {
        return bloggerService.addCommentToPost(bloggerId, comment);
    }

    @PostMapping("/add/post")
    ResponseEntity<ErrorDetails> addPost(@RequestBody PostDTO dto) {
        return bloggerService.addPost(dto);
    }

    @PutMapping("/update/post/{postId}")
    ResponseEntity<ErrorDetails> updatePost(@PathVariable("postId") Long postId,
                                            @RequestBody PostDTO dto) {
        return bloggerService.updatePost(postId, dto);
    }

    @DeleteMapping("/delete/post/{postId}")
    ResponseEntity<ErrorDetails> deletePost(@PathVariable Long postId) {

        return bloggerService.deletePost(postId);
    }

}
