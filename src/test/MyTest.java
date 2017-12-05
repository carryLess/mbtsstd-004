package test;

import dao.IStudentDao;
import model.SStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.MyBatisUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by carryLess on 2017/11/29.
 */
public class MyTest {
    private SqlSession sqlSession;
    private IStudentDao dao;

    @Before
    public void initDao(){
        sqlSession = MyBatisUtils.getSqlSession();
        dao = sqlSession.getMapper(IStudentDao.class);
    }

    @After
    public void over(){
        if(sqlSession != null){
            sqlSession.close();
        }
    }

    @Test
    public void testInsertList(){
        List<SStudent> sStudentList = new ArrayList<SStudent>();
        for(int i = 20;i<22;i++){
            SStudent sStudent = new SStudent();
            sStudent.setSname("ls-"+i);
            sStudent.setSage(25+i);
            sStudent.setScore(90);
            sStudentList.add(sStudent);
        }
        dao.insertStudentByList(sStudentList);
        sqlSession.commit();
    }

    @Test
    public void testSelectById(){
        SStudent sStudent = dao.selectById2(18);
        System.out.println(sStudent);
    }

    @Test
    public void testSelectByMap(){
        Map<String,Object> conMap = new HashMap<String,Object>();
        conMap.put("nameCon","s");
        conMap.put("ageCon",44);
        List<SStudent> sStudentList = dao.selectByMap(conMap);
        System.out.println(sStudentList);
    }

    @Test
    public void testSelectByCons(){
        List<SStudent> sStudentList = dao.selectByCons("s", 44);
        System.out.println(sStudentList);
    }

}
