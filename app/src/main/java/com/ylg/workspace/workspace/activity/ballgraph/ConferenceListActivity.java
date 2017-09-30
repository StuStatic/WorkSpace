package com.ylg.workspace.workspace.activity.ballgraph;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.ListViewAdapter_ConferenceListActivity;
import com.ylg.workspace.workspace.bean.FindAllSpaceToAPP;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConferenceListActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView listView;
    private ListViewAdapter_ConferenceListActivity adapter;

    private ImageView iv_back;
    //toolbar标题文字内容
    private TextView title_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferencelist);
        init();
    }

    private void init() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        title_tv = (TextView) findViewById(R.id.tv_title);
        title_tv.setText("选择空间");

        listView = (ListView) findViewById(R.id.conferencelist_lv);

        getData();

    }

    private void getData() {
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        Call call = api.getSpaceListData1("c81e728d9d4c2f636f067f89cc14862c");

        call.enqueue(new Callback<FindAllSpaceToAPP>() {
            @Override
            public void onResponse(Call<FindAllSpaceToAPP> call, Response<FindAllSpaceToAPP> response) {
                FindAllSpaceToAPP service = response.body();
                Log.d("zp", "aaaaaaa:" + service.toString());
                if (service != null && service.getCode().equals("200")) {
                    adapter = new ListViewAdapter_ConferenceListActivity(service, ConferenceListActivity.this);
                    listView.setAdapter(adapter);
                    adapter.setSubClickListener1(new ListViewAdapter_ConferenceListActivity.SubClickListener1() {
                        @Override
                        public void OnTopicClickListener(int s1, String s2) {
                            Intent intent = new Intent();
                            intent.putExtra("spaceId",s1);
                            intent.putExtra("spaceName",s2);
                            setResult(100,intent);
                            finish();
                        }
                    });

                } else {
                    Toast.makeText(ConferenceListActivity.this, "请求失败..", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<FindAllSpaceToAPP> call, Throwable t) {
                Toast.makeText(ConferenceListActivity.this, "请求失败！", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

}
