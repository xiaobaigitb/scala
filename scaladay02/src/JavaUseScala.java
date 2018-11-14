import scala.Function2;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.lu
 * @Title: JavaUseScala
 * @ProjectName scalademo
 * @Description: TODO
 * @date 2018/11/14:10:20
 */
public class JavaUseScala {
    public static void main(String[] args) {
        Dog.sing();
        new Dog().play();
        int sum = Dog.add(1, 2);
        System.out.println(sum);
        Map<String, Object> map = new Dog().wordcount();
        for (String key :
                map.keySet()) {
            System.out.println(key+"----"+map.get(key));
        }
        new Dog().repaisolr();
    }
}
