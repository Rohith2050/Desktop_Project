package Source;

import java.util.ArrayList;
//import java.util.List;

public class treeNode {
	
	private treeNode parent;
	private ArrayList<treeNode> children;
	private employee emp;
	
	public treeNode(String s, String p) {
		emp = new employee(s, p);
		children = new ArrayList<treeNode>();
       // parent = null;
    }

	public String returnEmp() {
		return emp.getName();
	}
	
	public void editEmpDetails(String s,String p) {
		emp.setFirstName(s);
		emp.setPhoneNumber(p);
	}
	
	public treeNode returnParent(){
		return parent;
	}
	
	public ArrayList<treeNode> returnChildren() {
		return children;
	}
	
	public void setParent(treeNode _parent) {
        parent = _parent;
    }
	public void setChildren(ArrayList<treeNode> _children) {
        children = _children;
    }
	
}
/*
 * import.util.ArrayList;

public class TreeNode {
    private Employee emp;
    private ArrayList<TreeNode> children;
    private TreeNode parent;
    
    public TreeNode(String s, String p) {
        emp = new Employee(s, p);
        children = new ArrayList<TreeNode>();
        parent = null;
    }
    
    public String returnEmp() {
        return emp.getName();
    }
    
    public void editEmpDetails(String s, String p) {
        emp.setFirstName(s);
        emp.setPhoneNumber(p);
    }
    
    public ArrayList<TreeNode> returnChildren() {
        return children;
    }
    
    public TreeNode returnParent() {
        return parent;
    }
    
    public void setChildren(ArrayList<TreeNode> _children) {
        children = _children;
    }
    
    public void setParent(TreeNode _parent) {
        parent = _parent;
    }
}*/
