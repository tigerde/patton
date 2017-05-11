package com.patton.er;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/5/10.
 */
public class FindText {
    private static String text = "2017/5/10可以通过调用 2017/5/10matcher 对象的 groupCount 方法来查看表达式有多少个分组。";

    //字符串处理
    public static void strText(){
        //匹配
        print(text.matches(".*matcher.*"));
        //替换
        print(text.replaceAll("\\d{3}", "200"));
        //分割
        print(text.split("\\d{3}"));
        //分割
        print(text.split("\\d{2}", 3));
    }
    //正则匹配
    public static void isPatternText(){
        String pattern = ".*matcher.*";
        //判断是否存在匹配结果
        boolean result = Pattern.matches(pattern,text);
        System.out.println("匹配结果:"+result);
    }

    /**
     * Pattern.matcher(String regex,CharSequence input)是一个静态方法,用于快速匹配字符串,该方法适合用于只匹配一次,且匹配全部字符串.
     */
    public static void patternMatchText(){
        Pattern.matches("\\d+","2223");//返回true
        Pattern.matches("\\d+","2223aa");//返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到
        Pattern.matches("\\d+","22bb23");//返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到
    }

    /**
     * Pattern类只能做一些简单的匹配操作,要想得到更强更便捷的正则匹配操作,那就需要将Pattern与Matcher一起合作
     */
    public static void initMatcher(){
        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("22bb23");
        m.pattern();//返回p 也就是返回该Matcher对象是由哪个Pattern对象的创建的
    }

    /**
     * Matcher.matches()/ Matcher.lookingAt()/ Matcher.find()
     * Matcher类提供三个匹配操作方法,三个方法均返回boolean类型,当匹配到时返回true,没匹配到则返回false
     */
    public static void matcheText(){
        /**
         * matches()对整个字符串进行匹配,只有整个字符串都匹配了才返回true
         */
        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("22bb23");
        m.matches();//返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
        Matcher m2=p.matcher("2223");
        m2.matches();//返回true,因为\d+匹配到了整个字符串
        /**
         * lookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
         */
       p=Pattern.compile("\\d+");
        m=p.matcher("22bb23");
        m.lookingAt();//返回true,因为\d+匹配到了前面的22
        m2=p.matcher("aa2223");
        m2.lookingAt();//返回false,因为\d+不能匹配前面的aa
        /**
         * find()对字符串进行匹配,匹配到的字符串可以在任何位置.
         */
        p=Pattern.compile("\\d+");
        m=p.matcher("22bb23");
        m.find();//返回true
        m2=p.matcher("aa2223");
        m2.find();//返回true
        Matcher m3=p.matcher("aa2223bb");
        m3.find();//返回true
        Matcher m4=p.matcher("aabb");
        m4.find();//返回false
    }

    /**
     * Mathcer.start()/ Matcher.end()/ Matcher.group()
     * 当使用matches(),lookingAt(),find()执行匹配操作后,就可以利用以上三个方法得到更详细的信息.
     * start()返回匹配到的子字符串在字符串中的索引位置.
     * end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
     * group()返回匹配到的子字符串
     */
    public static void groupText(){
        //demo1
        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("aaa2223bb");
        m.find();//匹配2223
        m.start();//返回3
        m.end();//返回7,返回的是2223后的索引号
        m.group();//返回2223
        //demo2
        Matcher m2=p.matcher("2223bb");
        m2.lookingAt();   //匹配2223
        m2.start();   //返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0
        m2.end();   //返回4
        m2.group();   //返回2223
        //demo3
        Matcher m3=p.matcher("2223"); //如果Matcher m3=p.matcher("2223bb"); 那么下面的方法出错，因为不匹配返回false
        m3.matches();   //匹配整个字符串
        m3.start();   //返回0
        m3.end();   //返回3,原因相信大家也清楚了,因为matches()需要匹配所有字符串
        m3.group();   //返回2223

    }

    /**
     * start(),end(),group()均有一个重载方法它们是start(int i),end(int i),group(int i)
     * 专用于分组操作,Mathcer类还有一个groupCount()用于返回有多少组.
     */
    public static void groupsText(){
        Pattern p=Pattern.compile("([a-z]+)(\\d+)");
        Matcher m=p.matcher("aaa2223bb");
        m.find();   //匹配aaa2223
        m.groupCount();   //返回2,因为有2组
        m.start(1);   //返回0 返回第一组匹配到的子字符串在字符串中的索引号
        m.start(2);   //返回3
        m.end(1);   //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
        m.end(2);   //返回7
        m.group(1);   //返回aaa,返回第一组匹配到的子字符串
        m.group(2);   //返回2223,返回第二组匹配到的子字符串
    }

    /**
     * 正则应用实例
     * 例如有一段文本,里面有很多数字,而且这些数字是分开的,我们现在要将文本中所有数字都取出来
     */
    public static void Text(){
        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com");
        while(m.find()) {
            System.out.println(m.group());
            System.out.print("start:"+m.start());
            System.out.println(" end:"+m.end());
        }
    }

    /**
     * 匹配验证-验证Email是否正确
     */
    public static void exampleEmail(){
        // 要验证的字符串
        String str = "service@xsoftlab.net";
        // 邮箱验证规则
        String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        System.out.println(rs);
    }

    /**
     * 在字符串中查询字符或者字符串
     */
    public static void exampleString(){
        // 要验证的字符串
        String str = "baike.xsoftlab.net";
        // 正则表达式规则
        String regEx = "baike.*";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 查找字符串中是否有匹配正则表达式的字符/字符串
        boolean rs = matcher.find();
        System.out.println(rs);
    }

    public static void main(String args[]){

    }
    //打印输出字符串
    public static void print(Object text){
        System.out.println(text);
    }
    //打印输出字符串数组
    public static void print(Object[] text){
        if(text!=null && text.length>0) {
            int length = text.length;
            for (int i = 0; i < length; i++)
                System.out.println(i + ":" + text[i]);
        }
    }
}
