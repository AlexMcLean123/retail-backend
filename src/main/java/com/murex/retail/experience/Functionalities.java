package com.murex.retail.experience;
import java.util.*;
import java.util.stream.Collectors;

import static com.murex.retail.experience.Main.logger;


public class Functionalities {
    private Map<String, List<ComputerComponent>> categoryMap = new HashMap<>();
    private Map<String, Map<String, List<ComputerComponent>>> categoryBrandMap = new HashMap<>();

    public Functionalities(List<ComputerComponent> list){

    }

    public List<ComputerComponent> sortList(List<ComputerComponent> list){
        list = list.stream().sorted(Comparator.comparing(ComputerComponent::getCategory)
                .thenComparing(ComputerComponent::getName)
                .thenComparing(ComputerComponent::getBrand)).limit(10).collect(Collectors.toList());
        for (ComputerComponent x : list)
        {
            logger.info(x.toString());
        }
        return list;
    }

    public double averagePrice(List<ComputerComponent> listIn){
        double averagePrice =
        listIn.stream()
                .mapToDouble(ComputerComponent::getPrice)
                .average().orElse(-1);
        logger.info("Average price of a component: " + averagePrice);
        return averagePrice;
    }

    public float averagePriceOfCPU(List<ComputerComponent> list) {
        float CPUAveragePrice = (float) list.stream()
                .filter(x -> "CPU".equals(x.getCategory())).mapToDouble(ComputerComponent::getPrice)
                .average()
                .orElse(-1);
       logger.info("Average price of a cpu: " + CPUAveragePrice);
       return CPUAveragePrice;
    }

    public ComputerComponent printCheapest(List<ComputerComponent> list) {
       ComputerComponent cheapestComponent =   (list.stream()
                .min(Comparator.comparing(ComputerComponent::getPrice))
                .get()
        );
       logger.info("Chpeapest :" +cheapestComponent.toString());
       return cheapestComponent;

    }

    public List<ComputerComponent> mostExpensive(List<ComputerComponent> list){
        categoryMap= list.stream()
                .collect(Collectors.groupingBy(ComputerComponent::getCategory));
        List<ComputerComponent> quantities = new ArrayList<>();
        categoryMap.forEach((key,value)-> quantities.add(value.stream().max(Comparator.comparing(ComputerComponent::getPrice)).get()));
        for(ComputerComponent x: quantities){
            logger.info("Most Exspenive: " + x);
        }
        return quantities;
    }

    public  Map<String, Integer> componentQuantity(List<ComputerComponent> list){
        categoryMap= list.stream()
                .collect(Collectors.groupingBy(ComputerComponent::getCategory));
        Map<String, Integer> quantityOfItems = new HashMap<>();
        categoryMap.forEach((key, value) ->
                quantityOfItems.put(key, value.stream().mapToInt(ComputerComponent::getQuantity).sum()));
        for (Map.Entry<String, Integer> entry : quantityOfItems.entrySet()) {
            logger.info("Category: " + entry.getKey() + " Quantity: " + entry.getValue());
        }
        return quantityOfItems;
    }

    public Map<String, Integer> componentBrandCategory(List<ComputerComponent> list){
        categoryBrandMap= list.stream().collect(Collectors.groupingBy(ComputerComponent::getCategory, Collectors.groupingBy(ComputerComponent::getBrand)));
        Map<String,Integer> brandCategory = new HashMap<>();
        categoryBrandMap.forEach((k, v)-> v.forEach((key,value)-> brandCategory.put(k + " " + key, value.stream().mapToInt(ComputerComponent::getQuantity).sum())));
        for(Map.Entry<String,Integer> entry: brandCategory.entrySet()){
            logger.info("Category & Brand : " + entry.getKey()+ "\t|\t"+ "Quantity: " +  entry.getValue());
        }
        return brandCategory;
    }


}