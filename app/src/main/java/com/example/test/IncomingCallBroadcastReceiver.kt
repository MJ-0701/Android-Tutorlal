//package com.example.test
//
//import android.annotation.SuppressLint
//import android.content.BroadcastReceiver
//import android.content.Context
//import android.content.Intent
//import android.telephony.PhoneNumberUtils
//import android.telephony.TelephonyManager
//import android.util.Log
//
//class IncomingCallBroadcastReceiver : BroadcastReceiver() {
//
//
//    @SuppressLint("UnsafeProtectedBroadcastReceiver")
//    override fun onReceive(context: Context, intent: Intent) {
//        Log.d(TAG, "onReceive()")
//
//        val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
//        mLastState = if (state == mLastState) {
//            return
//        } else {
//            state
//        }
//        if (TelephonyManager.EXTRA_STATE_RINGING == state) {
//            val incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
//            val phoneNumber = PhoneNumberUtils.formatNumber(incomingNumber)
//            val serviceIntent = Intent(context, CallingService::class.java)
//            serviceIntent.putExtra(CallingService.EXTRA_CALL_NUMBER, phoneNumber)
//            context.startService(serviceIntent)
//        }
//    }
//
//
//    companion object {
//
//        private const val TAG = "PHONE_STATE";
//        var mLastState : String? = null
//
//    }
//}