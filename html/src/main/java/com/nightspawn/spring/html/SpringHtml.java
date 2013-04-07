package com.nightspawn.spring.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import com.nightspawn.spring.core.Spring;

public class SpringHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform platform = HtmlPlatform.register();
    platform.assets().setPathPrefix("spring/");
    PlayN.run(new Spring());
  }
}
