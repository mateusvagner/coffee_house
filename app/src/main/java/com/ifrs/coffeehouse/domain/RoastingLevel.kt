package com.ifrs.coffeehouse.domain

import androidx.annotation.ColorRes
import com.ifrs.coffeehouse.R

enum class RoastingLevel(@ColorRes val color: Int) {
    Low(R.color.colorRoastingLow),
    Medium(R.color.colorPrimaryVariant),
    High(R.color.colorPrimary)
}