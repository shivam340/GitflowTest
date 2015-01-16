package shivam.com.gitflowtest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {


    private Button mBtnClick, mBtnClick2;
    private TextView mTxtMessage;
    private EditText mEdtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initUi();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * initializes an Ui components
     */
    private void initUi() {

        mBtnClick = (Button) findViewById(R.id.btn_click_here1);
        mBtnClick2 = (Button) findViewById(R.id.btn_click_here2);
        mTxtMessage = (TextView) findViewById(R.id.txt_message);
        mEdtNumber = (EditText) findViewById(R.id.edt_number);

        mBtnClick.setOnClickListener(new HandleOnClick(R.id.btn_click_here1));
        mBtnClick2.setOnClickListener(new HandleOnClick(R.id.btn_click_here2));
    }


    private class HandleOnClick implements View.OnClickListener  {

        private int mId;

        public HandleOnClick (int id) {

            mId = id;
        }

        @Override
        public void onClick(View view) {


            switch(mId) {

                case R.id.btn_click_here1:

                    Toast.makeText(getApplicationContext(),"on click1", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btn_click_here2:

                        if( mEdtNumber.getText() != null && mEdtNumber.getText().toString().trim().length()>0 ) {

                            try {
                                int number = Integer.parseInt(mEdtNumber.getText().toString().trim());
                                Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
                            }
                            catch(NumberFormatException ex) {

                                Toast.makeText(getApplicationContext(), "please enter a valid number ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    else {

                            Toast.makeText(getApplicationContext(), " insufficient information.", Toast.LENGTH_SHORT).show();
                        }

                    break;

            }

        }

    }

}
