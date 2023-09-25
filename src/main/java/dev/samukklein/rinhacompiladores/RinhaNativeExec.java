package dev.samukklein.rinhacompiladores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RinhaNativeExec {

  public static String exec(String input) throws IOException, InterruptedException {

    Process process = Runtime.getRuntime().exec("rinha " + input);

    StringBuilder textBuilder = new StringBuilder();
    try (var reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
      int c = 0;
      while ((c = reader.read()) != -1) {
        textBuilder.append((char) c);
      }
    }

    new BufferedReader(new InputStreamReader(process.getErrorStream())).lines()
        .forEach(System.err::println);

    process.waitFor();
    int exitCode = process.exitValue();
    System.out.println(exitCode);
    return textBuilder.toString();
  }

}
