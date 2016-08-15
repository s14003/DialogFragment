package s14003.std.it_college.ac.jp.dialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements
        CommonDialogFragment.CommonDialogInterface.onClickListener,
        CommonDialogFragment.CommonDialogInterface.onItemClickListener,
        CommonDialogFragment.CommonDialogInterface.onShowListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openDialogListItems();
    }
    private void openDialogMessageType() {
        Bundle args = new Bundle();
        args.putInt(CommonDialogFragment.FIELD_TITLE, R.string.app_name);
        args.putInt(CommonDialogFragment.FIELD_MESSAGE, R.string.hello_world);
        args.putInt(CommonDialogFragment.FIELD_LABEL_POSITIVE, android.R.string.ok);
        CommonDialogFragment dialogFragment = new CommonDialogFragment();
        dialogFragment.setArguments(args);
        dialogFragment.show(getSupportFragmentManager(), "dialog1");
    }

    // original view
    private void openDialogOriginalView() {
        Bundle args = new Bundle();
        args.putInt(CommonDialogFragment.FIELD_TITLE, R.string.app_name);
        // 自分で定義したレイアウト
        args.putInt(CommonDialogFragment.FIELD_LAYOUT, R.layout.activity_main);
        args.putInt(CommonDialogFragment.FIELD_LABEL_POSITIVE, android.R.string.ok);
        args.putInt(CommonDialogFragment.FIELD_LABEL_NEGATIVE, android.R.string.cancel);
        CommonDialogFragment dialogFragment = new CommonDialogFragment();
        dialogFragment.setArguments(args);
        dialogFragment.show(getSupportFragmentManager(), "dialog2");
    }

    // list items
    private void openDialogListItems() {
        Bundle args = new Bundle();
        args.putInt(CommonDialogFragment.FIELD_TITLE, R.string.app_name);
        // 定義されてる文字なら
        args.putIntArray(CommonDialogFragment.FIELD_LIST_ITEMS, new int[] {R.string.item1, R.string.item2});
        // ソースで動的に文字列をつくるなら
        args.putStringArray(CommonDialogFragment.FIELD_LIST_ITEMS_STRING, new String[] {"item a", "item b"});
        args.putInt(CommonDialogFragment.FIELD_LABEL_NEGATIVE, android.R.string.cancel);
        args.putInt(CommonDialogFragment.FIELD_LABEL_NEUTRAL, android.R.string.selectAll);

        CommonDialogFragment dialogFragment = new CommonDialogFragment();
        dialogFragment.setArguments(args);
        dialogFragment.show(getSupportFragmentManager(), "dialog3");
    }



    @Override
    public void onDialogButtonClick(String tag, Dialog dialog, int which) {
        if ("dialog2".equals(tag)) {
            // dialog 2のクリック
            if (DialogInterface.BUTTON_POSITIVE == which) {
                // ok ボタンがおされた
            } else if (DialogInterface.BUTTON_NEGATIVE == which) {
                // cancel ボタンがおされた
            }
        }



    }

    @Override
    public void onDialogItemClick(String tag, Dialog dialog, String title, int which) {
        // title には押されたリストアイテムのもの
        // which には押されたリストアイテムのindex
        if ( ! "dialog3".equals(tag)) {
            return;
        }
        if (getString(R.string.item1).equals(title)) {
            // item 1 がおされた
        } else if ("item a".equals(title)) {
            // item a がおされた
        } else if (which == 3) {
            // 4番目 item b がおされた
        }
    }

    @Override
    public void onDialogShow(String tag, Dialog dialog) {
        // dialogが表示されたら
        // EditTextとかで初期値を動的にやりたい場合とかに使ってる
        if ( ! "dialog2".equals(tag)) {
            return;
        }
        EditText txt = (EditText) dialog.findViewById(R.id.name);
        txt.setText("hogehoge");
    }
}

