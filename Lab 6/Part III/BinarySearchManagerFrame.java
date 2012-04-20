import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BinarySearchManagerFrame extends JFrame
{
	BinSearchTree bst;
	private JPanel buttonsPanel;
	private JScrollPane screenPanel;
	private JTextArea textArea;
	private InsertNodeFrame insertFrame;
	private BrowseNodeFrame browseFrame;
	private DataDeletedFrame createTreeFrame;
	private FindFrame findFrame;

	/* Buttons */
	private JButton insertButton;
	private JButton findButton;
	private JButton browseButton;
	private JButton createTreeButton;

	private Container c;

	public BinarySearchManagerFrame()
	{
		super( "Student Records" );

		bst = new BinSearchTree();

		buttonsPanel = new JPanel();
		screenPanel = new JScrollPane();
		textArea = new JTextArea();
		textArea.setEditable( false );
		textArea.insert( "This application allows a user to manage and maintain records of students.\n\nIt allows the user to:\n    -create a list of records using a Binary Search Tree\n    -insert new students\n    -delete students from the Tree\n    -search for students using their ID", 0 );

		/* Init buttons */
		insertButton = new JButton( "Insert" );
		findButton = new JButton( "Find" );
		browseButton = new JButton( "Browse" );
		createTreeButton = new JButton( "Create tree from..." );

		c = getContentPane();

		/* Add buttons to button panel */
		buttonsPanel.add( insertButton );
		buttonsPanel.add( findButton );
		buttonsPanel.add( browseButton );
		buttonsPanel.add( createTreeButton );

		/* Add buttons panel to the container */
		c.add( buttonsPanel, "South" );

		/* Actions */
		insertButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent evt )
			{
				if( insertFrame == null )
					insertFrame = new InsertNodeFrame( bst );
				insertFrame.setVisible( true );
			}
		});

		browseButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent evt )
			{
				browseFrame = new BrowseNodeFrame( bst );
				browseFrame.setVisible( true );
			}
		});

		createTreeButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent evt )
			{
				if( createTreeFrame == null )
					createTreeFrame = new DataDeletedFrame( bst );
				createTreeFrame.setVisible( true );
			}
		});

		findButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent evt )
			{
				if( findFrame == null )
					findFrame = new FindFrame( bst );
				findFrame.setVisible( true );
			}
		});

		screenPanel.setViewportView( textArea );
		c.add( screenPanel, "Center" );
		
		this.pack();
		this.setVisible( true );
	}

	public static void main( String[] args )
	{
		BinarySearchManagerFrame bsmf = new BinarySearchManagerFrame();
	}
}
