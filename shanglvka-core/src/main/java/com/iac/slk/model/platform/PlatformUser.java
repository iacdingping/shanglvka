package com.iac.slk.model.platform;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.iac.slk.model.BaseEntity;

@Entity
@Table(name = "slv_platform_user")
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
