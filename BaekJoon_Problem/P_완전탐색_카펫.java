
public class P_완전탐색_카펫 {
	
	static int brown = 24;
	static int yellow = 24 ;

	public static void main(String[] args) {
		double a1, b1, c1;
		double m,n,x1,x2;
		a1 = 1;
		b1 = -(brown/2+2);
		c1 = brown + yellow;
		m=b1*b1-4*a1*c1; 
		n=Math.pow(m,0.5); 
		x1=(-b1+n)/(2*a1); 
		x2=(-b1-n)/(2*a1); 
		x1=Math.floor(x1*10)/10;
		x2=Math.floor(x2*10)/10; 
		if (a1>0) { 
			if (m>=0) { 
				System.out.println(x1); 
				} else 
					System.out.println("complex"); 
			} else {
				if (m >= 0) 
					System.out.println(x2); 
				else 
					System.out.println("complex"); }

				
				
		

	}

}
