package three.two;

import java.util.List;

public class OrganizationImpl1 implements Organization {
    int id;

    public OrganizationImpl1(int id) {
        this.id = id;
    }

    @Override
    public List<Worker> getWorkers() {
        return null;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
