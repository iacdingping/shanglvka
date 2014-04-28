package com.iac.slk.platform;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.iac.slk.BaseEntity;

@Entity(name="slv_platform_user")
public class PlatformUser extends BaseEntity {

	@Column(nullable = false)
	private String platformCoding;

	public String getPlatformCoding() {
		return platformCoding;
	}

	public void setPlatformCoding(String platformCoding) {
		this.platformCoding = platformCoding;
	}
	
	
}
