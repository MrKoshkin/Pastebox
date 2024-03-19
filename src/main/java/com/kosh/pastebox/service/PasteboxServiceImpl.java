package com.kosh.pastebox.service;

import com.kosh.pastebox.api.request.PasteboxRequest;
import com.kosh.pastebox.api.response.PasteboxResponse;
import com.kosh.pastebox.api.response.PasteboxUrlResponse;
import com.kosh.pastebox.conf.PasteboxProperties;
import com.kosh.pastebox.entity.PasteBoxEntity;
import com.kosh.pastebox.repository.PasteboxRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Setter
public class PasteboxServiceImpl implements PasteboxService{

    private final PasteboxProperties properties;
    private final PasteboxRepository repository;


    @Override
    public PasteboxResponse getByHash(String hash) {
        PasteBoxEntity pasteBoxEntity = repository.findByHash(hash);
        return null;
    }

    @Override
    public List<PasteboxResponse> getFirstPublicPaste() {
        return null;
    }

    @Override
    public PasteboxUrlResponse create(PasteboxRequest request) {
        return null;
    }
}
