package com.extnds.nemo.website.features.resume;

import com.extnds.nemo.models.features.resume.BasicDetails;
import com.extnds.nemo.website.commons.exceptions.InternalServerException;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class ResumeAccessor {

    private ResumeCalls resumeCalls;
    private interface ResumeCalls {

        @GET("basicDetails")
        Call<BasicDetails> basicDetailsCall(@Query("id") String id);
    }

    @Autowired
    public ResumeAccessor(Retrofit retrofit) {
        resumeCalls = retrofit.create(ResumeCalls.class);
    }

    Optional<BasicDetails> fetchBasicDetails(String id) {

        BasicDetails basicDetails;

        Response<BasicDetails> response;
        try {
            response = resumeCalls.basicDetailsCall(id).execute();
        } catch (IOException e) {
            throw new InternalServerException(e);
        }

        if(response.isSuccessful()) {

            basicDetails = response.body();
            if(Objects.isNull(basicDetails)) {
                return Optional.empty();
            }

            basicDetails.validate();
            return Optional.of(basicDetails);
        }
        return Optional.empty();
    }
}
