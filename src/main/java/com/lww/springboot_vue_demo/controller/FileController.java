package com.lww.springboot_vue_demo.controller;


import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/list1")
    @ResponseBody  //以json方式输出过去
    public Object Hello(String path,String keyword) {
        List<Map<String, String>> contents = getContents(path);
        // keyword搜索
        if (StringUtils.hasText(keyword)){
//            contents = queryByKeyWord(keyword,contents);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("data", contents);
        return map;
    }


    private List<Map<String, String>> queryByKeyWord(String keyword,List<Map<String, String>> contents) {
        if (contents==null||contents.size()==0){
            return null;
        }
        List<Map<String, String>> ret = new ArrayList<>();
        StringBuilder stringBuilder;
        for (Map<String, String> content : contents) {
             stringBuilder= new StringBuilder(content.get("preName"));
            if (stringBuilder.indexOf(keyword)!=-1){
                ret.add(content);
            }
        }
        return ret;
    }


    @PostMapping("/list2")
    @ResponseBody  //以json方式输出过去
    public Object list2(HttpServletRequest request) throws Exception {
        String ipAddr = getIpAddr(request);
        System.out.println(ipAddr);
        return ipAddr;
    }


    /**
     * @Author：
     * @Description：获取某个目录下所有直接下级文件，不包括目录下的子目录的下的文件，所以不用递归获取
     * @Date：
     */
    public List<Map<String, String>> getContents(String path) {
        if ("E:".equals(path)){
            path = "E:/";
        }
        List<Map<String, String>> contents = new ArrayList<>();
        File file = new File(path);
        // 不存在此路径直接返回空
        if (!file.exists()){
            return Collections.emptyList();
        }
        File[] tempList = file.listFiles();
        Map<String, String> cont;
        for (int i = 0; i < tempList.length; i++) {
            cont = new HashMap<>();
            if (tempList[i].isFile()) {
                cont.put("type", "file");
                cont.put("path", tempList[i].toString());
                cont.put("preName", tempList[i].getName());
                //文件名，不包含路径
                //String fileName = tempList[i].getName();
            }
            if (tempList[i].isDirectory()) {
                cont.put("type", "folder");
                cont.put("path", tempList[i].toString());
                cont.put("preName", tempList[i].getName());
            }
            contents.add(cont);
        }
        return contents;
    }


    /**
     * 获取真实ip地址，避免获取代理ip
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取访问用户的客户端IP（适用于公网与局域网）.
     */
    public static final String getIpAddr(final HttpServletRequest request)
            throws Exception {
        if (request == null) {
            throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
        }
        String ipString = request.getHeader("x-forwarded-for");
        if (isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("Proxy-Client-IP");
        }
        if (isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ipString.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ipString = str;
                break;
            }
        }

        return ipString;
    }

    /**
     * @param s
     * @return 如果<tt>s</tt>为<tt>null</tt>或空白字符串返回<tt>true</tt>
     */
    public static boolean isBlank(String s) {
        return s == null ? true : s.trim().length() == 0;
    }



}




