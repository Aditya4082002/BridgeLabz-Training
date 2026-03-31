
class SnakeAndLadder{
	public static void main(String[] args){
		//UC-1
		int playerOnePosition = 0;
		int playerTwoPosition = 0;
		int chance = 1;
		int diceCount=0;
		
		while(playerOnePosition<100 && playerTwoPosition<100){
			if(chance==1){
				playerOnePosition=play(1,playerOnePosition);
				chance=2;
			}
			else{
				playerTwoPosition = play(2,playerTwoPosition);
				chance=1;
			}
		}
		if(playerOnePosition==100){
			System.out.println("Player One won");
		}
		else {
			System.out.println("Player Two won");
		}
		//System.out.println("Total dice Count :" + diceCount);
	}
	
	//UC-2 diceRoll
	static int diceRoll(){
		return (int)(Math.random()*6+1);
	}
	
	//UC-3 checks
	static int checks(){
		return (int)(Math.random()*3);
	}
	
	//UC-7 two player game
	static int play(int player,int playerPosition){
		int previous = playerPosition;
			int dice = diceRoll();
			int option = checks();
			switch(option){
				case 0:
					//No play
					break;
				case 1:
					//Ladder
					playerPosition+=dice;
					if(playerPosition>100){
						playerPosition=previous;
					}
					else if(playerPosition==100){
						return playerPosition;
					}
					play(player,playerPosition);
					break;
				case 2:
					//snake
					playerPosition-=dice;
					break;	
			}
			if(playerPosition<0){
				playerPosition=0;
			}
			System.out.println("Player " + player +" Position : " + playerPosition);
		return playerPosition;
	}
}