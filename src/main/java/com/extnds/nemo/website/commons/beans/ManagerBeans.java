package com.extnds.nemo.website.commons.beans;

import com.extnds.nemo.website.features.resume.ResumeAccessor;
import com.extnds.nemo.website.features.resume.ResumeManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagerBeans {

    @Bean
    public ResumeManager resumeManager(ResumeAccessor resumeAccessor) {
        return new ResumeManager(resumeAccessor);
    }
}
