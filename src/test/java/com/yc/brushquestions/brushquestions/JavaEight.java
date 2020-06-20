package com.yc.brushquestions.brushquestions;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import com.yc.brushquestions.brushquestions.model.DataBackForm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author liuxin@worken.cn
 * @Date 2020-05-08 17:48:29
 **/
@SpringBootTest
public class JavaEight {

    @Test
    public void test() {
        try {
//            String string = "\n【\\n北京丰台区副区长等被免职处理#\\n据北京日报消息：昨天";
//            BigInteger num = BigInteger.valueOf(9*1000000000);
//            System.out.println(num);
            String content = "三生三世>;嗷嗷啊";
            String s = content.replaceAll(">;", ">");
            System.out.println(s);


            String content1 = "这些人为啥被称为“球书记”？有来头";
            String content2 = "这些人为啥被称为“球书记”……有来头！";
            String content3 = "这些人为啥被称为“球书记”？有来头";
            float a = 0;
            System.out.println(a==0f);
            String content11 = quChong(content1);
            String content21 = quChong(content2);
            String content31 = quChong(content3);
            System.out.println(content1);
//            String s = "ab c, d. 3 ?  :  ! 5".replaceAll("[\\p{Punct}\\p{Space}]+", "");// abcd35
//            System.out.println(s);

//            String content = HttpUtil.get("https://content-test.oss-cn-hangzhou.aliyuncs.com/contentExample/9017842584892095929__9578990351367268141_3014287662_irContent.txt", CharsetUtil.CHARSET_GBK);
//            System.out.println(content);

//            String content = "为确保2020年度建设任务目标全面完成，12日下午，张坂片区项目土地房屋征迁指挥部召开海城大道市政道路工程、海城大道玉田互通工程等项目征迁动员大会，区党工委委员、管委会副主任赖丽水出席会议。\n" +
//                    "<IMAGE SRC=\"https://mmbiz.qpic.cn/mmbiz_jpg/W8hU3LzNbz0hyWicx7urXwkd32Dicia8aC9qIwS5ic9SVRib1Y3dWQAscIGaQ4QMvIZ6icMQYib1d8hZ8tIA4CRWCibguQ/640?wx_fmt=jpeg\">;\n" +
//                    "今年，张坂片区实施重点项目48个，现阶段启动征迁的重点项目是海城大道市政道路工程、海城大道玉田互通工程、东西大道延伸段，共涉及房屋380余宗约15.8万平，地上物99处，坟墓9000多个。\n" +
//                    "<IMAGE SRC=\"https://mmbiz.qpic.cn/mmbiz_gif/W8hU3LzNbz0hyWicx7urXwkd32Dicia8aC9BNyvHnd2NBWZEUcmLutZsFgOuRcjHpjicU4rqebLsE7NMNL3b1JpuHw/640?wx_fmt=gif\">;\n" +
//                    "海城大道市政道路工程\n" +
//                    "<IMAGE SRC=\"https://mmbiz.qpic.cn/mmbiz_png/W8hU3LzNbz0hyWicx7urXwkd32Dicia8aC9hQ8Md9ia0SLd3xyL0cLUibTRJibiadB4MqQWf0DPHhfPoN9FicJ8u40Ggqg/640?wx_fmt=png\">;\n" +
//                    "“五纵五横”之第四纵，城市主干道：北段起于张纬四路，终于张纬六路，南段起于泉东大道，终于海湾大道，设计速度80km/h，全长约3.96km，道路红线宽60米，主车道双向8车道，两侧设置辅道和人行道。\n" +
//                    "海城大道玉田互通工程\n" +
//                    "<IMAGE SRC=\"https://mmbiz.qpic.cn/mmbiz_jpg/W8hU3LzNbz0hyWicx7urXwkd32Dicia8aC9l364opuU2eXPPZ25Zw1143VmX8ice5FISPuickXkwFmSvlC8QgwQU76A/640?wx_fmt=jpeg\">;\n" +
//                    "建设内容有路线、路基路面、桥梁涵洞、人行天桥，地下通道、市政管线、照明工程、交通工程、绿化景观、改路等；其中海城大道主线长586.6m，东西大道长1160m，匝道8条，主线跨线桥1座，人行通道2座，人行天桥一座，线外框架桥1座，桥梁总面积35419.5平。\n" +
//                    "东西大道延伸段\n" +
//                    "<IMAGE SRC=\"https://mmbiz.qpic.cn/mmbiz_jpg/W8hU3LzNbz0hyWicx7urXwkd32Dicia8aC90CvJWH1z3HyJOSZLGCQjWiay9o98eb4pQk3HZC0BqcahX5j049bJ2Bw/640?wx_fmt=jpeg\">;\n" +
//                    "“五纵五横”之第三横，城市快速路，全长约6.32km；起点至海灵大道段（K0+000～K5+220）道路红线宽65-70m，道路等级为城市快速路，设计速度100km/h，主线双向8车道，两侧设置辅道和人行道，需扣除海城大道互通范围（K0+900～K2+060）。海灵大道至军博园段（K5+220～K7+480）道路红线宽35.5m，道路等级为城市主干路，主线双向6车道，两侧设置人行道。\n" +
//                    "<IMAGE SRC=\"https://mmbiz.qpic.cn/mmbiz_gif/W8hU3LzNbz0hyWicx7urXwkd32Dicia8aC9u2s2mdJ8CicecgAtMKtRMwTyq5CJyuIP4Fic14ACW6BNjXz09xoMzyYQ/640?wx_fmt=gif\">;\n" +
//                    "来源：活力张坂";
//            String patternStr = "<IMAGE\\s+[^>]*?(SRC=[\"|\'](\\w+?:?//|\\/|\\w*)[^\"]*?)[\"|\'][^>]*?>";
//            Pattern pattern=Pattern.compile(patternStr);
//            Matcher matcher = pattern.matcher(content);
//            while(matcher.find()){
//                content=content.replace(matcher.group(0),("<br/>"+matcher.group(0)));
//                content=content.replace(matcher.group(1),("style=\"display:block;margin: 0 auto;\" "+matcher.group(1)));
//            }
//            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String quChong(String content){
        content = content.replaceAll("[\\p{Punct}\\p{Space}]+", "");
        System.out.println(content);
        String regEx="[\u3002|\uff1f|\uff01|\uff0c|\u3001|\uff1b|\uff1a|\u201c|\u201d|\u2018|\u2019|\uff08|\uff09|\u300a|\u300b|\u3008|\u3009|\u3010|\u3011|\u300e|\u300f|\u300c|\u300d|\ufe43|\ufe44|\u3014|\u3015|\u2026|\u2014|\uff5e|\ufe4f|\uffe5|\uff0d \uff3f|\u002d]?";
        Pattern r = Pattern.compile(regEx);
        Matcher m = r.matcher(content);
        return m.replaceAll("").trim();
    }

    @Test
    public void fileTest() {
        try {
            BufferedInputStream bis = null;
            HttpURLConnection urlconnection = null;
            URL url = null;
            url = new URL("https://mmbiz.qpic.cn/mmbiz_png/BhcGU6XDfaUa5LnyRGOxibofDT1rgSLGeGbHShrWdcwzQtwSGSicXuSpicKib1BfIuzjakEpibIE9Z2Mb6NstogsHMg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1");
            urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.connect();
            bis = new BufferedInputStream(urlconnection.getInputStream());
            String type = HttpURLConnection.guessContentTypeFromStream(bis);
            type = type.split("/")[1];
            System.out.println("file type:" + type);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void zz() {
        String pattern = "(?<=mid=)(.*?)(?=&)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher("https://mp.weixin.qq.com/s?__biz=MjM5MTU3Mzk0NA==&mid=2650930675&idx=1&sn=770d7f67c8f8b120f659a3e5416f82ae#rd");
        if (m.find()) {
            System.out.println(m.group(0));
        }
    }


    @Test
    public void ListSort2() {
        long between = DateUtil.between(DateUtil.parse("2020-06-04"), DateUtil.beginOfDay(new Date()), DateUnit.DAY);
        long l = System.currentTimeMillis();
        long time = new Date().getTime();
        System.out.println(DateUtil.format(new Date(), "yyyy/MM/dd HH:mm:ss"));
        List<DataBackForm> list = new ArrayList<>();
//        list.add(new DataBackForm(11,"2020-03-27", DateUtil.parse("2020-03-27")));
//        list.add(new DataBackForm(5,"2020-03-20", DateUtil.parse("2020-03-20")));
//        list.add(new DataBackForm(12,"2020-04-22", DateUtil.parse("2020-04-22")));
//        list.add(new DataBackForm(9,"2020-02-27", DateUtil.parse("2020-02-27")));
//        list.add(new DataBackForm(29,"2020-01-27", DateUtil.parse("2020-01-27")));
        list.add(new DataBackForm(66, null, DateUtil.parse("2020-05-08")));
//        Optional<DataBackForm> min = list.stream().filter(o -> o.getTime() != null).distinct().min((e1, e2) -> DateUtil.compare(e1.getDate(), e2.getDate()));
//        boolean present = min.isPresent();
//        System.out.println(min==null);
//        DataBackForm dataBackForm = min.get();
//        System.out.println(min);
//        System.out.println(ObjectUtil.isEmpty(dataBackForm));
//        String time = list.stream().filter(o -> o.getTime() != null).distinct().min((e1, e2) -> DateUtil.compare(e1.getDate(), e2.getDate())).get().getTime();
//        System.out.println(time);

//        Stream<DataBackForm> sorted = list.stream().sorted(Comparator.comparing(DataBackForm::getDate).reversed());
//        Collections.sort(list, (o1,o2) ->{
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                try {
//                    Date dt1 = format.parse(o1.getTime());
//                    Date dt2 = format.parse(o2.getTime());
//                    if (dt1.getTime() > dt2.getTime()) {
//                        return 1;
//                    } else if (dt1.getTime() < dt2.getTime()) {
//                        return -1;
//                    } else {
//                        return 0;
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return 0;
//            }
//        );
//        System.out.println(list.toString());
    }

    @Test
    public void ListSort() {
        List<DataBackForm> list = new ArrayList<>();
        list.add(new DataBackForm(11, "2020-03-27", DateUtil.parse("2020-03-27")));
        list.add(new DataBackForm(5, "2020-03-20", DateUtil.parse("2020-03-20")));
        list.add(new DataBackForm(12, "2020-04-22", DateUtil.parse("2020-04-22")));

        List<DataBackForm> list2 = new ArrayList<>();
        list2.add(new DataBackForm(9, "2020-02-27", DateUtil.parse("2020-02-27")));
        list2.add(new DataBackForm(29, "2020-01-27", DateUtil.parse("2020-01-27")));
        list2.add(new DataBackForm(66, "2020-05-08", DateUtil.parse("2020-05-08")));
        list.addAll(list2);
        System.out.println(list);
        Collections.sort(list, new Comparator<DataBackForm>() {
            @Override
            public int compare(DataBackForm o1, DataBackForm o2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date dt1 = format.parse(o1.getTime());
                    Date dt2 = format.parse(o2.getTime());
                    if (dt1.getTime() > dt2.getTime()) {
                        return 1;
                    } else if (dt1.getTime() < dt2.getTime()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
        System.out.println(list.toString());
    }
}
