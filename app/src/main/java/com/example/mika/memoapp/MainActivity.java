package com.example.mika.memoapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //タイトル入力欄
    private EditText titleEditText;
    //コメント入力欄
    private EditText commentEditText;
    //電話番号入力欄
    private EditText phoneEditText;
    // プリファレンス(ふぁいるみたいな)キーと実データのペア」で保存
    private SharedPreferences preferences;

    //タイトル保存用のキー
    private static final String KEY_TITLE = "title";
    //コメント保存用のキー
    private static final String KEY_COMMENT = "comment";

    //電話番号保存用キー
    public static final String KEY_PHONE = "phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //// レイアウトより入力欄を取得
        titleEditText = (EditText) findViewById(R.id.main_title_etx);
        commentEditText = (EditText) findViewById(R.id.main_comment_etx);
        phoneEditText = (EditText) findViewById(R.id.main_phone_etx);

        //プリファレンスをデフォルト名で作成(保存用のファイルを作成するというイメージ)
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        // プリファレンスにデータが保存されていれば、保存されているデータをセットする
        // タイトル
        String title = preferences.getString(KEY_TITLE, "");
        titleEditText.setText(title);

        // コメント
        String comment = preferences.getString(KEY_COMMENT, "");
        commentEditText.setText(comment);

        String phone = preferences.getString(KEY_PHONE, "");
        phoneEditText.setText(phone);

        // 保存ボタンにリスナーを設定する
        Button saveBtn = (Button) findViewById(R.id.main_save_btn);
        saveBtn.setOnClickListener(this);

        // 削除ボタンにリスナーを設定する
        Button deleteBtn = (Button) findViewById(R.id.main_delete_btn);
        deleteBtn.setOnClickListener(this);

        // レイアウト(activity_main.xml)より、「占う」ボタン(IDがmain_btn_divine)を取得
        Button calenderBtn = (Button) findViewById(R.id.main_calender_btn);

        //占うボタンにリスナーを設定
        calenderBtn.setOnClickListener(this);

    }

    @Override
        public void onClick(View view) {

            // プリファレンスエディタの初期化
            SharedPreferences.Editor editor = preferences.edit();
            switch (view.getId()) {
                case R.id.main_save_btn:
                    // 入力されているデータを取得
                    String title = titleEditText.getText().toString();
                    String comment = commentEditText.getText().toString();
                    String phone = phoneEditText.getText().toString();

                    // プリファレンスにデータを保存
                    editor.putString(KEY_TITLE, title);
                    editor.putString(KEY_COMMENT, comment);
                    editor.putString(KEY_PHONE, phone);
                    editor.commit();

                    // Toastを表示し、保存が完了した旨を通知する
                    Toast.makeText(view.getContext(), "保存しました。", Toast.LENGTH_SHORT).show();
                    break;

                //削除ボタンが押された場合
                case R.id.main_delete_btn:

                    //プリファレンスからデータを削除
                    editor.remove(KEY_TITLE);
                    editor.remove(KEY_COMMENT);
                    editor.remove(KEY_PHONE);
                    editor.commit();//上書き保存

                    //入力欄を空にする
                    titleEditText.setText("");
                    commentEditText.setText("");
                    phoneEditText.setText("");

                    // Toastを表示し、削除が完了した旨を表示する
                    Toast.makeText(this,"削除しました。",Toast.LENGTH_SHORT).show();
                    break;

                switch (view.getId()) {
                    case R.id.main_calender_btn:
                        Intent intent4 = new Intent(this,CalendarActivity.class);

                        //画面遷移開始
                        startActivity(intent4);
                        break;
            }

    }
}
