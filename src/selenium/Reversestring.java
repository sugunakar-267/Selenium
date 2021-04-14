package selenium;

public class Reversestring 
{
	public static void main(String[] args) 
	{
		/*String string = "abcdef";
		String reverse = new StringBuffer(string).reverse().toString();
		System.out.println("\nString before reverse: "+string);
		System.out.println("String after reverse: "+reverse);*/
		String input = "Hello";
	    char[] output = input.toCharArray();
	    for (int i = output.length-1;i >= 0; i--)
	    {	
	    	System.out.print(output[i]);
	    }
	}

}
