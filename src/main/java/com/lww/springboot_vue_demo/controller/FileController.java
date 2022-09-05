package com.lww.springboot_vue_demo.controller;


import com.lww.springboot_vue_demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lww
 */
@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/list1")
    public Map<String, Object> Hello(String path, String keyword) {
        List<Map<String, String>> fileList = fileService.getFileList(path, keyword);
        Map<String, Object> map = new HashMap<>();
        map.put("data", fileList);
        return map;
    }

    @DeleteMapping("/deleteFile")
    public Map<String, Object> deleteFile(String path){
        fileService.deleteFile(path);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "删除成功!");
        map.put("code", 200);
        return map;
    }

    @PutMapping("/renameFile")
    public Map<String, Object> renameFile(String path,String newName){
        fileService.renameFile(path,newName);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "修改成功!");
        map.put("code", 200);
        return map;
    }

}




