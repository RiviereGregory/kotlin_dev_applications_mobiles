package mrs.riverjach.meteo

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import mrs.riverjach.meteo.meteo.Meteo
import mrs.riverjach.meteo.openweather.WeatherWrapper
import mrs.riverjach.meteo.openweather.mapOpenWeatherDataToWeather
import retrofit2.Call
import retrofit2.Response

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in [WidgetMeteoConfigureActivity]
 */
class WidgetMeteo : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        // When the user deletes the widget, delete the preference associated with it.
        for (appWidgetId in appWidgetIds) {
            deleteTitlePref(context, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = loadTitlePref(context, appWidgetId)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.widget_meteo)
    var meteo: Meteo? = null
    val call = App.weatherService.getWeather(MainActivity.langiso, widgetText)
    call.enqueue(object : retrofit2.Callback<WeatherWrapper> {
        override fun onFailure(call: Call<WeatherWrapper>, t: Throwable) {}
        override fun onResponse(call: Call<WeatherWrapper>, response: Response<WeatherWrapper>) {
            response.body()?.let {
                meteo = mapOpenWeatherDataToWeather(it)
                views.setTextViewText(R.id.appwidget_text, widgetText)
                views.setTextViewText(R.id.appwidget_city, widgetText)
                views.setTextViewText(
                    R.id.appwidget_temperature,
                    "${meteo?.temperature.toString()}°C"
                )
                when {
                    meteo?.iconUrl!!.contains("01d") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.d01
                    )

                    meteo?.iconUrl!!.contains("01n") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.n01
                    )

                    meteo?.iconUrl!!.contains("02d") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.d02
                    )

                    meteo?.iconUrl!!.contains("02n") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.n02
                    )

                    meteo?.iconUrl!!.contains("03d") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.d03
                    )

                    meteo?.iconUrl!!.contains("03n") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.n03
                    )

                    meteo?.iconUrl!!.contains("04d") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.d04
                    )

                    meteo?.iconUrl!!.contains("04n") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.n04
                    )

                    meteo?.iconUrl!!.contains("09d") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.d09
                    )

                    meteo?.iconUrl!!.contains("09n") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.n09
                    )

                    meteo?.iconUrl!!.contains("10d") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.d10
                    )

                    meteo?.iconUrl!!.contains("10n") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.n10
                    )

                    meteo?.iconUrl!!.contains("11d") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.d11
                    )

                    meteo?.iconUrl!!.contains("11n") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.n11
                    )

                    meteo?.iconUrl!!.contains("13d") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.d13
                    )

                    meteo?.iconUrl!!.contains("13n") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.n13
                    )

                    meteo?.iconUrl!!.contains("50d") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.d50
                    )

                    meteo?.iconUrl!!.contains("50n") -> views.setImageViewResource(
                        R.id.appwidget_icon,
                        R.drawable.n50
                    )
                }
                val pendingIntent: PendingIntent =
                    Intent(context, MainActivity::class.java).let { intent ->
                        PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
                    }
                views.setOnClickPendingIntent(R.id.appwidget_layout, pendingIntent)

                // Instruct the widget manager to update the widget
                appWidgetManager.updateAppWidget(appWidgetId, views)
            }
        }
    })
}