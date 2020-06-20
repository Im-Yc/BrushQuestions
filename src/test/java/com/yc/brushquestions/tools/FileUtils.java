package com.yc.brushquestions.tools;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.UUID;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Base64;

/**
 *file工具
 *
 * @Author liuxin@worken.cn
 * @Date 2020-04-16 19:27:02
 **/
public class FileUtils {

    /**
     * 将MultipartFile转为File
     * @param mulFile
     * @return
     */
//    public static File multipartFileToFile(MultipartFile mulFile) throws IOException {
//        InputStream ins = mulFile.getInputStream();
//        String fileName = mulFile.getOriginalFilename();
//        String prefix = getFileNameNoEx(fileName)+ UUID.fastUUID();
//        String suffix = "."+getExtensionName(fileName);
//        File toFile = File.createTempFile(prefix,suffix);
//        OutputStream os = new FileOutputStream(toFile);
//        int bytesRead = 0;
//        byte[] buffer = new byte[8192];
//        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
//            os.write(buffer, 0, bytesRead);
//        }
//        os.close();
//        ins.close();
//        return toFile;
//    }


    /**
     * 将Base64转为File
     * @param base64
     * @param fileType
     * @return
     */
    public static File Base64ToFile(String base64,String fileType) throws IOException {
        if(base64.contains("data:image")){
            base64 = base64.substring(base64.indexOf(",")+1);
        }
        byte[] bytes = Base64.getMimeDecoder().decode(base64);
        InputStream ins = IoUtil.toStream(bytes);
        String prefix =  UUID.fastUUID().toString();
        String suffix = "."+fileType;
        File toFile = File.createTempFile(prefix,suffix);
        OutputStream os = new FileOutputStream(toFile);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
        return toFile;
    }



    /**
     * 获取文件扩展名
     *
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /**
     * 获取不带扩展名的文件名
     *
     */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }



}
