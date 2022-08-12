package son.peace.common.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.children
import son.peace.common.R
import son.peace.common.extenstions.dpToPx
import son.peace.common.extenstions.getDeviceHeight

class AlertMessage @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = -1,
    private val rootViewGroup: ViewGroup,
    private val message: String = "",
    private val icon: Int? = null,
    private val textColor: Int? = null,
    private val background: Int? = null
): AppCompatTextView(context, attrs, defStyle) {

    init {
        text = message
        setBackground(ContextCompat.getDrawable(context, background ?: R.drawable.rectangle_black_alpha70_10dp))
        setTextColor(context.getColor(textColor ?: R.color.white))
        gravity = Gravity.CENTER_VERTICAL
        rootViewGroup.context.run {
            setPadding(24.dpToPx(this), 13.dpToPx(this), 24.dpToPx(this),13.dpToPx(this))
        }

        icon?.let {
            setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(context, it), null, null, null )
            compoundDrawablePadding = 12.dpToPx(rootViewGroup.context)
        }
        visibility = View.GONE
        setLayoutParams()
    }

    private fun setLayoutParams() {
        val params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        params.startToStart = rootViewGroup.id
        params.endToEnd = rootViewGroup.id
        layoutParams = params
    }

    fun setMessageVisibility(visible: Boolean) {
        if (visible && !rootViewGroup.children.contains(this)) {
            rootViewGroup.addView(this)
            visibility = View.GONE
        }
        val animationSet = AnimationSet(true)
        val alphaAnimation = if (visible) AlphaAnimation(0f, 1f) else  AlphaAnimation(1f, 0f)
        val translateAnimation = (rootViewGroup.context.getDeviceHeight() * 0.9).toFloat().let {
            if (visible) {
                TranslateAnimation(0f, 0f, it + 40f, it)
            } else {
                TranslateAnimation(0f, 0f, it, it + 40f)
            }
        }

        animationSet.run {
            duration = 700
            fillAfter = true
            addAnimation(alphaAnimation)
            addAnimation(translateAnimation)
            startAnimation(this)
        }

        animationSet.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {}
            override fun onAnimationStart(p0: Animation?) {
                visibility = View.VISIBLE
            }
            override fun onAnimationEnd(p0: Animation?) {
                if (!visible && rootViewGroup.children.contains(this@AlertMessage)) {
                    rootViewGroup.removeView(this@AlertMessage)
                }
            }
        })
    }
}