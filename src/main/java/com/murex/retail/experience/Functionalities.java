package com.murex.retail.experience;
import java.util.*;
import java.util.stream.Collectors;

import static com.murex.retail.experience.Main.logger;


public class Functionalities {
    private Map<String, List<ComputerComponent>> categoryMap = new HashMap<>();
    private Map<String, Map<String, List<ComputerComponent>>> categoryBrandMap = new HashMap<>();

    public Functionalities(List<ComputerComponent> list){
        categoryMap= list.stream()
                .collect(Collectors.groupingBy(ComputerComponent::getCategory));
        categoryBrandMap=list.stream()
                .collect(Collectors.groupingBy(ComputerComponent::getCategory, Collectors.groupingBy(ComputerComponent::getBrand)));
    }

    public void sortList(List<ComputerComponent> list) {
        list = list.stream().sorted(Comparator.comparing(ComputerComponent::getCategory)
                .thenComparing(ComputerComponent::getName)
                .thenComparing(ComputerComponent::getBrand)).limit(10).collect(Collectors.toList());
        for (ComputerComponent x : list)
        {
            logger.info("hello" + x.toString());
        }
    }

    public void averagePrice(List<ComputerComponent> list) {
        logger.info("The average price of all components is:\t" + (float) list.stream()
                .mapToDouble(ComputerComponent::getPrice)
                .average().orElse(-1));
    }

    public void averagePriceOfCPU(List<ComputerComponent> list) {
        logger.info("The average price of the CPU's is:\t" + (float) list.stream()
                .filter(x -> "CPU".equals(x.getCategory())).mapToDouble(ComputerComponent::getPrice)
                .average()
                .orElse(-1));
    }

    public void printCheapest(List<ComputerComponent> list) {
        logger.info(list.stream()
                .min(Comparator.comparing(ComputerComponent::getPrice))
                .get()
        );
    }

    public void mostExpensive(){
        List<ComputerComponent> quantities = new ArrayList<>();
        categoryMap.forEach((key,value)-> quantities.add(value.stream().max(Comparator.comparing(ComputerComponent::getPrice)).get()));
        for(ComputerComponent x: quantities){
            logger.info(x);
        }
    }

    public  void componentQuantity(){
        Map<String, Integer> quantityOfItems = new HashMap<>();
        categoryMap.forEach((key, value) ->
                quantityOfItems.put(key, value.stream().mapToInt(ComputerComponent::getQuantity).sum()));
        for (Map.Entry<String, Integer> entry : quantityOfItems.entrySet()) {
            logger.info("Category: " + entry.getKey() + "Quantity: " + entry.getValue());
        }
    }

    public void componentBrandCategory(){
        Map<String,Integer> brandCategory = new HashMap<>();
        categoryBrandMap.forEach((k, v)-> v.forEach((key,value)-> brandCategory.put(k + " " + key, value.stream().mapToInt(ComputerComponent::getQuantity).sum())));
        for(Map.Entry<String,Integer> entry: brandCategory.entrySet()){
            logger.info("Category: " + entry.getKey()+ "\t|\t"+ "Quantity: " +  entry.getValue());
        }
    }


}