package com.murex.retail.experience;

import java.util.*;
import java.util.stream.Collectors;

import static com.murex.retail.experience.Main.logger;


public class Functionalities {
    private Map<String, List<ComputerComponent>> categoryMap = new HashMap<>();
    private Map<String, Map<String, List<ComputerComponent>>> categoryBrandMap = new HashMap<>();


    public Functionalities(List<ComputerComponent> listOfComponents) {
        categoryBrandMap = listOfComponents.stream().collect(Collectors.groupingBy(ComputerComponent::getCategory, Collectors.groupingBy(ComputerComponent::getBrand)));
        categoryMap = listOfComponents.stream().collect(Collectors.groupingBy(ComputerComponent::getCategory));
    }

    public List<ComputerComponent> sortList(List<ComputerComponent> listOfComponents) {
        return listOfComponents.stream().sorted(Comparator.comparing(ComputerComponent::getCategory)
                .thenComparing(ComputerComponent::getName)
                .thenComparing(ComputerComponent::getBrand)).limit(10).peek(b -> logger.info(b.toString()))
                .collect(Collectors.toList());
    }

    public double averagePrice(List<ComputerComponent> listOfComponentsIn) {
        double averagePrice =
                listOfComponentsIn.stream()
                        .mapToDouble(ComputerComponent::getPrice)
                        .average().orElse(0);
        logger.info("Average price of a component: " + averagePrice);
        return averagePrice;
    }

    public double averagePriceOfCPU(List<ComputerComponent> listOfComponents) {
        double CPUAveragePrice = listOfComponents.stream()
                .filter(x -> "CPU".equals(x.getCategory())).mapToDouble(ComputerComponent::getPrice)
                .average()
                .orElse(0);
        logger.info("Average price of a CPU: " + CPUAveragePrice);
        return CPUAveragePrice;
    }

    public ComputerComponent printCheapest(List<ComputerComponent> listOfComponents) {
        ComputerComponent cheapestComponent = (listOfComponents.stream()
                .min(Comparator.comparing(ComputerComponent::getPrice))
                .get()
        );
        logger.info("Cheapest: " + cheapestComponent.toString());
        return cheapestComponent;
    }

    public List<ComputerComponent> mostExpensive() {
        List<ComputerComponent> quantities = new ArrayList<>();
        categoryMap.forEach((key, value) -> quantities.add(value.stream().max(Comparator.comparing(ComputerComponent::getPrice)).get()));
        for (ComputerComponent x : quantities) {
            logger.info("Most Expensive: " + x);
        }
        return quantities;
    }

    public Map<String, Integer> componentQuantity() {
        Map<String, Integer> quantityOfItems = new HashMap<>();
        categoryMap.forEach((key, value) ->
                quantityOfItems.put(key, value.stream().mapToInt(ComputerComponent::getQuantity).sum()));
        for (Map.Entry<String, Integer> entry : quantityOfItems.entrySet()) {
            logger.info("Category: " + entry.getKey() + " Quantity: " + entry.getValue());
        }
        return quantityOfItems;
    }

    public Map<String, Integer> componentBrandCategory() {
        Map<String, Integer> brandCategory = new HashMap<>();
        categoryBrandMap.forEach((k, v) -> v.forEach((key, value) -> brandCategory.put(k + " " + key, value.stream().mapToInt(ComputerComponent::getQuantity).sum())));
        for (Map.Entry<String, Integer> entry : brandCategory.entrySet()) {
            logger.info("Category & Brand : " + entry.getKey() + "\t|\t" + "Quantity: " + entry.getValue());
        }
        return brandCategory;
    }
}