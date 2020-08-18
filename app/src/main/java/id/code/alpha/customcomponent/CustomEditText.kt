package id.code.alpha.customcomponent

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.withStyledAttributes
import kotlinx.android.synthetic.main.view_custom_component.view.*

class CustomComponent : LinearLayout {
    private var attrs: AttributeSet? = null

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        initialize(attrs, defStyleAttr, defStyleRes)
    }

    constructor(context: Context) : super(context) {
        initialize(null, null, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initialize(attrs, null, null)
    }

    @SuppressLint("CustomViewStyleable")
    private fun initialize(
        attrs: AttributeSet?,
        defStyleAttr: Int?,
        defStyleRes: Int?
    ) {
        this.attrs = attrs
        LayoutInflater.from(context)
            .inflate(R.layout.view_custom_component, this, true)
        orientation = VERTICAL

        this.attrs?.let {
            context.withStyledAttributes(
                attrs,
                R.styleable.custom_component_attributes,
                defStyleAttr ?: 0,
                defStyleRes ?: 0
            ) {
                val warning = getString(R.styleable.custom_component_attributes_text_warning)

                isShowingWarning = getBoolean(
                    R.styleable.custom_component_attributes_show_warning,
                    false
                )
                showWarning(isShowingWarning)
                textWarning.text = warning
                editText.hint = warning
            }
        }
    }

    var isShowingWarning: Boolean = false
        get() = field
        set(value) {
            field = value
            showWarning(field)
        }

    private fun showWarning(status: Boolean) {
        if (status)
            textWarning.show()
        else
            textWarning.hide()
    }

    fun showWarning() {

    }

    fun hideWarning() {

    }
}