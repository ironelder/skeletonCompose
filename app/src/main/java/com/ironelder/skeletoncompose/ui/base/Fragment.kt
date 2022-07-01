package com.ironelder.skeletoncompose.ui.base

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.ironelder.skeletoncompose.ui.theme.DarkColorPalette
import com.ironelder.skeletoncompose.ui.theme.LightColorPalette

@Suppress("NOTHING_TO_INLINE")
inline fun Fragment.setThemeContent(noinline content: @Composable () -> Unit) =
    ComposeView(requireContext()).apply {
        setContent {
            val isDarkTheme = isSystemInDarkTheme()
            val colors = when {
                isDarkTheme -> LightColorPalette
                else -> DarkColorPalette
            }
            MaterialTheme(colors = colors, content = content)
        }
    }