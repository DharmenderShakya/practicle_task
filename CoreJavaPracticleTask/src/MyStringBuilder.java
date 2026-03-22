import java.util.Stack;

public class MyStringBuilder {

	public StringBuilder data;
	
	public Stack<ClassToStoreState> history=new Stack<>();
	
	public MyStringBuilder() {
		this.data=new StringBuilder();
	}
	
	// save current state
	
	public ClassToStoreState save() {
		return new ClassToStoreState(data.toString());
	}
	
	// restore the previous state
	
	public void restoreState(ClassToStoreState calState) {
		this.data=new StringBuilder(calState.getState());
	}
	
	public void append(String str) {
	data.append(str);	
	}
	
	public void delete(int start,int end) {
		data.delete(start, end);
	}
	
	public String getdata() {
		return data.toString();
	}
	
	// store history in stack
	
	public ClassToStoreState saveHistory(ClassToStoreState clasState) {
		return history.push(clasState);
	}
	
	public ClassToStoreState undo() {
		if(!history.isEmpty()) {
			return history.pop();
		}
		return null;
	}
	
}
