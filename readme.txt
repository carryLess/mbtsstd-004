基于前几篇:dao的实现类基本煤气到什么作用
        仅仅是通过SQLSession的相应API定位到mapper映射文件中指定id的sql语句,
        所以此刻,我们将实现类去掉,直接定位到映射文件的sql语句,
        这种对Dao的实现方式称为动态代理

此方式下需要注意:
    1.映射文件mapper标签中的namespace属性为Dao的全限定类名
    2.Dao接口中的方法名称要与mapper映射文件中sql标签的id一致
    3.dao对象的获取通过SqlSession.getMapper(dao.class);
    4.sqlSession.commit();注意添加
    5.动态代理下系统只会调用selectOne()或者selectList()方法,不支持返回Map的方法

