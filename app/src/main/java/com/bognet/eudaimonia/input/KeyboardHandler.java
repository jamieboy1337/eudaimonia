package com.bognet.eudaimonia.input;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardHandler {
    public static void hideKeyboard(Activity a, View v) {
        InputMethodManager mgr = (InputMethodManager)a.getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
