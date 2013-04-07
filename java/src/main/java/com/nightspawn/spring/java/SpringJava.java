package com.nightspawn.spring.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.nightspawn.spring.core.Spring;

public class SpringJava {

  public static void main(String[] args) {
    JavaPlatform platform = JavaPlatform.register();
    platform.assets().setPathPrefix("com/nightspawn/spring/resources");
    PlayN.run(new Spring());
  }
}
