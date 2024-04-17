package com.softulp.simulacro.ui.home;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
    public void llamar(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phoneNumber));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
        } else {
            // Mostrar mensaje de error en la Activity utilizando LiveData u otro método de comunicación
            // Por ejemplo, puedes usar un MutableLiveData<String> en el ViewModel para mostrar el mensaje de error
            Toast.makeText(getApplication(), "Ingrese un numero telefonico",Toast.LENGTH_LONG).show();
        }
    }
}