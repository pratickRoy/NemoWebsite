package com.extnds.nemo.website.features.resume;

import com.extnds.nemo.models.features.resume.BasicDetails;
import com.extnds.nemo.website.features.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RestController
public class ResumeController extends BaseController {

    private ResumeManager resumeManager;

    @Autowired
    public ResumeController(ResumeManager resumeManager) {
        this.resumeManager = resumeManager;
    }

    @RequestMapping("/resume")
    public BasicDetails greeting(@RequestParam String id) {

        log.error("HELLO");
        return resumeManager.fetchBasicDetails(id).orElse(null);
    }
}
