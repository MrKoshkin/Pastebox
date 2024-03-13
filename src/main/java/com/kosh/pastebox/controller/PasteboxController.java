package com.kosh.pastebox.controller;

import com.kosh.pastebox.api.request.PasteboxRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class PasteboxController {

    @GetMapping("/")
    public void getPublicPasteList() {

    }

    @GetMapping("/{hash}")
    public void getByHash(@PathVariable String hash) {

    }

    @PostMapping("/")
    public void add(@RequestBody PasteboxRequest request){

    }
}
