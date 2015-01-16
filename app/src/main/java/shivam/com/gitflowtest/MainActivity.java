package shivam.com.gitflowtest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

import shivam.com.gitflowtest.model.Student;

public class MainActivity extends ActionBarActivity {


    private Button mBtnInsert, mBtnFetch;
    //private TextView mTxtMessage;
    private EditText mEdtRollNumber, mEdtName, mEdtPercentage;

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


        mBtnInsert = (Button) findViewById(R.id.btn_insert_data);
        mBtnFetch = (Button) findViewById(R.id.btn_fetch_data);
       // mTxtMessage = (TextView) findViewById(R.id.txt_message);

        mEdtName = (EditText) findViewById(R.id.edt_name);
        mEdtRollNumber = (EditText) findViewById(R.id.edt_roll_number);
        mEdtPercentage = (EditText) findViewById(R.id.edt_percentage);


        mBtnInsert.setOnClickListener(new HandleOnClick(R.id.btn_insert_data));
        mBtnFetch.setOnClickListener(new HandleOnClick(R.id.btn_fetch_data));
    }


    private class HandleOnClick implements View.OnClickListener  {

        private int mId;

        public HandleOnClick (int id) {

            mId = id;
        }

        @Override
        public void onClick(View view) {


            switch(mId) {

                case R.id.btn_insert_data:

                        if( (mEdtRollNumber.getText() != null && mEdtRollNumber.getText().toString().trim().length()>0) &&
                                (mEdtPercentage.getText() != null && mEdtPercentage.getText().toString().trim().length()>0) &&
                                (mEdtName.getText() != null && mEdtName.getText().toString().trim().length()>0)  )   {

                            try {

                                int number = Integer.parseInt(mEdtRollNumber.getText().toString().trim());
                                //Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();

                                try {

                                    double percentage = Double.parseDouble(mEdtPercentage.getText().toString().trim());

                                    if( percentage >= 100)  {

                                        throw new NumberFormatException();
                                    }
                                    String name = mEdtName.getText().toString().trim();

                                    insertData( name, number, percentage);
                                }
                                catch (NumberFormatException ex) {

                                    Toast.makeText(getApplicationContext(), "please enter a valid percentage ", Toast.LENGTH_SHORT).show();
                                }


                            }
                            catch(NumberFormatException ex) {

                                Toast.makeText(getApplicationContext(), "please enter a valid roll number ", Toast.LENGTH_SHORT).show();

                            }
                        }
                    else {

                            Toast.makeText(getApplicationContext(), " insufficient information.", Toast.LENGTH_SHORT).show();

                        }

                    break;



                case R.id.btn_fetch_data:

                    /*
                    private  String mFullName;
                    private  int mRollNo;
                    private double mPercentage;*/


                     fetchDataByName();

                    break;




            }

        }

    }


    private void insertData(String name, int number, double percentage) {

        Student student = new Student(name,number,percentage);
        student.save();

        Toast.makeText(getApplicationContext(), "student info saved successfully.", Toast.LENGTH_SHORT).show();

        mEdtName.setText("");
        mEdtRollNumber.setText("");
        mEdtPercentage.setText("");

    }


    private void fetchDataByName() {


        if( mEdtName.getText() != null && mEdtName.getText().toString().trim().length()>0) {

            List<Student> authors = Student.find(Student.class, "m_full_name = ?", ""+mEdtName.getText().toString().trim());

            for( Iterator<Student> iterator=authors.iterator(); iterator.hasNext(); ) {

                Student student = iterator.next();
                Log.i("Student Name is ",""+student.getmFullName());
                Log.i("Roll number is ",""+student.getmRollNo());
                Log.i("Percentage is ",""+student.getmPercentage());

            }

            Toast.makeText(getApplicationContext(), "don", Toast.LENGTH_SHORT).show();
        }

    }

}