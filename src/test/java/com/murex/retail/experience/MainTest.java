package com.murex.retail.experience;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    static final String filePath = "src/main/resources/Inventory.csv";

    //do all the tests within one test
    @Test
    public void testProgramOutput() throws IOException{
        List<ComputerComponent> allComponents = Main.readInBuildComponent(filePath);
        Functionalities functions = new Functionalities(allComponents);
        testItemsSorted(functions, allComponents);
        testAveragePrice(functions, allComponents);
        testAveragePriceOfACPU(functions, allComponents);
        testCheapestComponent(functions, allComponents);
        testMostExpensiveComponentsInCat(functions, allComponents);
        testComponentsByCategory(functions,allComponents);
        testComponentsByBrandCategory(functions,allComponents);
        }

        public void testItemsSorted(Functionalities function, List<ComputerComponent> com) {
            List<ComputerComponent> sortedInventory = function.sortList(com);
            assertEquals("CPU", sortedInventory.get(0).getCategory());
            assertEquals("Atom Processor C3308", sortedInventory.get(0).getName());
            assertEquals("Intel", sortedInventory.get(0).getBrand());

            assertEquals("CPU", sortedInventory.get(9).getCategory());
            assertEquals("Atom Processor C3830", sortedInventory.get(9).getName());
            assertEquals("Intel", sortedInventory.get(9).getBrand());

        }

        public void testAveragePrice(Functionalities function, List<ComputerComponent> com) {
            assertEquals(145.83, function.averagePrice(com));
        }

        public void testAveragePriceOfACPU(Functionalities function, List<ComputerComponent> com) {
            assertEquals(92.43243408203125, function.averagePriceOfCPU(com));
        }

        public void testCheapestComponent(Functionalities function, List<ComputerComponent> com) {
            assertEquals(4, function.printCheapest(com).getPrice());
        }

        public void testMostExpensiveComponentsInCat(Functionalities function, List<ComputerComponent> com) {
            String[] arrayOfId = {"375cfcec-9655-4c68-9afc-8c706685c883",
                    "79b536c7-6a19-4099-96ec-5cdcb33b9548",
                    "8611b32f-5efc-4452-9bfe-0f0776c63195",
                    "abd86688-2ed5-4a16-af25-e7e2118a1af0",
                    "1a4eea28-0681-4ca3-b151-b13ecce8d85d",
                    "96fc477c-0c66-4400-9217-94817072429f",
                    "ea2b9fd9-d908-4c78-84f0-201483cd91ff"};
            for (int i = 0; i < arrayOfId.length; i++) {
                assertEquals(arrayOfId[i], function.mostExpensive(com).get(i).getID());
            }
        }

        public void testComponentsByCategory(Functionalities function, List<ComputerComponent> com) {
            Map<String, Integer> componentsByCat = function.componentQuantity(com);
            assertEquals(82, componentsByCat.get("Storage").intValue());
            assertEquals(192, componentsByCat.get("Monitor").intValue());
            assertEquals(141, componentsByCat.get("Memory").intValue());
            assertEquals(312, componentsByCat.get("Mouse").intValue());
            assertEquals(285, componentsByCat.get("Keyboard").intValue());
            assertEquals(1131, componentsByCat.get("CPU").intValue());
            assertEquals(55, componentsByCat.get("GPU").intValue());
        }
        public void testComponentsByBrandCategory(Functionalities function, List<ComputerComponent> com){
        Map<String,Integer> brandCategory = function.componentBrandCategory(com);
            assertEquals(90, brandCategory.get("Keyboard logitech").intValue());
            assertEquals(210, brandCategory.get("CPU AMD").intValue());
            assertEquals(153, brandCategory.get("Keyboard Microsoft").intValue());
            assertEquals(15, brandCategory.get("Mouse Kingston").intValue());
            assertEquals(40, brandCategory.get("Mouse Cougar").intValue());
            assertEquals(50, brandCategory.get("Mouse Microsoft").intValue());
            assertEquals(20, brandCategory.get("Monitor ViewSonic").intValue());
            assertEquals(40, brandCategory.get("Memory Team").intValue());
            assertEquals(15, brandCategory.get("Storage Western Digital").intValue());
            assertEquals(80, brandCategory.get("Monitor Asus").intValue());
            assertEquals(55, brandCategory.get("GPU NVIDIA").intValue());
            assertEquals(52, brandCategory.get("Mouse Razer").intValue());
            assertEquals(27, brandCategory.get("Storage Kingston").intValue());
            assertEquals(20, brandCategory.get("Keyboard Apple").intValue());
            assertEquals(921, brandCategory.get("CPU Intel").intValue());
            assertEquals(45, brandCategory.get("Monitor LG").intValue());
            assertEquals(135, brandCategory.get("Mouse CaseLogic").intValue());
            assertEquals(20, brandCategory.get("Mouse Apple").intValue());
            assertEquals(12, brandCategory.get("Memory Patriot").intValue());
            assertEquals(30, brandCategory.get("Storage Seagate").intValue());
            assertEquals(47, brandCategory.get("Monitor Samsung").intValue());
            assertEquals(22, brandCategory.get("Keyboard RAZER").intValue());
            assertEquals(10, brandCategory.get("Storage Samsung").intValue());
            assertEquals(89, brandCategory.get("Memory Kingston").intValue());

        }

        @Test
        public void testMain()throws IOException{
        String[]args=null;
        Main.main(args);
        }

        @Test
        public void testgetters(){
        ComputerComponent.ComputerComponentBuilder builder = new ComputerComponent.ComputerComponentBuilder();
        builder.productLine("This is the product line")
                .coreNum("This is the number of cores")
                .graphicSpeed("This is the graphics speed")
                .dimension("This is the dimension")
                .res("This is the resolution")
                .color("This is the color")
                .interf("this is the interface")
                .size("And this is the size");
        ComputerComponent newComp = builder.build();
       String expected = "This is the product lineThis is the number of coresThis is the graphics speedThis is the dimensionThis is the resolutionThis is the colorthis is the interfaceAnd this is the size";
            String actual = newComp.getProductLine()+newComp.getCoreNum()+newComp.getGraphicSpeed()+newComp.getDimension()+ newComp.getRes()+newComp.getColor()+newComp.getInterf()+newComp.getSize();
       assertEquals(expected, actual);

        }

}
