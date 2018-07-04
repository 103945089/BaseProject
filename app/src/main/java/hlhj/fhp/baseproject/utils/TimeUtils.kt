package hlhj.fhp.baseproject.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Administrator on 2018\7\2 0002.
 */
object TimeUtils {
    @Throws(ParseException::class)
    fun dateToStamp(time: String): String {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = simpleDateFormat.parse(time)
        var ts = date.time
        ts = ts / 1000
        return ts.toString()
    }

    @Throws(ParseException::class)
    fun dateToStampB(time: String): String {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = simpleDateFormat.parse(time)
        val ts = date.time
        return ts.toString()
    }

    /**
     * 将一个时间戳转换成提示性时间字符串，如刚刚，1秒前
     *
     * @param timeStamp
     * @return
     */
    fun convertTimeToFormat(timeStamp: Long): String {
        var timeStamp = timeStamp
        val times = timeStamp.toString() + ""
        if (times.length >= 11) {
            timeStamp = java.lang.Long.parseLong(times) / 1000.toLong()
        }
        val curTime = System.currentTimeMillis() / 1000.toLong()

        val time = curTime - timeStamp

        return if (time < 60 && time >= 0) {
            "刚刚"
        } else if (time >= 60 && time < 3600) {
            (time / 60).toString() + "分钟前"
        } else if (time >= 3600 && time < 3600 * 24) {
            (time / 3600).toString() + "小时前"
        } else if (time >= 3600 * 24 && time < 3600 * 24 * 10) {
            (time / 3600 / 24).toString() + "天前"
        } else {
            timeStampToStr(timeStamp)
        }
    }

    /*秒差距*/
    fun secLeft(timeStamp: Long): Long {
        var timeStamp = timeStamp
        val times = timeStamp.toString() + ""
        if (times.length >= 11) {
            timeStamp = java.lang.Long.parseLong(times) / 1000.toLong()
        }
        val curTime = System.currentTimeMillis() / 1000.toLong()

        return curTime - timeStamp
    }

    /**
     * 将一个时间戳转换成提示性时间字符串，今天 xxx；
     *
     * @param timeStamp
     * @return
     */
    fun convertTimeToCustom(timeStamp: Long): String {
        var timeStamp = timeStamp
        val times = timeStamp.toString() + ""
        val current = System.currentTimeMillis()
        val zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().rawOffset
        if (times.length >= 11) {
            timeStamp = java.lang.Long.parseLong(times) / 1000.toLong()
        }
        val curTime = zero / 1000.toLong()

        val time = curTime - timeStamp
        return if (time < 0) {
            "今天"
        } else if (time > 0 && time < 60 * 60 * 24) {
            "昨天"
        } else if (time > 3600 * 24 && time < 60 * 60 * 48) {
            "前天"
        } else {
            timeStampToMD(timeStamp)
        }

    }

    /**
     * 时间戳转化为时间格式
     *
     * @param timeStamp
     * @return
     */
    fun timeStampToStr(timeStamp: Long): String {
        var timeStamp = timeStamp
        val times = timeStamp.toString()
        if (times.length >= 11) {
            timeStamp = java.lang.Long.parseLong(times) / 1000.toLong()
        }
        @SuppressLint("SimpleDateFormat") val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return sdf.format(timeStamp * 1000)
    }

    /**
     * 时间戳转化为时间格式
     *
     * @param timeStamp
     * @return
     */
    fun timeStampToStrYMD(timeStamp: Long): String {
        var timeStamp = timeStamp
        val times = timeStamp.toString()
        if (times.length >= 11) {
            timeStamp = java.lang.Long.parseLong(times) / 1000.toLong()
        }
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        return sdf.format(timeStamp * 1000)
    }

    fun timeStampToStrYMMD(timeStamp: Long): String {
        var timeStamp = timeStamp
        val times = timeStamp.toString()
        if (times.length >= 11) {
            timeStamp = java.lang.Long.parseLong(times) / 1000.toLong()
        }
        val sdf = SimpleDateFormat("yyyy-M-d")
        return sdf.format(timeStamp * 1000)
    }

    fun timeStampToStrY(timeStamp: Long): String {
        var timeStamp = timeStamp
        val times = timeStamp.toString()
        if (times.length >= 11) {
            timeStamp = java.lang.Long.parseLong(times) / 1000.toLong()
        }
        val sdf = SimpleDateFormat("yyyy")
        return sdf.format(timeStamp * 1000)
    }

    /*获得年*/
    fun getYear(): String {
        val timeMillis = System.currentTimeMillis()
        val ym = TimeUtils.timeStampToYM(timeMillis)
        return ym.split("-".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()[0]
    }

    /*获得月*/
    fun getMonth(): String {
        val timeMillis = System.currentTimeMillis()
        val ym = TimeUtils.timeStampToYM(timeMillis)
        return ym.split("-".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()[1]
    }

    /**
     * 时间戳转化为小时分钟时间格式
     *
     * @param timeStamp
     * @return
     */
    fun timeStampToHM(timeStamp: Long): String {
        var timeStamp = timeStamp
        val times = timeStamp.toString()
        if (times.length >= 11) {
            timeStamp = java.lang.Long.parseLong(times) / 1000.toLong()
        }
        val sdf = SimpleDateFormat("HH:mm")
        return sdf.format(timeStamp * 1000)
    }

    fun timeStampToMD(timeStamp: Long): String {
        var timeStamp = timeStamp
        val times = timeStamp.toString()
        if (times.length >= 11) {
            timeStamp = java.lang.Long.parseLong(times) / 1000.toLong()
        }
        val sdf = SimpleDateFormat("MM-dd")
        return sdf.format(timeStamp * 1000)
    }

    fun timeStampToYM(timeStamp: Long): String {
        var timeStamp = timeStamp
        val times = timeStamp.toString()
        if (times.length >= 11) {
            timeStamp = java.lang.Long.parseLong(times) / 1000.toLong()
        }
        val sdf = SimpleDateFormat("yyyy-MM")
        return sdf.format(timeStamp * 1000)
    }
}