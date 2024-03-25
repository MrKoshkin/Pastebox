package com.kosh.pastebox.service;

import com.kosh.pastebox.api.request.PasteboxRequest;
import com.kosh.pastebox.api.request.PublicStatus;
import com.kosh.pastebox.api.response.PasteboxResponse;
import com.kosh.pastebox.api.response.PasteboxUrlResponse;
import com.kosh.pastebox.conf.PasteboxProperties;
import com.kosh.pastebox.entity.PasteBoxEntity;
import com.kosh.pastebox.repository.PasteboxRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Setter
public class PasteboxServiceImpl implements PasteboxService{

    private final PasteboxProperties properties;
    private final PasteboxRepository repository;


    @Override
    public PasteboxResponse getByHash(String hash) {
        PasteBoxEntity pasteBoxEntity = repository.findByHash(hash);
        return new PasteboxResponse(pasteBoxEntity.getData(), pasteBoxEntity.isPublic());
    }

    @Override
    public List<PasteboxResponse> getFirstPublicPaste() {
        List<PasteBoxEntity> list = repository.getListOfPublicAndAlive(properties.getPublicListSize());

        return list.stream().map(pasteBoxEntity ->
                        new PasteboxResponse(pasteBoxEntity.getData(), pasteBoxEntity.isPublic()))
                .collect(Collectors.toList());

    }

    @Override
    public PasteboxUrlResponse create(PasteboxRequest request) {
        String hash = generateHash();
        PasteBoxEntity pasteBoxEntity = new PasteBoxEntity();
        pasteBoxEntity.setData(request.getData());
        pasteBoxEntity.setHash(hash);
        pasteBoxEntity.setPublic(request.getPublicStatus().equals(PublicStatus.PUBLIC));
        pasteBoxEntity.setLifetime(LocalDateTime.now().plusSeconds(request.getExpirationTimeSeconds()));
        repository.save(pasteBoxEntity);

        return new PasteboxUrlResponse(properties.getHost() + "/" + pasteBoxEntity.getHash());

    }

    public String generateHash() {
        Long maxHash = repository.findMaxHash();
        Long nextHash = 1L;

        if (maxHash != null) {
            nextHash=maxHash+1;
        }

        return Long.toHexString(nextHash);
    }

}
