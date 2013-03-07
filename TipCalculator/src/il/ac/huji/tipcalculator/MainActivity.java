package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	private static final double TIP_RATIO = 0.12;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnCalculate = (Button)findViewById(R.id.btnCalculate);
		final EditText edtBillAmount = (EditText)findViewById(R.id.edtBillAmount);
		final CheckBox chkRound = (CheckBox)findViewById(R.id.chkRound);
		final TextView txtTipResult = (TextView)findViewById(R.id.txtTipResult);

		btnCalculate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				double amount = Double.parseDouble(edtBillAmount.getText().toString());		
				double tip = amount * TIP_RATIO;
				boolean rounded = chkRound.isChecked();
				String result = rounded ? String.format("Tip: $%.0f", tip) : String.format("Tip: $%.2f", tip);
				txtTipResult.setText(result);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
