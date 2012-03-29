package ensf409.lab9.part1;

import ensf409.lab9.part1.Temperature.TemperatureType;
import java.lang.String;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TemperatureCalculatorActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button calcC = (Button) findViewById(R.id.calcC);
        Button calcF = (Button) findViewById(R.id.calcF);
        
        calcC.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				
				EditText tempValue = (EditText) findViewById( R.id.tempValue );
				EditText tempUnit = (EditText) findViewById( R.id.tempUnit );
				TextView resultValue = (TextView) findViewById( R.id.tempResult );
				
				TemperatureType type = null;
				String userUnit = tempUnit.getText().toString(); 
				double userTemp = Double.parseDouble( tempValue.getText().toString() );
				
				if( userUnit.compareTo("C") == 0 )
					type = Temperature.TemperatureType.TemperatureTypeCelsius;
				else if( userUnit.compareTo("F") == 0 )
					type = Temperature.TemperatureType.TemperatureTypeFahrenheit;
				
				Temperature T1 = new Temperature( userTemp, type );
				resultValue.setText( Double.toString(T1.toCelsius()) );
			} 
		});
        
        calcF.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				
				EditText tempValue = (EditText) findViewById( R.id.tempValue );
				EditText tempUnit = (EditText) findViewById( R.id.tempUnit );
				TextView resultValue = (TextView) findViewById( R.id.tempResult );
				
				TemperatureType type = null;
				String userUnit = tempUnit.getText().toString(); 
				double userTemp = Double.parseDouble( tempValue.getText().toString() );
				
				if( userUnit.compareTo("C") == 0 )
					type = Temperature.TemperatureType.TemperatureTypeCelsius;
				else if( userUnit.compareTo("F") == 0 )
					type = Temperature.TemperatureType.TemperatureTypeFahrenheit;

				Temperature T1 = new Temperature( userTemp, type );
				resultValue.setText( Double.toString(T1.toFahrenheit()) );
			}
		});
    }
}