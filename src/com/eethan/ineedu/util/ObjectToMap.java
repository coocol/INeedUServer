package com.eethan.ineedu.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
* User: pengfei.hpf
* Date: 14-5-8
* Time: 下午12:34
*/
public class ObjectToMap {

//  public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
//    TestObject o = new TestObject();
//    o.setCity(3);
//    o.setName("bj");
//    o.setOrder("ASC");
//
//    ObjectToMap objectToMap = new ObjectToMap();
//    System.out.println("=========== Invoke objectToMapViaFields ===========");
//    objectToMap.objectToMapViaFields(o);
//  }


  


  /**
  * 通过getDeclaredFields 的方式复制属性值
  * getDeclaredFields方式不会返回父类的属性
  * */
  
  //过滤为空的项
  public static Map<String, Object> toMap(Object obj){
	    Map<String, Object> resMap = new HashMap<String, Object>();
	    Field[] declaredFields = obj.getClass().getDeclaredFields();
	    for (Field field : declaredFields) {
	      field.setAccessible(true);
	      
	      try {
			resMap.put(field.getName(), field.get(obj));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    return resMap;
	  }

 


//  /**
//  * 打印结果
//  * */
//  private static void printOut(Map<String, Object> resMap) {
//    for (String key : resMap.keySet()) {//遍历方法
//      System.out.println("Key:" + key + ";Value:" + resMap.get(key));
//    }
//  }


//  /**
//  * 测试类
//  * */
//  public static class TestObject {
//    int city;
//    String name;
//    String order;
//
//    public String getOrder() {
//      return order;
//    }
//
//    public void setOrder(String order) {
//      this.order = order;    }
//
//
//    public String getName() {
//      return name;
//    }
//
//    public void setName(String name) {
//      this.name = name;
//    }
//    public void setCity(int city) {
//        this.city = city;
//      }
//  }
}
  