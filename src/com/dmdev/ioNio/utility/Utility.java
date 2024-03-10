package com.dmdev.ioNio.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utility {
    public static void createInitialCSV(Path fileNamePath, String content) {
        try {

            Files.createDirectories(fileNamePath.getParent());

            try (var writer = new BufferedWriter(new FileWriter(String.valueOf(fileNamePath)))) {
                writer.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, String> readPrices(Path filePath) {
        try (Stream<String> lines = Files.lines(filePath)) {
            return lines.skip(1)
                    .map(line -> line.split(",", 2))
                    .collect(Collectors.toMap(
                            parts -> parts[0],
                            parts -> parts[1],
                            (existing, replacement) -> existing));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static Map<String, String[]> readNames(Path filePath) {
        try (Stream<String> lines = Files.lines(filePath)) {
            return lines.skip(1)
                    .map(line -> line.split(",", 3))
                    .collect(Collectors.toMap(
                            parts -> parts[0],
                            parts -> new String[]{parts[1], parts[2]}
                    ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static Map<String, String> mergeData(Map<String, String> prices, Map<String, String[]> names) {
        return names.entrySet().stream()
                .filter(entry -> prices.containsKey(entry.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue()[0] + "," + prices.get(entry.getKey())
                ));
    }

    public static List<String> getErrorData(Map<String, String> prices, Map<String, String[]> names) {

        List<String> missingInPrices = names.keySet().stream()
                .filter(id -> !prices.containsKey(id))
                .toList();

        List<String> missingInNames = prices.keySet().stream()
                .filter(id -> !names.containsKey(id))
                .toList();

        return Stream.concat(missingInPrices.stream(), missingInNames.stream())
                .distinct()
                .collect(Collectors.toList());
    }



    public static void createResultCSV(Map<String, String> mergedData, Path resultFile) {
        StringBuilder resultBuilder = new StringBuilder("ID,NAME,PRICE\n");
        mergedData.forEach((id, value) -> resultBuilder.append(id).append(",").append(value).append("\n"));

        try {
            Files.write(resultFile, resultBuilder.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createErrorCSV(List<String> errorData, Path errorFile) {
        StringBuilder errorBuilder = new StringBuilder("ID\n");
        errorData.forEach(id -> errorBuilder.append(id).append("\n"));
        try {
            Files.write(errorFile, errorBuilder.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
