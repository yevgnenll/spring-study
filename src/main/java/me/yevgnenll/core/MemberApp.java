package me.yevgnenll.core;

import me.yevgnenll.core.service.MemberService;
import me.yevgnenll.core.service.impl.MemberServiceImpl;

public class MemberApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();


  }
}
