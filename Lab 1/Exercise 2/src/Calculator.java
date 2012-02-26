import java.io.*;
import java.lang.String;

enum Operator {
	OperatorNone,
	OperatorMultiply,
	OperatorSubtract,
	OperatorAdd,
	OperatorDivide,
	OperatorModulus
};

public class Calculator {
	
	private double left_op, right_op;
	private Operator op = Operator.OperatorNone;
	
	public Calculator( String left_op, String right_op, String operator )
	{
		this.left_op = Double.parseDouble(left_op);
		this.right_op = Double.parseDouble(right_op);
		
		char char_op = operator.charAt(0);
		
		/* Get operator */
		if( char_op == 'x' ) {
			this.op = Operator.OperatorMultiply;
		} else if( char_op == '-' ) {
			this.op = Operator.OperatorSubtract;
		} else if( char_op == '%' ) {
			this.op = Operator.OperatorModulus;
		} else if( char_op == '+' ) {
			this.op = Operator.OperatorAdd;
		} else if( char_op == '/' ) {
			this.op = Operator.OperatorDivide;
		} else {
			System.out.println( "Error: invalid operator. Exiting." );
			System.exit(1);
		}
	}

	public double multiply()
	{
		return this.left_op * this.right_op;
	}

	public double add()
	{
		return this.left_op + this.right_op;
	}

	public double subtract()
	{
		return this.left_op - this.right_op;
	}

	public double divide()
	{
		return this.left_op / this.right_op;
	}

	public double remainder()
	{
		return this.left_op % this.right_op;
	}

	public static void main( String[] args )
	{
		if( args.length < 3 )
			return;

		Calculator calc = new Calculator(args[0], args[2], args[1]);

		switch( calc.op ) {
			case OperatorMultiply:
				System.out.println( args[0] + " " + args[1] + " " + args[2] + " = " + Double.toString( calc.multiply() ));
			break;
			case OperatorSubtract:
				System.out.println( args[0] + " " + args[1] + " " + args[2] + " = " + Double.toString( calc.subtract() ));
			break;
			case OperatorAdd:
				System.out.println( args[0] + " " + args[1] + " " + args[2] + " = " + Double.toString( calc.add() ));
			break;
			case OperatorDivide:
				System.out.println( args[0] + " " + args[1] + " " + args[2] + " = " + Double.toString( calc.divide() ));
			break;
			case OperatorModulus:
				System.out.println( args[0] + " " + args[1] + " " + args[2] + " = " + Double.toString( calc.remainder() ));
			break;
			default:
				break;
		}
	}
}
