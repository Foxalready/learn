import java.text.SimpleDateFormat
import java.util.Date

object Learn {
  def main(args: Array[String]): Unit = {
    val now: Date = new Date()
    val dateFormatDay = new SimpleDateFormat("yyyy-MM-dd")
    val dateFormatSecond = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    //零点时间戳
    val currentDayTimestamp = dateFormatDay.parse(dateFormatDay.format(now)).getTime / 1000
    val currentSecondTimestamp = dateFormatSecond.parse(dateFormatSecond.format(now)).getTime / 1000

    //8:00
    val currentTime0800 = currentDayTimestamp + (8 * 3600)

    var deliveryDate = currentDayTimestamp

    var minInspectionTime = currentDayTimestamp

    if (currentSecondTimestamp > currentTime0800) {
      deliveryDate = currentDayTimestamp + (24 * 3600)
    }

    minInspectionTime = deliveryDate - (24 * 3600)

    // 超过X 时间未发车的
    // 蔬果
    val configNoCarTime2 = (60 * 15)
    // 肉禽
    val configNoCarTime3 = (60 * 15)
    //. poi cT < poiCtLts = X时间未发车 数据
    val poiCtLt2 = currentSecondTimestamp - configNoCarTime2
    val poiCtLt3 = currentSecondTimestamp - configNoCarTime3

    println(currentDayTimestamp)
    println(currentSecondTimestamp)

  }
}

