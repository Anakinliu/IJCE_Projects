import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Anakinliu on 2017/1/22.
 */

class ICan {
    public void show() {

    }
}

interface Can {
    void show();
}

//为了保留XML相应的结构，可以创建相应的类把Node保存

public class XMLDemo extends ICan implements Can {
    public static void main(String[] args) {
        //DocumentBuilderFactory:定义工厂 API，使应用程序能够从 XML 文档获取生成 DOM 对象树的解析器。
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            //定义 API， 使其从 XML 文档获取 DOM 文档实例。使用此类，应用程序员可以从 XML 获取一个 Document。
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document d =  db.parse(new File("xmlTest.xml"));

            NodeList nl =  d.getElementsByTagName("email");


            System.out.println("================================");
            //
            int emailListLength = nl.getLength();

            Node email;

            //遍历所有名为email的节点
            System.out.println(nl.getLength());
            for (int i=0; i<emailListLength; i++) {
                System.out.println("===========" + "第" + (i+1) + "个" + "==========");
                //得到一个节点
                email = nl.item(i);//下标从0开始


                //-----得到此email节点的属性（Attr）值：只有一个属性时------
                Element element = (Element) email;

                //直接通过此属性名称获得属性节点的值
                String value = element.getAttribute("number");

                System.out.println("number属性：" + value);

                //-----得到此email节点的属性（Attr）值：只有一个属性时-------

                //-----遍历所有节点，包括Text类型的节点和Element类型节点-------
                NodeList emailChildNodes = email.getChildNodes();


                for (int j=0; j<emailChildNodes.getLength(); j++) {
                    //得到email的每个子节点
                    Node emailChildNode = emailChildNodes.item(j);

                    System.out.println("第" + (j+1) + "个" + "节点名称：" + emailChildNode.getNodeName());
                    System.out.println("第" + (j+1) + "个节点类型是：" + emailChildNode.getNodeType());
                    if (emailChildNode.getNodeType() == 1) {
                        //通过getFirstChild()得到节点内容（也是Node类型）
                        System.out.println("第" + (j + 1) + "个" + "节点的内容是" + (emailChildNode.getFirstChild()).getNodeValue());
                        System.out.println("第" + (j + 1) + "个" + "节点的内容的类型是" + (emailChildNode.getFirstChild()).getNodeType());

                        //注意getTextContent()与getNodeValue()区别
                        System.out.println("第" + (j + 1) + "个" + "节点后的所有内容是" + (emailChildNode.getFirstChild()).getTextContent());
                    }
                    else {
                        System.out.println("第" + (j+1) + "个" + "节点的内容是空！！！！" + emailChildNode.getFirstChild());
                    }
                    System.out.println();
                }



               /*email节点
                * 有多个属性（Attr）时
                * 获取此节点的所有属性的集合=====Attr
                 */

                NamedNodeMap nnm = email.getAttributes();

                //可以用for循环遍历获取这个节点的每个属性(属性也可以看作节点)的名称，值
                int nnmLength = nnm.getLength();
                System.out.println("========email节点自身的属性=============");
                for (int j=0; j<nnmLength; j++) {

                    //依次得到每个属性
                    Node emailattr = nnm.item(j);

                    System.out.println("第" + (j+1) + "个节点名是：" + emailattr.getNodeName());
                    System.out.println("第" + (j+1) + "个节点值是：" + emailattr.getNodeValue());
                    System.out.println("第" + (j+1) + "个节点类型是：" + emailattr.getNodeType());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
