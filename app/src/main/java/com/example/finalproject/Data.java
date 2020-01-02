package com.example.finalproject;


import javax.xml.transform.Result;

class Data {
    Result[] list;

    class Result{
        Results main;
        String dt_txt;
        String dt;
        class Results{
            String temp;
            int humidity;
        }
    }
}

