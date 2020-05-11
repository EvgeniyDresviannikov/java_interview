package three.two;

public class WorkerImpl4 implements Worker {
    String position;
    double salary;

    public WorkerImpl4(String position, double salary) {
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public String getPosition() {
        return this.position;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
