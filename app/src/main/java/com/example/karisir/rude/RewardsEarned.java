package com.example.karisir.rude;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by vickieli on 2/20/16.
 */
public class RewardsEarned extends AppCompatActivity {


    ListView rewards;
    private PopupWindow pwindo;
    private ArrayAdapter<CharSequence> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        rewards = (ListView) findViewById(R.id.rewards_list);
        listAdapter = ArrayAdapter.createFromResource(this, R.array.rewards_earned, android.R.layout.simple_list_item_1);
        rewards.setAdapter(listAdapter);

        rewards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(RewardsEarned.this, "Redeemed!", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(RewardsEarned.this, RedeemReward.class);
//                intent.putExtra("which reward", i);
//                startActivity(intent);





            }
        });
    }

//    private void initiatePopup(int reward_num){
//        Toast.makeText(RewardsEarned.this, "this!", Toast.LENGTH_LONG).show();
//        ImageView reward_image = (ImageView) findViewById(R.id.reward_image);
//        TextView reward_title = (TextView) findViewById(R.id.reward_title);
//        TextView reward_details = (TextView) findViewById(R.id.reward_details);
//        String[] reward_title_array = getResources().getStringArray(R.array.rewards_earned);
//        String[] reward_details_array = getResources().getStringArray(R.array.rewards_details);
//
////        reward_title_text = reward_title_array[reward_num];
//        reward_title.setText(reward_title_array[reward_num]);
//        reward_details.setText(reward_details_array[reward_num]);
////        reward_image.setImageResource(R.id.reward_title_text);
//
//
//        LayoutInflater popupInflater = (LayoutInflater) RewardsEarned.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View Popup = popupInflater.inflate(R.layout.popup, (ViewGroup)findViewById(R.id.popup_layout));
//        pwindo = new PopupWindow(Popup, 300, 370, true);
//        pwindo.showAtLocation(Popup, Gravity.CENTER, 0, 0);
//
//    }
}
