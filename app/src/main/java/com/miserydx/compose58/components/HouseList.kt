package com.miserydx.compose58.components

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import com.miserydx.compose58.model.DataProvider
import com.miserydx.compose58.model.HouseListItemBean
import com.miserydx.compose58.model.RecommendReason
import com.miserydx.compose58.R

@Composable
fun HouseList() {
    val houseList = remember { DataProvider.houseList }
    LazyColumn(
        Modifier.clickable {
            Log.e("misery","点击了")
            DataProvider.houseList[1].price = "2222"
            DataProvider.houseList.removeFirst()
        }
    ) {
        Log.e("misery","LazyColumn inner start")
        items(
            items = houseList,
            itemContent = {
                HouseListItem(itemBean = it)
            }
        )
    }
}

@Composable
fun HouseListItem(itemBean: HouseListItemBean) {
    Log.e("misery","HouseListItem start")
    Column {
        Log.e("misery","HouseListItem Column inner start")
        Row {
            HouseImage(itemBean.picUrl)
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, top = 12.dp)
                    .fillMaxWidth()
            ) {
                var test = remember{ mutableStateOf(1) }
                Text(text = test.value.toString(),
                modifier = Modifier.clickable {
                    test.value++
                })
                Title(title = itemBean.title)
                SubTitle(itemBean = itemBean)
                TagLayout(itemBean = itemBean)
                Price(price = itemBean.price, unit = itemBean.priceUnit)
                SubwayInfo(distanceDict = itemBean.distanceDict)
                RecommendReason(itemBean.recommendReason)
            }
        }
        Divider(
            color = Color(0xffEAEAEA),
            thickness = 0.5.dp,
            modifier = Modifier.padding(start = 15.dp, top = 20.dp, end = 15.dp)
        )
    }

}

@Composable
fun HouseImage(imgUrl: String) {
    Image(
        painter = rememberCoilPainter(imgUrl),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(start = 15.dp, top = 15.dp)
            .size(120.dp, 90.dp)
            .clip(RoundedCornerShape(3.dp))
    )
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun SubTitle(itemBean: HouseListItemBean) {
    val subTitle = "${itemBean.huxing}·${itemBean.area}·${itemBean.dictName}·${itemBean.lastLocal}"
    Text(
        text = subTitle,
        fontSize = 13.sp,
        maxLines = 1,
        color = Color(0xff666666),
        modifier = Modifier.padding(top = 3.5.dp),
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun TagLayout(itemBean: HouseListItemBean) {
    Row(
        modifier = Modifier.padding(top = 7.5.dp)
    ) {
        itemBean.centerImg?.apply {
            Image(
                painter = rememberCoilPainter(this),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(26.dp, 16.dp)
            )
        }
        val tagList = itemBean.usedTages.split(",")
        tagList.take(3).forEach {
            ShapeTag(tag = it)
        }
    }
}

@Composable
fun ShapeTag(tag: String) {
    Surface(
        shape = RoundedCornerShape(1.dp),
        border = BorderStroke(
            width = 0.5.dp,
            color = Color(0xff8AC1EA),
        ),
        modifier = Modifier.padding(end = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 3.dp, end = 3.dp)
                .size(height = 16.dp, width = Dp.Unspecified),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = tag,
                fontSize = 10.sp,
                color = Color(0xff2588D4),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2,
            )
        }
    }
}

@Composable
fun Price(price: String, unit: String) {
    var priceState = remember{mutableStateOf(price)}
    Row(
        modifier = Modifier.padding(top = 5.5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = priceState.value,
            style = TextStyle(
                fontWeight = FontWeight.W900
            ),
            fontSize = 17.sp,
            color = Color(0xffFF552E),
            modifier = Modifier
                .padding(end = 2.dp)
                .clickable {
                    priceState.value = priceState.value
                        .toInt()
                        .plus(100)
                        .toString()
                }
        )
        Text(
            text = unit,
            fontSize = 13.sp,
            color = Color(0xffFF552E)
        )
    }
}

@Composable
fun SubwayInfo(distanceDict: String?) {
    distanceDict?.let {
        Row(
            modifier = Modifier.padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.mipmap.house_list_subway_icon),
                contentDescription = null,
                modifier = Modifier.size(11.dp)
            )
            Text(
                text = it,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 2.dp),
                color = Color(0xff666666),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun RecommendReason(recommendReason: RecommendReason?) {
    recommendReason?.let {
        Surface(
            shape = RoundedCornerShape(1.dp),
            color = Color(0xffFEF6E9),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(2.dp)
            ) {
                Text(
                    text = it.text,
                    fontSize = 11.sp,
                    color = Color(0xffFF7A00),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    HouseList()
}