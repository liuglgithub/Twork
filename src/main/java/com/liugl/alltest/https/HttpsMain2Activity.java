package com.liugl.alltest.https;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

public class HttpsMain2Activity extends BaseActivity {

    @BindView(R.id.no_cer_https_button6)
    Button noCerHttpsButton6;
    @BindView(R.id.yes_cer_https_button6)
    Button yesCerHttpsButton6;
    private OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_https_main2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.yes_cer_https_button6,R.id.no_cer_https_button6})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.no_cer_https_button6:
                getAsynHttp();
                break;
            case R.id.yes_cer_https_button6:
                try {
                    setCertificates(getAssets().open("srca.cer"));
//                    setCertificates(new Buffer().writeUtf8("").inputStream(), getAssets().open("zhy_server.cer"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    /**
     * 不使用证书，直接访问https链接
     */
    private void getAsynHttp() {
        mOkHttpClient = new OkHttpClient();
        Request.Builder requestBuilder = new Request.Builder().url("https://kyfw.12306.cn/otn/");
        //可以省略，默认是GET请求
        requestBuilder.method("GET", null);
        Request request = requestBuilder.build();
        Call mcall = mOkHttpClient.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.e("wangshu", "IOException---" + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (null != response.cacheResponse()) {
                    String str = response.cacheResponse().toString();
                    Log.i("wangshu", "cache---" + str);
                } else {
                    response.body().string();
                    String str = response.networkResponse().toString();
                    Log.i("wangshu", "network---" + str);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    public void setCertificates(InputStream... certificates) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates) {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));

                try {
                    if (certificate != null)
                        certificate.close();
                } catch (IOException e) {
                }
            }

            SSLContext sslContext = SSLContext.getInstance("TLS");

            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            trustManagerFactory.init(keyStore);
            sslContext.init(  null,  trustManagerFactory.getTrustManagers(),  new SecureRandom());

//            mOkHttpClient.sslSocketFactory(sslContext.getSocketFactory());

            mOkHttpClient = new OkHttpClient.Builder().sslSocketFactory(sslContext.getSocketFactory(),new X509TrustManager(){

                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            })  .build();

            Request.Builder requestBuilder = new Request.Builder().url("https://kyfw.12306.cn/otn/");
            //可以省略，默认是GET请求
            requestBuilder.method("GET", null);
            Request request = requestBuilder.build();
            Call mcall = mOkHttpClient.newCall(request);
            mcall.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                    Log.e("wangshu", "IOException---" + e.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (null != response.cacheResponse()) {
                        String str = response.cacheResponse().toString();
                        Log.i("wangshu", "cache---" + str);
                    } else {
                        response.body().string();
                        String str = response.networkResponse().toString();
                        Log.i("wangshu", "network---" + str);
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
