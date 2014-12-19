package TicTacToeLogic;

public class TicTacToeLogic {
	
	private int[][] table;
	private boolean player;
	private String winner;
	private int freeFields;
	private boolean gameOver;
	
	public TicTacToeLogic(int size){
		table = new int[size][size];
		player = true;
		winner = "Tie";
		freeFields = size * size;
		gameOver = false;
		initTable();
	}
	
	private void initTable(){
		for(int i = 0; i < table.length; i++){
			for(int j = 0; j < table[i].length; j++){
				table[i][j] = -1;
			}
		}
	}
	
	public boolean setCell(int x, int y){
		if( x < 0 || x > table.length || y < 0 || y > table[0].length){
			throw new IndexOutOfBoundsException("Pogresne koordinate");
		}
		if( table[x][y] != -1){
			throw new IllegalArgumentException("Polje je zauzeto");
		}
		
		int value = player == true ? 1 : 2;
		
		table[x][y] = value;
		freeFields--;
		player = !player;

		return gameOver = isOver();
	}
	
	private boolean isOver(){
		
		if( checkRows() == true ){
			return true;
		}
		
		if( checkColumns() == true ){
			return true;
		}
		
		if( checkDiagonals() == true){
			return true;
		}
			
		if( freeFields == 0){
			return true;
		}
		
		
		
		return false;
	}
	
	
	private boolean checkRows(){
		for(int i = 0; i < table.length; i++){
			if( checkRow(i) == true)
				return true;
		}
		return false;
	}
	
	private boolean checkRow(int index){
		int[] row = table[index];
		if( row[0] == -1)
			return false;
		for(int i = 1; i < table.length; i++){
			if( row[i] != row[i-1])
				return false;
		}
		setWinner(row[0]);
		return true;
	}
	
	private boolean checkColumns(){	
		for(int i = 0; i < table[0].length; i++){
			if( checkColumn(i) == true)
				return true;
		}
		return false;
	}
	
	private boolean checkColumn(int index){
		if( table[0][index] == -1)
			return false;
		for(int i = 1; i < table.length; i++){
			if( table[i-1][index] != table[i][index])
				return false;
		}
		setWinner(table[0][index]);
		return true;
	}
	
	private boolean checkDiagonals(){
		
		boolean allEqualDiagonal = true;
		boolean allEqualConDiagonal = true;
		
		for(int i = 1; i < table.length; i++){
			if( table[i-1][i-1] != table[i][i])
				allEqualDiagonal = false;
		}
		if( table[0][0] == -1)
			allEqualDiagonal = false;
		
		for(int i = 1; i < table.length; i++){
			int j = table.length - i - 1;
			if( table[i-1][j+1] != table[i][j])
				allEqualConDiagonal = false;
		}
		if( table[0][table[0].length-1] == -1)
			allEqualConDiagonal = false;
		
		if( allEqualDiagonal == true || allEqualConDiagonal == true){
			setWinner(table[table.length/2][table.length/2]);
			return true;
		}
		
		return false;
		
	}
	
	private void setWinner(int cellValue){
		if( cellValue == 1)
			winner = "Player 1";
		else
			winner = "Player 2";
	}
	
	public String getWinner(){
		return winner;
	}
	
	public void clear(){
		initTable();
		player = true;
		winner = "Tie";
		freeFields = table.length * table.length;
		gameOver = false;
	}
	
	public boolean getGameOver(){
		return gameOver;
	}
	
	public String getPreviousPlayer(){
		return !player == true ? "X" : "O";
	}
	
	
	/**
	 * za debug
	 */
	public void printTable(){
		for(int[] row : table){
			for(int cell : row){
				System.out.print(cell+" ");
			}
			System.out.println();
		}
	}
	

}
