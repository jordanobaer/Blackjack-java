
public class Cards {
	public	String name1;
	public	String name2=" ";
	int[][] cards = new int [16][13];
	
	
	//Creating the cards
	// 4 decks
	public void setCards(){
	
		for(int i=0;i<16;i++){
			for(int j=0; j<13;j++){
				if(j == 0){
					cards[i][j]=1;
				}else if(j==10||j==11||j==12){
					cards[i][j]=10;
				}else{
					cards[i][j]=cards[i][j-1] + 1;	
			}
		}
		
	 	}
	}
	
	//Get a card
	public int getCards(){
	int card=0;
	int x = (int) (Math.random()*(16));
	int y = (int) (Math.random()*(13));
	//System.out.println(cards[x][y]);
	setName(x,y);
	card=cards[x][y];
	cards[x][y]=0;
	return card;
	}
	
	//Name of the card
	public void setName(int x, int y){
		if(x==0||x==4||x==8||x==12){
			name2="Clubs";
		}else if(x==1||x==5||x==9||x==13){
			name2="Diamonds";
		}else	if(x==2||x==6||x==10||x==14){
			name2="Hearts";
		}else{
			name2= "Spades";
		}
		
		
		if(y==10){
			name1="Jack";
		}else if(y==11){
			name1="Queen";
		}else if(y==12){
			name1="King";
		}else{
			name1=" ";
		}
		 
	}
	
	
	public String getName(){
		if(name1.equals(" ")){
			return name2;
		}else{
		return name1+" "+ name2;
		}
	}
	
}
