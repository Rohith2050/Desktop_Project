package Source;

import java.util.*;

public class company {
	//String name;
	public String allEmployees;
	public treeNode foundNode;
	
	public treeNode root;
    public String name;
    
    public company() {
        setName("Company");
    }
    
    public company(String s) {
        setName(s);
    }
    
    public void setName(String s) {
        name = s;
    }
	public String getName() {
		return name;
	}
	
	public void setLeader(String s,String p) {
		if(root==null) {
			System.out.println("New Leader---------");
			root=new treeNode(s,p);
		}else {
			System.out.println("Setup an Leader-----------");
			root.editEmpDetails(s, p);
		}
	}
	
	public treeNode returnLeader() {
		System.out.println("Returning Leader----------"+root.returnEmp().charAt(0));
		return root;
	}
	
	public void addChildren(treeNode node, ArrayList<String> names, ArrayList<String> numbers) {
	    ArrayList<treeNode> _children = node.returnChildren();
	    for (int i = 0; i < names.size(); i++) {
	        treeNode newNode = new treeNode(names.get(i), numbers.get(i));
	        _children.add(newNode);
	        newNode.setParent(node);
	    }
	    node.setChildren(_children);
	}
	
	public String returnEmployees(treeNode node, List<Boolean> flag, int depth, boolean isLast) {
	    
	    if (node == null){
	        return allEmployees;
	    }
	    
	    for (int i = 1 ;i < depth; ++i) {
	        
	        if (flag.get(i) == true) {
	            allEmployees += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	        }
	        
	        else {
	            allEmployees += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	        }
	    }
	    if (depth == 0){
	        allEmployees += node.returnEmp() + "<br>";
	        if(allEmployees.contains("null")) {
	        	allEmployees = node.returnEmp() + "<br>";
	        }else {
	        	allEmployees += node.returnEmp() + "<br>";
	        }
	    }
	    
	    
	    else if (isLast) {
	        allEmployees += "+----------" + node.returnEmp() + "<br>";
	        
	        flag.set(depth, false);
	    }
	    else {
	        allEmployees += "+----------" + node.returnEmp() + "<br>";
	    }
	    int it = 0;
	    ArrayList<treeNode> _children = node.returnChildren();
	    for (int i = 0; i < _children.size(); ++i, ++it){
	        
	        returnEmployees(_children.get(i), flag, depth + 1, it == (node.returnChildren().size()));
	        flag.set(depth, true);
	    }
	    return allEmployees;
	}
	
	public treeNode findNode(treeNode node, String e) {
		System.out.println(e+"*-*-*-*-*-*-*-*-*");
		System.out.println(node.returnEmp()+"*-*-*-*-*-*-*-*-*");
	    if (node.returnEmp().equals(e)) {
	    	System.out.println("Node is null");
	        foundNode = node;
	        return foundNode;
	    } else {
	        for (int i = 0; i < node.returnChildren().size(); i++) {
	            findNode(node.returnChildren().get(i), e);
	        }
	        return foundNode;
	    }
	}

	
	public void resetFoundNode() {
		foundNode=null;
	}
	public treeNode returnFoundNode() {
		return foundNode;
	}
	
	public treeNode deleteNode(treeNode root,treeNode founNode,String promoteSetting) {
		treeNode searchNode = foundNode;
		treeNode parent = searchNode.returnParent();
		
		if(searchNode.returnChildren().size()==0) {
			ArrayList<treeNode> child=parent.returnChildren();
			for(int i=0;i<child.size();i++) {
				if(child.get(i)==searchNode) {
					child.remove(child.get(0+i));
					parent.setChildren(child);
				}
			}
			
		}
		else if(searchNode.returnChildren().size()==1) {
			treeNode oneChild=searchNode.returnChildren().get(0);
			ArrayList<treeNode> child=parent.returnChildren();
			for(int i=0;i<child.size();i++) {
				if(child.get(i)==searchNode) {
					child.set(i, oneChild);
					parent.setChildren(child);
				}
			}
			oneChild.setParent(parent);
		}
		
		else if(searchNode.returnChildren().size()>1 && promoteSetting =="all") {
			ArrayList<treeNode> allChild=searchNode.returnChildren();
			ArrayList<treeNode> child=parent.returnChildren();
			
			for(int i=0;i<child.size();i++) {
				if(child.get(i)==searchNode) {
					child.remove(child.get(0+i));
				}
			}
			
			for(int i=0;i<allChild.size();i++) {
				allChild.get(i).setParent(parent);
				child.add(allChild.get(i));
			}
			parent.setChildren(child);
			
		}
		
		else {
			List<treeNode> allChild=searchNode.returnChildren();
			treeNode nodeToPromote = allChild.get(0);
			int InsertPos=0;
			for(int i=0;i<allChild.size();i++) {
				if(allChild.get(i).returnEmp() == promoteSetting) {
					nodeToPromote = allChild.get(i);
					nodeToPromote.setParent(parent);
				}
			}
			
			ArrayList<treeNode> child=parent.returnChildren();
			for(int i=0;i<child.size();i++) {
				if(child.get(i)==searchNode) {
					InsertPos=i;
					child.remove(child.get(0+i));
				}
			}
			
			ArrayList<treeNode> nTPchild=nodeToPromote.returnChildren();
			for(int i=0;i<allChild.size();i++) {
				if(allChild.get(i).returnEmp() != promoteSetting) {
					nTPchild.add(allChild.get(i));
					allChild.get(i).setParent(nodeToPromote);
				}
				nodeToPromote.setChildren(nTPchild);
				}
			child.add(InsertPos, nodeToPromote);
			parent.setChildren(child);
		}
		return root;	
	}
	public treeNode changeParent(treeNode root,treeNode foundNode,String newBoss) {
		treeNode nBoss=findNode(root,newBoss);
		if(nBoss==null) {
			return root;
		}
		else if(nBoss.returnEmp().equals(newBoss)) {
			treeNode parent =foundNode.returnParent();
			ArrayList<treeNode> child=parent.returnChildren();
			for(int i=0;i<child.size();i++) {
				if(child.get(i).equals(foundNode)) {
					child.remove(i);
				}
			}
			parent.setChildren(child);
			
			ArrayList<treeNode> pChild=nBoss.returnChildren();
			pChild.add(foundNode);
			nBoss.setChildren(pChild);
			
			foundNode.setParent(nBoss);
		}
		return root;
	}
	
	public void resetEmployeeString() {
		allEmployees=null;
	}
	
}
