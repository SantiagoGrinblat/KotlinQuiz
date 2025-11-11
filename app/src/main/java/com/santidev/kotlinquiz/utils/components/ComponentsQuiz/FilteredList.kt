import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.santidev.kotlinquiz.R
import com.santidev.kotlinquiz.data.QuestionCategory
import com.santidev.kotlinquiz.utils.components.ComponentsQuiz.GridItemWithDrawable

@Composable
fun FilteredList(
  onItemSelected: (String) -> Unit,
  onCloseModal: () -> Unit
  ){
  val itemsImage = listOf(
    GridItemWithDrawable("kotlin", R.drawable.kotlinlogo, QuestionCategory.FUNDAMENTALS),
    GridItemWithDrawable("jetpack compose", R.drawable.jclogob, QuestionCategory.COMPOSE),
    GridItemWithDrawable("Preguntas avanzadas", R.drawable.advancelogob, QuestionCategory.ADVANCED),
    GridItemWithDrawable("poo", R.drawable.poologob, QuestionCategory.POO),
    GridItemWithDrawable("Testing", R.drawable.logotestingb, QuestionCategory.TEST),
    GridItemWithDrawable("Arquitectura", R.drawable.arquitecturab, QuestionCategory.ARCHITECTURE)
  )
  
  LazyVerticalGrid(
    columns = GridCells.Fixed(2), // 2 columnas para 4 elementos
    modifier = Modifier
      .fillMaxWidth()
      .height(490.dp),
    contentPadding = PaddingValues(
      start = 8.dp,
      top = 8.dp,
      end = 8.dp,
      bottom = 8.dp
    ),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    content = {
      items(itemsImage.size) { index ->
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable {
              onItemSelected(itemsImage[index].category.displayName)
              onCloseModal()
            },
          colors = CardDefaults.cardColors(
            containerColor = Color(0xFF3D2A52).copy(alpha = 0.8f)
          ),
          elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
          Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
          ) {
            Image(
              painter = painterResource(id = itemsImage[index].drawableResId),
              contentDescription = itemsImage[index].name,
              modifier = Modifier.fillMaxSize(),
              contentScale = ContentScale.Fit
            )
          }
        }
      }
    }
  )
}