package com.example.reshma.interactivestory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Story mStory = new Story();
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private Page mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText editText = (EditText) findViewById(R.id.EditText);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);

        loadPage(0);//When we launched our app it will show the story of **mPages[0]**
    }

    private void loadPage(int choice) {
        mCurrentPage = mStory.getPage(choice);

        String pageText = mCurrentPage.getText();
        mTextView.setText(pageText);
        mChoice1.setText(mCurrentPage.getChoice1().getText());
        mChoice2.setText(mCurrentPage.getChoice2().getText());

        //Now we are setting onClickListenere For each button and replace the story with new story

        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = mCurrentPage.getChoice1().getNextPage();//getting which next story
                loadPage(nextPage);// and replace with old story
            }
        });

        mChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = mCurrentPage.getChoice2().getNextPage();
                loadPage(nextPage);
            }
        });
    }
}


