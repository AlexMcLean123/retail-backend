package com.murex.retail.experience;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    private static final Path filePath = Paths.get("src/main/resources/Inventory.csv");

    //do all the tests within one test
    @Test
    public void testProgramOutput() throws IOException {
        final String CSVFile = "src/main/resources/Inventory.csv";
        List<ComputerComponent> componentList = Main.readInBuildComponent(CSVFile);

        Functionalities functions = new Functionalities(componentList);
        String s1 = "[INFO ] 2019-02-05 17:22:36.874 [main] Main - hello46100e71-689d-4f37-a94a-9cba59919d8f\t|\tCPU\t|\tAtom Processor C3308\t|\tIntel\t|\tAtom\t|\t2\t|\t2.10 GHz\t|\tN/A\t|\tN/A\t|\tN/A\t|N/A\t|\tN/A\t|\tN/A\t|\t45\t|\t25\n" +
                "[INFO ] 2019-02-05 17:22:36.874 [main] Main - hello06510d3e-c002-40c2-8a9d-42259699211c\t|\tCPU\t|\tAtom Processor C3338\t|\tIntel\t|\tAtom\t|\t2\t|\t2.20 GHz\t|\tN/A\t|\tN/A\t|\tN/A\t|N/A\t|\tN/A\t|\tN/A\t|\t55\t|\t45\n" +
                "[INFO ] 2019-02-05 17:22:36.874 [main] Main - hello18690849-1586-4b7c-8315-f84c2504edec\t|\tCPU\t|\tAtom Processor C3508\t|\tIntel\t|\tAtom\t|\t4\t|\t1.60 GHz\t|\tN/A\t|\tN/A\t|\tN/A\t|N/A\t|\tN/A\t|\tN/A\t|\t45\t|\t30\n" +
                "[INFO ] 2019-02-05 17:22:36.874 [main] Main - hello3f1dcd8f-58bb-4431-908e-9db89533281d\t|\tCPU\t|\tAtom Processor C3538\t|\tIntel\t|\tAtom\t|\t4\t|\t2.10 GHz\t|\tN/A\t|\tN/A\t|\tN/A\t|N/A\t|\tN/A\t|\tN/A\t|\t50\t|\t40\n" +
                "[INFO ] 2019-02-05 17:22:36.875 [main] Main - helloe64b6501-67be-48d2-b889-a1f8c0716a55\t|\tCPU\t|\tAtom Processor C3558\t|\tIntel\t|\tAtom\t|\t4\t|\t2.20 GHz\t|\tN/A\t|\tN/A\t|\tN/A\t|N/A\t|\tN/A\t|\tN/A\t|\t70\t|\t40\n" +
                "[INFO ] 2019-02-05 17:22:36.875 [main] Main - hello35720aec-1d59-4670-9908-cd1fda5a137d\t|\tCPU\t|\tAtom Processor C3708\t|\tIntel\t|\tAtom\t|\t8\t|\t1.70 GHz\t|\tN/A\t|\tN/A\t|\tN/A\t|N/A\t|\tN/A\t|\tN/A\t|\t70\t|\t50\n" +
                "[INFO ] 2019-02-05 17:22:36.875 [main] Main - hello7885b384-e91e-4ff5-ac38-0003f358c3bc\t|\tCPU\t|\tAtom Processor C3750\t|\tIntel\t|\tAtom\t|\t8\t|\t2.20 GHz\t|\tN/A\t|\tN/A\t|\tN/A\t|N/A\t|\tN/A\t|\tN/A\t|\t55\t|\t45\n" +
                "[INFO ] 2019-02-05 17:22:36.875 [main] Main - hello8cd6cf99-057f-4b18-9f95-27438475853b\t|\tCPU\t|\tAtom Processor C3758\t|\tIntel\t|\tAtom\t|\t8\t|\t2.20 GHz\t|\tN/A\t|\tN/A\t|\tN/A\t|N/A\t|\tN/A\t|\tN/A\t|\t50\t|\t46\n" +
                "[INFO ] 2019-02-05 17:22:36.875 [main] Main - hellode663c1d-3681-43a7-a21d-0d5d0de1f311\t|\tCPU\t|\tAtom Processor C3808\t|\tIntel\t|\tAtom\t|\t12\t|\t2.00 GHz\t|\tN/A\t|\tN/A\t|\tN/A\t|N/A\t|\tN/A\t|\tN/A\t|\t65\t|\t20\n" +
                "[INFO ] 2019-02-05 17:22:36.875 [main] Main - hellobdf30ee6-665d-484c-af41-917bf9dc6d15\t|\tCPU\t|\tAtom Processor C3830\t|\tIntel\t|\tAtom\t|\t12\t|\t1.90 GHz\t|\tN/A\t|\tN/A\t|\tN/A\t|N/A\t|\tN/A\t|\tN/A\t|\t60\t|\t10"
        assertEquals(functions.sortList(componentList), s1);
    }
}
