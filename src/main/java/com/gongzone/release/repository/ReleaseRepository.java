package com.gongzone.release.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.release.entity.Release;
import com.gongzone.release.entity.ReleaseId;

/**
 * 출고 리포지토리
 * @author Hanju Park
 * @version 1.0
 * */
public interface ReleaseRepository extends JpaRepository<Release, ReleaseId> {

	@Query(value = "SELECT r FROM Release r WHERE r.releaseId = :releaseId")
	Optional<Release> findByReleaseId(@Param("releaseId") Long releaseId);

	@Modifying
	@Query(value = "INSERT INTO t_release VALUES (:#{#release.releaseId}, :#{#release.releaseConfirmed}, :#{#release.releaseDate}, :#{#release.releaseDescription}, :#{#release.releaseQuantity}, :#{#release.releaseTotalPrice}, :#{#release.releaseType}, :#{#release.production}, :#{#release.delivery}) ", nativeQuery = true)
	@Transactional
	void saveRelease(@Param("release") Release release);
	
	@Modifying
	@Query(value = "DELETE FROM t_release WHERE release_id = :releaseId", nativeQuery = true)
	@Transactional
	void deleteRelease(@Param("releaseId") Long releaseId);

}
