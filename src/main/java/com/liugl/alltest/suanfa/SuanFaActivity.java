package com.liugl.alltest.suanfa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuanFaActivity extends AppCompatActivity {

    @BindView(R.id.maopao)
    Button maopao;

    @BindView(R.id.charu)
    Button charu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suan_fa);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.zhong_hou,R.id.charu,R.id.maopao})
    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.maopao:
//                bubbleSort();
                posSort();
                break;
            case R.id.charu:
                main();
                break;
            case R.id.zhong_hou:
//      MidleTurnToBehind testStacknew = new MidleTurnToBehind("A+B*(C-D)/E+F/H");
//      MidleTurnToBehind testStacknew = new MidleTurnToBehind("a+b*c+(d*e+f)*g");
                MidleTurnToBehind testStacknew = new MidleTurnToBehind("a-b-c");
//      MidleTurnToBehind testStacknew = new MidleTurnToBehind("ac");
//        testStacknew.anaysisStr();
                testStacknew.anaysis();
                break;
        }
    }

    /*插入排序start*/
    public   void sort(Integer[] arr){
        int j;
        for(int p=1;p<arr.length;p++){

            Integer tmp = arr[p];
            for(j=p;j>0 && tmp.compareTo(arr[j-1])<0;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;

        }
    }

    void sor(Integer[] arr){

        int j;
        for(int p = 1;p<arr.length;p++){
            Integer tmp = arr[p];
            for(j = p; j>0 && tmp.compareTo(arr[j-1]) < 0;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }

    }

    public   void main( ) {
        Integer[] arr = new Integer[]{10 ,45  ,3 ,54 ,1 ,2 ,0 ,4 ,98 ,33 };
//      此处说明传递的时候引用
        sort(arr);
        System.out.println();

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    /*插入排序end*/


    //冒泡算法1
    public void bubbleSort() {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }

            Log.e("maopao", "===================================");
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < a.length; k++) {
                sb.append(a[k] + " ");

            }
            Log.i("maopao", sb.toString());
        }
    }

    /**
     * 对位置进行排序，每次遍历后，就把前面几个排序完成
     */
    public void posSort() {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        int temp = 0;

        for (int i = 0; i < a.length - 1; i++) {

            for (int j = i + 1; j < a.length - 1; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            Log.e("maopao", "===================================");
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < a.length; k++) {
                sb.append(a[k] + " ");
            }
            Log.i("maopao", sb.toString());

        }
    }

}
