package com.gongzone.storage.mapper;

import com.gongzone.storage.dto.StorageUpdateDTO;
import com.gongzone.storage.entity.Storage;
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
public class StorageUpdateMapperImpl implements StorageUpdateMapper {

    @Override
    public StorageUpdateDTO toDto(Storage e) {
        if ( e == null ) {
            return null;
        }

        StorageUpdateDTO.StorageUpdateDTOBuilder storageUpdateDTO = StorageUpdateDTO.builder();

        storageUpdateDTO.storageAddress( e.getStorageAddress() );
        storageUpdateDTO.storageCategory( e.getStorageCategory() );
        storageUpdateDTO.storageDescription( e.getStorageDescription() );

        return storageUpdateDTO.build();
    }

    @Override
    public Storage toEntity(StorageUpdateDTO d) {
        if ( d == null ) {
            return null;
        }

        Storage.StorageBuilder storage = Storage.builder();

        storage.storageAddress( d.getStorageAddress() );
        storage.storageCategory( d.getStorageCategory() );
        storage.storageDescription( d.getStorageDescription() );

        return storage.build();
    }

    @Override
    public List<StorageUpdateDTO> toDtoList(List<Storage> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StorageUpdateDTO> list = new ArrayList<StorageUpdateDTO>( entityList.size() );
        for ( Storage storage : entityList ) {
            list.add( toDto( storage ) );
        }

        return list;
    }

    @Override
    public List<Storage> toEntityList(List<StorageUpdateDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Storage> list = new ArrayList<Storage>( dtoList.size() );
        for ( StorageUpdateDTO storageUpdateDTO : dtoList ) {
            list.add( toEntity( storageUpdateDTO ) );
        }

        return list;
    }
}
