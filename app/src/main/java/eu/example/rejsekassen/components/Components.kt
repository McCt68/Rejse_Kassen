package eu.example.rejsekassen.components

import androidx.compose.runtime.Composable
import com.google.firebase.firestore.FirebaseFirestore

// make picture

// Test function to add amount to firebase
// we should be able to add, or decrease an a amount to a user total amount
@Composable
fun ChangeAmountSaved(database: FirebaseFirestore, amount: String) {


	// test how to update data
	val updateTest = database.collection("users").document("tester")

	updateTest.update("last", amount)
	updateTest.update("first", amount)
}