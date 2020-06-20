package com.yc.brushquestions.tools;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import com.yc.brushquestions.brushquestions.model.DataBackDTO;
import com.yc.brushquestions.brushquestions.model.DataBackForm;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Base64Utils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author liuxin@worken.cn
 * @Date 2020-05-19 10:24:38
 **/
@SpringBootTest(classes = HuTool.class)
@Slf4j
public class HuTool {


    @Test
    public void test() {

        String a = "2";
//        Integer i = Integer.parseInt(a);
        Double v = Double.parseDouble(a);
        System.out.println(v.intValue());
//        String base64 = "file: \"data:image/jpeg;base64,PCFET0NUWVBFIGh0bWw+CjxodG1sIGxhbmc9ImVuIj4KICA8aGVhZD4KICAgIDxtZXRhIGNoYXJzZXQ9InV0Zi04Ij4KICAgIDxtZXRhIGh0dHAtZXF1aXY9IlgtVUEtQ29tcGF0aWJsZSIgY29udGVudD0iSUU9ZWRnZSI+CiAgICA8bWV0YSBuYW1lPSJ2aWV3cG9ydCIgY29udGVudD0id2lkdGg9ZGV2aWNlLXdpZHRoLGluaXRpYWwtc2NhbGU9MS4wIj4KICAgIDwhLS0gPGxpbmsgcmVsPSJpY29uIiBocmVmPSJmYXZpY29uLmljbyI+IC0tPgogICAgCiAgICA8bWV0YSBuYW1lPSJyZWZlcnJlciIgY29udGVudD0ibmV2ZXIiPgogICAgPHRpdGxlPuaUv+azleiejeWqkuS6kTwvdGl0bGU+CiAgPC9oZWFkPgogIDxib2R5PgogICAgPG5vc2NyaXB0PgogICAgICA8c3Ryb25nPldlJ3JlIHNvcnJ5IGJ1dCDmlL/ms5Xono3lqpLkupEgZG9lc24ndCB3b3JrIHByb3Blcmx5IHdpdGhvdXQgSmF2YVNjcmlwdCBlbmFibGVkLiBQbGVhc2UgZW5hYmxlIGl0IHRvIGNvbnRpbnVlLjwvc3Ryb25nPgogICAgPC9ub3NjcmlwdD4KICAgIDxkaXYgaWQ9ImFwcCI+PC9kaXY+CiAgICA8c2NyaXB0IHNyYz0idGlueW1jZTQuNy41L3RpbnltY2UubWluLmpzIj48L3NjcmlwdD4KICAgIDwhLS0gYnVpbHQgZmlsZXMgd2lsbCBiZSBhdXRvIGluamVjdGVkIC0tPgogIDxzY3JpcHQgdHlwZT0idGV4dC9qYXZhc2NyaXB0IiBzcmM9ImNodW5rLXZlbmRvcnMuMTU4OTc4MDg0NjE5MC5qcyI+PC9zY3JpcHQ+PHNjcmlwdCB0eXBlPSJ0ZXh0L2phdmFzY3JpcHQiIHNyYz0iYXBwLjE1ODk3ODA4NDYxOTAuanMiPjwvc2NyaXB0PjwvYm9keT4KPC9odG1sPgo=\"";
//        String s = checkImageBase64Format(base64);
//        byte[] bytes = Base64Utils.decodeFromString(base64);
//        ByteArrayInputStream byteArrayInputStream = IoUtil.toStream(bytes);
//        File jpg = getFileByUrl("https://mmbiz.qpic.cn/mmbiz_png/o9lSB1lJTUuuaiaKEeOb3ibVMktskVSlDpWnoWupvSibAvLeHQAplrJia9HlSPNuMuMj0cYxJDIERa5VuKUT3anr4g/640?tp=webp&amp;wxfrom=5&amp;wx_lazy=1&amp;wx_co=1", "jpg");
//        File jpg = getFileByUrl("https://imagepphcloud.thepaper.cn/pph/image/67/813/543.jpg", "jpg");
//        String name = jpg.getName();
//        System.out.println(jpg);
    }


    //base64字符串转化成图片
    public static File base64ToFile(String base64, String fileName) throws Exception {
        if(base64.contains("data:image")){
            base64 = base64.substring(base64.indexOf(",")+1);
        }
        base64 = base64.toString().replace("\r\n", "");
        File file = null;
        //创建文件目录
        BufferedOutputStream bos = null;
        java.io.FileOutputStream fos = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes =  decoder.decodeBuffer(base64);

            fileName =  UUID.fastUUID().toString();

            file=new File(fileName);
            OutputStream out = new FileOutputStream(fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        }finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }


