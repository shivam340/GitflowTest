package shivam.com.gitflowtest.model;

import android.content.Context;

import com.orm.SugarRecord;

/**
 * Created by shivam on 1/16/15.
 */
public class Student extends SugarRecord<Student> {

    String mFullName;
    int mRollNo;
    double mPercentage;

    public Student() {

    }

    public Student(String fullName, int rollNo , double percentage) {

        mFullName = fullName;
        mRollNo = rollNo;
        mPercentage = percentage;

    }


    public String getmFullName() {
        return mFullName;
    }

    public void setmFullName(String mFullName) {
        this.mFullName = mFullName;
    }

    public int getmRollNo() {
        return mRollNo;
    }

    public void setmRollNo(int mRollNo) {
        this.mRollNo = mRollNo;
    }

    public double getmPercentage() {
        return mPercentage;
    }

    public void setmPercentage(double mPercentage) {
        this.mPercentage = mPercentage;
    }
}