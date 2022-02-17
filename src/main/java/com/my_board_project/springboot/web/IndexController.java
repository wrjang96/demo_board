package com.my_board_project.springboot.web;

import com.my_board_project.springboot.config.auth.LoginUser;
import com.my_board_project.springboot.config.auth.dto.SessionUser;
import com.my_board_project.springboot.domain.posts.Posts;
import com.my_board_project.springboot.service.posts.FileService;
import com.my_board_project.springboot.service.posts.PostsService;
import com.my_board_project.springboot.web.dto.FileDto;
import com.my_board_project.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final FileService fileService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        if(dto.getFileId() != null) {
            FileDto fileDto = fileService.getFile(dto.getFileId());
            model.addAttribute("OrigFilename", fileDto.getOrigFilename());
        }
        return "posts-update";
    }
    @GetMapping("/posts/read/{id}")
    public String postsRead(@PathVariable Long id, Model model){

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        if(dto.getFileId() != null) {
            FileDto fileDto = fileService.getFile(dto.getFileId());
            model.addAttribute("OrigFilename", fileDto.getOrigFilename());
        }
        return "posts-read";
    }
}