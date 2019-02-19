package com.murex.retail.experience;

import com.murex.retail.experience.computercomponent.ComputerComponent;

import java.util.*;
import java.util.stream.Collectors;

import static com.murex.retail.experience.FileReader.LOGGER;

public class Report {
    private final List<ComputerComponent> listOfComponents;
    private Map<String, List<ComputerComponent>> categoryMap;
    private Map<String, Map<String, List<ComputerComponent>>> categoryBrandMap;


    public Report(List<ComputerComponent> listOfComponents) {
        this.listOfComponents = listOfComponents;
        categoryBrandMap = listOfComponents.stream().collect(Collectors.groupingBy(ComputerComponent::getCategory, Collectors.groupingBy(ComputerComponent::getBrand)));
        categoryMap = listOfComponents.stream().collect(Collectors.groupingBy(ComputerComponent::getCategory));
    }

    public List<ComputerComponent> getSortedList() {
        return listOfComponents.stream().sorted(Comparator
                .comparing(ComputerComponent::getCategory)
                .thenComparing(ComputerComponent::getName)
                .thenComparing(ComputerComponent::getBrand))
                .limit(10).peek(LOGGER::info)
                .collect(Collectors.toList());
    }

    public double getAveragePrice() {
        double averagePrice =
                listOfComponents.stream()
                        .mapToDouble(ComputerComponent::getPrice)
                        .average().orElse(0);
        LOGGER.info("Average price of a component: " + averagePrice);
        return averagePrice;
    }

    public double getAveragePriceOfCPU() {
        double cpuAveragePrice = categoryMap.get("CPU").stream().mapToDouble(ComputerComponent::getPrice).average().orElse(0);
        LOGGER.info("Average price of a CPU: " + cpuAveragePrice);
        return cpuAveragePrice;
    }

    public ComputerComponent getCheapest() {
        ComputerComponent cheapestComponent = listOfComponents.stream()
                .min(Comparator.comparing(ComputerComponent::getPrice))
                .orElse(null);
        LOGGER.info("Cheapest: " + cheapestComponent.toString());
        return cheapestComponent;
    }

    public List<ComputerComponent> getMostExpensiveByCategory() {
        List<ComputerComponent> quantities = new ArrayList<>();
        categoryMap.forEach((key, value) -> quantities.add(value.stream().max(Comparator.comparing(ComputerComponent::getPrice)).orElse(null)));
        quantities.forEach(k -> LOGGER.info("Most Expensive: " + k));
        return quantities;
    }

    public Map<String, Integer> componentQuantityByCategory() {
        Map<String, Integer> quantityOfItems = new HashMap<>();
        categoryMap.forEach((key, value) ->
                quantityOfItems.put(key, value.stream().mapToInt(ComputerComponent::getQuantity).sum()));

        quantityOfItems.forEach((k, v) -> LOGGER.info("Category: " + k + " Quantity: " + v));
        return quantityOfItems;
    }

    public Map<String, Integer> componentQuantityByBrandCategory() {
        Map<String, Integer> brandCategory = new HashMap<>();
        categoryBrandMap.forEach((category, brandMap) -> brandMap.forEach((brand, components) -> brandCategory.put(category + " " + brand, components.stream().mapToInt(ComputerComponent::getQuantity).sum())));
        brandCategory.forEach((k, v) ->
                LOGGER.info("Category & Brand : " + k + "\t|\t" + "Quantity: " + v));
        return brandCategory;
    }
}