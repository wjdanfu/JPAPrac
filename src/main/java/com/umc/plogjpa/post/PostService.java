package com.umc.plogjpa.post;

import com.umc.plogjpa.domain.*;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ReCommentRepository reCommentRepository;
    private final LikecntRepository likecntRepository;

    public Long savePost(PostDto postDto, long userIdx) throws NotFoundException {
        User user = userRepository.findByUserIdx(userIdx)
                .orElseThrow(() -> new NotFoundException("회원정보를 찾을 수 없습니다."));
        postDto.setUser(user);

        Post entity = postRepository.save(postDto.toEntity());
        return entity.getPostIdx();
    }

    public Long saveComment(CommentDto commentDto, long postIdx, long userIdx) throws NotFoundException {
        User user = userRepository.findByUserIdx(userIdx)
                .orElseThrow(() -> new NotFoundException("회원정보를 찾을 수 없습니다."));
        Post post = postRepository.findByPostIdx(postIdx)
                .orElseThrow(() -> new NotFoundException("없는 게시글 입니다."));

        commentDto.setPost(post);
        commentDto.setUser(user);

        Comment entity = commentRepository.save(commentDto.toEntity());
        return entity.getCommentIdx();
    }

    public Long saveReComment(ReCommentDto reCommentDto, long commentIdx, long userIdx) throws NotFoundException {
        User user = userRepository.findByUserIdx(userIdx)
                .orElseThrow(() -> new NotFoundException("회원정보를 찾을 수 없습니다."));
        Comment comment = commentRepository.findByCommentIdx(commentIdx)
                .orElseThrow(() ->new NotFoundException("없는 댓글 입니다."));

        reCommentDto.setComment(comment);
        reCommentDto.setUser(user);

        ReComment entity = reCommentRepository.save(reCommentDto.toEntity());
        return entity.getRecommentIdx();
    }

    public List<PostResDto> getPost() throws NotFoundException{
        List<Post> entity = postRepository.findAll();
        List<PostResDto> postResDtos = new ArrayList<>();
        for (int i = 0; i<entity.size(); i++){
            PostResDto postResDto = new PostResDto(entity.get(i));
            postResDtos.add(postResDto);
        }
        return postResDtos;

    }
    public PostIdxResDto getPostIdx(long postIdx) throws NotFoundException{
        Post post = postRepository.findByPostIdx(postIdx)
                .orElseThrow(() -> new NotFoundException("없는 게시글 입니다."));

        List<Comment> comments = commentRepository.findAllByPost_postIdx(post.getPostIdx());
        PostIdxResDto postResIdxDto = new PostIdxResDto(post);
        List<CommentResDto> commentResDtos = new ArrayList<>();

        for (int i = 0; i<comments.size(); i++){
            CommentResDto comment = new CommentResDto(comments.get(i).getCommentIdx(),comments.get(i).getContent(),comments.get(i).getUser());
            commentResDtos.add(comment);

            List<ReComment> reComments = reCommentRepository.findAllByComment_commentIdx(comments.get(i).getCommentIdx());
            List<ReCommentResDto> reCommentResDtos = new ArrayList<>();
            for (int j =0; j<reComments.size();j++){
                ReCommentResDto reComment = new ReCommentResDto(reComments.get(j).getContent(),reComments.get(j).getUser());
                reCommentResDtos.add(reComment);
            }
            comment.setReComment(reCommentResDtos);
        }
        postResIdxDto.setComments(commentResDtos);

        return postResIdxDto;
    }

    public boolean postLike(long postIdx,long userIdx) throws NotFoundException {
        User user = userRepository.findByUserIdx(userIdx)
                .orElseThrow(() -> new NotFoundException("회원정보를 찾을 수 없습니다."));
        Post post = postRepository.findByPostIdx(postIdx)
                .orElseThrow(() -> new IllegalArgumentException("없는 게시글 입니다."));
        boolean check = likecntRepository.existsByUser_userIdxAndPost_postIdx(user.getUserIdx(),postIdx);
        if (check == false){
            Likecnt likecnt = Likecnt.builder()
                    .user(user)
                    .post(post)
                    .status("ACTIVE")
                    .build();
            likecntRepository.save(likecnt);
            return true;
        }else{
            likecntRepository.deleteByUser_userIdxAndPost_postIdx(user.getUserIdx(), postIdx);
            return false;
        }
    }
}
