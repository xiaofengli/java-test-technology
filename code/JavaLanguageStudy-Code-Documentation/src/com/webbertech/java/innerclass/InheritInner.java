package com.webbertech.java.innerclass;
class WithInner {
	class Inner {}
}

public class InheritInner extends WithInner.Inner {

	//default constructor will not work
	//InheritInner() {}
	//need to initialize WithInner to get its inner class to extend
	InheritInner(WithInner wi) {
		wi.super();
	}
	
	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InheritInner ii =new InheritInner(wi);
	}
}

