package com.kosh.pastebox.service;

import com.kosh.pastebox.api.request.PasteboxRequest;
import com.kosh.pastebox.api.response.PasteboxResponse;
import com.kosh.pastebox.api.response.PasteboxUrlResponse;

import java.util.List;

public interface PasteboxService {
    PasteboxResponse getByHash(String hash);
    List<PasteboxResponse> getFirstPublicPaste();
    PasteboxUrlResponse create(PasteboxRequest request);
}
