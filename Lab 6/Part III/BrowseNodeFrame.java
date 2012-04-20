import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BrowseNodeFrame extends JFrame
{
	BinSearchTree bst;

	private JPanel buttonsPanel;
	private JPanel recordsPanel;
	private JButton back;
	private JTextArea records;

	private Container c;

	public BrowseNodeFrame( BinSearchTree bst )
	{
		super( "Browse" );

		buttonsPanel = new JPanel();
		recordsPanel = new JPanel();

		back = new JButton( "Back" );
		back.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent evt )
			{
				setVisible( false );
			}
		});
		buttonsPanel.add( back );

		records = new JTextArea();
		records.setEditable( false );
		recordsPanel.add( records );

		c = getContentPane();
		c.add( buttonsPanel, "South" );
		c.add( recordsPanel, "Center" );

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter( sw, true );
		try {
			bst.print_tree( bst.root, pw );
		} catch( IOException e ) {
			System.out.println( "Couldn't print." );
		}

		records.setText( "ID          " + "Faculty  " + "Major    " + "Year      \n" + sw.toString() );
		pw.close();

		this.pack();
	}
}
