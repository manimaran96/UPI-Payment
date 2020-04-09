package com.manimaran96.upi_payment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    var payeeAddress = "abc123xyz@upi"
    var payeeName: String = "Manimaran"
    var transactionNote = "UPI Payment by Deeplinking"
    var amount = 1.0
    var currencyUnit = "INR"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtName.setText(payeeName)
        txtUpiId.setText(payeeAddress)
        txtAmount.setText(amount.toString())
        txtCurrency.setText(currencyUnit)
        txtNote.setText(transactionNote)


        btnMakePayment.setOnClickListener {

            if (!TextUtils.isEmpty(txtName.text))
                payeeName = txtName.text.toString().trim()
            else {
                showMsg("Enter valid name");
                return@setOnClickListener
            }

            if (!TextUtils.isEmpty(txtUpiId.text))
                payeeAddress = txtUpiId.text.toString().trim()
            else {
                showMsg("Enter valid UPI Id");
                return@setOnClickListener
            }

            if (!TextUtils.isEmpty(txtAmount.text))
                amount = txtAmount.text.toString().trim().toDouble()
            else {
                showMsg("Enter valid amount");
                return@setOnClickListener
            }

            if (!TextUtils.isEmpty(txtCurrency.text))
                currencyUnit = txtCurrency.text.toString().trim()
            else {
                showMsg("Enter valid Currency Unit");
                return@setOnClickListener
            }

            if (!TextUtils.isEmpty(txtNote.text))
                transactionNote = txtNote.text.toString().trim()
            else {
                showMsg("Enter valid transaction note");
                return@setOnClickListener
            }

            val deepLinkUri: Uri = Uri.parse(
                getUPIDeepLink(
                    payeeAddress,
                    payeeName,
                    amount,
                    currencyUnit,
                    transactionNote
                )
            )
            Log.d(TAG, "UPI - DEEP LINK: uri: $deepLinkUri")
            val intent = Intent(Intent.ACTION_VIEW, deepLinkUri)
            startActivity(intent)
        }
    }

    private fun showMsg(s: String) {
        Toast.makeText(applicationContext, s, Toast.LENGTH_SHORT).show()
    }

    private fun getUPIDeepLink(
        payeeAddress: String,
        payeeName: String,
        amount: Double,
        currencyUnit: String,
        transactionNote: String
    ): String {
        return "upi://pay?pa=" + payeeAddress +
                "&pn=" + payeeName +
                "&tn=" + transactionNote +
                "&am=" + amount +
                "&cu=" + currencyUnit
    }

}
