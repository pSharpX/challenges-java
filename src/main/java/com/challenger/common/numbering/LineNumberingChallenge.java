package com.challenger.common.numbering;

import java.util.List;
import java.util.stream.IntStream;

public class LineNumberingChallenge {

    public static List<String> number(List<String> lines) {
        return numberStreams(lines);
    }

    public static List<String> numberDefault(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, (i+1) + ": " + lines.get(i));
        }

        return lines;
    }

    public static List<String> numberStreams(List<String> lines) {
        return IntStream.range(0, lines.size())
                .mapToObj(index -> (index+1) + ": " +  lines.get(index))
                .toList();
    }

}
