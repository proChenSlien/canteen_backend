package com.cp.controller;

import com.cp.utils.PrimaryKeyUtil;
import com.cp.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: fanyongjiu
 * @Date: 18/5/16 13:40
 */
@RestController
@RequestMapping("/file")
public class SysFileController {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${imagePath}")
    private String imagePath;

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * 图片上传
     *
     * @param file
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "图片上传Form方式")
    @PostMapping("/uploadImg")
    public Result uploadImg(@RequestParam MultipartFile file[], MultipartHttpServletRequest request) throws Exception {
        Map<String, MultipartFile> map = request.getFileMap();

        List<String> names = new ArrayList<>();
        for (MultipartFile f : file) {
            // 图片的名字用毫秒数+图片原来的名字拼接
            String imgName = PrimaryKeyUtil.getTableID();
            names.add(imgName);
            //上传文件
//            uploadFileUtil(f.getBytes(), imgName);
        }

        return Result.createBySuccess("data", names);
    }
}
