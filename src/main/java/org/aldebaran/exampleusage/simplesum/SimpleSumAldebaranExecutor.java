package org.aldebaran.exampleusage.simplesum;

import org.aldebaran.common.utils.run.Callable;
import org.aldebaran.master.executor.AldebaranExecutor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SimpleSumAldebaranExecutor {

    public static void main(String[] args) throws Exception {

        Date tic = new Date();

        List<Serializable> listResults = getSums();
        System.out.println("###################################");
        System.out.println("results = " + listResults);
        System.out.println("###################################");

        Date toc = new Date();
        long millis = toc.getTime() - tic.getTime();

        System.out.println("###################################");
        System.out.println("millis = " + millis);
        System.out.println("###################################");

        System.exit(0);
    }

    private static List<Serializable> getSums() throws Exception {

        final String applicationName = "SimpleSum";
        final String password = "Erodn20fwcSAKsrd**&23";
        final List<String> listLocationAgents = Arrays.asList("localhost:8080");
        final String pathJARs = "./target";

        List<Callable<?>> listJob = new ArrayList<>();

        for (int i = 0; i<10; i++) {

            final int iFinal = i;

            Callable<?> job = () -> {

                int sum = 0;

                for (int j = 1; j<=10; j++) {
                    sum += j;
                }

                return sum + iFinal;
            };

            listJob.add(job);
        }

        AldebaranExecutor aldebaranExecutor = new AldebaranExecutor(applicationName, password, listLocationAgents, pathJARs);
        List<Serializable> listResults = aldebaranExecutor.execute(listJob);
        return listResults;
    }
}
