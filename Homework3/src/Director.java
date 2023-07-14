public class Director extends Employee{

    public Director(String FIO, String post, String telephone, int age, int salary) {
        super(FIO, post, telephone, age, salary);
    }

    public static void salaryUp(Employee[] personal, int minAge, int salaryPlus) {
        for (Employee e: personal) {
            if (e.getAge() > minAge && !(e instanceof Director)) {
                e.setSalary(e.getSalary() + salaryPlus);
                System.out.printf("Поздравляю %s! Вам прибавили зарплату! " +
                        "И теперь она составляет: %d\n", e.getFIO(), e.getSalary());
            }else if (e instanceof Director) {
                System.out.printf("%s, не наглей! Ты же руководитель!" +
                        " Твоя зарплата рассаматривается индивидуальо на совете директоров\n", e.getFIO());
            } else System.out.printf("Увы %s, Вам еще не положена прибавка к зарплате\n", e.getFIO());
        }
    }
}
