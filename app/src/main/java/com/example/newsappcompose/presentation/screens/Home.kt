package com.example.newsappcompose.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.newsappcompose.R
import com.example.newsappcompose.domain.model.ArticleModel
import com.example.newsappcompose.presentation.viewmodel.NewsViewModel


@Composable
fun HomeScreen(viewModel: NewsViewModel = hiltViewModel()) {

    val res = viewModel.articles.value


    if (res.isLoading) {
        Box(modifier = Modifier.fillMaxSize())
        {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = res.error, modifier = Modifier.align(Alignment.Center))
        }

    }


    res.data?.let {
        Text(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
            text = "Top Headlines",
            style = MaterialTheme.typography.displaySmall
        )
        LazyColumn(contentPadding = PaddingValues(all = 20.dp)) {
            items(it) {
                ArticleItem(it)
            }
        }

    }


}

@Composable
fun ArticleItem(it: ArticleModel?) {

    Column {

        Image(
            painter = rememberImagePainter(data = it?.urlToImage ?: R.drawable.placeholderthin),
            contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(corner = CornerSize(16.dp))),
            contentScale = ContentScale.Crop

        )

        Text(
            text = it!!.title, style = TextStyle(
                fontWeight = FontWeight.SemiBold, fontSize = 20.sp
            ),
            modifier = Modifier.padding(12.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = it.content,
            style = TextStyle(color = Color.Gray, fontSize = 14.sp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Divider(
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color.LightGray,
            thickness = 2.dp
        )
        Spacer(modifier = Modifier.height(12.dp))

    }


}


