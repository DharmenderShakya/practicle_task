
public class Main {

	public static void main(String[] args) {
		
		MyStringBuilder classToStoreState=new MyStringBuilder();
		
		// save state before change 
		
		classToStoreState.saveHistory(classToStoreState.save());
		
		classToStoreState.append("hello");
		
		// save state before change
		
		classToStoreState.saveHistory(classToStoreState.save());
		
		classToStoreState.append("world");
		
		System.out.println("this is the data berfore restore"+" "+classToStoreState.getdata());
		
		classToStoreState.restoreState(classToStoreState.undo());
		
		System.out.println("this is the data berfore restore the last state"+" "+classToStoreState.getdata());
		
	}
	
}
