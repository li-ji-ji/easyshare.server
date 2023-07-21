package com.easyshare.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easyshare.entity.Files;
import com.easyshare.service.impl.FilesServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author li-ji-ji
 * @since 2023-07-21
 */
@RestController
@RequestMapping("/files")
public class FilesApi {

    @Value("${file.storage.path}")
    private String STORAGE_PATH;
    private final FilesServiceImpl filesService;

    @Autowired
    public FilesApi(FilesServiceImpl filesService) {
        this.filesService = filesService;
    }

    /**
     * 上传单个文件
     * */
    @GetMapping("/uploadOne")
    public String uploadOne(@RequestParam("file") MultipartFile file) {
        // 文件名
        var fileName = file.getOriginalFilename();
        var filePath = STORAGE_PATH.concat("/").concat(fileName); // 文件存放位置
        var fileType = file.getContentType(); // 文件类型
        var dest = new File(filePath);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        var fileMsg = new Files();
        fileMsg.setFileName(fileName);
        fileMsg.setFileType(fileType);
        fileMsg.setFilePath(filePath);
        fileMsg.setSecret(RandomStringUtils.randomAlphanumeric(6));
        fileMsg.setUploadTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()).toString());
        filesService.save(fileMsg);

        try {
            file.transferTo(dest);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "upload failed";
        }
        return "upload success";
    }


    /**
     * 根据文件名称获取文件信息
     * */
    @GetMapping("/getByFileName")
    public Files getByFileName(@RequestParam("file") String file){
        var queryWrapper = new QueryWrapper<Files>();
        queryWrapper.eq("file_name",file);
        return filesService.getOne(queryWrapper);
    }

    /**
     * 查询所有文件
     * */
    @GetMapping("/listAll")
    public List<Files> listAll(){
        return filesService.list();
    }
}
