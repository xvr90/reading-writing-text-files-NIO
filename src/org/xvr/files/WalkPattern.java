package org.xvr.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class WalkPattern {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("files/media");

        boolean directory = Files.isDirectory(path);
        System.out.println("Directory = " +directory);

         Stream<Path> stream = Files.walk(path);

        long count =  stream.count();

        long countDirs =
                Files.walk(path)
                        .filter(Files::isDirectory)
                        .count();

        long countFiles =
                Files.walk(path)
                        .filter(Files::isRegularFile)
                        .count();


        System.out.println("Count = " + count);
        System.out.println("Count Directories = " + countDirs);
        System.out.println("Count Files = " + countFiles);
    }
}
