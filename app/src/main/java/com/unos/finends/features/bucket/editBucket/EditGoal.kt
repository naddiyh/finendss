package com.unos.finends.features.bucket.editBucket


import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.firestore.FirebaseFirestore
import com.unos.finends.R
import com.unos.finends.ui.theme.YelGreen
import androidx.compose.material.DropdownMenuItem
import com.unos.finends.features.bucket.addBucket.GoalsViewModel

@OptIn(ExperimentalMaterial3Api::class)


@Composable
fun EditGoal(navController: NavController) {
    val goalsViewModel: GoalsViewModel = viewModel()
    val db = FirebaseFirestore.getInstance()
    val clickedText = remember { mutableStateOf("Random Add") }
    val titleRandom = remember { mutableStateOf("") }
    val titleText = remember { mutableStateOf("") }
    val goalAmount = remember { mutableStateOf("") }
    val goalAmountRandom = remember { mutableStateOf("") }
    val planPerInterval = remember { mutableStateOf("") }
    val targetDate = remember { mutableStateOf("") }
    val frequencySelected = remember { mutableStateOf("") }
    val frequencyRandom = remember { mutableStateOf("") }
    val id = remember { mutableStateOf("") }
    val isSaving = remember { mutableStateOf(false) }
    val saveStatus = remember { mutableStateOf("") }
    val selectedCategory by remember { mutableStateOf("") }


    fun saveGoalToFirebase() {
        if (clickedText.value.isBlank()) {
            saveStatus.value = "Please select a type first"
            return
        }



        isSaving.value = true
        saveStatus.value = "Loading..."
        val selectedFrequency = if (clickedText.value == "Random Add") frequencyRandom.value else frequencySelected.value

        val goalData = goalsViewModel.createGoalData(
            goalType = clickedText.value,
            titleText = titleText.value,
            titleRandom = titleRandom.value,
            goalAmount = goalAmount.value,
            goalAmountRandom = goalAmountRandom.value,
            planPerInterval = planPerInterval.value,
            targetDate = targetDate.value,
            frequency = selectedFrequency,
            category = selectedCategory,
        )

        if (goalData != null) {
            db.collection("goals")
                .add(goalData)
                .addOnSuccessListener {
                    Log.d("AddGoal", "Goal successfully added")
                    isSaving.value = false
                    saveStatus.value = "Success! Goal successfully added"
                    navController.popBackStack()
                }
                .addOnFailureListener { e ->
                    isSaving.value = false
                    saveStatus.value = "Error: ${e.message}"
                }
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "back",
                        modifier = Modifier.size(35.dp),
                        tint = Color.Unspecified
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Add a New Goal",
                    fontSize = 18.sp,
                    color = YelGreen
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.65f)
                    .height(30.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = Color.LightGray),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                GoalTypeButton("Random Add", clickedText, YelGreen)
                GoalTypeButton("Planned Out", clickedText, Color.LightGray)
            }

            ImagePickerScreen()
            Spacer(modifier = Modifier.height(25.dp))


            when (clickedText.value) {
                "Random Add" -> RandomAddGoalForm(
                    titleRandom = titleRandom,
                    goalAmountRandom = goalAmountRandom,
                    frequencyRandom = frequencyRandom,

                    saveGoalToFirebase = { saveGoalToFirebase() }
                )
                "Planned Out" -> PlannedOutGoalForm(
                    titleText = titleText,
                    planPerInterval = planPerInterval,
                    goalAmount = goalAmount,
                    frequencySelected = frequencySelected,

                    saveGoalToFirebase = { saveGoalToFirebase() })
            }

            if (isSaving.value) {
                Text(text = "Saving...", color = Color.Blue, fontSize = 16.sp)
            } else if (saveStatus.value.isNotBlank()) {
                Text(
                    text = saveStatus.value,
                    color = if (saveStatus.value.contains("Success")) Color.Green else Color.Red,
                    fontSize = 16.sp
                )
            }
        }
    }
}
@Composable
fun CategorySelectionDropdown(
    category: List<String>,
    selectedCategory: MutableState<String>
) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Select Category", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp))
                .padding(8.dp)
        ) {
            Text(
                text = if (selectedCategory.value.isBlank()) "Select Category" else selectedCategory.value,
                color = if (selectedCategory.value.isBlank()) Color.Gray else Color.Black,
                fontSize = 14.sp
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            category.forEach { categoryItem ->
                DropdownMenuItem(onClick = {
                    selectedCategory.value = categoryItem
                    expanded = false

                }) {
                    Text(text = categoryItem)
                }
            }
        }
    }
}


