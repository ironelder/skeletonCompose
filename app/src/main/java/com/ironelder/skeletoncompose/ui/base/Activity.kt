package com.ironelder.skeletoncompose.ui.base

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.ironelder.skeletoncompose.ui.theme.DarkColorPalette
import com.ironelder.skeletoncompose.ui.theme.LightColorPalette


fun ComponentActivity.setThemeContent(content: @Composable () -> Unit) =
    setContent {
        val isDarkTheme = isSystemInDarkTheme()
        val colors = when {
            isDarkTheme -> DarkColorPalette
            else -> LightColorPalette
        }
        MaterialTheme(colors = colors, content = content)
    }