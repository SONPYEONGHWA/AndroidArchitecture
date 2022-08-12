package son.peace.common.presentation

import android.content.Context
import android.view.ViewGroup

class AlertMessageBuilder(
    private val rootViewGroup: ViewGroup
) {
    private var message: String = ""
    private var icon: Int? = null
    private var textColor: Int? = null
    private var background: Int? = null

    fun build(): AlertMessage =
        AlertMessage(
            rootViewGroup = rootViewGroup,
            context = rootViewGroup.context,
            message = message,
            icon = icon,
            textColor = textColor,
            background = background
        )

    fun setMessage(message: String): AlertMessageBuilder {
        this.message = message
        return this
    }

    fun setIcon(icon: Int): AlertMessageBuilder {
        this.icon = icon
        return this
    }

    fun setTextColor(color: Int): AlertMessageBuilder {
        textColor = color
        return this
    }

    fun setBackground(drawable: Int): AlertMessageBuilder {
        background = drawable
        return this
    }
}