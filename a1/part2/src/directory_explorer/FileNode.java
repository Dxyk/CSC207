package directory_explorer;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

/**
 * The root of a tree representing a directory structure.
 */
public class FileNode {

	/** The name of the file or directory this node represents. */
	private String name;
	/** Whether this node represents a file or a directory. */
	private FileType type;
	/** This node's parent. */
	private FileNode parent;
	/**
	 * This node's children, mapped from the file names to the nodes. If type is
	 * FileType.FILE, this is null.
	 */
	private Map<String, FileNode> children;

	/**
	 * A node in this tree.
	 *
	 * @param name
	 *            the file
	 * @param parent
	 *            the parent node.
	 * @param type
	 *            file or directory
	 * @see buildFileTree
	 */
	public FileNode(String name, FileNode parent, FileType type) {
		this.name = name;
		// TODO: complete this method.
		this.parent = parent;
		this.type = type;
		this.children = new HashMap<String, FileNode>();
		if (parent != null && parent.type != FileType.FILE){
			parent.addChild(this.name, this);
		}
	}

	/**
	 * Find and return a child node named name in this directory tree, or null
	 * if there is no such child node.
	 *
	 * @param name
	 *            the file name to search for
	 * @return the node named name
	 */
	public FileNode findChild(String name) {
		// TODO: complete this method.
		if (this.children.get(name) != null) {
			return this.children.get(name);
		} else {
			for (FileNode f : this.getChildren()) {
				if (f.type == FileType.DIRECTORY) {
					return f.findChild(name);
				}
			}
		}
		return null;
	}

	/**
	 * Return the name of the file or directory represented by this node.
	 *
	 * @return name of this Node
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name of the current node
	 *
	 * @param name
	 *            of the file/directory
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the child nodes of this node.
	 *
	 * @return the child nodes directly underneath this node.
	 */
	public Collection<FileNode> getChildren() {
		return this.children.values();
	}

	/**
	 * Return this node's parent.
	 * 
	 * @return the parent
	 */
	public FileNode getParent() {
		return parent;
	}

	/**
	 * Set this node's parent to p.
	 * 
	 * @param p
	 *            the parent to set
	 */
	public void setParent(FileNode p) {
		this.parent = p;
	}

	/**
	 * Add childNode, representing a file or directory named name, as a child of
	 * this node.
	 * 
	 * @param name
	 *            the name of the file or directory
	 * @param childNode
	 *            the node to add as a child
	 */
	public void addChild(String name, FileNode childNode) {
		this.children.put(name, childNode);
	}

	/**
	 * Return whether this node represents a directory.
	 * 
	 * @return whether this node represents a directory.
	 */
	public boolean isDirectory() {
		return this.type == FileType.DIRECTORY;
	}

	/**
	 * This method is for code that tests this class.
	 * 
	 * @param args
	 *            the command line args.
	 */
	public static void main(String[] args) {
		System.out.println("Testing FileNode");
		// f1
		FileNode f1 = new FileNode("top", null, FileType.DIRECTORY);
		if (!f1.getName().equals("top")) {
			System.out.println("Error: " + f1.getName() + " should be " + "top");
		}
		// check type and parent
		if (f1.getParent() != null) {
			System.out.println("Error: " + f1.getParent() + "should be null");
		}
		if (!f1.isDirectory()) {
			System.out.println("Error: f1 is directory (" + f1.isDirectory() + ") should be true");
		}
		// check children
		if (!f1.children.isEmpty()) {
			System.out.println("Error: " + f1.getName() + "should have no children now");
		}
		// add a child directory and check methods
		// f1
		FileNode child1 = new FileNode("child1", f1, FileType.DIRECTORY);
		// check findChild for directories
		if (!f1.findChild("child1").equals(child1)) {
			System.out.println("Error: find child method not right: top should have children child1");
		}
		// check findChild if file DNE
		if (f1.findChild("child3") != null) {
			System.out.println("Error: top doesn't have child3 as a child, so should return null");
		}
		// check f1.children
		if (f1.getChildren().isEmpty()) {
			System.out.println("Error: " + f1.getParent() + "should have children child1");
		}
		// add a child file and check methods
		FileNode child2 = new FileNode("child2", f1, FileType.FILE);
		// check children for files
		if (!child2.getChildren().isEmpty()) {
			System.out.println("Error: child2 should have no children");
		}
		// check findChild for files
		if (child2.findChild("1") != null) {
			System.out.println("Error: child2 have no children so should not find any child");
		}
		// create a node under child1
		FileNode child3 = new FileNode("child3", child1, FileType.FILE);
		// check child3 is under both top and child1
		if (!child1.findChild("child3").equals(child3)) {
			System.out.println("Error: child3 is under child2");
		}
		if (!f1.findChild("child3").equals(child3)) {
			System.out.println("Error: child3 is under child1. Should check recursion");
		}
	}

}
