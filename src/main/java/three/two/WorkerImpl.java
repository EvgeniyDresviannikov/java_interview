package three.two;

public class WorkerImpl implements Worker {
    @Override
    public double getSalary() {
        return 0;
    }

    @Override
    public String getPosition() {
        return null;
    }

    private String Name;

    @Override
    public int getPoints() {
        return 0;
    }

    public WorkerImpl(String name) {
        Name = name;
    }

    @Override
    public String getName() {
        return this.Name;
    }
}
