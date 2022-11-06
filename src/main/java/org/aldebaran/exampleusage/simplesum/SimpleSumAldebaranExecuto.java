package org.aldebaran.exampleusage.simplesum;

import org.aldebaran.common.utils.run.Callable;
import org.aldebaran.master.executor.AldebaranExecutor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleSumAldebaranExecuto {

    public static void main(String[] args) throws Exception {

        final String applicationName = "SimpleSum";
        final String password = "Erodn20fwcSAKsrd**&23";
        final List<String> listLocationAgents = Arrays.asList("localhost:8080");
        final String pathJARs = "";

        List<Callable<?>> listJob = new ArrayList<>();

        for (int i = 0; i<10; i++) {

            Callable<?> job = () -> {

                int sum = 0;

                for (int j = 1; j<=10; j++) {
                    sum += j;
                }

                return sum;
            };

            listJob.add(job);
        }

        AldebaranExecutor aldebaranExecutor = new AldebaranExecutor(applicationName, password, listLocationAgents, pathJARs);
        List<Serializable> listResults = aldebaranExecutor.execute(listJob);
        System.out.println(listResults);
    }
}
