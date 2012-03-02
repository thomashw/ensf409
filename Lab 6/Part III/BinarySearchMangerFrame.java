import javax.swing.*;
import java.awt.*;

public class BinarySearchMangerFrame extends JApplet {

	private static final long serialVersionUID = 1L;

	private BinSearchTree bst;
	private JPanel buttonsPanel;
	private JButton insertButton;
	private JScrollPane screenPanel;
	private JTextArea outputScreen;
	private InsertNodeFrame ins;
	private Container c;

	private void initComponents() // define
	{
		
	}
	

	public BinarySearchMangerFrame () 
	{
		// create an empty tree
		bst = new BinSearchTree();
		
		// create and initialize the components
		ins = new InsertNodeFrame(bst); 
		buttonsPanel = new JPanel(); 
		insertButton = new JButton(“Insert”); 
		screenPanel = new JScrollPane(); 
		outputScreen = new JTextArea(); 
		outputScreen.setEditable(false);
		// CREATE AND INITIALIZE MORE COMPONENTS AS NEED
		
		// get a reference to the frame’s container and add 
		// a panel to the container
		c = getContentPane();
		
		buttonsPanel.add(insert);
		// ADD MORE COMPONENTS TO THE PANELS AS NEEDED
		
		c.add(buttonsPanel, "South");
		// ADD MORE PANELS TO THE CONTAINER AS NEEDED
		
		// create an anonymous ActionListener object to
		// listen to insert-button event 
		insertButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed( ActionEvent evt)
			{ 
				// ADD CODE TO IMPLEMENT THE PROCESS OF
				// OF INSERTING A NEW NODE TO THE TREE
			} 
		});
		screenPanel.setViewportView(outputScreen); 
		c.add(screenPanel, "Centre");
		pack();
	}
	
	// ADD MORE ActionPerformed METHODS AS NEEDED
}
