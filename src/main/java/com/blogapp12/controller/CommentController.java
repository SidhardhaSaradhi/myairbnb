package com.blogapp12.controller;

import com.blogapp12.payload.CommentDto;
import com.blogapp12.payload.PostWithCommentDto;
import com.blogapp12.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    //http://localhost:8080/api/comments/1
    @PostMapping("/{postId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable long postId){
        CommentDto dto = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<PostWithCommentDto> getAllCommentsByPostId(@PathVariable long postId){
        PostWithCommentDto allCommentsByPostId = commentService.getAllCommentsByPostId(postId);
        return new ResponseEntity<>(allCommentsByPostId,HttpStatus.OK);

    }
   //http://localhost:8080/api/comments?id=1
    @GetMapping
        public ResponseEntity<CommentDto> getCommentById(@RequestParam long id){
        CommentDto dto = commentService.getCommentById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }

}
