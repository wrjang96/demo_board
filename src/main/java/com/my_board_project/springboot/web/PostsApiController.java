package com.my_board_project.springboot.web;
import com.my_board_project.springboot.service.posts.FileService;
import com.my_board_project.springboot.web.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.my_board_project.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final PostsService postsService;
//    private final FileService fileService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        logger.info("디버그 " + requestDto.getFileId());
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }

//    @PostMapping("/api/upload")
//    public Long uploadFile(@RequestParam("file") MultipartFile uploadFile) {
//        Long fileId = null;
//        try {
//            String origFilename = uploadFile.getOriginalFilename();
//            UUID uid = UUID.randomUUID();
//            String filename = uid.toString() + "." + StringUtils.getFilenameExtension(origFilename);
////            C:/Users/계정/Documents/img/
//            String directory = "C:/Users/wrjan/Documents/img/";
//            String filePath = Paths.get(directory, filename).toString();
//            // Save the file locally
//            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
//            stream.write(uploadFile.getBytes());
//            stream.close();
//            FileDto fileDto = new FileDto();
//            fileDto.setOrigFilename(origFilename);
//            fileDto.setFilename(filename);
//            fileDto.setFilePath(filePath);
//            fileId = fileService.saveFile(fileDto);
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//            fileId = null;
//        }
//        logger.info("디버그 " + fileId);
//        return fileId;
//    }

}