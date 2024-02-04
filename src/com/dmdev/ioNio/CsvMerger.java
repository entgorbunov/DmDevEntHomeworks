package com.dmdev.ioNio;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvMerger {

    public static void main(String[] args) {
        String priceFile = "items-price.csv";
        String nameFile = "items-name.csv";
        String resultFile = "result.csv";
        String errorFile = "errors.csv";

        Map<String, String> prices = new HashMap<>();
        Map<String, String[]> names = new HashMap<>();

        try {
            // Чтение цен
            List<String> priceLines = Files.readAllLines(Paths.get(priceFile));
            for (String line : priceLines.subList(1, priceLines.size())) {
                String[] parts = line.split(",");
                prices.put(parts[0], parts[1]);
            }

            // Чтение названий и описаний
            List<String> nameLines = Files.readAllLines(Paths.get(nameFile));
            for (String line : nameLines.subList(1, nameLines.size())) {
                String[] parts = line.split(",", 3);
                names.put(parts[0], new String[]{parts[1], parts[2]});
            }

            // Объединение данных и запись в файлы
            StringBuilder resultBuilder = new StringBuilder("ID,NAME,PRICE\n");
            StringBuilder errorBuilder = new StringBuilder("ID\n");

            names.keySet().forEach(id -> {
                if (prices.containsKey(id)) {
                    String[] nameDesc = names.get(id);
                    resultBuilder.append(id).append(",").append(nameDesc[0]).append(",").append(prices.get(id)).append("\n");
                } else {
                    errorBuilder.append(id).append("\n");
                }
            });

            prices.keySet().stream().filter(id -> !names.containsKey(id)).forEach(id -> errorBuilder.append(id).append("\n"));

            Files.write(Paths.get(resultFile), resultBuilder.toString().getBytes());
            Files.write(Paths.get(errorFile), errorBuilder.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
