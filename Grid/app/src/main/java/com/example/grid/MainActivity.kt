package com.example.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grid.data.DataSource
import com.example.grid.model.Topic
import com.example.grid.ui.theme.GridTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridApp()
                }
            }
        }
    }
}

@Composable
fun GridCard(topic: Topic) {
    Card(
        modifier = Modifier.padding(
            all = 8.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(width = 68.dp, height = 68.dp),
                painter = painterResource(id = topic.icon),
                contentDescription = stringResource(topic.category)
            )
            Column {
                Text(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    text = LocalContext.current.getString(topic.category),
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )

                Row {
                    Image(
                        modifier = Modifier.padding(start = 16.dp),
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = "grain"
                    )
                    Text(
                        modifier = Modifier.padding(
                            start = 8.dp
                        ),
                        text = "123",
                        fontSize = MaterialTheme.typography.labelMedium.fontSize
                    )
                }
            }
        }
    }
}

@Composable
fun GridList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(topicList) { topic ->
            GridCard(topic = topic)
        }
    }
}

@Composable
fun GridApp() {
    GridList(
        topicList = DataSource.topics
    )
}

@Composable
@Preview
fun GridCardPreview() {
    GridCard(
        topic = Topic(
            R.string.architecture, 234,
            R.drawable.architecture
        )
    )
}

@Composable
@Preview
fun GridAppPreview() {
    GridApp()
}