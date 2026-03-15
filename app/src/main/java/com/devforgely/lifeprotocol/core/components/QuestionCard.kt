package com.devforgely.lifeprotocol.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devforgely.lifeprotocol.R

@Composable
fun QuestionCard(title: String = "QUESTION", description: String?, textPlaceHolder: String?, maxQuestion: Int, progress: Int) {
    var text by remember { mutableStateOf("") }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.elevatedCardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Progress row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                ProgressDots(maxQuestion, progress)
                Text(
                    text = "$progress / $maxQuestion",
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(Modifier.height(7.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.ic_quiz),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(7.dp))
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Spacer(Modifier.height(7.dp))

            Text(
                text = description?: "",
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(7.dp))

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = {
                    textPlaceHolder?.let {
                        Text(
                            text = textPlaceHolder,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    focusedTextColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground
                ),
                shape = RoundedCornerShape(16.dp)
            )
        }
    }
}