package dev.samukklein.rinhacompiladores;

import java.io.IOException;

public class Main {

  private static final String FILE_PATH = "/var/rinha/source.rinha";

  private static Interpreter inteprestation = new Interpreter();

  public static void main(String[] args) throws IOException, InterruptedException {
    var json = RinhaNativeExec.exec(FILE_PATH);
    System.out.println(json);
    inteprestation.exec(json);
  }
}
