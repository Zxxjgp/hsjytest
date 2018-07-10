package com.jgp.test;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSpliceTest {

    public static  void main(String[] args){
/*        StringBuilder  str = new StringBuilder();
        str.append("你好");
        str.append("这个世界");
        str.toString();
        System.out.println("这个是我拼接字符串="+str);

        String strd = "abcdefg";
        for (int i = 0 ; i < 2; i++){
            strd = strd + "jgp";
        }
        String  test= strd.replaceAll("j","1111111");
        System.out.println(test);
        String test1 = strd.replace("a","王干");
        System.out.println(test1);

        System.out.println(strd);*/


        /**
         * 第二阶段的测试用例
         */
 /*       HashMap<Object, Object> myMap = new HashMap<Object, Object>();

        String targetObj = "对象1";
        myMap.put("a", targetObj);
        myMap.put("b", targetObj);
        System.out.println(myMap.get("b") == myMap.get("a") );*/


        /**
         * ArrayList的使用
         */
/*        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        List<String> subList = list.subList(0, 1);
        System.out.println(subList.hashCode());

        String[] ar = new String[2];
        ar = list.toArray(ar);
        System.out.println(ar[1]);*/

        /**
         * 数组--->集合
         */
/*        String[]  jj = new String[5];
        jj[0] = "111111111111111";
        jj[1] = "222222222222222";
        jj[2] = "333333333333333";
        jj[2] = "eeeeeeeeeeeeeeeeeee";
        List list =Arrays.asList(jj);
        list.add("3we3w432432433");
        System.out.println(list.size());*/

        /**
         * 集合的遍历问题
         */
/*        List<Integer> list = new ArrayList<>();
        list.add(21);
        list.add(13);
        list.add(96);
        Collections.sort(list);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer o = iterator.next();
            System.out.println(o);
        }*/

   /*     StringBuilder sb = new StringBuilder();
        sb.append("yyyy年MM月dd日 HH:mm:SS")
                .append(" 上下午标志 a")
                .append(" E")
                .append(" 一年中的第D天")
                .append(" 一月中的第F个星期")
                .append(" 一年中的第w个星期")
                .append(" 一月中的第W个星期")
                .append(" Z")
                .append(" z");
        System.out.println(sb.toString());
        SimpleDateFormat sdf = new SimpleDateFormat(sb.toString());
        String dateString = sdf.format(new Date());
        System.out.println(dateString);
*/
       /* SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date : " + today);

        Date date = new Date();
        Instant instant = Instant.now();

        System.out.println(instant.toString());

        String nowdate = format0.format(date);

        System.out.println(nowdate);
*/

  /*      LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
*/
  /*      Instant instant = Instant.now();
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(instant));


        LocalDate dNow = LocalDate.now();
        System.out.println(dNow);
        LocalTime tNow = LocalTime.now();
        System.out.println(tNow);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(df.format(LocalDateTime.now()));


        System.out.println(LocalDate.parse("2016/11/28", df));

        DateTimeFormatter nTZ = DateTimeFormatter.ofPattern("d MMMM, yyyy h:mm a");
        System.out.println(ZonedDateTime.now().format(nTZ));*/

        String str = "zo";
        String pattern = "{0,}";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());


        HashMap<String,String> hashMap =  new HashMap <>();

    }




}
