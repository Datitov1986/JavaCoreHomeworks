
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        Employee sergey = new Employee("Ivanov Sergey Petrovich", "Manager", "89163451223", 23, 56000);
        Employee slava = new Employee("Petrov Viatcheslav Petrovich", "Cleaner", "89163454523", 46, 66000);
        Employee ignat = new Employee("Zverev Ignat Vasilievich", "Manager", "89169851223", 29, 57000);
        Employee iliya = new Employee("Fedorov Iliya Savelievich", "Slesar'", "89163451290", 51, 126000);
        Employee evgeniy = new Employee("Ivanov Evgeniy Petrovich", "Driver", "89163451221", 23, 59000);
        Director ivan = new Director("Sidorov Ivan Terentievich", "CEO", "84957772233", 61, 250000);
        Employee[] personal = {sergey, slava, ignat, iliya, evgeniy, ivan};
        for (Employee e: personal) {
            System.out.println(e.displayEmployee());
        }
        Employee.salaryUp(personal);
        Director.salaryUp(personal, 37, 10000);
        System.out.println(Employee.averageAge(personal));
        System.out.println(Employee.averageSalary(personal));
        CompareAge comp = new CompareAge();
        System.out.println(comp.compare(evgeniy, sergey));
        CompareName compName = new CompareName();
        System.out.println(compName.compare(sergey, slava));

    }
}
