package com.gl.contactproviders;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayContactsActivity extends AppCompatActivity {
    private Button mBtnAdd;
    private EditText mEtName, mEtPhone, mEtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);

        mBtnAdd = (Button) findViewById(R.id.btnAdd);
        mEtName = (EditText) findViewById(R.id.etName);
        mEtPhone = (EditText) findViewById(R.id.etPhoneNo);
        mEtEmail = (EditText) findViewById(R.id.etEmail);
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContacts();
            }
               /* ContentResolver cr = getContentResolver();
                ContentValues cv = new ContentValues();
                cv.put(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, mEtName.getText().toString());
                cv.put(ContactsContract.CommonDataKinds.Phone.NUMBER, mEtPhone.getText().toString());
                cv.put(ContactsContract.CommonDataKinds.Email.DATA, mEtEmail.getText().toString());
                cv.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
                Uri uri = cr.insert(ContactsContract.Data.CONTENT_URI, cv);
                long rawContactId = ContentUris.parseId(uri);
                if (rawContactId != -1) {
                    Toast.makeText(getApplicationContext(), "Record inserted", Toast.LENGTH_LONG).show();
                }

            }*/
        });


        //Display Contacts
        /*Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String[] PROJECTION =
                {
                        ContactsContract.Contacts._ID,
                        ContactsContract.Contacts.LOOKUP_KEY,
                        ContactsContract.Contacts.HAS_PHONE_NUMBER,
                        ContactsContract.Contacts.DISPLAY_NAME


                };

        String[] PROJECTION1 = {
                ContactsContract.CommonDataKinds.Phone.NUMBER


        };

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(uri, PROJECTION, null, null, null, null);
        if (cursor != null) while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String hasNo = cursor.getString(2);
            String name = cursor.getString(3);
            Log.i("ID", id + "");
            Log.i("Name", name);
            Log.i("Has No", hasNo);
            if (hasNo.equals("1")) {
                ContentResolver resolver = getContentResolver();
                Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PROJECTION1,  ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);
                phoneCursor.moveToFirst();
                Log.i("Phone No", phoneCursor.getString(0));
                phoneCursor.close();
            }

        }
        cursor.close();*/

    }

    private void addContacts(){
        ArrayList<ContentProviderOperation> ops =
                new ArrayList<ContentProviderOperation>();

        int rawContactID = ops.size();
        // Adding insert operation to operations list
        // to insert a new raw contact in the table ContactsContract.RawContacts
        ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, "com.google")
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME,"coolshilpi6@gmail.com")
                .build());

        // Adding insert operation to operations list
        // to insert display name in the table ContactsContract.Data
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, rawContactID)
                .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, mEtName.getText().toString())
                .build());

        // Adding insert operation to operations list
        // to insert Mobile Number in the table ContactsContract.Data
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, rawContactID)
                .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, mEtPhone.getText().toString())
                .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
                .build());
        // Adding insert operation to operations list
        // to insert Home Email in the table ContactsContract.Data
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, rawContactID)
                .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Email.ADDRESS, mEtEmail.getText().toString())
                .withValue(ContactsContract.CommonDataKinds.Email.TYPE, ContactsContract.CommonDataKinds.Email.TYPE_HOME)
                .build());
        try{
            // Executing all the insert operations as a single database transaction
            getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
            Toast.makeText(getBaseContext(), "Contact is successfully added", Toast.LENGTH_SHORT).show();
        }catch (RemoteException e) {
            e.printStackTrace();
        }catch (OperationApplicationException e) {
            e.printStackTrace();
        }

    }

}
