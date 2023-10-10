package org.ignitescript.compiler.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class IgnEntryPointFile {

    public static String getEntryPointFile(String entryPoint) throws IOException {

        String originPath = System.getProperty("user.dir").replace("\\", "/") + "/src/";
        System.out.println(originPath);
        BufferedReader reader = new BufferedReader(new FileReader(originPath + entryPoint + ".ign"));
        StringBuilder sb = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        return sb.toString();
    }
}
