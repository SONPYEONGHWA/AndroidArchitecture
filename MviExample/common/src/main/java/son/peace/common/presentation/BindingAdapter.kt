package son.peace.common.presentation

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("cornerRadius")
    fun ShapeableImageView.setRadius(radius: Float) {
        shapeAppearanceModel = ShapeAppearanceModel().withCornerSize(radius)
    }

    @JvmStatic
    @BindingAdapter("loadImage")
    fun ImageView.loadImage(url: String?) {
        url?.let { load(it) }
    }

    @JvmStatic
    @BindingAdapter("clipToOutLine")
    fun clipToOutLine(view: View, clipToOutLine: Boolean){
        view.clipToOutline = clipToOutLine
    }
}