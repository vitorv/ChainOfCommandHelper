package com.example.chainofcommandhelper.ui.tables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TableModel(
    @StringRes val titleResId: Int,
    @DrawableRes val imageResId: Int,
    val searchableString: String)