
public class ReflectionTest {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//used for JNI
		Class<?> cDoubleArray = Class.forName("[D");
		Class<?> jDoubleArray = double[].class;
		
		if(cDoubleArray == jDoubleArray)
		{
			System.out.println("yes they are the same");
		}
		
		//used for JNI
		Class<?> cStringArray = Class.forName("[[Ljava.lang.String;");
		Class<?> jStringArray = String[][].class;
		
		System.out.println(cStringArray.toString());
		
		if(cStringArray == jStringArray) {
			System.out.println("it is the same");
		}
         
		Class<?> c = Class.forName( "java.io.PrintStream" );
		
		System.out.println(c.toString());
		
		Class<?> d = java.io.PrintStream.class;
		
		System.out.println(d.toString());
		
		
		if(Double.TYPE == double.class)
		{
			System.out.println("PrimitiveType.class is the same as the PrimitiveTypeWrapper.Type");
		}
		
		System.out.println(Void.TYPE.toString());
		System.out.println(void.class);
		
	}

}
