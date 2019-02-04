package com.murex.retail.experience;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;



public class Functionalities {
    public static void sortList(List<ComputerComponent> list){
        list= list.stream().sorted(Comparator.comparing(ComputerComponent::getCategory)
                .thenComparing(ComputerComponent::getName)
                .thenComparing(ComputerComponent::getBrand)).limit(10).collect(Collectors.toList());
        for(ComputerComponent x: list)
        {
            System.out.println(x.toString());
        }
    }

    public static void averagePrice(List<ComputerComponent> list){
        System.out.println("The average price of all components is:\t" + (float)list.stream()
                .mapToDouble(ComputerComponent::getPrice)
                .average().orElse(-1));
    }
    public static void averagePriceOfCPU(List<ComputerComponent> list){
        System.out.println("The average price of the CPU's is:\t" + (float)list.stream()
                .filter(x-> "CPU".equals(x.getCategory())).mapToDouble(ComputerComponent::getPrice)
                .average()
                .orElse(-1));
    }
    public static void printCheapest(List<ComputerComponent> list){
        System.out.println(
                list.stream()
                .min(Comparator.comparing(ComputerComponent::getPrice))
                        .get()

        );
    }
    public static void mostExpensiveCategory(List<ComputerComponent> list) {
        ComputerComponent expensiveCPU = list.stream()
                .filter(x -> x.getCategory().equals("CPU"))
                .max(Comparator.comparing(ComputerComponent::getPrice))
                .get();
        System.out.println(expensiveCPU.toString());

        ComputerComponent expensiveGPU = list.stream()
                .filter(x -> x.getCategory().equals("GPU"))
                .max(Comparator.comparing(ComputerComponent::getPrice))
                .get();
        System.out.println(expensiveGPU.toString());

        ComputerComponent expensiveKeyboard = list.stream()
                .filter(x -> x.getCategory().equals("Keyboard"))
                .max(Comparator.comparing(ComputerComponent::getPrice))
                .get();
        System.out.println(expensiveKeyboard.toString());

        ComputerComponent expensiveMouse = list.stream()
                .filter(x -> x.getCategory().equals("Mouse"))
                .max(Comparator.comparing(ComputerComponent::getPrice))
                .get();
        System.out.println(expensiveMouse.toString());

        ComputerComponent expensiveMonitor = list.stream()
                .filter(x -> x.getCategory().equals("Monitor"))
                .max(Comparator.comparing(ComputerComponent::getPrice))
                .get();
        System.out.println(expensiveMonitor.toString());

        ComputerComponent expensiveMemory = list.stream()
                .filter(x -> x.getCategory().equals("Memory"))
                .max(Comparator.comparing(ComputerComponent::getPrice))
                .get();
        System.out.println(expensiveMemory.toString());

        ComputerComponent expensiveStorage = list.stream()
                .filter(x-> x.getCategory().equals("Storage"))
                .max(Comparator.comparing(ComputerComponent::getPrice))
                .get();
        System.out.println(expensiveStorage.toString());

    }
}
