import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FindFrame extends JFrame
{
	BinSearchTree bst;
	private JPanel labelPanel;
	private JPanel buttonPanel;

	private JLabel label;
	private JTextField studentIdField;
	private JButton okButton;
	private JButton cancelButton;

	private Container c;

	public FindFrame( BinSearchTree binTree )
	{
		super( "Find" );

		this.bst = binTree;

		okButton = new JButton( "OK" );
		cancelButton = new JButton( "Cancel" );
		buttonPanel = new JPanel();
		buttonPanel.add( cancelButton );
		buttonPanel.add( okButton );

		label = new JLabel( "Enter the student's ID." );
		studentIdField = new JTextField(10);
		labelPanel = new JPanel();
		labelPanel.add( label );
		labelPanel.add( studentIdField );

		c = getContentPane();
		c.add( labelPanel, "Center" );
		c.add( buttonPanel, "South" );

		/* Add actions */
		okButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent evt )
			{	
				Node n = bst.find( bst.root, studentIdField.getText() );

				if( n != null ) {
					JOptionPane.showMessageDialog( null, "Student ID: " + n.data.id + "\nFaculty: " + n.data.faculty + "\nMajor: " + n.data.major + "\nYear: " + n.data.year, "Student Found", JOptionPane.INFORMATION_MESSAGE );
				} else {
					JOptionPane.showMessageDialog( null, "Couldn't find student." );
				}
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
