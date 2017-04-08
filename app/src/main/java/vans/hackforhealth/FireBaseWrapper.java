package vans.hackforhealth;


import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.google.android.gms.internal.zzt.TAG;

/**
 * Created by root on 8/4/17.
 */

public class FireBaseWrapper {

    //static Firebase myFirebaseRef = new Firebase("https://hackforhealth-76f5a.firebaseio.com/");
    FirebaseDatabase database;
    DatabaseReference myRef;

    String seedUrl="https://hackforhealth-76f5a.firebaseio.com";
    String dbProfile="Profile";
    String dbChat="Chat";
    String dbForum="Forum";



    public FireBaseWrapper() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReferenceFromUrl("https://hackforhealth-76f5a.firebaseio.com/");
        chatListener();
    }

    public void sendToCloud(String text){
        myRef.setValue(text);

        //myRef=myRef.push();
        Log.e("Hello",myRef.getKey());
    }

    public void sendUserDataToCloud(String val){
        database.getReference(dbProfile).push().setValue(val);
    }

    public void sendChatToCloud(String val){
        database.getReference(dbChat).push().setValue(val);
    }

    public void sendForumToCloud(String val){
        database.getReference(dbForum).push().setValue(val);
    }

    public void sendCommentToCloud(String val){
        database.getReference(dbProfile).push().setValue(val);
    }

    public void chatListener(){
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                ChatMsg post = dataSnapshot.getValue(ChatMsg.class);
                // [START_EXCLUDE]
               // mAuthorView.setText(post.author);
               // mTitleView.setText(post.title);
               // mBodyView.setText(post.body);
                // [END_EXCLUDE]
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // [START_EXCLUDE]
                // [END_EXCLUDE]
            }
        };
        database.getReference(dbChat).addValueEventListener(postListener);
    }

}
