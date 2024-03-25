package com.kosh.pastebox.controller;

import com.kosh.pastebox.api.request.PasteboxRequest;
import com.kosh.pastebox.api.response.PasteboxResponse;
import com.kosh.pastebox.api.response.PasteboxUrlResponse;
import com.kosh.pastebox.service.PasteboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class PasteboxController {
    private final PasteboxService pasteboxService;

    @GetMapping("/")
    public void getPublicPasteList() {

    }

    @GetMapping("/{hash}")
    public PasteboxResponse getByHash(@PathVariable String hash) {
        return pasteboxService.getByHash(hash);
    }

    @PostMapping("/")
    public PasteboxUrlResponse add(@RequestBody PasteboxRequest request){
        return pasteboxService.create(request);
    }
}
