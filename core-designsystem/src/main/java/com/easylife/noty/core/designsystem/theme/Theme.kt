package com.easylife.noty.core.designsystem.theme

import androidx.compose.material3.lightColorScheme
import com.easylife.diary.core.designsystem.theme.alabaster
import com.easylife.diary.core.designsystem.theme.black
import com.easylife.diary.core.designsystem.theme.darkGray
import com.easylife.diary.core.designsystem.theme.gold
import com.easylife.diary.core.designsystem.theme.gray
import com.easylife.diary.core.designsystem.theme.outerSpace
import com.easylife.diary.core.designsystem.theme.white

val DefaultColorScheme = lightColorScheme(
    primary = gold,
    onPrimary = black,
    secondary = white,
    tertiary = outerSpace,
    background = alabaster,
    onBackground = outerSpace,
    surface = alabaster,
    onSurface = outerSpace,
    surfaceVariant = white,
    onSurfaceVariant = darkGray,
    outlineVariant = gray
)