@Composable
fun ImagePickerScreen() {
    val context = LocalContext.current
    val imageUri = remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri.value = uri
    }

    Column(
        modifier = Modifier
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        imageUri.value?.let { uri ->
            Image(
                painter = rememberAsyncImagePainter(model = uri),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(2.dp, Color.Gray, RoundedCornerShape(10.dp))
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Box(  modifier = Modifier

            .clickable { launcher.launch("image/*") }) {
            Image(
                painter = painterResource(id = R.drawable.upgambar),
                contentDescription = "Upload Icon",
                modifier = Modifier.size(100.dp)
            )


        }
    }
}


@Composable
fun GoalTypeButton(
    label: String,
    clickedText: MutableState<String>,
    activeColor: Color
) {
    Box(
        modifier = Modifier
            .height(40.dp)

            .clickable { clickedText.value = label }
            .clip(RoundedCornerShape(10.dp))
            .background(if (clickedText.value == label) YelGreen else Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = if (clickedText.value == label) Color.White else Color.Black,
            modifier = Modifier.padding(start = 17.dp, end = 12.dp)
        )
    }
}


@Composable
fun RandomAddGoalForm(
    titleRandom: MutableState<String>,
    goalAmountRandom: MutableState<String>,
    frequencyRandom: MutableState<String>,
    saveGoalToFirebase: () -> Unit,

    ) {
    var showAlert by remember { mutableStateOf(false) }
    val selectedCategory = remember { mutableStateOf("") }
    val categoryRandom = listOf("Holiday", "Vehicle", "Gadget")
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        TextFieldWithLabel(label = "Title", value = titleRandom)
        CategorySelectionDropdown(
            category = categoryRandom,
            selectedCategory = selectedCategory
        )
        TextFieldWithLabel(label = "Goal Amount", value = goalAmountRandom)
        Text(text = "Notify Frequncy", fontSize = 14.sp, color = Color.Gray)
        FrequencySelectionRow(frequencyRandom)
        if (titleRandom.value.isNotBlank() && goalAmountRandom.value.isNotBlank() && frequencyRandom.value.isNotBlank()) {
            SaveGoalButton(
                label = "Done",
                saveGoalToFirebase = saveGoalToFirebase
            )
        } else {

            SaveGoalButton(
                label = "Done",
                saveGoalToFirebase = { showAlert = true }
            )
        }

        if (showAlert) {
            AlertDialog(
                onDismissRequest = { showAlert = false },
                title = { Text(text = "Alert") },
                text = { Text(text = "Please fill all the columns") },
                confirmButton = {
                    TextButton(onClick = { showAlert = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}


@Composable
fun PlannedOutGoalForm(
    titleText: MutableState<String>,
    planPerInterval: MutableState<String>,
    goalAmount: MutableState<String>,
    frequencySelected: MutableState<String>,
    saveGoalToFirebase: () -> Unit,


    ) {
    var showAlert by remember { mutableStateOf(false) }
    val selectedCategory = remember { mutableStateOf("") }
    val category = listOf("Holiday", "Vehicle", "Gadget")

    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        TextFieldWithLabel(label = "Title", value = titleText)

        CategorySelectionDropdown(
            category = category,
            selectedCategory = selectedCategory
        )
        TextFieldWithLabel(label = "Amount per Interval", value = planPerInterval)
        TextFieldWithLabel(label = "Goal Amount", value = goalAmount)
        Text(text = "Notify Frequency", fontSize = 14.sp, color = Color.Gray)
        FrequencySelectionRow(frequencySelected)
        if (titleText.value.isNotBlank() && planPerInterval.value.isNotBlank() && goalAmount.value.isNotBlank() && frequencySelected.value.isNotBlank()) {
            SaveGoalButton(
                label = "Done",
                saveGoalToFirebase = saveGoalToFirebase
            )
        } else {

            SaveGoalButton(
                label = "Done",
                saveGoalToFirebase = { showAlert = true }
            )
        }

        if (showAlert) {
            AlertDialog(
                onDismissRequest = { showAlert = false },
                title = { Text(text = "Alert") },
                text = { Text(text = "Please fill all the columns") },
                confirmButton = {
                    TextButton(onClick = { showAlert = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}

// TextField with label
@Composable
fun TextFieldWithLabel(label: String, value: MutableState<String>) {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(text = label, fontSize = 14.sp, color = Color.Gray)
        TextField(
            value = value.value,
            onValueChange = { value.value = it },
            placeholder = { Text(text = "Enter $label", fontWeight = FontWeight.Light, fontSize = 14.sp) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray,
            ),
        )
    }
}

// Row for frequency selection (Weekly, Monthly, Yearly)
@Composable
fun FrequencySelectionRow(frequencyState: MutableState<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(34.dp)
            .padding(vertical = 1.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.LightGray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        FrequencyOptionButton("Weekly", frequencyState)
        FrequencyOptionButton("Monthly", frequencyState)
        FrequencyOptionButton("Yearly", frequencyState)
    }
}


@Composable
fun FrequencyOptionButton(label: String, frequencyState: MutableState<String>) {
    Box(
        modifier = Modifier
            .clickable { frequencyState.value = label }
            .background(if (frequencyState.value == label) YelGreen else Color.LightGray)
            .padding(horizontal = 35.dp, vertical = 4.dp)
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = if (frequencyState.value == label) Color.White else Color.Black
        )
    }
}

@Composable
fun SaveGoalButton(
    label: String,

    saveGoalToFirebase: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(1f)
            .clickable { saveGoalToFirebase() }
            .clip(RoundedCornerShape(10.dp))
            .background(YelGreen),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 17.dp, end = 12.dp)
        )
    }
}
