package model;

/**
 * Created by carryLess on 2017/11/29.
 */
public class SStudent {
    private Integer id;
    private String name;
    private Integer age;
    private double score;

    public SStudent() {
    }

    public SStudent(String sname, Integer sage, double score) {
        this.name = sname;
        this.age = sage;
        this.score = score;
    }

    @Override
    public String toString() {
        return "SStudent{" +
                "id=" + id +
                ", sname='" + name + '\'' +
                ", sage=" + age +
                ", score=" + score +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return name;
    }

    public void setSname(String sname) {
        this.name = sname;
    }

    public Integer getSage() {
        return age;
    }

    public void setSage(Integer sage) {
        this.age = sage;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
