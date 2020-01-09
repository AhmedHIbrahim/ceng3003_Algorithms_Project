import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {

		// Reading from Names_file
		if (args.length <= 0) {
			System.out.println("Please, Enter valid path");
		} else {

			File namesFile = new File(args[0]);

			if (namesFile.isFile()) {

				FileReader namesFileReader;

				BufferedReader bufferReader;

				AVL_Tree tree = new AVL_Tree();
				
				DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

				try {
					namesFileReader = new FileReader(namesFile);

					bufferReader = new BufferedReader(namesFileReader);

					String word;

					while ((word = bufferReader.readLine()) != null) {

						tree.root = tree.insert(tree.root, word);
						doublyLinkedList.push(word);

					}
					// Calculating the time it takes to search "Tugba" in AVL
					// tree
					
					
					String name = "Tugba";
					
					
					//Search in the doublyLinkedList
					System.out.println("Doubly LinkedList: Search(\""+ name +"\")");
					
					
					{
						long start_doublyLL_search = System.nanoTime();
						doublyLinkedList.searchForNode(name);

						long end_doublyLL_search = System.nanoTime();

						System.out.println(end_doublyLL_search);
						System.out.println(start_doublyLL_search);
						
						System.out.println("That took " + (end_doublyLL_search - start_doublyLL_search)
								+ " nanoseconds, to check if Tugba exists in the doubly linkedList.");

					}
					
					System.out.println("**************");
					{
					System.out.println("AVL tree: Search(\""+ name +"\")");
					
					long start_AVL_tree_search = System.nanoTime();

					tree.Search(tree.root, name);

					long end_AVL_tree_search = System.nanoTime();

					System.out.println(start_AVL_tree_search);
					System.out.println(end_AVL_tree_search);
					
					System.out.println("That took " + (end_AVL_tree_search - start_AVL_tree_search)
							+ " nanoseconds, to check if "+ name +" exists in the in the AVL Tree.");

					}
					System.out.println("**************");
					
					

					
				} catch (Exception e) {

					// TODO Auto-generated catch block
					e.printStackTrace();

				}
			}
			else{
				System.out.println("invalid file path");
			}
		}
	}

}
