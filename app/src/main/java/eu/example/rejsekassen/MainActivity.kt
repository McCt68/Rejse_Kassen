package eu.example.rejsekassen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
// import com.google.firebase.firestore.FirebaseFirestore
// import eu.example.rejsekassen.components.SamletBe
import eu.example.rejsekassen.data.Repository
import eu.example.rejsekassen.navigation.MainNavigator
import eu.example.rejsekassen.ui.theme.RejseKassenTheme
import eu.example.rejsekassen.widgets.RoundIconButton

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			RejseKassenTheme {

				MainNavigator()
			}
		}
	}
}

// Made the passedNavController nullable, to be able to preview the function
@Composable
fun MainScreen(passedNavController: NavHostController?) {

	// For holding the value of samlet beløb
	var samletBeløbState = remember {
		mutableStateOf(0)
	}

	Scaffold() {
		Surface(modifier = Modifier.fillMaxSize()) {
			Column(
				verticalArrangement = Arrangement.Top,
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Row() {
					Text(
						modifier = Modifier
							.padding(8.dp),
						text = "Opsparet beløb", fontSize = 36.sp
					)

				}
				Row {
					Text(
						modifier = Modifier
							.padding(8.dp),
						text = samletBeløbState.value.toString(),
						fontSize = 36.sp
					)

				}
				Row(
					modifier = Modifier
						.padding(8.dp)
						.fillMaxWidth(0.6f),
					horizontalArrangement = Arrangement.SpaceEvenly,
					verticalAlignment = Alignment.CenterVertically
				) {
					RoundIconButton(
						imageVectorIcon = Icons.Default.Add,
						onClick = { samletBeløbState.value = samletBeløbState.value + 100 })
					RoundIconButton(
						imageVectorIcon = Icons.Default.Remove,
						onClick = { samletBeløbState.value = samletBeløbState.value - 100 })

				}
				Row(
					modifier = Modifier
						.padding(8.dp)
				) {
					Button(onClick = { passedNavController?.navigate("details_screen") }) {
						Text(text = "Navigate to other screen")
					}
				}
				Box(modifier = Modifier.padding(8.dp)) {
					Image(
						painterResource(R.drawable.tenerife_strand),
						contentDescription = null,
						modifier = Modifier
							//.requiredSize(50.dp)
							.size(320.dp)
					)
				}

				// firestore test
				val myFirestoreInstance = Repository()
				// myFirestoreInstance.CreateCollection()

				// Use update method from repository to update a field in the database document tester
				myFirestoreInstance.updateData("Bettine", changeHolidaysavingsAmount = 3000)

				// Call upsparet beløb function from repository to change its value
				myFirestoreInstance.updateOpsparetBeløb(10000 )

			}
		}
	}
}
