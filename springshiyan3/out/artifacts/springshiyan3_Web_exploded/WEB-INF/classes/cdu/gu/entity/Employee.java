package cdu.gu.entity;

public class Employee {
    private Integer id;
    private Integer number;
    private String name;
    private String gender;
    private Integer age;
    private Department dep;

    public Employee() {
    }

    public Employee(Integer id, Integer number, String name, String gender, Integer age, Department dep) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.dep = dep;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", dep=" + dep +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }
}
