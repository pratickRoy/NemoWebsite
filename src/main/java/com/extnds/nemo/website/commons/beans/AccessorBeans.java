package com.extnds.nemo.website.commons.beans;

import com.extnds.nemo.website.features.resume.ResumeAccessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

@Configuration
public class AccessorBeans {

    @Bean
    public ResumeAccessor resumeAccessor(Retrofit retrofit) {

        return new ResumeAccessor(retrofit);
    }
}
