package three.two;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOrganization {
    public static void main(String[] strings) {
        StreamOrganization streamOrganization = new StreamOrganization();
        Worker w1 = new WorkerImpl("Vika");
        Worker w2 = new WorkerImpl("Daria");
        Worker w3 = new WorkerImpl("Vika");
        Worker w4 = new WorkerImpl("Jenia");
        Worker w5 = new WorkerImpl("AAA");

        Organization org1 = new OrganizationImpl(new ArrayList<Worker>(Arrays.asList(w1, w2, w3)));
        Organization org2 = new OrganizationImpl(new ArrayList<Worker>(Arrays.asList(w4, w5)));

        List orgs = new ArrayList<Organization>(Arrays.asList(org1, org2));
        //streamOrganization.uniqueNameStream(orgs.stream());

        OrganizationImpl1 org11 = new OrganizationImpl1(1);
        OrganizationImpl1 org12 = new OrganizationImpl1(2);

        ArrayList orgs1 = new ArrayList<OrganizationImpl1>(Arrays.asList(org11, org12));
        //streamOrganization.integerOrganizationMap(orgs1);


        WorkerImpl1 w21 = new WorkerImpl1(3, "Ivan");
        WorkerImpl1 w22 = new WorkerImpl1(5, "Sergey");
        WorkerImpl1 w23 = new WorkerImpl1(1, "Misha");
        WorkerImpl1 w24 = new WorkerImpl1(6, "Nastya");
        WorkerImpl1 w25 = new WorkerImpl1(2, "Natalia");
        ArrayList workers3 = new ArrayList<WorkerImpl1>(Arrays.asList(w21, w22, w23, w24, w25));
        //streamOrganization.getTheBestWorkers(workers3);

        WorkerImpl3 w31 = new WorkerImpl3("Manager");
        WorkerImpl3 w32 = new WorkerImpl3("Programmer");
        WorkerImpl3 w33 = new WorkerImpl3("Manager");
        WorkerImpl3 w34 = new WorkerImpl3("Programmer");
        WorkerImpl3 w35 = new WorkerImpl3("CEO");
        ArrayList workers4 = new ArrayList<WorkerImpl3>(Arrays.asList(w31, w32, w33, w34, w35));
        //streamOrganization.getGroupingByPosition(workers4);

        WorkerImpl4 w41 = new WorkerImpl4("Manager", 100);
        WorkerImpl4 w42 = new WorkerImpl4("Programmer", 200);
        WorkerImpl4 w43 = new WorkerImpl4("Manager", 150);
        WorkerImpl4 w44 = new WorkerImpl4("Programmer", 300);
        WorkerImpl4 w45 = new WorkerImpl4("CEO", 400);
        ArrayList worker44 = new ArrayList<WorkerImpl4>(Arrays.asList(w41, w42, w43, w44, w45));
        streamOrganization.getSalaryAverage(worker44);

    }

    Stream<String> uniqueNameStream(Stream<Organization> organizationStream) {
        return organizationStream
                .filter(x -> x.getWorkers().size() > 2)
                .flatMap(x -> x.getWorkers().stream())
                .map(x -> x.getName())
                .distinct();


    }

    Map<Integer, Organization> integerOrganizationMap(ArrayList<OrganizationImpl1> organizations) {
        Map<Integer, Organization> actual = organizations.stream()
                .collect(Collectors.toMap(x -> x.getId(), x -> x)
                );
        return actual;
    }

    String getTheBestWorkers(ArrayList<WorkerImpl1> workers) {
        String actual = workers.stream()
                .sorted(Comparator.comparing(Worker::getPoints).reversed()).limit(3).map(x -> x.getName())
                .collect(Collectors.joining(", "));
        System.out.println(actual);
        return actual;
    }

    Map<String, Long>  getGroupingByPosition(ArrayList<WorkerImpl3> workers) {
            Map<String, Long> actual = workers.stream()
                    .collect(
                            Collectors.groupingBy(x -> x.getPosition(), Collectors.counting())
                    );

        System.out.println(actual);
        return actual;
    }

    Map<String, Double>  getSalaryAverage(ArrayList<WorkerImpl4> workers) {
        Map<String, Double> actual = workers.stream()
                .collect(
                        Collectors.groupingBy(x -> x.getPosition(), Collectors.averagingDouble(Worker::getSalary))
                );

        System.out.println(actual);
        return actual;
    }
}






