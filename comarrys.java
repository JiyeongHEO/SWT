
public class comarrys {
	
	public static void main(String[] args) {
		 String[] a= {"love","cat","penguin","zoo","deer","door"};
		 String[] b= {"zoo","cat","love","door","penguin"};
		 
		 System.out.println("left one: "+compare(a,b));
		 
	}

	
	
	
	public static String compare(String[] a, String[] b){
		String res = "";
		int flag=0;
		
		for(int i=0; i<a.length; i++){
				flag=0;		
			for(int j=0; j<b.length; j++){
				if(a[i].equals(b[j])){flag=1;}
				
			}
			if(flag==0){res=a[i];}
		}
	
		
		return res; }
}