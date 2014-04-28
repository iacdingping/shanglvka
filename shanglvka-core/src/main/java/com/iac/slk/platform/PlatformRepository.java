package com.iac.slk.platform;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

@Resource
public interface PlatformRepository extends Repository<PlatformUser, Long> {

	Page<PlatformUser> findAll(Pageable pageable);
	
	PlatformUser getByPlatformCoding(String platformCoding);
}
