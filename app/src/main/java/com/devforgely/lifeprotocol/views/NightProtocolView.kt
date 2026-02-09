package com.devforgely.lifeprotocol.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devforgely.lifeprotocol.R
import com.devforgely.lifeprotocol.components.HeaderSection
import com.devforgely.lifeprotocol.components.HorizontalNavBar
import com.devforgely.lifeprotocol.components.ListCard
import com.devforgely.lifeprotocol.components.MultiGoalSection
import com.devforgely.lifeprotocol.components.NoteCard
import com.devforgely.lifeprotocol.components.SingleGoalSection
import com.devforgely.lifeprotocol.ui.theme.Blue


@Composable
fun NightProtocolView() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Synthesis", "Goals", "Rules")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                HeaderSection(R.drawable.ic_moon_stars, Blue, "Night Protocol", "PHASE 3: SYNTHESIS")
                Spacer(Modifier.height(28.dp))

                HorizontalNavBar(tabs, selectedTab) { selectedTab = it }

                Spacer(Modifier.height(20.dp))

                when (selectedTab) {
                    0 -> NoteCard(
                        "Today's Compaction",
                        "Compress your vision into a single sentence based on today's progress."
                    )
                    1 -> Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        MultiGoalSection(iconId = R.drawable.ic_target, iconColor = MaterialTheme.colorScheme.primary, title = "DAILY QUEST", note = "No active levers)")

                        SingleGoalSection(
                            iconId = R.drawable.ic_swords,
                            iconColor = MaterialTheme.colorScheme.primary,
                            title = "1 MONTH: THE BOSS FIGHT",
                            question = "What project will gain you the most XP?"
                        )

                        SingleGoalSection(
                            iconId = R.drawable.ic_crown,
                            iconColor = MaterialTheme.colorScheme.primary,
                            title = "1 YEAR: THE MISSION",
                            question = "What is your sole priority in life?"
                        )
                    }
                    2 -> ListCard(
                        iconId = R.drawable.ic_lock,
                        iconColor = MaterialTheme.colorScheme.primary,
                        title = "THE RULES",
                        subtitle = "What are you NOT willing to sacrifice? Constraints breed creativity.",
                        rules = listOf("Sleep 8 hours")
                        )
                }
            }
        }
    }
}