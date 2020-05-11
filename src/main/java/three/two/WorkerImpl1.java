package three.two;

public class WorkerImpl1 implements Worker{
    @Override
    public double getSalary() {
        return 0;
    }

    @Override
    public String getPosition() {
        return null;
    }

    int points;
    String name;

    public WorkerImpl1(int points, String name) {
        this.points = points;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPoints() {
        return this.points;
    }
}
