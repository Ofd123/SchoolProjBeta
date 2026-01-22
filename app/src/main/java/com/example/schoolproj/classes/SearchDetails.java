package com.example.schoolproj.classes;

import android.os.Build;

import java.time.LocalDateTime;

public class SearchDetails
{
    String search_id;
    LocalDateTime search_date;
    LocalDateTime delete_date;
    String search_query;

    public SearchDetails(String search_id, String search_query, boolean compare_price)
    {
        this.search_id = search_id;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            this.search_date = LocalDateTime.now();
            this.delete_date = LocalDateTime.now().plusWeeks(2); //delete after 2 weeks
        }
        this.search_query = search_query;
        this.compare_price = compare_price;
    }

    public String getSearch_id()
    {
        return search_id;
    }

    public LocalDateTime getSearch_date() {
        return search_date;
    }

    public void setSearch_date(LocalDateTime search_date) {
        this.search_date = search_date;
    }

    public LocalDateTime getDelete_date() {
        return delete_date;
    }

    public void setDelete_date(LocalDateTime delete_date) {
        this.delete_date = delete_date;
    }

    public String getSearch_query() {
        return search_query;
    }

    public void setSearch_query(String search_query) {
        this.search_query = search_query;
    }

    public boolean isCompare_price() {
        return compare_price;
    }

    public void setCompare_price(boolean compare_price) {
        this.compare_price = compare_price;
    }



    //file - search_result
    boolean compare_price;
}
