package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("")}
    var inputUnit by remember { mutableStateOf("Centimeter") }
    var outputUnit by remember { mutableStateOf("Meter") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember{ mutableDoubleStateOf(1.00) }
    val oConversionFactor = remember{ mutableDoubleStateOf(1.00) }

    val customTextStyle = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Serif,
        fontSize = 16.sp,
        color = Color.Red
    )
    fun convertUnit(){
        // ?: elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result =(inputValueDouble * conversionFactor.doubleValue * 100/oConversionFactor.doubleValue).roundToInt() / 100.0
        outputValue = result.toString()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter", style = customTextStyle )
            Spacer(modifier = Modifier.padding(16.dp))
            OutlinedTextField(value = inputValue,
            onValueChange = {
                inputValue = it
                },
            label = { Text("Enter")},
            modifier = Modifier.padding(16.dp)
        )
        Row {
            //inputBox
            Box{
                Button(onClick = { iExpanded = true } ) {
                    Text(inputUnit)
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Expand")

                }
                    DropdownMenu(
                        expanded = iExpanded,
                        onDismissRequest = { iExpanded = false },
                        modifier = Modifier.wrapContentSize()
                    ) {
                        DropdownMenuItem(
                            text = { Text("Centimeter") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "CM"
                                conversionFactor.doubleValue = 0.01
                                convertUnit()
                            })
                        DropdownMenuItem(
                            text = { Text("Meter") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "M"
                                conversionFactor.doubleValue = 1.0
                                convertUnit()
                            })
                        DropdownMenuItem(
                            text = { Text("Feet") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Ft"
                                conversionFactor.doubleValue = 0.3048
                                convertUnit()
                            })
                        DropdownMenuItem(
                            text = { Text("KiloMeter") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Km"
                                conversionFactor.doubleValue = 1000.0
                                convertUnit()
                    })
                }
            }
            //output Box
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                    Button(onClick = { oExpanded = true }) {
                        Text(outputUnit)
                        Icon(Icons.Default.KeyboardArrowDown,
                            contentDescription = "Expand")
                }
                DropdownMenu(
                    expanded = oExpanded,
                    onDismissRequest = { oExpanded = false },
                    modifier = Modifier.wrapContentSize()
                ) {
                    DropdownMenuItem(
                        text = { Text("Centimeter")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Cm"
                            oConversionFactor.doubleValue = 0.01
                            convertUnit()
                        })
                    DropdownMenuItem(
                        text = { Text("Meter") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "M"
                            oConversionFactor.doubleValue = 1.0
                            convertUnit()
                        })
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Ft"
                            oConversionFactor.doubleValue = 0.3048
                            convertUnit()
                        })
                    DropdownMenuItem(
                        text = { Text("Kilometer") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Km"
                            oConversionFactor.doubleValue = 1000.0
                            convertUnit()
                        })
                }
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Text("result: $outputValue $outputUnit",
            style = MaterialTheme.typography.displaySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
   UnitConverter()
}