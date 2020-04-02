package com.alexeykatsuro.themestylesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonChat = findViewById<FloatingActionButton>(R.id.button_chat)
        val buttonRecover = findViewById<Button>(R.id.button_recover)
        val labelForgetTextView = findViewById<TextView>(R.id.label_forget_password)
        val drawImageView = findViewById<ImageView>(R.id.icon_draw)



        val bottomSheetView = findViewById<View>(R.id.bottom_sheet)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView)
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) = Unit
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // this part hides the button immediately and waits bottom sheet
                // to collapse to show

                when(newState){
                    BottomSheetBehavior.STATE_DRAGGING,
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        buttonChat.animate().scaleX(0f).scaleY(0f).setDuration(300).start();
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        buttonChat.animate().scaleX(1f).scaleY(1f).setDuration(300).start();
                    }
                }
            }
        })

        val onPeekViewClick = View.OnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
        labelForgetTextView.setOnClickListener(onPeekViewClick)
        drawImageView.setOnClickListener(onPeekViewClick)

        buttonRecover.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }
}
