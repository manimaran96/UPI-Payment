# UPI - Payment

*  UPI payement by Deeplink

**Demo App** - [Click here](https://gitlab.com/manimaran/upi-payment/raw/master/files/upi-payment-deeplink.apk)

### Screen Shots

<img src="https://gitlab.com/manimaran/upi-payment/raw/master/files/upi-payment_1.jpg" data-canonical-src="https://gitlab.com/manimaran/upi-payment/raw/master/files/upi-payment_1.jpg" width="300" height="500" />

<img src="https://gitlab.com/manimaran/upi-payment/raw/master/files/upi-payment_2.jpg" data-canonical-src="https://gitlab.com/manimaran/upi-payment/raw/master/files/upi-payment_2.jpg" width="300" height="500" />

<br>

### How To Use 

```kotlin
    // UPI - Deeplink 
    // upi://pay?pa=960078968101@ippb&pn=Manimaran&tn=UPI Payment by Deeplinking&am=1.0&cu=INR

    // GET UPI - Deeplink
    private fun getUPIDeepLink(payeeAddress: String, payeeName: String, amount: Double, currencyUnit: String, transactionNote: String): String {
        return "upi://pay?pa=" + payeeAddress +
                "&pn=" + payeeName +
                "&tn=" + transactionNote +
                "&am=" + amount +
                "&cu=" + currencyUnit
    }

    // Hit - UPI Deep link
    val deepLinkUri: Uri = Uri.parse(getUPIDeepLink(payeeAddress, payeeName, amount, currencyUnit, transactionNote))
    val intent = Intent(Intent.ACTION_VIEW, deepLinkUri)
    startActivity(intent)
```
