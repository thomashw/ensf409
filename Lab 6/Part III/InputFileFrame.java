import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class InputFileFrame extends JFrame
{
	BinSearchTree bst;

	private JPanel buttonPanel;
	private JPanel filePanel;

	private JLabel label;
	private JTextField fileField;

	private JButton okButton;
	private JButton cancelButton;

	private Container c;

	public InputFileFrame( BinSearchTree binTree )
	{
		super( "File" );

		this.bst = binTree;

		label = new JLabel( "Enter the file name:" );
		fileField = new JTextField(20);

		filePanel = new JPanel();
		filePanel.add( label );
		filePanel.add( fileField );

		okButton = new JButton( "OK" );
		cancelButton = new JButton( "Cancel" );
		buttonPanel = new JPanel();
		buttonPanel.add( cancelButton );
		buttonPanel.add( okButton );

		c = getContentPane();
		c.add( buttonPanel, "South" );
		c.add( filePanel, "Center" );

		/* Add action listeners */
		okButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent evt )
			{
				File file = new File( fileField.getText() );

				Scanner input = null;
				try {
					input = new Scanner( file );
				} catch( FileNotFoundException e ) {
					System.err.println( "File not found" );
					return;
				}

				while( input.hasNext() ) {
					/* Add records from the file */
					bst.insert( input.next(), input.next(), input.next(), input.next() );
				}

				setVisible( false );
			}
		});

		cancelButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent evt )
			{
				setVisible( false );
			}
		});

		pack();
	}
}
