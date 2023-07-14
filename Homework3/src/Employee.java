public class Employee {
    private String FIO;
    private String post;
    private String telephone;
    private int age;
    private int salary;

    public String getFIO() {
        return FIO;
    }

    public String getPost() {
        return post;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public Employee(String FIO, String post, String telephone, int age, int salary) {
        this.FIO = FIO;
        this.post = post;
        this.telephone = telephone;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee " +
                "FIO='" + FIO + '\'' +
                ", post='" + post + '\'' +
                ", telephone='" + telephone + '\'' +
                ", age=" + age +
                ", salary=" + salary;
    }

    public String displayEmployee () {
        return String.format("Employee fio %s, post %s, phone number %s, age %d, salary %d\n", FIO,post,telephone,age,salary);
    }

    public static void salaryUp (Employee[] personal) {
        for (Employee e: personal) {
            if (e.getAge() > 45) {
                e.setSalary(e.getSalary() + 5000);
                System.out.printf("Поздравляю %s! Вам прибавили зарплату! " +
                        "И теперь она составляет: %d\n", e.getFIO(), e.getSalary());
            } else System.out.printf("Увы %s, Вам еще не положена прибавка к зарплате\n", e.FIO);
        }

    }


    public static float averageAge (Employee[] personal) {
        int temp = 0;
        for (Employee e: personal) {
            temp = temp + e.getAge();
        }
        return temp / personal.length;
    }

    public static float averageSalary (Employee[] personal) {
        int temp = 0;
        for (Employee e: personal) {
            temp = temp + e.getSalary();
        }
        return temp / personal.length;
    }
}
