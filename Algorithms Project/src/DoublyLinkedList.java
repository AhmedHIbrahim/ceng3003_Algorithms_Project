public class DoublyLinkedList {
	DLL_Node headNameNode;
	DLL_Node lastNameNode;

	// Pushing new name in front of the Doubly Linked List
	public void push(String name) {

		// Create new Node for the name
		DLL_Node newNameNode = new DLL_Node(name);

		// Bind the new node : next to current nameNode ; previous: null
		newNameNode.next = headNameNode;

		newNameNode.previous = null;

		// if the currentNode exists; bind its previous to the newNameNode
		if (headNameNode != null) {

			headNameNode.previous = newNameNode;
 
		}
		else{

			lastNameNode= newNameNode;
			headNameNode = newNameNode;
		}
		headNameNode = newNameNode;
		

	}

	public void searchForNode(String name) {
		// TODO Auto-generated method stub

		// Start searching from headNode
		DLL_Node currentNode = headNameNode;
		// indexing from 1
		int index = 1;
		// status, Found the given name or not
		boolean status = false;

		// if headNode is null
		if (headNameNode == null) {
			System.out.println("The Doubly Linked List is empty!");
			return;
		}

		// progress to next node while currentNode is not null
		while (currentNode != null) {
			// Check if name is found,
			if (currentNode.name.equals(name)) {
				status = true;
				break;
			} else {
				// Otherwise, progress the index, and the current node
				currentNode = currentNode.next;
				index++;
			}
		}

		// Check if status is true(The name is found)
		if (status) {
			System.out
					.println("Found name: " + name + ", at " + index + " index, ");
		} else {
			System.out.println("Name is not present in the list");
		}

	}
}
