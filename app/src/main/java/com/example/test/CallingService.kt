//package com.example.test
//
////noinspection SuspiciousImport
//
//import android.annotation.SuppressLint
//import android.app.Service
//import android.content.Intent
//import android.graphics.PixelFormat
//import android.os.IBinder
//import android.text.TextUtils
//import android.view.LayoutInflater
//import android.view.MotionEvent
//import android.view.View
//import android.view.View.OnTouchListener
//import android.view.WindowManager
//import android.widget.TextView
//import butterknife.ButterKnife
//import butterknife.InjectView
//import butterknife.OnClick
//
//
//class CallingService : Service() {
//
//
//    private var rootView: View? = null
//
//
//    @SuppressLint("NonConstantResourceId")
//    @InjectView(R.id.tv_call_number)
//    var tvCallNumber: TextView? = null
//
//    var callNumber: String? = null
//
//    var params: WindowManager.LayoutParams? = null
//    private var windowManager: WindowManager? = null
//
//
//    override fun onBind(intent: Intent?): IBinder? {
//
//        // Not used
//        return null
//    }
//
//    @SuppressLint("InflateParams")
//    override fun onCreate() {
//        super.onCreate()
//        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
//        val display = windowManager!!.defaultDisplay
//        val width = (display.width * 0.9).toInt() //Display 사이즈의 90%
//        params = WindowManager.LayoutParams(
//            width,
//            WindowManager.LayoutParams.WRAP_CONTENT,
//            WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
//            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
//                    or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
//                    or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
//                    or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
//            PixelFormat.TRANSLUCENT
//        )
//        val layoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        rootView = layoutInflater.inflate(R.layout.call_popup_top, null)
//        ButterKnife.inject(this, rootView)
//        setDraggable()
//    }
//
//
//    private fun setDraggable() {
//        rootView!!.setOnTouchListener(object : OnTouchListener {
//            private var initialX = 0
//            private var initialY = 0
//            private var initialTouchX = 0f
//            private var initialTouchY = 0f
//            override fun onTouch(v: View, event: MotionEvent): Boolean {
//                when (event.action) {
//                    MotionEvent.ACTION_DOWN -> {
//                        initialX = params!!.x
//                        initialY = params!!.y
//                        initialTouchX = event.rawX
//                        initialTouchY = event.rawY
//                        return true
//                    }
//
//                    MotionEvent.ACTION_UP -> return true
//                    MotionEvent.ACTION_MOVE -> {
//                        params!!.x = initialX + (event.rawX - initialTouchX).toInt()
//                        params!!.y = initialY + (event.rawY - initialTouchY).toInt()
//                        if (rootView != null) windowManager!!.updateViewLayout(rootView, params)
//                        return true
//                    }
//                }
//                return false
//            }
//        })
//    }
//
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        windowManager!!.addView(rootView, params)
//        setExtra(intent)
//        if (!TextUtils.isEmpty(callNumber)) {
//            tvCallNumber!!.text = callNumber
//        }
//        return START_REDELIVER_INTENT
//    }
//
//
//    private fun setExtra(intent: Intent?) {
//        if (intent == null) {
//            removePopup()
//            return
//        }
//        callNumber = intent.getStringExtra(EXTRA_CALL_NUMBER)
//    }
//
//
//    override fun onDestroy() {
//        super.onDestroy()
//        removePopup()
//    }
//
//    @SuppressLint("NonConstantResourceId")
//    @OnClick(R.id.btn_close)
//    fun removePopup() {
//        if (rootView != null && windowManager != null) windowManager!!.removeView(rootView)
//    }
//
//    companion object {
//        const val EXTRA_CALL_NUMBER = "call_number"
//    }
//
//
//}
