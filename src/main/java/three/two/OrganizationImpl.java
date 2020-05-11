package three.two;

import java.util.ArrayList;
import java.util.List;

public class OrganizationImpl implements Organization {
    ArrayList<Worker> workers;

    @Override
    public int getId() {
        return 0;
    }

    public OrganizationImpl(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public List<Worker> getWorkers() {
        return this.workers;
    }
}
