package com.example.fluffy_aos.ui.common.survey.resuable

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.fluffy_aos.ui.common.reusable.RoundedOutlineButton

@Composable
fun PhotoField(
    selectedImageUri: Uri,
    onChangeValue: (Uri) -> Unit = {}
) {

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            println("uri = ${uri}")
            onChangeValue(uri ?: Uri.EMPTY)
        }


    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        if (selectedImageUri != Uri.EMPTY) {
            Image(
                painter = rememberAsyncImagePainter(selectedImageUri),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .height(250.dp)
                    .aspectRatio(1f)
                    .align(Alignment.CenterHorizontally)
            )
        }
        RoundedOutlineButton(onClick = { launcher.launch("image/*") }, text = "사진 올리기")
    }

}