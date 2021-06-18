package app.practice.androidpaging3multipleviewtype.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import app.practice.androidpaging3multipleviewtype.databinding.ViewArticleBinding
import app.practice.androidpaging3multipleviewtype.domain.model.ArticleModel

class ViewArticle @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = ViewArticleBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    fun bind(item: ArticleModel) {
        binding.titleTextView.text = item.shelftTtle
    }

}