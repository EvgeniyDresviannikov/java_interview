package three.two;

public class WorkerImpl3 implements Worker {
    String position;

    @Override
    public double getSalary() {
        return 0;
    }

    public WorkerImpl3(String position) {
        this.position = position;
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
}
