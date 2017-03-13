package com.webbertech.java.nameproject;

import java.util.HashSet;
import java.util.Set;

public class NameTokenTest {
   public static void main(String[] args) {
       Set<NameToken> s = new HashSet<NameToken>();
       NameToken a = new NameToken("ÀîÏş·å","10");
       s.add(a);
       
       NameToken b = new NameToken("ÀîÏş·å","10");
       s.add(b);
       
       System.out.println(s.contains(a));
       System.out.println(s.size());
       System.out.println(a.hashCode());
       System.out.println(b.hashCode());
       System.out.println(a.equals(b));
   }
}
