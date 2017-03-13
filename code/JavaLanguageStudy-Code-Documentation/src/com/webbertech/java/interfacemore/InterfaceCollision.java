package com.webbertech.java.interfacemore;

//try not to use exact same name in different interfaces
//this is bad for readability

interface I1 {	  void f(); }

class c1 { public void f(){}; }

class c1b { public int f(){ return 1; }; }

//legal
class c2 extends c1 implements I1 {} //two same method, it is fine

//illegal
//class c3 extends c1b implements I1{} //two same methods but different return type

public class InterfaceCollision {

}
