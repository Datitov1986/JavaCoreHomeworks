import java.util.Comparator;
import java.util.function.Function;

public class CompareName implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getFIO().compareTo(emp2.getFIO());
    }
}
