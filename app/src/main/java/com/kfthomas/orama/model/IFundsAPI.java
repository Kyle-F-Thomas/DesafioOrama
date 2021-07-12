package com.kfthomas.orama.model;

import com.kfthomas.orama.data.FundJsonData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface IFundsAPI {

    @GET("json/fund_detail_full.json?serializ%20er=fund_detail_full")
    Call<List<FundJsonData>> getFundDetailFull();
}
