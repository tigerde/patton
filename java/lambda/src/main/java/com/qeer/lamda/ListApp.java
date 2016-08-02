package com.qeer.lamda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.qeer.entity.NewPerson;
import com.qeer.utils.LambdaUtils;

public class ListApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        /**
         * ()->5
         * x->2*x
         * (x,y)->x*y
         * (int x,int y)->x+y
         * (String str)->System.out.println(str)
         */
        // testList();
        // testThread();
        // testSortList();
        testEditList();
        /*
         * List<Person> list = new ArrayList<Person>(); list.add(new Person(1,
         * 1, "fabc")); list.add(new Person(2, 1, "ddef")); list.add(new
         * Person(3, 1, "sghi")); list.add(new Person(4, 1, "ajkl")); Person[] p
         * = list.toArray(new Person[list.size()]); Arrays.sort(p, new
         * Comparator<Person>() {
         * 
         * @Override public int compare(Person o1, Person o2) { // TODO
         * Auto-generated method stub System.out.println(123); return
         * o2.getAge() - o1.getAge(); } }); list.clear();
         * Collections.addAll(list, p); list.forEach((x) ->
         * System.out.println(x.getAge()));
         */ }

    /**
     * 
     * @Title: testList 
     * @Description: lambda遍历列表逐行处理demo
     */
    public static void testList() {
        // 初始化List列表
        List<String> listString = LambdaUtils.getStringList();
        // 遍历列表并输出两种方式->和::
        listString.forEach((abc) -> {
            System.out.println(abc);
            System.out.println(abc);
        });
        listString.forEach(System.out::println);
    }

    /**
     * 
     * @Title: testThread 
     * @Description: lambda初始化线程
     */
    public static void testThread() {

        // Thread Test
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("thread1");
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> System.out.println("thread2"));
        thread2.start();
        Thread thread3 = new Thread(() -> {
            System.out.println("thread3");
            System.out.println("thread3");
        });
        thread3.start();
    }

    /**
     * 
     * @Title: testSortList 
     * @Description: List列表对象排序
     */
    public static void testSortList() {
        List<String> list = LambdaUtils.getStringList();
        String[] str = LambdaUtils.getStrings();
        // 使用lambda表达式初始化参数
        list.sort((str1, str2) -> str1.length() - str2.length());
        // 使用lambda表达式实现接口
        Comparator<String> cmp = (str1, str2) -> str1.length() - str2.length();
        list.sort(cmp);
        Arrays.sort(str, cmp);
        List<String> liststr = Arrays.asList(str);
        liststr.forEach(System.out::println);
        list.forEach(System.out::println);
    }

    public static void testEditList() {
        List<NewPerson> list = LambdaUtils.getListJavaPerson();
        list.forEach((e) -> System.out.println(e.getAge()));
        // 循环对象逻辑操作大于30的做处理
        list.forEach((e) -> {
            if (e.getAge() > 30) {
                System.out.println(e.getAge() + ":old man");
                // e.setAge(3);
            }

        });
        // 循环对象逻辑操作大于30的做处理
        list.stream().filter((a) -> a.getAge() > 30).forEach((a) -> System.out.println(a.getAge() + ":old man"));
        list.stream().skip(1).limit(3).filter((a) -> a.getAge() > 30).forEach((a) -> System.out.println(a.getAge() + ":old man"));
        // 排序
        list.stream().limit(3).forEach((e) -> System.out.println(e.getSalary()));
        // list的max或者min指的是排序的首位或者最后一位，本身不具备大小功能依赖参数lambda进行排序
        System.out.println("最后：" + list.stream().limit(3).min((o1, o2) -> o1.getSalary() - o2.getSalary()).get().getSalary());
        System.out.println("最后：" + list.stream().limit(3).min((o2, o1) -> o1.getSalary() - o2.getSalary()).get().getSalary());

        // 组合提取
        Set<Integer> set = list.stream().map((e) -> e.getAge()).collect(Collectors.toSet());
        System.out.println("用分号拼接数据：" + list.stream().map((e) -> e.getAge() + "").collect(Collectors.joining(";")));
        System.out.println("总和计算：" + list.stream().mapToInt((e) -> e.getAge()).sum());
        System.out.println("处理后长度计算：" + list.stream().mapToInt((e) -> e.getAge()).count());
        System.out.println("并行总和计算：" + list.parallelStream().mapToInt((e) -> e.getAge()).sum());
        
        //数据概要统计
        IntSummaryStatistics is=list.stream().mapToInt((e)->e.getAge()).summaryStatistics();
        System.out.println(is.getAverage());
        System.out.println(is.getCount());
        System.out.println(is.getMax());
        System.out.println(is.getMin());
        System.out.println(is.getSum());
    }
}
