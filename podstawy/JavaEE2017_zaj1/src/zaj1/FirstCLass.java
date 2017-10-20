package zaj1;

public class FirstCLass {
	public int value=12;	
	public double dvalue;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Witamy w Java");
		int i = 0;
		boolean  b;
		String s = "Ala ma kota";
		s= new String("Ala ma kota");
		FirstCLass fC = new FirstCLass((int) 12.0,5);
		System.out.println(fC+s);
		System.out.println(18<<1);
	}

	

	public FirstCLass(int value, double dvalue) {
		super();
		this.value = value;
		this.dvalue = dvalue;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value+":"+dvalue;
	}

	
}
