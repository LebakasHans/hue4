package net.htlgkr.ErstesBeispiel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvIO {
    final String FILE = "numbers.csv";

    public ArrayList<Integer> readCsv() {
        ArrayList<Integer> res = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE));
            List<String> csvLines = br.lines().collect(Collectors.toList());
            for (String s : csvLines ) {
                var test = s.split(":");
                var removedLetters = Arrays.stream(test).map(s1 -> s1.replaceAll("\\D", "")).collect(Collectors.toList());
                res.addAll(removedLetters.stream().filter(s1 -> !s1.isEmpty()).map(Integer::parseInt).collect(Collectors.toList()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
}