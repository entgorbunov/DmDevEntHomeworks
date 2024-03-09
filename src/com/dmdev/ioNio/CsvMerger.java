package com.dmdev.ioNio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.dmdev.ioNio.utility.Utility.*;

public class CsvMerger {

    private static final String SRC_FOLDER = "src";
    private static final String RESOURCES_FOLDER = "resources";
    private static final String PRICE_FILE_NAME = "items-price.csv";
    private static final String ITEMS_FILE_NAME = "items-name.csv";
    private static final String RESULT_FILE_NAME = "result.csv";
    private static final String ERROR_FILE_NAME = "errors.csv";

    private static final String ITEMS_PRICE_CONTENT = """
            ID,PRICE
            1,9.98
            2,25.05
            3,16.45
            """;

    private static final String ITEMS_NAME_CONTENT = """
            ID,NAME,DESCRIPTION
            1,Шарф,Теплый зимний шарф красного цвета
            2,Шапка,Вязаная зеленая шапка
            3,Ботинки,Осенние ботинки на толстой подошве
            """;


    public static void main(String[] args) {

        var pathToPriceFileName = Path.of(SRC_FOLDER, RESOURCES_FOLDER, PRICE_FILE_NAME);
        var pathToItemsFileName = Path.of(SRC_FOLDER, RESOURCES_FOLDER, ITEMS_FILE_NAME);
        var pathToResult = Path.of(SRC_FOLDER, RESOURCES_FOLDER, RESULT_FILE_NAME);
        var pathToErrorData = Path.of(SRC_FOLDER, RESOURCES_FOLDER, ERROR_FILE_NAME);


        createInitialCSV(pathToPriceFileName, ITEMS_PRICE_CONTENT);
        createInitialCSV(pathToItemsFileName, ITEMS_NAME_CONTENT);
        var prices = readPrices(pathToPriceFileName);
        var names = readNames(pathToItemsFileName);
        var mergedData = mergeData(prices, names);
        var errorData = getErrorData(prices, names);
        createResultCSV(mergedData, pathToResult);
        createErrorCSV(errorData, pathToErrorData);


    }


}
