package app.practice.androidpaging3multipleviewtype.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import app.practice.androidpaging3multipleviewtype.databinding.ViewArticleBinding
import app.practice.androidpaging3multipleviewtype.databinding.ViewLargeBannerBinding
import app.practice.androidpaging3multipleviewtype.domain.model.LargeBannerModel

class ViewLargeBanner @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0

) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = ViewLargeBannerBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    fun bind(item: LargeBannerModel) {

    }

}