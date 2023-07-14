import java.util.Comparator;

public class CompareAge implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.getAge() > emp2.getAge()) {
            return 1;
        } else if (emp1.getAge()==emp2.getAge()){
            return 0;
        } else return -1;
    }
}