package com.gongzone.storage.mapper;

import com.gongzone.dto.storage.StorageDTO;
import com.gongzone.entity.storage.Storage;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-02T18:19:55+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class StorageMapperImpl implements StorageMapper {

    @Override
    public StorageDTO toDto(Storage e) {
        if ( e == null ) {
            return null;
        }

        StorageDTO.StorageDTOBuilder storageDTO = StorageDTO.builder();

        storageDTO.storageId( e.getStorageId() );
        storageDTO.storageAddress( e.getStorageAddress() );
        storageDTO.storageCategory( e.getStorageCategory() );
        storageDTO.storageDescription( e.getStorageDescription() );

        return storageDTO.build();
    }

    @Override
    public Storage toEntity(StorageDTO d) {
        if ( d == null ) {
            return null;
        }

        Storage.StorageBuilder storage = Storage.builder();

        storage.storageId( d.getStorageId() );
        storage.storageAddress( d.getStorageAddress() );
        storage.storageCategory( d.getStorageCategory() );
        storage.storageDescription( d.getStorageDescription() );

        return storage.build();
    }

    @Override
    public List<StorageDTO> toDtoList(List<Storage> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StorageDTO> list = new ArrayList<StorageDTO>( entityList.size() );
        for ( Storage storage : entityList ) {
            list.add( toDto( storage ) );
        }

        return list;
    }

    @Override
    public List<Storage> toEntityList(List<StorageDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Storage> list = new ArrayList<Storage>( dtoList.size() );
        for ( StorageDTO storageDTO : dtoList ) {
            list.add( toEntity( storageDTO ) );
        }

        return list;
    }
}
