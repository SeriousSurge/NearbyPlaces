package com.hiremarknolan.nearbyplaces.composables.buttons

import android.content.Intent
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ShareButton(url: String, name: String? = null) {

    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, url)
        name?.let {
            putExtra(Intent.EXTRA_TITLE, it)
        }
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)
    val context = LocalContext.current


    Button(
        onClick = { context.startActivity(shareIntent) }
    ) {
        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = null,
            tint = MaterialTheme.colors.onPrimary
        )
    }
}