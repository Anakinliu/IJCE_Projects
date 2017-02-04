package polymorphismANDinterface;

import java.util.Arrays;
import static print.Print.*;

/**
 * Created by Anakinliu on 2017/1/17.
 */
class Processor {
    public String name() {
        return getClass().getSimpleName();
        //返回源代码中给出的底层类的简称。
    }
    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String)input).toUpperCase();
        //使用默认语言环境的规则将此 String 中
        // 的所有字符都转换为大写。
    }
}

class Downcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Splitter extends Processor {
    @Override
    Object process(Object input) {
        return Arrays.toString(((String)input).split("[D]"));
        //根据给定正则表达式的匹配拆分此字符串。

        //Arrays.toString(Object[] a)
    }
}

public class Apply {
    public static void process (Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
    public static String s = "Disagreement with beliefs is by definition incorrect";
    public static void main(String[] args) {
        process(new Upcase(),s);
        process(new Downcase(),s);
        process(new Splitter(),s);
    }
}
