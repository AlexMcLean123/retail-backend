package com.murex.retail.experience;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Main
{
   static final Logger logger = LogManager.getLogger(Main.class);

   public static void main(String[] args)
   {
      final String CSVFile = "src/main/resources/Inventory.csv";
      readIn(CSVFile);
   }

   public static void readIn(String input)
   {
      Path path = Paths.get(input);
      try (Stream<String> lines = Files.lines(path).skip(1))
      {
         List<String> list = lines.collect(Collectors.toList());
         List<ComputerComponent> componentList = new ArrayList<>();
         for(String s: list)
         {
            String[] array;
            array = s.split(",");
            ComputerComponent.ComputerComponentBuilder builder = new ComputerComponent.ComputerComponentBuilder();
            builder.id(array[0].trim())
                    .category(array[1].trim())
                    .name(array[2].trim())
                    .brand(array[3].trim())
                    .productLine(array[4].trim())
                    .coreNum(array[5].trim())
                    .procSpeed(array[6].trim())
                    .graphicSpeed(array[7].trim())
                    .dimension(array[8].trim())
                    .res(array[9].trim())
                    .color(array[10].trim())
                    .interf(array[11].trim())
                    .size(array[12].trim())
                    .price(Integer.parseInt(array[13].trim()))
                    .quantity(Integer.parseInt(array[14].trim()));
            ComputerComponent newComp = builder.build();
            componentList.add(newComp);
            logger.info(newComp.toString());
         }
            Functionalities.sortList(componentList);
            Functionalities.averagePrice(componentList);
            Functionalities.averagePriceOfCPU(componentList);
            Functionalities.printCheapest(componentList);
            Functionalities.mostExpensiveCategory(componentList);

      }
      catch(Exception e)
      {
         logger.error(e);
      }
   }
}
