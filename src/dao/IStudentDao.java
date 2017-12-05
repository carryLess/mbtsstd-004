package dao;

import model.SStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by carryLess on 2017/11/29.
 */
public interface IStudentDao {

    /**
     * 插入集合
     * @param studentList
     */
    void insertStudentByList(List<SStudent> studentList);

    /**
     * 根据id查询1
     * @param id
     * @return
     */
    SStudent selectById1(int id);

    /**
     * 根据id查询2
     * @param id
     * @return
     */
    SStudent selectById2(int id);

    /**
     * 根据map查询  map中key为:nameCon和ageCon
     * @param conMap
     * @return
     */
    List<SStudent> selectByMap(Map<String,Object> conMap);

    /**
     * 多参数查询,其中@Param中的value是字段名称
     * @param name
     * @param age
     * @return
     */
    List<SStudent> selectByCons(@Param("name") String name, @Param("age") int age);
}
