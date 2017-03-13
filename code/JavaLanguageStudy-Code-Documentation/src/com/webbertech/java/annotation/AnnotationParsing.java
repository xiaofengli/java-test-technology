package com.webbertech.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
/*
 * This program contains a main method, and it should be run separately.
 * 
 * We will use Reflection to parse java annotations from a class. 
 * Please note that Annotation Retention Policy should be RUNTIME otherwise it’s information 
 * will not be available at runtime and we wont be able to fetch any data from it.
 * */

public class AnnotationParsing {

	public static void main(String[] args) {
		try {
			for (Method method : AnnotationParsing.class.getClassLoader()
					.loadClass(("com.webbertech.java.annotation.AnnotationExample")).getMethods()) {
				// checks if MethodInfo annotation is present for the method
				if (method.isAnnotationPresent(com.webbertech.java.annotation.MethodInfo.class)) {
					try {
						// iterates all the annotations available in the method
						for (Annotation anno : method.getDeclaredAnnotations()) {
							System.out.println("Annotation in Method '" + method + "' : " + anno);
						}
						//it gets the annotation
						MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
						if (methodAnno.revision() == 1) {
							System.out.println("Method with revision no 1 = " + method);
						}

					} catch (Throwable ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
