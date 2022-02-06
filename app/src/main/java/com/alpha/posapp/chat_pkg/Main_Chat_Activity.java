package com.alpha.posapp.chat_pkg;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.posapp.R;
import com.alpha.posapp.bean.HistoryData;
import com.apradanas.prismoji.PrismojiAutocompleteTextView;
import com.apradanas.prismoji.PrismojiManager;
import com.apradanas.prismoji.PrismojiPopup;
import com.apradanas.prismoji.listeners.OnSoftKeyboardCloseListener;
import com.apradanas.prismoji.one.PrismojiOneProvider;

import java.util.ArrayList;

public class Main_Chat_Activity extends AppCompatActivity implements View.OnClickListener, Main_Chat_Adapter.MyOrderAppOnclickListener {
    public ArrayList<HistoryData> chatList;
    RecyclerView chat_rv;
    ImageView iv_back;
    View toolbar;
    AppCompatTextView tv_title, tv_notification,tv_clearNotification;
    AppCompatImageView iv_notification;
    String userid;
    RelativeLayout rootView,rl_search,rl_notification;
    ImageButton emojiButton;
    PrismojiAutocompleteTextView prismojiEditText;
    PrismojiPopup prismojiPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_chat__personal_rv);

        PrismojiManager.install(new PrismojiOneProvider());

//        userid = AppSession.getStringPreferences(Notification_Activity.this, Constants.USER_ID);

        toolbar = findViewById(R.id.toolbar);
        tv_title = toolbar.findViewById(R.id.tv_tittle);
        iv_back = toolbar.findViewById(R.id.id_back);

        iv_back.setOnClickListener(this);

        tv_title.setText("John Deo");
        chat_rv = findViewById(R.id.id_rv_chat);

        chatList = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        chat_rv.setLayoutManager(linearLayoutManager);

//        =================

//        ================


        emojiButton = findViewById(R.id.main_activity_emoji);
        rootView = findViewById(R.id.main_activity_root_view);
        prismojiEditText = findViewById(R.id.main_activity_edit_text);

        emojiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                prismojiPopup.toggle();
                emojiButton.setImageResource(
                        prismojiPopup.isShowing() ?
                                R.drawable.ic_smile : R.drawable.ic_smile
                );
            }
        });

        prismojiPopup = PrismojiPopup.Builder.fromRootView(rootView)
                .setOnSoftKeyboardCloseListener(new OnSoftKeyboardCloseListener() {
                    @Override
                    public void onKeyboardClose() {
                        prismojiPopup.dismiss();
                    }
                })
                .into(prismojiEditText)
                .build();
//        ==============
//        ===========
        getVendoreList();
    }


    public void getVendoreList(){
        for(int i=0; i<8; i++){
            chatList.add(new HistoryData("Hey, Whats ur plan today ?"));
        }

        Main_Chat_Adapter adapter = new Main_Chat_Adapter(getApplicationContext(), chatList,this);
        chat_rv.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.id_notification:
//                startActivity(new Intent(Notification_Activity.this, Notification_Activity.class));
//                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
//                finish();
//                break;

            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

        }
    }

    @Override
    public void MyOrderAppOnclickListener(View view, int position, HistoryData orderList) {

    }
}
