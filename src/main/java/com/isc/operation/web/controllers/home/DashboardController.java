package com.isc.operation.web.controllers.home;

import com.isc.common.data.response.BaseResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rx.Single;
import rx.schedulers.Schedulers;

@Controller
public class DashboardController {

    @GetMapping("/admin/dashboard")
    public String getPostDetail() {
        return "admin/views/index";
    }
}
