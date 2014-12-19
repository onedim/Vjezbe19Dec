import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DriverClass {
	
	public static void main(String[] args) {
		String s=(String) JOptionPane.showInputDialog(new JFrame(),"Enter game field size:","Tic Tac Toe size", 
				JOptionPane.PLAIN_MESSAGE);
		
		try{
			int size=Integer.parseInt(s);
			System.out.println(size);
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
				
	}
	
	
}
