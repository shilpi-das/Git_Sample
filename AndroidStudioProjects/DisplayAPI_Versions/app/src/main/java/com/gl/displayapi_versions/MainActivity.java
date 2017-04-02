package com.gl.displayapi_versions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    Button button;
    ImageView imageView;
    TextView textView1, textView2;
    Integer ArrayVersion[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    ArrayList<String> Features1, Features2;
    ArrayList<Integer> ImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Linking all XML components

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        
        //Adding features to Array List
        Features1 = new ArrayList<String>();
        Features2 = new ArrayList<String>();
        ImageList = new ArrayList<Integer>();
        //API level 1
        Features1.add(Features.WEBPAGE);
        Features2.add("Folders allowing the grouping of a number of application icons into a single folder icon on the Home screen");
        ImageList.add(R.drawable.android);
        //API level 2
        Features1.add("Details and reviews available when a user searches for businesses on Maps");
        Features2.add("Longer in-call screen timeout default when using the speakerphone, plus ability to show/hide dialpad");
        ImageList.add(R.drawable.android);
        //API level 3
        Features1.add("Support for third-party virtual keyboards with text prediction and user dictionary for custom words");
        Features2.add("Support for Widgets");
        ImageList.add(R.drawable.cupcake);
        //API level 4
        Features1.add("Voice and text entry search enhanced to include bookmark history, contacts, and the web");
        Features2.add("Ability for developers to include their content in search results");
        ImageList.add(R.drawable.donut);
        //API level 5
        Features1.add("Expanded Account sync");
        Features2.add("Ability to tap a Contacts photo and select to call, SMS, or email the person");
        ImageList.add(R.drawable.eclair);
        //API level 6
        Features1.add("Minor API changes, bugfixes and framework behavioral changes");
        Features2.add(null);
        ImageList.add(R.drawable.eclair);
        //API level 7
        Features1.add("Minor amendments to the API and bugfixes");
        Features2.add(null);
        ImageList.add(R.drawable.eclair);
        //API level 8
        Features1.add("Additional application speed improvements, implemented through JIT compilation");
        Features2.add("Integration of Chrome's V8 JavaScript engine into the Browser application");
        ImageList.add(R.drawable.froyo);
        //API level 9
        Features1.add("Support for extra-large screen sizes and resolutions");
        Features2.add("Native support for SIP VoIP internet telephony");
        ImageList.add(R.drawable.gingerbread);
        //API level 10
        Features1.add("Support for voice or video chat using Google Talk");
        Features2.add("Open Accessory Library support");
        ImageList.add(R.drawable.gingerbread);
        //API level 11
        Features1.add("Optimized tablet support with a new “holographic” user interface");
        Features2.add("Simplified multitasking – tapping Recent Applications in the System Bar");
        ImageList.add(R.drawable.honeycombbee);
        //API level 12
        Features1.add("UI refinements");
        Features2.add("Connectivity for USB accessories");
        ImageList.add(R.drawable.honeycombbee);
        //API level 13
        Features1.add("Improved hardware support, including optimizations for a wider range of tablets");
        Features2.add("Increased ability of applications to access files on the SD card, e.g. for synchronization");
        ImageList.add(R.drawable.honeycombbee);
        //API level 14
        Features1.add("Separation of widgets in a new tab, listed in a similar manner to applications");
        Features2.add("Easier-to-create folders, with a drag-and-drop style");
        ImageList.add(R.drawable.icecreamsandwich);
        //API level 15
        Features1.add("Numerous bugfixes and optimizations");
        Features2.add("Improvements to graphics, databases, spell-checking and Bluetooth functionality");
        ImageList.add(R.drawable.icecreamsandwich);
        //API level 16
        Features1.add("Ability to turn off notifications on an application-specific basis");
        Features2.add("Shortcuts and widgets can automatically be re-arranged or re-sized to allow new items to fit on home screens");
        ImageList.add(R.drawable.jellybean);
        //API level 17
        Features1.add("Lock screen improvements, including widget support and the ability to swipe directly to camera");
        Features2.add("Notification power controls (\"Quick Settings\")");
        ImageList.add(R.drawable.jellybean);
        //API level 18
        Features1.add("Restricted access mode for new user profiles");
        Features2.add("OpenGL ES 3.0 support, allowing for improved game graphics[");
        ImageList.add(R.drawable.jellybean);
        //API level 19
        Features1.add("Ability for applications to trigger translucency in the navigation and status bars");
        Features2.add("Restriction for applications when accessing external storage, except for their own directories");
        ImageList.add(R.drawable.kitkat);
        //API level 20
        Features1.add("UI updates for Google Maps navigation and alarms");
        Features2.add("Offline music playback");
        ImageList.add(R.drawable.kitkat);
        //API level 21
        Features1.add("Android Runtime (ART) with ahead-of-time compilation and improved garbage collection, replacing Dalvik that combines bytecode interpretation with trace-based just-in-time compilation[");
        Features2.add("Support for 64-bit CPUs");
        ImageList.add(R.drawable.lollipop);
        //API level 22
        Features1.add("Ability to join Wi-Fi networks and control paired Bluetooth devices from quick settings");
        Features2.add("Official support for multiple SIM cards");
        ImageList.add(R.drawable.lollipop);
        //API level 23
        Features1.add("Introduction of Doze mode, which reduces CPU speed while the screen is off in order to save battery life");
        Features2.add("Google \"Now on Tap\" feature");
        ImageList.add(R.drawable.marshmallow);
        //API level 24
        Features1.add("Multi-window support, which supports floating apps on a desktop layout");
        Features2.add("New JIT Compiler, making for 75 percent faster app installations and a 50 percent reduction in compiled code size");
        ImageList.add(R.drawable.nougat);


        //Creating Array Adapter
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, ArrayVersion);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check the selected version
                int VersionSelect = Integer.parseInt(autoCompleteTextView.getText().toString());
                boolean flag = false;
                int IndexValue = 0;
                for (int count = 0; count < 24; count++) {
                    if (VersionSelect == ArrayVersion[count]) {
                        IndexValue = count;
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    textView1.setText("Version not Found");
                } else {

                    textView1.setText("1) " + Features1.get(IndexValue));
                    textView2.setText("2) " + Features2.get(IndexValue));
                    imageView.setImageResource(ImageList.get(IndexValue));
                }


            }
        });


    }
}
