package com.blazeey.newsstandnav.Utils;

public class AlgorithmUtils {

    public static float minMax(float oldMin,float oldMax,float newMin,float newMax,float x){
        return (((x-oldMin)/(oldMax-oldMin))*(newMax-newMin))+newMin;
    }
}
