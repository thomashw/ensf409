import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InsertNodeFrame extends JFrame
{
	BinSearchTree bst;
	private JPanel buttonsPanel;
	private JPanel newRecordPanel;
	private JButton insert;
	private JButton back;

	private JTextField studentIdField;
	private JTextField facultyField;
	private JTextField majorField;
	private JTextField yearField;

	private JLabel studentIdLabel;
	private JLabel facultyLabel;
	private JLabel majorLabel;
	private JLabel yearLabel;

	private Container c;

	public InsertNodeFrame( BinSearchTree binTree )
	{
		super( "Insert" );

		this.bst = binTree;
		buttonsPanel = new JPanel();
		newRecordPanel = new JPanel( new GridLayout( 4, 2 ) );

		/* Add the buttons */
		insert = new JButton( "Insert" );
		back = new JButton( "Back" );
		buttonsPanel.add( insert );
		buttonsPanel.add( back );

		/* Add the new record text fields & labels */
		studentIdField = new JTextField(10);
		facultyField = new JTextField(10);
		majorField = new JTextField(10);
		yearField = new JTextField(10);
		studentIdLabel = new JLabel( "Student ID:", SwingConstants.RIGHT );
		facultyLabel = new JLabel( "Faculty:", SwingConstants.RIGHT );
		majorLabel = new JLabel( "Major:", SwingConstants.RIGHT );
		yearLabel = new JLabel( "Year:", SwingConstants.RIGHT );

		newRecordPanel.add( studentIdLabel );
		newRecordPanel.add( studentIdField );
		newRecordPanel.add( facultyLabel );
		newRecordPanel.add( facultyField );
		newRecordPanel.add( majorLabel );
		newRecordPanel.add (majorField );
		newRecordPanel.add( yearLabel );
		newRecordPanel.add( yearField );

		c = getContentPane();
		c.add( buttonsPanel, "South" );
		c.add( newRecordPanel, "Center" );

		this.pack();

		/* Action listener for the back button */
		back.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent evt )
			{
				setVisible( false );
			}
		});

		/* Action listener for the insert button */
		insert.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent evt )
			{
				if( studentIdField.getText().length() <= 0 ) {
					System.out.println( "No student ID." );
					return;
				}

				if( facultyField.getText().length() <= 0 ) {
					System.out.println( "No faculty." );
					return;
				}

				if( majorField.getText().length() <= 0 ) {
					System.out.println( "No major." );
					return;
				}

				if( yearField.getText().length() <= 0 ) {
					System.out.println( "No year." );
					return;
				}

				bst.insert( studentIdField.getText(), facultyField.getText(), majorField.getText(), yearField.getText() );
			}
		});

		this.addWindowListener(
			new WindowAdapter()
			{
				public void WindowClosing( WindowEvent e )
				{
					setVisible( false );
				}
			});
	}
}
