package com.yc.brushquestions.brushquestions;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.yc.brushquestions.brushquestions.model.DataBackDTO;
import com.yc.brushquestions.brushquestions.model.DataBackForm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author liuxin@worken.cn
 * @Date 2020-05-08 17:48:29
 **/
@SpringBootTest
public class JavaEight {

    @Test
    public void test(){
        try{

//            long between = DateUtil.between(DateUtil.parse("2020-05-11 13:38:50"), new Date(), DateUnit.DAY);
//            System.out.println(between);
//            System.out.println(DateUtil.format(new Date(), "yyyy-MM-dd"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void beanToBean2(){
        DataBackDTO dataBackDTO = DataBackDTO.builder().readNum(20).time("20点").build();
        DataBackDTO dataBackDTO2 = new DataBackDTO();
        BeanUtil.copyProperties(dataBackDTO, dataBackDTO2);
        System.out.println(dataBackDTO2);
    }

    @Test
    public void beanToBean(){
        DataBackDTO dataBackDTO = DataBackDTO.builder().readNum(20).time("20点").build();
        DataBackForm convert = Convert.convert(DataBackForm.class, dataBackDTO);
        System.out.println(convert);
    }

    @Test
    public void mapToBean(){
        HashMap<String, Object> infoMap = new HashMap<>(8);
        infoMap.put("reAdnum",20);
        infoMap.put("TiMe","晚上九点");
        DataBackForm dataBackForm = BeanUtil.mapToBeanIgnoreCase(infoMap, DataBackForm.class, false);
        System.out.println(dataBackForm);
    }


    @Test
    public void ListSort2() {
        List<DataBackForm> list = new ArrayList<>();
        list.add(new DataBackForm(11,"2020-03-27"));
        list.add(new DataBackForm(5,"2020-03-20"));
        list.add(new DataBackForm(12,"2020-04-22"));
        list.add(new DataBackForm(9,"2020-02-27"));
        list.add(new DataBackForm(29,"2020-01-27"));
        list.add(new DataBackForm(66,"2020-05-08"));
        Collections.sort(list, (o1,o2) ->{
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
        );
        System.out.println(list.toString());
    }

    @Test
    public void ListSort() {
        List<DataBackForm> list = new ArrayList<>();
        list.add(new DataBackForm(11,"2020-03-27"));
        list.add(new DataBackForm(5,"2020-03-20"));
        list.add(new DataBackForm(12,"2020-04-22"));
        list.add(new DataBackForm(9,"2020-02-27"));
        list.add(new DataBackForm(29,"2020-01-27"));
        list.add(new DataBackForm(66,"2020-05-08"));
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
