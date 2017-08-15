package com.ylg.workspace.workspace.wxapi;




import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
	
	private static final String TAG = "dyy";
	
    private IWXAPI api;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.pay_result);
        
    	api = WXAPIFactory.createWXAPI(this, App.App_ID);
        api.handleIntent(getIntent(), this);
    }

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
        api.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq req) {
		Log.d(TAG, "onPayFinish, errCode = " + req.toString());
	}

	@Override
	public void onResp(BaseResp resp) {
		Log.d(TAG, "onPayFinish, errCode = " + resp.errCode);

		if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("提示");
			builder.setMessage(getString(R.string.action_sign_in, String.valueOf(resp.errCode)));
			builder.show();
			if (resp.errCode==0){
				Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
			}else if (resp.errCode==-1){
				Toast.makeText(this, "支付错误", Toast.LENGTH_SHORT).show();
//				finish();
			}else if (resp.errCode==-2){
				Toast.makeText(this, "取消支付", Toast.LENGTH_SHORT).show();
				finish();
			}
		}
	}
}