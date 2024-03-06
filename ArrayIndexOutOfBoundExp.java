package arrays;

public class ArrayIndexOutOfBoundExp {
	public static void main(String[] args) {
		
		int [] ar =new int[4];
		
		try {
			ar[0] =10;
			ar[1] =100 ;
			ar[2] =50;
			ar[3] =80;
			ar[4] =20 ;
		}
	   catch(ArrayIndexOutOfBoundsException exp) 
		{
		 System.out.println("Access the elements within the boundry");
		}
		
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		
	}
	
}
