import java.util.ArrayList;

public class random_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m, e, n, d;
		double c;
		m = 42;
		e = 17;
		n = 3233;
		d = 2753;
		c = Math.pow(m, e) % n;
//		System.out.println(c);
		
		int m2;
		m2 = (int) Math.pow(c, d) % n;
		System.out.println(m2);
		
		
	}

}
