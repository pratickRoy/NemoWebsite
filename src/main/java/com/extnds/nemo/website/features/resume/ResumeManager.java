package com.extnds.nemo.website.features.resume;

import com.extnds.nemo.models.features.resume.BasicDetails;
import com.extnds.nemo.website.features.BaseManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ResumeManager extends BaseManager {

    private ResumeAccessor resumeAccessor;

    @Autowired
    public ResumeManager(ResumeAccessor resumeAccessor) {
        this.resumeAccessor = resumeAccessor;
    }

    Optional<BasicDetails> fetchBasicDetails(String id) {

        return resumeAccessor.fetchBasicDetails(id);
    }
}
