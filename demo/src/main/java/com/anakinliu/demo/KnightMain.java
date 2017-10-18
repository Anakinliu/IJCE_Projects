package com.anakinliu.demo;

import com.anakinliu.demo.config.KnightConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Anakinliu on 17.10.13.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
/*
ClassPathXmlApplicationContext实现了Spring上下文
它会加载应用程序类路径(classPath)下的XML文件(XML可以一个或多个)

因为我用的是Java配置文件非XML, 所以使用的是AnnotationConfigApplicationContext
 */
public class KnightMain {

    /*
    这个main方法创建了Spring应用上下文(基于Java版配置文件)
    然后将此应用上下文作为工厂来得到ID为knight的bean,
    得到Knight对象后, 就可以调用对象的方法了.
    这个类完全不知道Knight接受的是哪种Quest,
    更不知道Knight其实是BraveKnight!
    **只有配置文件知道这些具体实现细节!**
     */
    public static void main(String[] args)
        throws Exception
    {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = applicationContext.getBean(Knight.class);
        knight.embarkOnQuest();
        applicationContext.close();

    }
}
