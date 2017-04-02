package com.gl.gsonexample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.gl.gsonexample.R;
import com.gl.gsonexample.model.CoordinateModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class JsonSdCardStoreActivity extends Activity {
    ArrayList<CoordinateModel> mCoordModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_sd_card_store);
        init();
        createFile("demo1");
        readFile("demo1");
    }

    private void readFile(String fileName) {
        String dir = Environment.getExternalStorageDirectory().getAbsolutePath();
        try {
            File file = new File(dir, fileName + ".json");
            FileReader fw = new FileReader(file);
            BufferedReader br = new BufferedReader(fw);
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            String data;
            CoordinateModel coordinateModels[] = null;
            stringBuilder.append("[");
            while ((data = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    stringBuilder.append(data);
                } else {
                    stringBuilder.append(",");
                    stringBuilder.append(data);
                }
            }
            stringBuilder.append("]");
            coordinateModels = createModel(stringBuilder.toString());
            Log.i("Output", stringBuilder.toString());
            if (coordinateModels != null)
                for (CoordinateModel coordinateModel : coordinateModels) {
                    Log.i("Output", coordinateModel.getObjName());
                }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createFile(String fileName) {
        String dir = Environment.getExternalStorageDirectory().getAbsolutePath();
        OutputStreamWriter out = null;
        try {
            File file = new File(dir, fileName + ".json");
            FileWriter fw = new FileWriter(file, true);
            for (CoordinateModel coordinateModel : mCoordModel) {
                createJson(fw, coordinateModel);
                fw.append('\n');
            }
            fw.close();
        } catch (IOException e) {
            Log.e("Exception", e.toString());
        }
    }

    private void createJson(OutputStreamWriter writer, CoordinateModel coordinateModel) {
        Gson gson = new GsonBuilder().create();
        gson.toJson(coordinateModel, writer);
    }

    private CoordinateModel[] createModel(String reader) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(reader, CoordinateModel[].class);
    }

    private void init() {
        mCoordModel = new ArrayList<>();
        CoordinateModel coordinateModel = new CoordinateModel("belly", 10.0000f, 2.4567f, 5.6666f, "12346960584839393040996", "Team Member", "desk", null);
        mCoordModel.add(coordinateModel);
        coordinateModel = new CoordinateModel("Almira", 10.0000f, 2.4567f, 5.6666f, "12346960584839393040996", "Other", "desk", "cupboard");
        mCoordModel.add(coordinateModel);
        coordinateModel = new CoordinateModel("Saily", 10.0000f, 2.4567f, 5.6666f, "12346960584839393040996", "Team Member", "desk", null);
        mCoordModel.add(coordinateModel);


    }
}
