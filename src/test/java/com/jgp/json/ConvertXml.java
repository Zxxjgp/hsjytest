package com.jgp.json;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

public class ConvertXml {
    public  static  void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        File file = new File("src/main/resources/xml/book.xml");
        Document filecocument = reader.read(file);
        Element root = filecocument.getRootElement();//获取更元素
       /* List<Element> clidElemnt = root.elements();
        for (Element child : clidElemnt) {//循环输出全部book的相关信息
            List<Element> books = child.elements();

            for (Element book : books) {
                String name = book.getName();//获取当前元素名
                String text = book.attributeValue("name");//获取当前属性值
                String value = book.elementText(name);
                //String value = book.getText();
                System.out.println(name + ":" + text+"+++++++++++++"+value);
            }
        }*/
        /*System.out.println("当前节点的名称：" + root.getName());
        Element data = root.element("data");//获取子节点
        String  ret_code=  data.attributeValue("ret_code");//获取子节点属性的值

        String  error_message=  data.attributeValue("error_message");//获取子节点属性的值

        System.out.println("ret_code:"+ret_code+"+++++++++++++++"+"error_message:"+error_message);
        Element datas = root.element("sign");//获取子节点
        System.out.println(datas.getName()+"====="+datas.getText());
        String  text=  data.elementText("refund_no");//获取节点的值
        System.out.println(data.getText()+":"+text+">>>");*/
        String data = root.attributeValue("refund_no");//获取子节点

        Element gg = root.element("refund_no");
        System.out.println(gg.getName()+gg.attributeValue("refund_no")+gg.getNamespacePrefix()+gg.getText());
       /*  File xmlfile = new File("D:/book.xml");
       //File file = new File("src/main/resources/xml/book.xml");
        String xml = "<books><book><author>Thomas</author><title>Java从入门到放弃</title><publisher>UCCU</publisher>" +
                "</book><book><author>小白</author><title>MySQL从删库到跑路</title><publisher>GoDie</publisher></book>" +
                "<book><author>PHPer</author><title>BestPHP</title><publisher>PHPchurch</publisher></book></books>";
        Document fileDocument = reader.read(file);//从xml文件获取数据
        Document document = reader.read(new ByteArrayInputStream(xml.getBytes("utf-8")));//读取xml字符串，注意这里要转成输入流
        Element root = document.getRootElement();//获取根元素
        List<Element> childElements = root.elements();//获取当前元素下的全部子元素

        for (Element child : childElements) {//循环输出全部book的相关信息
            List<Element> books = child.elements();
            for (Element book : books) {
                String name = book.getName();//获取当前元素名
                String text = book.getText();//获取当前元素值
                System.out.println(name + ":" + text);
            }
        }
        //获取第二条书籍的信息
        Element book2 = childElements.get(1);
        Element author = book2.element("author");//根据元素名获取子元素
        Element title = book2.element("title");
        Element publisher = book2.element("publisher");
        System.out.println("作者：" + author.getText());//获取元素值
        System.out.println("书名：" + title.getText());
        System.out.println("出版社："+publisher.getText());*/

    }
}
