import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DataDeletedFrame extends JFrame
{
	BinSearchTree bst;

	InputFileFrame inputFileFrame;

	private JPanel buttonPanel;
	private JPanel labelPanel;

	private JLabel warningLabel;
	private JButton okButton;
	private JButton cancelButton;

	private Container c;

	public DataDeletedFrame( BinSearchTree binTree )
	{
		super( "Are you sure?" );

		this.bst = binTree;

		buttonPanel = new JPanel();
		labelPanel = new JPanel();

		warningLabel = new JLabel( "The existing records will be deleted.\nDo you wish to continue?" );
		okButton = new JButton( "OK" );
		cancelButton = new JButton( "Cancel" );

		buttonPanel.add( cancelButton );
		buttonPanel.add( okButton );
		labelPanel.add( warningLabel );

		c = getContentPane();
		c.add( buttonPanel, "South" );
		c.add( labelPanel, "Center" );

		/* Add actions */
		okButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent evt )
			{	
				/* Remove all records from the search tree */
				bst.destroy();

				if( inputFileFrame == null )
					inputFileFrame = new InputFileFrame( bst );
				setVisible( false );
				inputFileFrame.setVisible( true );
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
