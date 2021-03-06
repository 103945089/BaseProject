package hlhj.fhp.baseproject.network;

import android.util.JsonReader;
import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.convert.Converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018\6\12 0012.
 */

public class JsonConvert<T> implements Converter<T> {
    private Type type;
    private Class<T> clazz;

    public JsonConvert() {
    }

    public JsonConvert(Type type) {
        this.type = type;
    }

    public JsonConvert(Class<T> clazz) {
        this.clazz = clazz;
    }
    @Override
    public T convertResponse(Response response) throws Throwable {
        Type genericSuperclass = getClass().getGenericSuperclass();
        type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        return pariseBean((Class<T>) type,response);
    }
    private T pariseBean(Class<T> type, Response response) throws IOException, JSONException {
        if (type==null) return null;
        Log.e("info","开始");
        ResponseBody body = response.body();
        if (body==null) return null;
        JsonReader reader = new JsonReader(body.charStream());

        if (type==String.class){
            return (T)body.string();
        }else if (type == JSONObject.class){
            return (T) new JSONObject(body.string());
        }else if (type== JSONArray.class){
            return (T) new JSONArray(body.string());
        }else {
            String responceStr = body.string();
            T t = new Gson().fromJson(responceStr,type);
            response.close();
            Log.e("info","开始5");

            return t;

        }
    }
}
