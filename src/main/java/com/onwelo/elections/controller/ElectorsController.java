package com.onwelo.elections.controller;

import com.onwelo.elections.dto.NewElectorRequest;
import com.onwelo.elections.dto.ElectorResponse;
import com.onwelo.elections.dto.UpdateElectorRequest;
import com.onwelo.elections.service.ElectorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/electors")
@RequiredArgsConstructor
class ElectorsController {

    private final ElectorsService electorsService;

    @PostMapping
    ElectorResponse addElector(@RequestBody NewElectorRequest request) {
        return electorsService.addElector(request);
    }

    @PutMapping
    ElectorResponse updateElectorInfo(@RequestBody UpdateElectorRequest request) {
        return electorsService.updateElector(request);
    }
}
