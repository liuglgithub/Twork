package com.liugl.alltest.utils;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liugl on 2017/2/25.
 */

public class CommonUtils {

    /**
     * 设备的唯一标识
     *
     * @param
     * @return
     */
    public static String devUniqueID() {

//        TelephonyManager TelephonyMgr = (TelephonyManager) mContext.getSystemService(mContext.TELEPHONY_SERVICE);
//        String szImei = TelephonyMgr.getDeviceId();

        //we make this look like a valid IMEI
        String m_szDevIDShort = "35" +
                Build.BOARD.length() % 10 +
                Build.BRAND.length() % 10 +
                Build.CPU_ABI.length() % 10 +
                Build.DEVICE.length() % 10 +
                Build.DISPLAY.length() % 10 +
                Build.HOST.length() % 10 +
                Build.ID.length() % 10 +
                Build.MANUFACTURER.length() % 10 +
                Build.MODEL.length() % 10 +
                Build.PRODUCT.length() % 10 +
                Build.TAGS.length() % 10 +
                Build.TYPE.length() % 10 +
                Build.USER.length() % 10; //13 digits

        String m_szLongID = "imei" + m_szDevIDShort;
        Log.e("devid undes", m_szLongID);
// compute md5
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        m.update(m_szLongID.getBytes(), 0, m_szLongID.length());
// get md5 bytes
        byte p_md5Data[] = m.digest();
// create a hex string
        String m_szUniqueID = new String();
        for (int i = 0; i < p_md5Data.length; i++) {
            int b = (0xFF & p_md5Data[i]);
// if it is a single digit, make sure it have 0 in front (proper padding)
            if (b <= 0xF)
                m_szUniqueID += "0";
// add number to string
            m_szUniqueID += Integer.toHexString(b);
        }   // hex string to uppercase
        m_szUniqueID = m_szUniqueID.toUpperCase();
        return m_szUniqueID;
    }

}
