package com.umc.plogjpa.post;

import com.umc.plogjpa.ApiResponse;
import com.umc.plogjpa.domain.Post;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @ExceptionHandler
    private ApiResponse<String> exceptionHandle(Exception exception) {
        return ApiResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    private ApiResponse<String> notFoundHandle(NotFoundException exception) {
        return ApiResponse.fail(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @PostMapping("/posts/{userIdx}")
    public ApiResponse<Long> savePost(@RequestBody PostDto postDto,
                                      @PathVariable long userIdx)
            throws NotFoundException {
        Long postIdx = postService.savePost(postDto, userIdx);
        return ApiResponse.ok(postIdx);
    }

    @PostMapping("/comments/{postIdx}/{userIdx}")
    public ApiResponse<Long> saveComment(@RequestBody CommentDto commentDto,
                                         @PathVariable long postIdx,
                                         @PathVariable long userIdx)
            throws NotFoundException {
        Long commentIdx = postService.saveComment(commentDto, postIdx, userIdx);
        return ApiResponse.ok(commentIdx);
    }

    @PostMapping("/comments/recomment/{commentIdx}/{userIdx}")
    public ApiResponse<Long> saveReComment(@RequestBody ReCommentDto reCommentDto,
                                         @PathVariable long commentIdx,
                                         @PathVariable long userIdx)
            throws NotFoundException {
        Long recommentIdx = postService.saveReComment(reCommentDto, commentIdx, userIdx);
        return ApiResponse.ok(recommentIdx);
    }

    @GetMapping("/posts")
    public ApiResponse<List<PostResDto>> getPost(
    ) throws NotFoundException {
        return ApiResponse.ok(
                postService.getPost());
    }

    @GetMapping("/posts/{postIdx}")
    public ApiResponse<PostIdxResDto> getPostIdx(@PathVariable long postIdx)
            throws NotFoundException {
        return ApiResponse.ok(
                postService.getPostIdx(postIdx)
        );
    }

    @PostMapping("/like/{postIdx}/{userIdx}")
    public ApiResponse<String> postLike(@PathVariable long postIdx, long userIdx) throws NotFoundException{
        return ApiResponse.ok(postService.postLike(postIdx,userIdx));
    }
}
