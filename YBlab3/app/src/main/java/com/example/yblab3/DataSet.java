package com.example.yblab3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 杨邦 on 2016/10/10.
 */
public class DataSet {
    public static List<Map<String, Object>> list;
    private static String name[] = {"Aaron", "Elvis", "David", "Edwin", "Frank", "Joshua", "Ivan", "Mark", "Joseph", "Phoebe"};
    private static String phone[] = {"17715523654", "18825653224", "15052116654", "18854211875", "13955188541", "13621574410", "15684122771", "17765213579", "13315466578", "17895466428"};
    private static String color[] = {"#BB4C3B", "#c48d30", "#4469b0", "#20A17B", "#BB4C3B", "#c48d30", "#4469b0", "#20A17B", "#BB4C3B", "#c48d30"};
    private static String address[] = {"江苏苏州电信", "广东揭阳移动", "江苏无锡移动", "山东青岛移动", "安徽合肥移动", "江苏苏州移动", "山东烟台联通", "广东珠海电信", "河北石家庄电信", "山东东营移动"};
    static {
        list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Map<String, Object> temp = new LinkedHashMap<>();
            temp.put("name", name[i]);
            temp.put("phone", phone[i]);
            temp.put("color", color[i]);
            temp.put("address", address[i]);
            list.add(temp);
        }
    }
    static public void remove(int index){
        list.remove(index);
    }
    static public void setName(int index, String Name){
        Map<String, Object> temp = new LinkedHashMap<>();
        temp.put("name", Name);
        list.set(index, temp);
    }
    static public void setPhone(int index, String Phone){
        Map<String, Object> temp = new LinkedHashMap<>();
        temp.put("name", Phone);
        list.set(index, temp);
    }
    static public void setAddress(int index, String Address){
        Map<String, Object> temp = new LinkedHashMap<>();
        temp.put("name", Address);
        list.set(index, temp);
    }
    static public void setColor(int index, String Color){
        Map<String, Object> temp = new LinkedHashMap<>();
        temp.put("name", Color);
        list.set(index, temp);
    }
}
