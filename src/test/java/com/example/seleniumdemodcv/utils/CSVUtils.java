package com.example.seleniumdemodcv.utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class CSVUtils {
    public static Object[][] readCSV(String resourcePath) {
        List<Object[]> data = new ArrayList<>();
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                CSVUtils.class.getClassLoader().getResourceAsStream(resourcePath)
                        )
                )
        ) {
            String line;
            boolean isFirst = true;
            while ((line = br.readLine()) != null) {
                if (isFirst) { isFirst = false; continue; } // skip header
                String[] parts = line.split(",");
                data.add(parts);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading CSV: " + resourcePath, e);
        }
        return data.toArray(new Object[0][]);
    }
}
