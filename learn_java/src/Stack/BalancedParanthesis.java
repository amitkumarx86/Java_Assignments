package Stack;

public class BalancedParanthesis extends STACK {
	
	
	public static void main(String[] args) {
		
		String paran = "{[[[[()()]]]]}";
		String[] arr_paran = paran.split("");
		System.out.println(CheckBrace(arr_paran) ? "Balanced" : "Not Balanced");
		
	}
	static boolean  CheckBrace(String[] arr_paran){
	  STACK list = new STACK();
	  boolean flag = true;
	  String temp = "";
	  String match = "";
	  for (String brac : arr_paran) {
		    if(brac.equals("{") || brac.equals("[") || brac.equals("("))list.push(brac);
			else{
				if(brac.equals((String) ")")){
					
					match = (String)list.pop();
					if(match == null){
						flag = false;
						return flag;
					}
					while(!match.equals((String)"(")){
						temp = temp + match ;
						match = (String)list.pop();
						if(match == null){
							flag = false;
							return flag;
						}
					}
					int length = temp.length();
					while(length > 0){
						list.push(""+temp.charAt(--length));
					}
					temp="";
				}
				else if(brac.equals((String) "]")){
					match = (String)list.pop();
					if(match == null){
						flag = false;
						return flag;
					}
					while(!match.equals((String)"[")){
						temp = temp + match ;
						match = (String)list.pop();
						if(match == null){
							flag = false;
							return flag;
						}
					}
					int length = temp.length();
					while(length > 0){
						list.push(""+temp.charAt(--length));
					}
					temp="";
				}
				else{
				 
					match = (String)list.pop();
					if(match == null){
						flag = false;
						return flag;
					}
					while(!match.equals((String)"{")){
						temp = temp + match ;
						match = (String)list.pop();
						if(match == null){
							flag = false;
							return flag;
						}
					}
					int length = temp.length();
					while(length > 0){
						list.push(""+temp.charAt(--length));
						list.display();
					}
					temp="";
				}
				
			} 
			
		}
	  	if((String)list.pop() != null){
			return false;
		}
	 return flag;
     
  }
}
