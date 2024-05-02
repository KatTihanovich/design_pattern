package com.pattern.shape.reader;

import com.pattern.shape.service.RectangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import java.util.stream.Stream;

public class FileReader {
    private static final int NUMBER_OF_SIDES = 4;
    private static final String DELIMITER = "; ";
    private static final String LINE_ERROR_MESSAGE = "Error parsing sides for line: ";
    private static final String READING_ERROR_MESSAGE = "Error reading file: ";

    private static final Logger logger = LogManager.getLogger(FileReader.class.getName());

    public static Double[][] readSides(String filePath) {
        List<Double[]> sidesList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                String[] stringSides = line.split(DELIMITER);
                if (stringSides.length == NUMBER_OF_SIDES) {
                    try {
                        Double[] sides = Arrays.stream(stringSides)
                                .map(Double::parseDouble)
                                .toArray(Double[]::new);
                        sidesList.add(sides);
                    } catch (NumberFormatException e) {
                        logger.warn(LINE_ERROR_MESSAGE + line, e);
                    }
                }
            });
        } catch (IOException e) {
            logger.warn(READING_ERROR_MESSAGE + filePath, e);
        }
        return sidesList.toArray(new Double[0][]);
    }
}