package com.epam.tc.hw7.jsonparser;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.reporters.Files;

public class JsonReadFromTheFile {
    public List<TestDataClass> parseJson() throws IOException {

        String file = Files.readFile(Paths
                .get("src/test/java/com/epam/tc/hw7/TestData/JDI_ex8_metalsColorsDataSet.json")
                .toFile());
        JSONObject jsonObject = new JSONObject(file);

        List<TestDataClass> testDataClassList = new ArrayList<>();

        for (String dataFieldName : jsonObject.keySet()) {
            TestDataClass testDataClass = new TestDataClass();

            JSONObject testData = (JSONObject) jsonObject.get(dataFieldName);

            List<Object> summary = ((JSONArray) testData.get("summary")).toList();
            List<Object> elements = ((JSONArray) testData.get("elements")).toList();
            Object color = testData.get("color");
            Object metals = testData.get("metals");
            List<Object> vegetables = ((JSONArray) testData.get("vegetables")).toList();

            testDataClass.setSummary(summary.stream().map(Object::toString).collect(Collectors.toList()));
            testDataClass.setElements(elements.stream().map(Object::toString).collect(Collectors.toList()));
            testDataClass.setColor(color.toString());
            testDataClass.setMetals(metals.toString());
            testDataClass.setVegetables(vegetables.stream().map(Object::toString).collect(Collectors.toList()));

            testDataClassList.add(testDataClass);
        }

        return testDataClassList;
    }
}
