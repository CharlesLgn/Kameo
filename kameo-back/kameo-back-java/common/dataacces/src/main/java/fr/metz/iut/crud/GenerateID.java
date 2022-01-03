package fr.metz.iut.crud;

import java.util.concurrent.atomic.AtomicInteger;

public class GenerateID {

  private static final AtomicInteger ID = new AtomicInteger();

  public static String generateNewId() {
    return Integer.toString(ID.getAndIncrement());
  }
}
