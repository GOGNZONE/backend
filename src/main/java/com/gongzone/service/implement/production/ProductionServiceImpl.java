package com.gongzone.service.implement.production;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.common.errors.errorcode.CommonErrorCode;
import com.gongzone.common.errors.exception.RestApiException;
import com.gongzone.dto.production.ProductionDetailsDto;
import com.gongzone.dto.production.ProductionHistoryInsertDto;
import com.gongzone.dto.production.ProductionInsertUpdateDto;
import com.gongzone.dto.production.ProductionListDto;
import com.gongzone.dto.stock.StockUpdateDTO;
import com.gongzone.entity.client.Client;
import com.gongzone.entity.production.Production;
import com.gongzone.entity.stock.Stock;
import com.gongzone.entity.storage.Storage;
import com.gongzone.repository.client.ClientRepository;
import com.gongzone.repository.production.ProductionHistoryRepository;
import com.gongzone.repository.production.ProductionRepository;
import com.gongzone.repository.stock.StockRepository;
import com.gongzone.repository.storage.StorageRepository;
import com.gongzone.service.production.ProductionService;

import lombok.RequiredArgsConstructor;

/**
 * 생산 서비스 인터페이스 구현체
 * @author Hanju Park
 * @version 1.0
 * */
@Service
@RequiredArgsConstructor
public class ProductionServiceImpl implements ProductionService {
   
   private final ProductionRepository productionRepository;
   private final ClientRepository clientRepository;
   private final StorageRepository storageRepository;
   private final StockRepository stockRepository;
   private final ProductionHistoryRepository productionHistoryRepository;
   
   /**
    *  전체 생산 목록 조회
    *  @return List<ProductionListDto>
    */
   @Override
   @Transactional(readOnly = true)
   public List<ProductionListDto> findAllProductions() {
      List<ProductionListDto> productions = productionRepository.findAll()
            .stream()
            .map(ProductionListDto::new)
            .collect(Collectors.toList());
      return productions;
   }
   
   /**
    * 생산 품목 코드(production_id)로 생산 품목 상세 조회
    * @param { productionId }
    * @return ProductionDetailsDto
    * */
   @Override
   @Transactional(readOnly = true)
   public ProductionDetailsDto findByProductionId(final Long productionId) {
      Production production = productionRepository.findById(productionId)
            .orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
      return new ProductionDetailsDto(production);
   }
   
   /**
    * 생산 품목 등록
    * @param { productionInsertDto }
    * @return void
    * */
   @Override
   @Transactional
   public void insertProduction(final ProductionInsertUpdateDto productionInsertUpdateDto) {
      Client client = clientRepository.findById(productionInsertUpdateDto.getClient().getClientId()).orElseThrow(
            () -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
      productionInsertUpdateDto.setClient(client);
      
      productionRepository.save(productionInsertUpdateDto.toEntity());
   }
   
   /**
    * 생산 품목 코드(production_id)로 생산 품목 수정
    * @param { productionId, ProductionInsertUpdateDto }
    * @return void
    * */
   @Override
   @Transactional
   public void updateProduction(final Long productionId, final ProductionInsertUpdateDto productionInsertUpdateDto) {
      Production production = productionRepository.findById(productionId)
            .orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      
      if(productionInsertUpdateDto.getProductionProgress() != production.getProductionProgress()) {
         ProductionHistoryInsertDto productionHistoryInsertDto = new ProductionHistoryInsertDto(timestamp.getTime(), (byte) 0, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), productionInsertUpdateDto.getProductionProgress().toString(), production);
         productionHistoryRepository.saveProductionHistory(productionHistoryInsertDto.toEntity());
      } else if(!production.equals(productionInsertUpdateDto.toEntity())) {
         ProductionHistoryInsertDto productionHistoryInsertDto = new ProductionHistoryInsertDto(timestamp.getTime(), (byte) 1, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), productionInsertUpdateDto.getProductionDescription(), production);
         productionHistoryRepository.saveProductionHistory(productionHistoryInsertDto.toEntity());
      }
      
      if(productionInsertUpdateDto.getProductionProgress() == 2) {
         Storage storage = storageRepository.findById(productionInsertUpdateDto.getStock().getStorage().getStorageId()).orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
         StockUpdateDTO stockDto = new StockUpdateDTO(
               productionInsertUpdateDto.getProductionName(), 
               Long.valueOf(productionInsertUpdateDto.getProductionQuantity()),
               null,
               storage);
         Stock stock = stockRepository.save(stockDto.toEntity());
         productionInsertUpdateDto.setStock(stock);
      } else if(production.getStock() != null) {
         stockRepository.deleteByStockId(production.getStock().getStockId());
         productionInsertUpdateDto.setStock(null);
      }

      production.updateProduction(productionInsertUpdateDto);
   }

   /**
    * 생산 품목 코드(production_id)로 생산 품목 삭제
    * @param { productionId }
    * @return void
    * */
   @Override
   @Transactional
   public void deleteProduction(final Long productionId) {
      Production production = productionRepository.findById(productionId)
            .orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
//      if(production.getStock() != null) {
//         stockRepository.deleteByStockId(production.getStock().getStockId());
//      }
      productionRepository.delete(production);
   }

}