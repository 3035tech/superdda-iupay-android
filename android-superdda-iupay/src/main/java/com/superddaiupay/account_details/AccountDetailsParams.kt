package com.superddaiupay.account_details

import android.content.Context
import android.graphics.BitmapFactory
import android.view.View
import android.widget.CompoundButton
import com.superddaiupay.R
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AccountDetailsParams : Serializable {
    var chartDataText: String? = null
    var chartDataValue: String? = null
    var chartLegend: String? = null
    var chartWidth: Int? = null
    var chartData: ArrayList<ChartData>? = null
    var data: AccountDetailsInfo? = null
    var baseColor: String? = null
    var pdfAvailable: Boolean = false

    @Transient
    var onClickBack: View.OnClickListener? = null

    @Transient
    var onClickOptions: View.OnClickListener? = null

    @Transient
    var onClickViewAccountDetails: View.OnClickListener? = null

    @Transient
    var onClickViewPDF: View.OnClickListener? = null

    @Transient
    var onClickRejectAccount: View.OnClickListener? = null

    @Transient
    var onClickCopyBarcode: View.OnClickListener? = null

    @Transient
    var onSwitchAutoPaymentChange: CompoundButton.OnCheckedChangeListener? = null

    @Transient
    var onClickPaymentScheduleButton: View.OnClickListener? = null

    companion object {
        @JvmStatic
        fun example(context: Context): AccountDetailsParams {
            val params = AccountDetailsParams()
            params.baseColor = "#8f06c3" // "#FF5555"
            params.pdfAvailable = false
            params.chartDataText = "JUNHO"
            params.chartDataValue = "R$ 1.983,36"
            params.chartData = ArrayList()
            params.chartData!!.add(ChartData("Fev", 950))
            params.chartData!!.add(ChartData("Mar", 1050))
            params.chartData!!.add(ChartData("Abr", 800))
            params.chartData!!.add(ChartData("Mai", 970))
            params.chartData!!.add(ChartData("Jun", 1300))
            params.chartData!!.add(ChartData("Jul", 1500))
            params.data = AccountDetailsInfo()
            params.data!!.isFromIuPay = true
            params.data!!.companyLogo =
                BitmapFactory.decodeResource(context.resources, R.raw.nubank)
            params.data!!.companyName = "Nu Pagamentos S.A."
            params.data!!.cardHolderName = "Roberto de Oliveira Santos"
            params.data!!.cnpj = "18.236.120/0001-58"
            params.data!!.cardNumber = "5162 **** **** 9090"
            params.data!!.billDetails = BillDetails()
            params.data!!.billDetails!!.billDate = "JUL 2020"
            params.data!!.billDetails!!.value = 1326.70
            params.data!!.billDetails!!.minimumPaymentValue = 305.68
            params.data!!.billDetails!!.dueDate =
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse("26/07/2020")
            params.data!!.billDetails!!.emissionDate =
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse("19/07/2020")
            params.data!!.billDetails!!.barCode =
                "34191.09065 44830. 1285 40141.906 8 00001.83120.59475"
            params.data!!.billDetails?.totalLimitValue = 4000
            params.data!!.billDetails?.totalWithdrawLimitValue = 200
            params.data!!.billDetails?.interestRate = 14
            params.data!!.billDetails?.interestRateCET = 440.41
            params.data!!.billDetails?.interestInstallmentFine = 2
            params.data!!.billDetails?.interestInstallmentRate = 12
            params.data!!.billDetails?.interestInstallmentRateCET = 15

            params.onClickOptions = View.OnClickListener {
//                Toast.makeText(
//                    context,
//                    "onClickOptions " + params.data?.companyName,
//                    Toast.LENGTH_SHORT
//                ).show()
            }
            return params
        }
    }
}