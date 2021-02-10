package com.jidekrm.transitiondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.jidekrm.transitiondemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myLayout.setOnTouchListener{ v: View, m:MotionEvent ->
            handleTouch()
            true

        }


    }

    private fun handleTouch() {
        val changeBounds = ChangeBounds()
        changeBounds.duration = 3000
        changeBounds.interpolator = BounceInterpolator()
        TransitionManager.beginDelayedTransition(binding.myLayout, changeBounds)
        binding.myButton.minWidth = 500
        binding.myButton.minHeight = 350

        val set = ConstraintSet()


        set.connect(R.id.myButton, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)
        set.connect(R.id.myButton, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0)
        set.constrainWidth(R.id.myButton, ConstraintSet.WRAP_CONTENT)
        set.applyTo(binding.myLayout)
        println("updated")


    }
}