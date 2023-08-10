package com.example.recyclerview

import androidx.annotation.DrawableRes

sealed class ListItem {
    data class Header(val text: String): ListItem()
    data class TextItem(val text: String): ListItem()
    data class ImageItem(@DrawableRes val image: Int): ListItem()
}
