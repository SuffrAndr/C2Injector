package com.miri.blephone.mediainjector.controller;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miri.blephone.mediainjector.mgtv.notify.FeedbackResult;

@RestController
public class FeedbackController {

    @RequestMapping(value = "/cmsfeedback/SubCmsApi/Feedback.action", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public FeedbackResult feedback(@RequestParam("cmsresult") String cmsresult) {

        System.out.println(cmsresult);

        FeedbackResult feedbackResult = new FeedbackResult();
        feedbackResult.setResult(NumberUtils.INTEGER_ONE);

        return feedbackResult;
    }
}
