package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.ComputerComponent;

import java.util.*;
import java.util.stream.Collectors;

import static com.murex.retail.experience.ReadIn.LOGGER;

public class Functionalities {
    private Map<String, List<ComputerComponent>> categoryMap;
    private Map<String, Map<String, List<ComputerComponent>>> categoryBrandMap;


    public Functionalities(List<ComputerComponent> listOfComponents) {
        categoryBrandMap = listOfComponents.stream().collect(Collectors.groupingBy(ComputerComponent::getCategory, Collectors.groupingBy(ComputerComponent::getBrand)));
        categoryMap = listOfComponents.stream().collect(Collectors.groupingBy(ComputerComponent::getCategory));
    }

    public List<ComputerComponent> sortList(List<ComputerComponent> listOfComponents) {
        return listOfComponents.stream().sorted(Comparator
                .comparing(ComputerComponent::getCategory)
                .thenComparing(ComputerComponent::getName)
                .thenComparing(ComputerComponent::getBrand))
                .limit(10).peek(LOGGER::info)
                .collect(Collectors.toList());
    }

    public double averagePrice(List<ComputerComponent> listOfComponentsIn) {
        double averagePrice =
                listOfComponentsIn.stream()
                        .mapToDouble(ComputerComponent::getPrice)
                        .average().orElse(0);
        LOGGER.info("Average price of a component: " + averagePrice);
        return averagePrice;
    }

    public double averagePriceOfCPU() {
        double cpuAveragePrice = categoryMap.get("CPU").stream().mapToDouble(ComputerComponent::getPrice).average().orElse(0);
        LOGGER.info("Average price of a CPU: " + cpuAveragePrice);
        return cpuAveragePrice;
    }

    public ComputerComponent getCheapest(List<ComputerComponent> listOfComponents) {
        ComputerComponent cheapestComponent = (listOfComponents.stream()
                .min(Comparator.comparing(ComputerComponent::getPrice))
                .get()
        );
        LOGGER.info("Cheapest: " + cheapestComponent.toString());
        return cheapestComponent;
    }

    public List<ComputerComponent> getMostExpensiveByCategory() {
        List<ComputerComponent> quantities = new ArrayList<>();
        categoryMap.forEach((key, value) -> quantities.add(value.stream().max(Comparator.comparing(ComputerComponent::getPrice)).get()));
        for (ComputerComponent x : quantities) {
            LOGGER.info("Most Expensive: " + x);
        }
        quantities.forEach(k->LOGGER.info("Most Expensive: " + k ));
        return quantities;
    }

    public Map<String, Integer> componentQuantityByCategory() {
        Map<String, Integer> quantityOfItems = new HashMap<>();
        categoryMap.forEach((key, value) ->
                quantityOfItems.put(key, value.stream().mapToInt(ComputerComponent::getQuantity).sum()));

        quantityOfItems.forEach((k,v)-> LOGGER.info("Category: " + k + " Quantity: " + v));
        return quantityOfItems;
    }

    public Map<String, Integer> componentQuantityByBrandCategory() {
        Map<String, Integer> brandCategory = new HashMap<>();
        categoryBrandMap.forEach((category, brandMap) -> brandMap.forEach((brand, components) -> brandCategory.put(category + " " + brand, components.stream().mapToInt(ComputerComponent::getQuantity).sum())));
        brandCategory.forEach((k,v)->
                LOGGER.info("Category & Brand : " + k + "\t|\t" + "Quantity: " + v));
        return brandCategory;
    }
}