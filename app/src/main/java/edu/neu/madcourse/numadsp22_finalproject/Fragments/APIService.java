package edu.neu.madcourse.numadsp22_finalproject.Fragments;

import edu.neu.madcourse.numadsp22_finalproject.Notifications.MyResponse;
import edu.neu.madcourse.numadsp22_finalproject.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=ADD HERE YOUR KEY FROM FIREBASE PROJECT"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