    @Test
    public void streamSort(){
        List<DataBackForm>dataBackForms = new ArrayList<>();
        dataBackForms.add(DataBackForm.builder().readNum(111).time("1").build());
        dataBackForms.add(DataBackForm.builder().readNum(222).time("1").build());
        dataBackForms.add(DataBackForm.builder().readNum(333).time("2").build());
        dataBackForms.add(DataBackForm.builder().readNum(444).time("2").build());
        dataBackForms.add(DataBackForm.builder().readNum(555).time("3").build());
        dataBackForms.add(DataBackForm.builder().readNum(666).time("3").build());
        TreeMap<String,List<DataBackForm>> ageMap =  dataBackForms.stream().collect(Collectors.groupingBy(DataBackForm :: getTime, TreeMap::new,Collectors.toList()));
        System.out.println(ageMap);
    }


    @Test
    public void fileUtil() throws IOException {
        String base64 = "data:image/png;base64,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\n";
        if(base64.contains("data:image")){
            base64 = base64.substring(base64.indexOf(",")+1);
        }
        String fileType = "png";
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
        String type = FileUtil.getType(toFile);
        System.out.println(type);
    }


    @Test
    public void httpUtil(){
        //GET请求
        String content = HttpUtil.get("https://mp.weixin.qq.com/s?__biz=MjM5MTU3Mzk0NA==&mid=2650930675&idx=1&sn=770d7f67c8f8b120f659a3e5416f82ae#rd");
        String patternStr = "<img\\s+[^>]*?src=[\"|\']((\\w+?:?//|\\/|\\w*)[^\"]*?)[\"|\'][^>]*?>";
        Pattern r = Pattern.compile(patternStr);
        Matcher m = r.matcher(content);
        String msgDataId = "";
        while (m.find()){
            String res = m.group(1);
            if (res.length()>0){
                System.out.println(res);
            }
        }
    }


    private File getFileByUrl(String fileUrl, String fileType) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        BufferedOutputStream stream = null;
        InputStream inputStream = null;
        File file = null;
        try {
            URL imageUrl = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            inputStream = conn.getInputStream();
            String prefix =  UUID.fastUUID().toString();
            String suffix = "."+fileType;
            file = File.createTempFile(prefix,suffix);
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            inputStream.close();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (inputStream != null) inputStream.close();
                if (stream != null) stream.close();
                outStream.close();
                if(file!=null)file.delete();
            } catch (Exception e) {
                System.out.println("关闭流异常");
                e.printStackTrace();
            }
        }
    }


    //链接url下载图片
    private static void downloadPicture(String urlList, String path) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            BASE64Encoder encoder = new BASE64Encoder();
            String encode = encoder.encode(buffer);//返回Base64编码过的字节数组字符串
            System.out.println(encode);
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void jsonArray() {
        JSONObject jsonStr = JSONUtil.parseObj("{\n" +
                "    \"list\": []\n" +
                "}");
        JSONArray objects = JSONUtil.parseArray(jsonStr.get("list"));
//        System.out.println(objects);
        List<Integer> articleTotal = JSONUtil.toList(objects, Integer.class);
        for (Integer integer : articleTotal) {
            System.out.println(integer);
        }
        System.out.println("结束");
    }


    @Test
    public void dateUtilTest() {
        try {
            int i = 0;
            Date newDate = DateUtil.offsetMonth(new Date(), -1);
            while (DateUtil.between(newDate, new Date(), DateUnit.DAY) > 0) {
                i++;
                newDate = DateUtil.offsetDay(newDate, 1);
            }
            System.out.println(i);
//            Date newDate = DateUtil.offsetMonth(new Date(), -1);
//            String format = DateUtil.format(newDate, "yyyy/MM/dd HH:mm:ss");
//            System.out.println(format);
//            long between = DateUtil.between(DateUtil.parse("2020-05-11 13:38:50"), new Date(), DateUnit.DAY);
//            System.out.println(between);
//            System.out.println(DateUtil.format(new Date(), "yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void beanToBean2() {
        DataBackDTO dataBackDTO = DataBackDTO.builder().readNum(20).time("20点").build();
        Map<String, Object> map = BeanUtil.beanToMap(dataBackDTO);
        map.put("authType",1);
        System.out.println(map);
        DataBackDTO dataBackDTO2 = new DataBackDTO();
        BeanUtil.copyProperties(dataBackDTO, dataBackDTO2);
        System.out.println(dataBackDTO2);
    }

    @Test
    public void beanToBean() {
        DataBackDTO dataBackDTO = DataBackDTO.builder().readNum(20).time("20点").build();
        DataBackForm convert = Convert.convert(DataBackForm.class, dataBackDTO);
        System.out.println(convert);
    }

    @Test
    public void mapToBean() {
        HashMap<String, Object> infoMap = new HashMap<>(8);
        infoMap.put("reAdnum", 20);
        infoMap.put("TiMe", "晚上九点");
        DataBackForm dataBackForm = BeanUtil.mapToBeanIgnoreCase(infoMap, DataBackForm.class, false);
        System.out.println(dataBackForm);
    }


}
