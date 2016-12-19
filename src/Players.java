
public class Players {
Cards c = new Cards();
	
	int j = 0;
	int[] p1= new int[10];
	String[] n1=new String [10];
	int p1_total;
	
	String name;
	
	public void Play(){
	c.setCards();
	
	
	//Loop to determine if the card has already been used
	do{ 
	p1[j]=c.getCards();
	n1[j]=c.getName();
	j++;
	p1[j]=c.getCards();
	n1[j]=c.getName();
	p1_total=p1[0]+p1[1];
	}while(p1[0]==0||p1[1]==0);
	 
	 
	}
	
	public void setName(String name){
		
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public String getCardName(int j){
		
		return n1[j];
		
	}
	
	
	public int getNext(int j){
		
		return p1[j];
	}
	
	public void Hit(){
	 
	do{
		j++;
		p1[j]=c.getCards();
		n1[j]=c.getName();
		}while (p1[j]==0);
		p1_total+=p1[j];
		 
	 
	
	 
	}
	
	public int getTotal(){
		return p1_total;
	}
	
	
}
