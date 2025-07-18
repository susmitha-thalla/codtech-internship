package com.codtech.blog.service;

import com.codtech.blog.model.Blog;
import com.codtech.blog.model.Comment;
import com.codtech.blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * Adds a comment to a blog.
     * @param blog The blog to comment on.
     * @param comment The comment to add.
     * @return The saved comment.
     */
    @Override
    public Comment addCommentToBlog(Blog blog, Comment comment) {
        comment.setBlog(blog);
        return commentRepository.save(comment);
    }

    /**
     * Retrieves all comments for a given blog.
     * @param blog The blog to get comments for.
     * @return List of comments.
     */
    @Override
    public List<Comment> getCommentsByBlog(Blog blog) {
        return commentRepository.findByBlog(blog);
    }
}
