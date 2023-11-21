package com.gutib.dialogexplorer.gutibjunasnazarito_activity6_dialogexplorer

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.gutib.dialogexplorer.gutibjunasnazarito_activity6_dialogexplorer.databinding.ActivitySecondPageBinding
import java.util.Calendar

class SecondPage : AppCompatActivity() {
    private lateinit var binding : ActivitySecondPageBinding
    private var selectedTitle: String = ""
    private var selectedDate: String = ""
    private var selectedTime: String = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            showAlertDialog()
        }

        binding.button2.setOnClickListener {
            showDatePickerDialog()
        }

        binding.button3.setOnClickListener {
            showTimePickerDialog()
        }

        binding.button4.setOnClickListener {
            if (selectedTitle.isBlank() || selectedDate.isBlank() || selectedTime.isBlank()) {
                Toast.makeText(this, "Please complete the selection above", Toast.LENGTH_SHORT).show()
            } else {
                binding.displayTextView.text = "$selectedTitle\n$selectedDate\n$selectedTime"
            }
        }

        binding.button5.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }


    private fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Donor")
            .setMessage("Are you a donor?")
            .setPositiveButton("YES") { _, _ ->
                selectedTitle = "Is a Donor: YES"
            }
            .setNegativeButton("NO") { _, _ ->
                selectedTitle = "Is a Donor: NO"
            }
            .create()

        alertDialog.show()
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            selectedDate = "Date selected: $selectedYear-$selectedMonth-$selectedDay"
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
            selectedTime = "Time selected: $selectedHour:$selectedMinute"
        }, hour, minute, true)

        timePickerDialog.show()
    }

}