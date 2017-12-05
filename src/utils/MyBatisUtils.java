package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by carryLess on 2017/11/30.
 */
public class MyBatisUtils {

    /*
    * SqlSession 由SqlSessionFactory对象创建,
    * 而SqlSessionFactory对象为重量级对象
    * 并且是线程安全的,所以我们将其设为单例
    * */
    private static SqlSessionFactory factory;

    /**
     * 私有化构造方法,避免该工具类在外部被实例化
     */
    private MyBatisUtils(){}

    /**
     * 获取 SqlSession
     * @return
     */
    public static SqlSession getSqlSession(){
        try {
            if(factory == null){
                //读取配置文件
                InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
                //创建工厂类
                factory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        /*
        * factory.openSession(true);     创建一个有自动提交功能的SqlSession
        * factory.openSession(false);    创建一个没有自动提交功能的SqlSession,需要手动提交
        * factory.openSession();         同factory.openSession(false);
        */
        return factory.openSession();
    }
}
