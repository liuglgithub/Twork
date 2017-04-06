package com.liugl.alltest.rsa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RSAMain2Activity extends BaseActivity {

    @BindView(R.id.entre)
    Button entre;
    @BindView(R.id.desjiam)
    Button desjiam;


    private String keypublicss = "";
    private String keyprivate = "";

    //	private static String toenstr = "jzgliugl";
    private String toenstr = "jzgliugl中国精真估";

    private byte[] tmp;
    private byte[] tmpde;

    private String result;
    private String deresult;

    Map<String,Object> keymap ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsamain2);
        ButterKnife.bind(this);
        try {
            keymap = RSAUtils.initKey();
            keypublicss = RSAUtils.getPublicKey(keymap);
            keyprivate = RSAUtils.getPrivateKey(keymap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.entre, R.id.desjiam})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.entre:
                try {
                    tmp = RSAUtils.encryptByPublicKey(toenstr.getBytes(), keypublicss);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                deresult = new String(tmp);
//                System.out.println("加密result = " + deresult);
                Log.e("rsa","加密前 = " + toenstr);
                Log.e("rsa","加密后 = " + deresult);
                break;
            case R.id.desjiam:
                try {
                    tmpde = RSAUtils.decryptByPrivateKey(tmp, keyprivate);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                result = new String(tmpde);

//                System.out.println("解密result = " + result);
                Log.e("rsa","解密后= " + result);
                break;
        }
    }


}
