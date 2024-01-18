package org.lsj.app08

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast

import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import org.lsj.app08.databinding.ActivityMainBinding
import org.lsj.app08.databinding.DialogLayoutBinding

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.button5.setOnClickListener {
            val dialogBinding = DialogLayoutBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run {
                setTitle("input")
                setView(dialogBinding.root)
                dialogBinding.radioButton.setOnClickListener{
                    val name:String = dialogBinding.editTextText.text.toString()
                    val gender:String = dialogBinding.radioButton.text.toString()
                    binding.tv1.setText("name : $name, gender : $gender")
                }
                dialogBinding.radioButton2.setOnClickListener{
                    val name:String = dialogBinding.editTextText.text.toString()
                    val gender:String = dialogBinding.radioButton2.text.toString()
                    binding.tv1.setText("name : $name, gender : $gender")
                }
                setPositiveButton("닫기", null)
                show()
            }
        }


        binding.button4.setOnClickListener {
            val items = arrayOf("사과", "복숭아", "포도")
            AlertDialog.Builder(this).run {
                setTitle("item test")
                setIcon(android.R.drawable.ic_dialog_alert)
                setMultiChoiceItems(items,
                    booleanArrayOf(true, false, false),
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(
                            dialog: DialogInterface?,
                            which: Int,
                            isChecked: Boolean
                        ) {
                            if(isChecked){
                                binding.tv1.setText("${items[which]} 선택됨")
                            } else {
                                binding.tv1.setText("${items[which]} 해제됨")
                            }
                        }
                    }
                )
                setPositiveButton("닫기", null)
                show()
            }
        }

        binding.button3.setOnClickListener {
            TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    binding.tv1.setText("time : $hourOfDay:$minute")
                }
            },12,0,true).show()
        }

        binding.button2.setOnClickListener {
            DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    binding.tv1.setText("date : $year. $month. $dayOfMonth")
                }
            },2024, 1, 16).show()
        }

        binding.button.setOnClickListener {
            val toast = Toast.makeText(baseContext, "토스트 메시지", Toast.LENGTH_SHORT)
            toast.addCallback(
                object : Toast.Callback() {
                    override fun onToastHidden() {
                        super.onToastHidden()
                        binding.tv1.setText("Toast Hidden")
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        binding.tv1.setText("Toast show...")
                    }
                }
            )


            val requestLauncher = registerForActivityResult(
                /* contract = */ ActivityResultContracts.RequestPermission()
            ) { isGranted ->
                if (isGranted) {
                    Log.d("aaaa", "cllback...granted")
                } else {
                    Log.d("aaaa", "cllback...denied...")
                }
            }
            val status = ContextCompat.checkSelfPermission(
                this,
                "android.permission.ACCESS_FINEO_LOCATION"
            )
            if (status == PackageManager.PERMISSION_GRANTED) {
                Log.d("aaaa", "granted...")
            } else {
                requestLauncher.launch("android.permission.ACCESS_FINE_LOCATION")
            }
        }
    }
}